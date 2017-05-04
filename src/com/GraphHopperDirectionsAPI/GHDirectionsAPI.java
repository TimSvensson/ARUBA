/*
 * Project: ARUBA 
 * Class:   GHDirectionsAPI
 *
 * Version info
 * Created: 19/04/17
 * Creator: Tim Svensson
 *
 * Copyright notice
 * Property of Fasbros IT. Do not copy, alter, distribute, or sell in any way unless given explicit permission.
 */

package com.GraphHopperDirectionsAPI;

import com.ARUBAExceptions.ModeOfTransportException;
import com.ARUBAExceptions.NoAgentsExcpetions;
import com.ARUBAExceptions.NoAssignmentsException;
import com.Agent;
import com.Assignment;
import com.Interface.DirectionsInterface;
import com.Interface.GeocodingInterface;
import com.Position;
import com.TravelRoutes;

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
public class GHDirectionsAPI implements DirectionsInterface, GeocodingInterface {

    //<editor-fold desc="Public Methods">

    //<editor-fold desc="Geocoding">
    @Override
    public boolean geocode(Position position) {
        return false;
    }

    @Override
    public boolean reverseGeocode(Position position) {
        return false;
    }

    //</editor-fold>

    //<editor-fold desc="Routing">
    @Override
    public List<TravelRoutes> calculateRoutes(List<Agent> agents, List<Assignment> assignments,
                                              String modeOfTransport)
    throws NoAgentsExcpetions, NoAssignmentsException, ModeOfTransportException {
        return null;
    }

    //</editor-fold>

    //</editor-fold>
}
