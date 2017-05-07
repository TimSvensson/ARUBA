package com.GoogleAPI;

import com.ARUBAExceptions.GoogleNoResultsException;
import com.ARUBAExceptions.ModeOfTransportException;
import com.ARUBAExceptions.NoAgentsExcpetions;
import com.ARUBAExceptions.NoAssignmentsException;
import com.Agent;
import com.Assignment;
import com.Interface.DirectionsInterface;
import com.Route;
import com.TravelRoutes;
import com.google.maps.DirectionsApi;
import com.google.maps.GeoApiContext;
import com.google.maps.errors.ApiException;
import com.google.maps.model.DirectionsResult;
import com.google.maps.model.TravelMode;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;

import static com.ARUBA.LOGGER;
import static com.google.maps.model.TravelMode.DRIVING;

/**
 * Created by timsvensson on 11/04/17.
 */
public class DirectionsGoogle implements DirectionsInterface {
    String apiKey = "AIzaSyC3SJNwOjapbbdwGZlanF1mC83UGEbWH7s";
    GeoApiContext context = new GeoApiContext().setApiKey(apiKey);


    /**
     * Constructs a DirectionsGoogle object that is ready to calculate the travelroutes between all Agents and
     * all Assignments.
     *
     */
    public DirectionsGoogle() {}

    /**
     * Calculates the travelroutes between all Agents and all Assignments.
     *
     * @return true
     */
    @Override
    public List<TravelRoutes> calculateRoutes(List<Agent> agents, List<Assignment> assignments,
                                              String modeOfTransport)
            throws NoAgentsExcpetions, NoAssignmentsException, ModeOfTransportException, GoogleNoResultsException {

        System.out.println("Entering calculateRoutes");
        List<TravelRoutes> travelRoutes = new ArrayList<>();

        for (Agent a : agents) {
            for (Assignment ass : assignments) {
                try {
                    DirectionsResult dirResult =
                            DirectionsApi.getDirections(this.context, a.getPosition().getAddress(),
                                    ass.getPosition().getAddress()).await();

                    if (dirResult.routes.length == 0) {
                        throw new GoogleNoResultsException("DirectionsGoogle.calculateRoutes: No results were found...");
                    }

                    // TODO All routes and legs must be uncovered here.
                    double distance = (double)  dirResult.routes[0].legs[0].distance.inMeters;
                    long duration =             dirResult.routes[0].legs[0].duration.inSeconds;

                    Route route = new Route(distance, duration, modeOfTransport);

                    TravelRoutes travelRoute = new TravelRoutes(a, ass, route);
                    travelRoutes.add(travelRoute);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (ApiException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return ((agents.size() * assignments.size()) == travelRoutes.size()) ? travelRoutes : null;
    }
}
