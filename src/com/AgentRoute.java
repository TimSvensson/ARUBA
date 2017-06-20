/**
 * Contains information about an agent and its certain route to the wanted destination.
 * That being the assignment.
 * </p>
 *
 * @author Created by Haubir -  haubir.mariwani@fasbros.it
 *                              jagheterhaubir@gmail.com
 * @version JDK 1.8
 * @since JDK 1.8
 */

package com;

public class AgentRoute {
    private Agent agent;
    private Route route;


    /**
     * Constructs an AgentRoute object
     * @param agent
     * @param route
     */
    public AgentRoute(Agent agent, Route route) {
        this.agent = agent;
        this.route = route;
    }

    /**
     * Returns the Agent
     * @return Agent
     */
    public Agent getAgent() {
        return agent;
    }

    /**
     * Replace the agent with the given agent
     */
    public void setAgent(Agent agent) {
        this.agent = agent;
    }

    /**
     * Returns the route
     * @return Route
     */
    public Route getRoute() {
        return route;
    }

    /**
     * Sets the current route to the given route
     */
    public void setRoute(Route route) {
        this.route = route;
    }
}