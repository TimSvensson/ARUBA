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
 * Class summary.
 * <p>
 * Class Description.
 * </p>
 *
 * @author Haubir Mariwani <haubir.mariwani@fasbros.it>
 * @version JDK 1.8
 * @since JDK 1.8
 */
public class AgentRoute {
    private Agent agent;
    private Route route;

    public AgentRoute(Agent agent, Route route) {
        this.agent = agent;
        this.route = route;
    }

    public Agent getAgent() {
        return agent;
    }

    public void setAgent(Agent agent) {
        this.agent = agent;
    }

    public Route getRoute() {
        return route;
    }

    public void setRoute(Route route) {
        this.route = route;
    }
}