


package com;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/**
 *
 * A sorted list based on the least amount of travelTime that each Agent has.
 * <p>
 * A list that automatically sorts itself based on the least amount of travelTime that each Agent has.
 * WARNING: Only works if the Agent class extends the Comparable class and overrides the compareTo() method.
 *
 * @author Created by Haubir -  haubir.mariwani@fasbros.it
 *                              jagheterhaubir@gmail.com
 * @version //What version of java is current
 * @since April 11th of 2017
 */
public class SortingList {
    private List<Agent> listOfAgents = new ArrayList<Agent>();
    private int size;


    /**
     * @author Created by Haubir -  haubir.mariwani@fasbros.it
     *                              jagheterhaubir@gmail.com
     * The constructor creates a new SortingList object by taking a list and adding it's elements onto it's own list
     */
    public SortingList(List<Agent> list) {
        this.size = 0;
        for (Agent a : list) {
            this.addAgent(a);
        }
    }

    /**
     * @author Created by Desireé Björkman -  desiree.bjorkman@fasbros.it
     *                              desiree.bjorkman@fasbros.it
     * The constructor creates a new SortingList object
     */
    public SortingList(){
        this.listOfAgents = new ArrayList<Agent>();
        this.size = 0;
    }
    /**
     * @author Created by Haubir -  haubir.mariwani@fasbros.it
     *                              jagheterhaubir@gmail.com
     * The constructor creates a new SortingList object by taking in a number and adding as many Agents to the list as
     * the number. This constructor is only for testing and simulation purposes.
     * @param amount - a list of Agents
     */
    public SortingList(int amount, String [] firstNames, String [] lastNames, String [] addresses,
                       long [] travelDistances, long [] travelTimes) {
        for (int i = 0; i < amount; i++) {
            Agent newAgent = new Agent(new Position(
                    new Geocoordinate(i, i),
                    addresses[i], "" + i + "",
                    "" + i + "", "" + i + "",
                    "" + i + "", "" + i + ""),
                    "" + i + "", firstNames[i], lastNames[i], travelTimes[i], travelDistances[i]);
            this.addAgent(newAgent);
            System.out.println("New agent " + newAgent.getFirstName() + " has a travelTime of " + newAgent.getTravelTime() + " seconds and a travelDistance of " + newAgent.getDistance() + " metres.");
        }

    }

    /**
     * @author Created by Haubir -  haubir.mariwani@fasbros.it
     *                              jagheterhaubir@gmail.com
     * Returns the list of Agents
     * @return listOfAgents
     */
    public List<Agent> getListOfAgents() {
        return listOfAgents;
    }

    /**
     * @author Created by Haubir -  haubir.mariwani@fasbros.it
     *                              jagheterhaubir@gmail.com
     * Returns an Agent based on it's index in the listOfAgents
     * @param index
     * @return the agent at the given index in the listOfAgents
     */
    public Agent getAgent(int index) {
        return this.listOfAgents.get(index);
    }

    /**
     * @author Created by Haubir -  haubir.mariwani@fasbros.it
     *                              jagheterhaubir@gmail.com
     * Returns the size of the list
     * @return size
     */
    public int getSize() {
        return size;
    }

    /**
     * @author Created by Haubir -  haubir.mariwani@fasbros.it
     *                              jagheterhaubir@gmail.com
     * Adds an agent to the list and then sorts the list accordingly.
     * @param a - an Agent
     */
    public void addAgent(Agent a) {
        if (this.findID(a)) {
            return;
        }
        else {
            this.listOfAgents.add(a);
            this.size++;
            Collections.sort(listOfAgents);
        }
    }

    /**
     * @author Created by Desiree Bjorkman -  desiree.bjorkman@fasbros.it
     *                              desiree.bjorkman@fasbros.it
     * Checks to see if the agent already excist in the sorting list by ID.
     * @param a - an Agent
     * @return idExists - an boolean
     */
    public boolean findID(Agent a) {
        boolean idExists = false;
        if (this.getSize() == 0) {
            idExists = false;
        }
        else {
            for (int i = 0; i < this.getSize(); i++) {
                if (this.getAgent(i).getId().equals(a.getId())) {
                    idExists = true;
                    break;
                }
            }
        }
        return idExists;
    }

    /**
     * @author Created by Haubir -  haubir.mariwani@fasbros.it
     *                              jagheterhaubir@gmail.com
     * Prints the contents of the list.
     */
    public void printList() {
        for (Agent a : this.listOfAgents) {
            System.out.println("Agent " + a.getFirstName() + " has a travelTime of " + a.getTravelTime() + " seconds and a travelDistance of " + a.getDistance() + " metres.");
        }
    }
}
