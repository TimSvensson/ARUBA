package com.GoogleAPI;

import com.*;
import com.ARUBAExceptions.NoResultsException;
import com.ARUBAExceptions.ModeOfTransportException;
import com.ARUBAExceptions.NoAgentsExcpetions;
import com.ARUBAExceptions.NoAssignmentsException;
import com.Interface.DirectionsInterface;
import com.google.maps.DirectionsApi;
import com.google.maps.GeoApiContext;
import com.google.maps.errors.ApiException;
import com.google.maps.model.DirectionsResult;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by timsvensson on 11/04/17.
 */
public class DirectionsGoogle extends GoogleMaps implements DirectionsInterface {
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
            throws NoAgentsExcpetions, NoAssignmentsException, ModeOfTransportException, NoResultsException {

        System.out.println("Entering calculateRoutes");
        List<TravelRoutes> travelRoutes = new ArrayList<>();

        for (Agent a : agents) {
            for (Assignment ass : assignments) {
                try {

                    // Picks out the most precise position format in the respective Position objects
                    String assignmentLocation = ass.getPosition().getMostPreciseLocation();
                    String agentLocation = a.getPosition().getMostPreciseLocation();

                    if (assignmentLocation.toLowerCase().equals("zip")) {
                        //findZipGeocoordinates(ass.getPosition()); // The real implementation that is costly.
                        setZipGeocoordinate(ass.getPosition()); // The temporary, free implementation
                        assignmentLocation = ass.getPosition().getGeocoordinate().toString();
                    }
                    if (agentLocation.toLowerCase().equals("zip")) {
                        //findZipGeocoordinates(a.getPosition()); // The real implementation that is costly.
                        setZipGeocoordinate(a.getPosition()); // The temporary, free implementation
                        agentLocation = a.getPosition().getGeocoordinate().toString();
                    }

                    DirectionsResult dirResult =
                            DirectionsApi.getDirections(this.context, agentLocation, assignmentLocation).await();

                    if (dirResult.routes.length == 0) {
                        throw new NoResultsException("DirectionsGoogle.calculateRoutes: No results were found...");
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
