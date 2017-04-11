package com.GoogleAPI;

import com.Agent;
import com.Assignment;
import com.Interface.DirectionsInterface;
import com.Route;

import java.util.ArrayList;

/**
 * Created by timsvensson on 11/04/17.
 */
public class DirectionsGoogle implements DirectionsInterface {


    @Override
    public boolean CalculateDistances(ArrayList<Agent> agents, ArrayList<Assignment> assignments) {
        return false;
    }

    @Override
    public ArrayList<Route> getRoutes() {
        return null;
    }

    @Override
    public ArrayList<Route> getRoutes(Agent agent) {
        return null;
    }

    @Override
    public ArrayList<Route> getRoutes(Assignment assignment) {
        return null;
    }
}
