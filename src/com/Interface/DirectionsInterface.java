/*
 * Tim Svensson
 *
 * Version info
 * First pass
 *
 * Property of Fasbros IT. Do not copy, rewrite, ues or distribute without permission from
 * Fasbros IT
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
 * @author Tim Svensson
 * @version JDK 1.8
 * @since JDK 1.8
 */
public interface DirectionsInterface {

    /**
     * Calculates the distance between the sets of agents and assignments givens as parameters.
     * Saves the results in member variables.
     *
     * @return A list of TravelRoutes.
     */
    List<TravelRoutes> calculateRoutes(List<Agent> agents, List<Assignment> assignments,
                                       String modeOfTransport)
    throws NoAgentsException, NoAssignmentsException, ModeOfTransportException, HasErrorsException, NoResultsException;

}

