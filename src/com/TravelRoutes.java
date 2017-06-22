/*
 * Project: ARUBA 
 * Class:   AllRoutes
 *
 * Version info
 * Created: 12/04/17
 * Creator: Tim Svensson
 *
 * Copyright notice
 * Property of Fasbros IT. Do not copy, alter, distribute, or sell in any way unless given explicit permission.
 */

package com;

import java.util.ArrayList;
import java.util.List;

/**
 * Holds all the Routes between an Agent and an Assignment.
 *
 * @author Tim Svensson <tim.svensson@fasbros.it>
 * @version JDK 1.8
 * @since JDK 1.8
 */
public class TravelRoutes {

    //<editor-fold desc="Member Variables">

    private Agent agent;
    private Assignment assignment;
    private ArrayList<Route> routes;

    //</editor-fold>

    public TravelRoutes(Agent agent, Assignment assignment) {
        this.agent = agent;
        this.assignment = assignment;
        this.routes = new ArrayList<Route>();
    }

    public TravelRoutes(Agent agent, Assignment assignment, Route route) {
        this.agent = agent;
        this.assignment = assignment;
        this.routes = new ArrayList<Route>();
        routes.add(route);
    }

    public TravelRoutes(Agent agent, Assignment assignment, ArrayList<Route> routes) {
        this.agent = agent;
        this.assignment = assignment;
        this.routes = routes;
    }

    //<editor-fold desc="Getters">
    public Agent getAgent() {
        return agent;
    }

    public Assignment getAssignment() {
        return assignment;
    }

    // TODO Fix the possible exploit described below.
    // This returns a reference to the routes object meaning that it may be altered by anyone whom receives it. This may
    // cause problems in the future if there is a malicious end-user.
    public ArrayList<Route> getRoutes() {
        return routes;
    }
    //</editor-fold>

    //<editor-fold desc="Public Methods">

    public void addRoute(Route r) {
        this.routes.add(r);
    }

    public void addRoutes(List<Route> routes) {
        this.routes.addAll(routes);
    }

    public Route getRoute(int index) {
        return getRoutes().get(index);
    }

    @Override
    public String toString() {
        String s =
                "\tAgent\t\t" + this.agent.toString() + "\n\r" +
                "\tAssignment\t" + this.assignment.toString() + "\n\r" +
                "\tRoutes\n\r";
        for (Route r : this.routes) {
            s += "\t\t\t\t" + r.toString();
        }
        return s;
    }

    //</editor-fold>
}