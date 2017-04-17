package com.GoogleAPI;

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
    ArrayList<TravelRoutes> travelRoutes;
    List<Agent> agents;
    List<Assignment> assignments;

    /*
     * Ska kunna ta in N antal Agents och N antal Assignments och räkna ut avstånd och restid
     * mellan varje Agent och Assignment. Information om varenda avstånd+restid ska sparas i ett
     * Route objekt.
     */

    public DirectionsGoogle(List<Agent> agents, List<Assignment> assignments) {
        this.agents = agents;
        this.assignments = assignments;
        this.travelRoutes = new ArrayList<TravelRoutes>();
    }

    @Override
    public boolean CalculateDistances() {
        for (Agent a : agents) {
            for (Assignment ass : assignments) {
                try {
                    DirectionsResult dirResult =
                            DirectionsApi.getDirections(context, a.getPosition().getAddress(), ass.getPosition().getAddress()).await();

                    // TODO All routes and legs must be uncovered here.
                    double distance = (double)  dirResult.routes[0].legs[0].distance.inMeters;
                    long duration =             dirResult.routes[0].legs[0].duration.inSeconds;

                    Route route = new Route(distance, duration, "driving");

                    TravelRoutes travelRoute = new TravelRoutes(a, ass, route);
                    this.travelRoutes.add(travelRoute);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (ApiException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return true;
    }

    @Override
    public ArrayList<TravelRoutes> getRoutes() {
        return travelRoutes;
    }

    @Override
    public ArrayList<TravelRoutes> getRoutes(Agent agent) {

        return null;
    }

    @Override
    public ArrayList<TravelRoutes> getRoutes(Assignment assignment) {
        return null;
    }

    @Override
    public void AddAgent(Agent agent) {

    }

    @Override
    public void AddAgents(List<Agent> agents) {

    }

    @Override
    public void AddAssignment(Assignment assignment) {

    }

    @Override
    public void AddAssignments(List<Assignment> assignments) {

    }
}
