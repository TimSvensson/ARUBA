package com.GoogleAPI;

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
    ArrayList<TravelRoutes> travelRoutes;
    List<Agent> agents;
    List<Assignment> assignments;

    /*
     * Ska kunna ta in N antal Agents och N antal Assignments och räkna ut avstånd och restid
     * mellan varje Agent och Assignment. Information om varenda avstånd+restid ska sparas i ett
     * Route objekt.
     */

    /**
     * Constructs a DirectionsGoogle object that is ready to calculate the travelroutes between all Agents and
     * all Assignments.
     *
     * @param agents - the list of agents
     * @param assignments - the list of assignments
     */
    public DirectionsGoogle(List<Agent> agents, List<Assignment> assignments) {
        this.agents = agents;
        this.assignments = assignments;
        this.travelRoutes = new ArrayList<>();
    }

    /**
     * Calculates the travelroutes between all Agents and all Assignments.
     *
     * @return true
     */
//    @Override
    public boolean calculateRoutes() {
        System.out.println("Entering calculateRoutes");
        for (Agent a : this.agents) {
            for (Assignment ass : this.assignments) {
                try {
                    DirectionsResult dirResult =
                            DirectionsApi.getDirections(this.context, a.getPosition().getAddress
                                    (), ass.getPosition().getAddress()).await();

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

        return ((this.agents.size() * this.assignments.size()) == this.travelRoutes.size());
    }

    /**
     * Returns the list of Agents that are in the object
     *
     * @return agents
     */
    public List<Agent> getAgents() {
        return agents;
    }

    /**
     * Returns the list of Assignments that are in the object
     *
     * @return assignments
     */
    public List<Assignment> getAssignments() {
        return assignments;
    }

    /**
     * Returns all the travelroutes that have been calculated by this object.
     *
     * @return travelRoutes
     */
//    @Override
    public ArrayList<TravelRoutes> getRoutes() {
        return travelRoutes;
    }

    /**
     * Returns the travelroutes to all the Assignments for the parameter Agent.
     *
     * @param agent - An Agent
     * @return travelRoutes1 - The travelroutes to all the Assignments
     */
//    @Override
    public ArrayList<TravelRoutes> getRoutes(Agent agent) {
        ArrayList<TravelRoutes> travelRoutes1 = new ArrayList<>();
        for (TravelRoutes travRout : this.travelRoutes) {
            if (agent.getId().equals(travRout.getAgent().getId())) {
                travelRoutes1.add(travRout);
            }
        }

        return (travelRoutes1.size() == 0) ? null : travelRoutes1;
    }

    /**
     * Returns the travelroutes from all the Agents to the parameter Assignment.
     *
     * @param assignment - An Assignment
     * @return travelRoutes1 - The travelroutes from all the Agents
     */
//    @Override
    public ArrayList<TravelRoutes> getRoutes(Assignment assignment) {
        ArrayList<TravelRoutes> travelRoutes1 = new ArrayList<>();
        for (TravelRoutes travRout : this.travelRoutes) {
            if (assignment.getId().equals(travRout.getAssignment().getId())) {
                travelRoutes1.add(travRout);
            }
        }

        return (travelRoutes1.size() == 0) ? null : travelRoutes1;
    }

    /**
     * Adds an Agent to the list of Agents.
     *
     * @param agent - The Agent that is to be added
     */
//    @Override
    public void addAgent(Agent agent) {
        this.agents.add(agent);
    }

    /**
     * Adds several Agents to the list of Agents.
     *
     * @param agents - The list of Agents.
     */
//    @Override
    public void addAgents(List<Agent> agents) {
        this.agents.addAll(agents);
    }

    /**
     * Adds several Assignments to the list of Assignments.
     *
     * @param assignment - The Assignment to be added.
     */
//    @Override
    public void addAssignment(Assignment assignment) {
        this.assignments.add(assignment);
    }

    /**
     * Adds several Assignments to the list of Agents.
     *
     * @param assignments - The list of Agents.
     */
//    @Override
    public void addAssignments(List<Assignment> assignments) {
        this.assignments.addAll(assignments);
    }

//    @Override
    public void setModeOfTransport(String modeOfTransport) {

    }

    @Override
    public List<TravelRoutes> calculateRoutes(List<Agent> agents, List<Assignment> assignments,
                                              String modeOfTransport)
    throws NoAgentsExcpetions, NoAssignmentsException, ModeOfTransportException {
        return null;
    }
}
