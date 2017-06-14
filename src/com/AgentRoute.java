/*
 * Project: ARUBA 
 * Class:   AgentRoute
 *
 * Version info
 * Created: 4/22/17
 * Creator: Haubir Mariwani
 *
 * Copyright notice
 * Property of Fasbros IT. Do not copy, alter, distribute, or sell in any way unless given explicit permission.
 */

package com;

/**
 * Holds an agent and its travelroute to an Assignment.
 * <p>
 *
 * </p>
 *
 * @author Haubir Mariwani <haubir.mariwani@fasbros.it>
 * @version JDK 1.8
 * @since JDK 1.8
 */
public class AgentRoute {
    private Agent agent;
    private Route route;

    /**
     * Constructs an AgentRoute object.
     *
     * @param agent
     * @param route
     */
    public AgentRoute(Agent agent, Route route) {
        this.agent = agent;
        this.route = route;
    }

    /**
     * Returns the agent of the object.
     *
     * @return agent
     */
    public Agent getAgent() {
        return agent;
    }

    /**
     * Sets the agent of the object to the parameter agent.
     *
     * @param agent
     */
    public void setAgent(Agent agent) {
        this.agent = agent;
    }

    /**
     * Returns the route of the object.
     *
     * @return route
     */
    public Route getRoute() {
        return route;
    }

    /**
     * Sets the route of the object to the parameter route.
     * @param route
     */
    public void setRoute(Route route) {
        this.route = route;
    }
}