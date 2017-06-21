/*
 * Project: ARUBA 
 * Class:   GHMatixAPI
 *
 * Version info
 * Created: 12/04/17
 * Creator: Tim Svensson
 *
 * Copyright notice
 * Property of Fasbros IT. Do not copy, alter, distribute, or sell in any way unless given
 * explicit permission.
 */

package com.GraphHopperDirectionsAPI;

import com.ARUBAExceptions.ModeOfTransportException;
import com.ARUBAExceptions.NoAgentsException;
import com.ARUBAExceptions.NoAssignmentsException;
import com.ARUBAExceptions.HasErrorsException;
import com.Agent;
import com.Assignment;
import com.Interface.DirectionsInterface;
import com.Route;
import com.TravelRoutes;
import com.graphhopper.api.*;
import com.graphhopper.util.shapes.GHPoint;

import java.util.ArrayList;
import java.util.List;

/**
 * Used to create and send requests to, and to receive the results from, GraphHopper's Matrix API.
 * Implements the DirectionsInterface.
 *
 * @author Tim Svensson <tim.svensson@fasbros.it>
 * @version JDK 1.8
 * @since JDK 1.8
 */
public class GHMatrixAPI implements DirectionsInterface {

    //<editor-fold desc="Member Variables">

    GraphHopperMatrixWeb matrixClient;

    //</editor-fold>

    public GHMatrixAPI(String apiKey) {

        this.matrixClient = new GraphHopperMatrixWeb();
        this.matrixClient.setKey(apiKey);
    }

    //<editor-fold desc="Public Mathods">
    @Override
    public List<TravelRoutes> calculateRoutes(List<Agent> agents, List<Assignment> assignments,
                                              String modeOfTransport)
    throws NoAgentsException, NoAssignmentsException, ModeOfTransportException, HasErrorsException {

        GHMRequest ghmRequest = new GHMRequest();

        //TODO Make dynamic
        ghmRequest.addOutArray("distances");
        ghmRequest.addOutArray("times");

        if (agents == null || agents.isEmpty()) {
            throw new NoAgentsException();
        }
        for (Agent a : agents) {
            ghmRequest.addFromPoint(ToGHPoint(a));
        }

        if (assignments == null || assignments.isEmpty()) {
            throw new NoAssignmentsException();
        }
        for (Assignment a : assignments) {
            ghmRequest.addToPoint(ToGHPoint(a));
        }

        if (modeOfTransport == null || modeOfTransport.isEmpty() || modeOfTransport.equals("")) {
            throw new ModeOfTransportException();
        } else {
            ghmRequest.setVehicle(modeOfTransport);
        }

        MatrixResponse matrixResponse = matrixClient.route(ghmRequest);
        if (matrixResponse.hasErrors()) {
            throw new HasErrorsException(matrixResponse.getErrors().toString());
        }

        ArrayList<TravelRoutes> travelRoutes = new ArrayList<>();

        // Converts the matrix response (which is a 2d array) into the desired format of an
        // ArrayList.
        int toIndex = 0;
        int fromIndex = 0;
        for (Assignment assignment : assignments) {
            for (Agent agent : agents) {
                GHMResponse response = matrixResponse.get(fromIndex, toIndex);
                Route route = new Route(response.getDistance(), response.getTime(),
                                        modeOfTransport);

                travelRoutes.add(new TravelRoutes(agent, assignment, route));
                fromIndex++;
            }
            toIndex++;
        }
        return travelRoutes;
    }
    //</editor-fold>

    //<editor-fold desc="Private Methods">
    /**
     * Converts the position data of an Agent into a GHPoint.
     * @param agent An Agent who's position data is to be converted to a GHPoint.
     * @return A GHPoint representing the position of the Agent.
     */
    private GHPoint ToGHPoint(Agent agent) {
        double lat = agent.getPosition().getGeocoordinate().getLatitude();
        double lon = agent.getPosition().getGeocoordinate().getLongitude();

        return new GHPoint(lat, lon);
    }

    /**
     * Converts the position data of an Assignment into a GHPoint.
     * @param assignment The Assignment that has a position that is to be converted to a GHPoint.
     * @return A GHPoint representing the position of the Assignment.
     */
    private GHPoint ToGHPoint(Assignment assignment) {
        double lat = assignment.getPosition().getGeocoordinate().getLatitude();
        double lon = assignment.getPosition().getGeocoordinate().getLongitude();

        return new GHPoint(lat, lon);
    }
    //</editor-fold>
}
