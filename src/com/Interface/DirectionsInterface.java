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

import com.ARUBAExceptions.*;
import com.Agent;
import com.Assignment;
import com.TravelRoutes;

import java.util.List;

/**
 * Interface for all Directions API calls.
 *
 * @version		0.1 2017-04-11
 * @author		Tim Svensson
 */
public interface DirectionsInterface {

    /**
     * Calculates the distance between the sets of agents and assignments givens as parameters.
     * Saves the results in member variables.
     *
     * @return A list of TravelRoutes.
     */
    List<TravelRoutes> calculateRoutes(List<Agent> agents, List<Assignment> assignments, String
            modeOfTransport) throws NoAgentsExcpetions, NoAssignmentsException,
                                    ModeOfTransportException, RoutingResponsErrorsException, NoResultsException;

}

