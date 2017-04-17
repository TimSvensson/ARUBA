package com.GoogleAPI;

import com.Agent;
import com.Assignment;
import com.Interface.DirectionsInterface;
import com.TravelRoutes;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by timsvensson on 11/04/17.
 */
public class DirectionsGoogle implements DirectionsInterface {


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
}
