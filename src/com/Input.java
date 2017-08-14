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

import java.util.ArrayList;
import java.util.List;

public class Input {
    private Assignment assignment;
    private List<Agent> agents;
    private boolean debugMode;

    /**
     * @author Created by Haubir -  haubir.mariwani@fasbros.it
     *                              jagheterhaubir@gmail.com
     * Constructs the Input object.
     *@param assignment - the Assignment of the order
     * @param agentArray - the array of Agents that are available
     */
    public Input(Assignment assignment, List<Agent> agentArray) {
        this.assignment = assignment;
        this.agents = agentArray;
        this.debugMode = false;
    }

    public Input(Assignment assignment, List<Agent> agentArray, boolean debugMode) {
        this.assignment = assignment;
        this.agents = agentArray;
        this.debugMode = debugMode;
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
    public List<Agent> getAgents() {
        return agents;
    }

    /**
     * @author Created by Haubir -  haubir.mariwani@fasbros.it
     *                              jagheterhaubir@gmail.com
     *
     * Sets the array of Agents to the parameter.
     * @param agents - the array of Agents to be set.
     */

    public void setAgents(List<Agent> agents) {
        this.agents = agents;
    }

    /**
     * @author Created by Haubir -  haubir.mariwani@fasbros.it
     *                              jagheterhaubir@gmail.com
     *
     * Tells if the user wants debugging information or not.
     * @return true or false.
     */
    public boolean isDebugMode() {
        return debugMode;
    }

    /**
     * @author Created by Haubir -  haubir.mariwani@fasbros.it
     *                              jagheterhaubir@gmail.com
     *
     * Sets the debugMode attribute to true if debugging information is wanted.
     * @param debugMode
     */
    public void setDebugMode(boolean debugMode) {
        this.debugMode = debugMode;
    }

    @Override
    public String toString(){
      return this.assignment + "\n" + this.agents;
    }

}
