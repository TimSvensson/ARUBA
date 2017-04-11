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
import com.Route;

import java.util.ArrayList;

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
     * @param agents The set of agents
     * @param assignments The set of assignments
     * @return True if call was successful, otherwise false.
     */
    boolean CalculateDistances(ArrayList<Agent> agents, ArrayList<Assignment> assignments);

    /**
     * Returns all routes saved in the objects member variables.
     *
     * @return A set of routes.
     */
    ArrayList<Route> getRoutes();

    /**
     * Returns all routes associated with a specific agent.
     *
     * @param agent An agent
     * @return A set of routes associated with the agent
     */
    ArrayList<Route> getRoutes(Agent agent);

    /**
     * Returns all routes associated with a specific assignment.
     *
     * @param assignment An assignment
     * @return A set of routes associated with the assignment
     */
    ArrayList<Route> getRoutes(Assignment assignment);

}
