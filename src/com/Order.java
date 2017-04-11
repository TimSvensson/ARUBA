package com;

/**
 * Created by Haubir on 4/10/17.
 */
public class Order {
    private Assignment assignment;
    private Agent [] agents;

    public Order(Assignment assignment, Agent [] agentArray) {
        this.assignment = assignment;
        this.agents = new Agent[agentArray.length];
        for (int i = 0; i < this.agents.length; i++) {
            this.agents[i] = agentArray[i];
        }
    }

    public Assignment getAssignment() {
        return assignment;
    }

    public void setAssignment(Assignment assignment) {
        this.assignment = assignment;
    }

    public Agent[] getAgents() {
        return agents;
    }

    public void setAgents(Agent[] agents) {
        this.agents = agents;
    }
}
