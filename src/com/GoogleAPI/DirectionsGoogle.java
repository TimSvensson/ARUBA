/*
 * Project: ARUBA
 * Class:   DirectionsGoogle
 *
 * Version info
 * Created: 4/11/17
 * Creator: Haubir Mariwani
 *
 * Copyright notice
 * Property of Fasbros IT. Do not copy, alter, distribute, or sell in any way unless given explicit permission.
 */

package com.GoogleAPI;

import com.ARUBAExceptions.ModeOfTransportException;
import com.ARUBAExceptions.NoAgentsException;
import com.ARUBAExceptions.NoAssignmentsException;
import com.ARUBAExceptions.NoResultsException;
import com.Agent;
import com.Assignment;
import com.Interface.DirectionsInterface;
import com.Route;
import com.TravelRoutes;
import com.google.maps.DirectionsApi;
import com.google.maps.errors.ApiException;
import com.google.maps.model.DirectionsResult;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Handles the functionalities and duties of the Google Directions API in this system.
 * Inherits from the GoogleMaps class and implements the DirectionsInterface.
 * <p>
 * Supports calculations of travelroutes and traveltimes.
 *
 * </p>
 *
 * @author Haubir Mariwani <haubir.mariwani@fasbros.it>
 * @version JDK 1.8
 * @since JDK 1.8
 */
public class DirectionsGoogle extends GoogleMaps implements DirectionsInterface {

    public DirectionsGoogle(String apiKey) {
        super(apiKey);
    }

    /**
     * Calculates and returns the travelroutes between a set of Agents and a set of
     * Assignments.
     *
     * @throws NoAgentsExcpetions,
     * @throws NoAssignmentsException
     * @throws ModeOfTransportException
     * @throws NoResultsException
     *
     * @param agents            - the agents
     * @param assignments       - the assignements
     * @param modeOfTransport   - the desired mode of transport
     *
     * @return a list of all the Travelroutes objects if the method finished successfully,
     * eitherwise null.
     */
    @Override
    public List<TravelRoutes> calculateRoutes(List<Agent> agents, List<Assignment> assignments,
                                              String modeOfTransport)
    throws NoAgentsException, NoAssignmentsException, ModeOfTransportException, NoResultsException {

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
