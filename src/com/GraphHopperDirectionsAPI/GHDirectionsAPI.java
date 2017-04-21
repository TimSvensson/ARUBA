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
    public boolean CalculateDistances() {
        return false;
    }

    @Override
    public ArrayList<TravelRoutes> getRoutes() {
        return null;
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

    @Override
    public void setModeOfTransport(String string) {

    }
    //</editor-fold>

    //</editor-fold>
}
