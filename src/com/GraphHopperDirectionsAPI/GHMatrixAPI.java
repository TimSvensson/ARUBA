/*
 * Project: ARUBA 
 * Class:   GHMatixAPI
 *
 * Version info
 * Created: 12/04/17
 * Creator: Tim Svensson
 *
 * Copyright notice
 * Property of Fasbros IT. Do not copy, alter, distribute, or sell in any way unless given explicit permission.
 */

package com.GraphHopperDirectionsAPI;

import com.Agent;
import com.Assignment;
import com.Interface.DirectionsInterface;
import com.Route;
import com.TravelRoutes;
import com.graphhopper.api.*;
import com.graphhopper.util.shapes.GHPoint;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.ArrayList;
import java.util.List;

/**
 * Class summary.
 * <p>
 * Class Description.
 * </p>
 *
 * @author Tim Svensson <tim.svensson@fasbros.it>
 * @version JDK 1.8
 * @since JDK 1.8
 */
public class GHMatrixAPI implements DirectionsInterface {


    //<editor-fold desc="Member Variables">

    private final String APIkey;
    GraphHopperMatrixWeb matrixClient;


    private ArrayList<Agent> agents = new ArrayList<>();
    private ArrayList<Assignment> assignments = new ArrayList<>();

    private ArrayList<TravelRoutes> travelRoutes;

    private MatrixResponse matrixResponse;

    //</editor-fold>

    public GHMatrixAPI(String APIkey) {

        this.APIkey = APIkey;

        // TODO Move this to a more "general" method.
        // Hint: create this thread safe instance only once in your application to allow the underlying library to cache
        // the costly initial https handshake
        matrixClient = new GraphHopperMatrixWeb();
        matrixClient.setKey(APIkey);
    }

    //<editor-fold desc="Public Mathods">

    @Override
    public void AddAgent(Agent agent) {
        agents.add(agent);
    }

    @Override
    public void AddAgents(List<Agent> agents) {
        agents.addAll(agents);
    }

    @Override
    public void AddAssignment(Assignment assignment) {
        assignments.add(assignment);
    }

    @Override
    public void AddAssignments(List<Assignment> assignments) {
        assignments.addAll(assignments);
    }

    @Override
    public boolean CalculateDistances() {

        GHMRequest ghmRequest = new GHMRequest();

        //TODO Make dynamic
        ghmRequest.addOutArray("distances");
        ghmRequest.addOutArray("times");

        String modeOfTransport = "car";

        ghmRequest.setVehicle(modeOfTransport);

        for( Agent a : agents ) {
            ghmRequest.addFromPoint(ToGHPoint(a));
        }

        for (Assignment a : assignments ) {
            ghmRequest.addToPoint(ToGHPoint(a));
        }

        matrixResponse = matrixClient.route(ghmRequest);

        if (matrixResponse.hasErrors()) {
            return false;
        }

        travelRoutes = new ArrayList<TravelRoutes>();

        int index = 0;
        for (Assignment assignment : assignments) {

            for (Agent agent : agents) {

                GHMResponse response = matrixResponse.get(index, index);

                Route route = new Route(response.getDistance(), response.getTime(), modeOfTransport);

                travelRoutes.add(new TravelRoutes(agent, assignment, route));
                index++;
            }

        }

        return true;
    }

    @Override
    public ArrayList<TravelRoutes> getRoutes() {
        // TODO Figure out how to do this without giving the recipient the possibility of modifying the original list
        return this.travelRoutes;
    }

    @Override
    public ArrayList<TravelRoutes> getRoutes(Agent agent) {
        // TODO
        throw new NotImplementedException();
    }

    @Override
    public ArrayList<TravelRoutes> getRoutes(Assignment assignment) {
        // TODO
        throw new NotImplementedException();
    }

    public String getError() {
        return matrixResponse.getErrors().toString();
    }

    //</editor-fold>

    private GHPoint ToGHPoint(Agent agent) {
        double lat = agent.getPosition().getGeocoordinate().getLatitude();
        double lon = agent.getPosition().getGeocoordinate().getLongitude();

        return new GHPoint(lat, lon);
    }

    private GHPoint ToGHPoint(Assignment assignment) {
        double lat = assignment.getPosition().getGeocoordinate().getLatitude();
        double lon = assignment.getPosition().getGeocoordinate().getLongitude();

        return new GHPoint(lat, lon);
    }

}