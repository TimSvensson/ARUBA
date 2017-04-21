/*
 * %W% %E% Tim Svensson
 *
 * Version info
 * First pass
 *
 * Prpoerty of Fasbros IT. Do not copy, rewrite, ues or distribute without permission from Fasbros IT
 * Email: contact@fasbros.it
 */

package com.Interface;

import com.Agent;
import com.Assignment;
import com.TravelRoutes;

import java.util.ArrayList;
import java.util.List;

/**
 * Interface for all Directions API calls.
 *
 * @version		0.1 2017-04-11
 * @author		Tim Svensson
 */
public interface DirectionsInterface {

    /**
     * Calculates the distance between the sets of agents and assignments givens as parameters. Saves the results in
     * member variables.
     *
     * @return True if call was successful, otherwise false.
     */
    boolean CalculateDistances();

    /**
     * Returns all routes saved in the objects member variables.
     *
     * @return A set of routes.
     */
    ArrayList<TravelRoutes> getRoutes();

    /**
     * Returns all routes associated with a specific agent.
     *
     * @param agent An agent
     * @return A set of routes associated with the agent
     */
    ArrayList<TravelRoutes> getRoutes(Agent agent);

    /**
     * Returns all routes associated with a specific assignment.
     *
     * @param assignment An assignment
     * @return A set of routes associated with the assignment
     */
    ArrayList<TravelRoutes> getRoutes(Assignment assignment);

    void AddAgent(Agent agent);

    void AddAgents(List<Agent> agents);

    void AddAssignment(Assignment assignment);

    void AddAssignments(List<Assignment> assignments);

    /**
     * Sets the mode of transportation to be used in the API call when calculating the routes.
     *
     * @param modeOfTransport
     */
    void setModeOfTransport(String modeOfTransport);

}
