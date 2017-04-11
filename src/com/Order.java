/**
 * @author Created by Haubir -  haubir.mariwani@fasbros.it
 *                              jagheterhaubir@gmail.com
 *
 * An order.
 * <p>
 * The order contains information about an Assignment and the available Agents for it.
 *
 * @version //What version of java is current
 * @since April 11th of 2017
 */
package com;

public class Order {
    private Assignment assignment;
    private Agent [] agents;

    /**
     * @author Created by Haubir -  haubir.mariwani@fasbros.it
     *                              jagheterhaubir@gmail.com
     * Constructs the Order object.
     *
     * @param assignment - the Assignment of the order
     * @param agentArray - the array of Agents that are available
     */
    public Order(Assignment assignment, Agent [] agentArray) {
        this.assignment = assignment;
        this.agents = new Agent[agentArray.length];
        for (int i = 0; i < this.agents.length; i++) {
            this.agents[i] = agentArray[i];
        }
    }

    /**
     * @author Created by Haubir -  haubir.mariwani@fasbros.it
     *                              jagheterhaubir@gmail.com
     *
     * Returns the Assignment.
     * @return assignment
     */
    public Assignment getAssignment() {
        return assignment;
    }

    /**
     * @author Created by Haubir -  haubir.mariwani@fasbros.it
     *                              jagheterhaubir@gmail.com
     *
     * Sets the Assignment to the parameter.
     * @param assignment - the Assignment to be set.
     */
    public void setAssignment(Assignment assignment) {
        this.assignment = assignment;
    }

    /**
     * @author Created by Haubir -  haubir.mariwani@fasbros.it
     *                              jagheterhaubir@gmail.com
     *
     * Returns the array of Agents.
     * @return agents
     */
    public Agent[] getAgents() {
        return agents;
    }

    /**
     * @author Created by Haubir -  haubir.mariwani@fasbros.it
     *                              jagheterhaubir@gmail.com
     *
     * Sets the array of Agents to the parameter.
     * @param agents - the array of Agents to be set.
     */
    public void setAgents(Agent[] agents) {
        this.agents = agents;
    }
}