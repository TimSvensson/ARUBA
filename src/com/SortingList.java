package com;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Haubir on 4/5/17.
 */
public class SortingList {
    private List<Agent> listOfAgents = new ArrayList<Agent>();
    private int size;

    /**
     * Returns the list of Agents
     * @return listOfAgents
     */
    public List<Agent> getListOfAgents() {
        return listOfAgents;
    }

    /**
     * Returns the size of the list
     * @return size
     */
    public int getSize() {
        return size;
    }

    /**
     * The constructor creates a new SortingList object by taking a list and adding it's elements onto it's own list
     * @param list  - a list of Agents
     */
    public SortingList(List<Agent> list) {
        this.size = 0;
        for (Agent a : list) {
            this.addAgent(a);
        }
    }

    /**
     * Adds an agent to the list and then sorts the list accordingly.
     * @param a     - an Agent
     */
    public void addAgent(Agent a) {
        this.listOfAgents.add(a);
        this.size++;
        Collections.sort(listOfAgents);
    }

    /**
     * Prints the contents of the list.
     */
    public void printList() {
        for (Agent a : this.listOfAgents) {
            System.out.println("Agent " + a.getFirstName() + " has a travelTime of " + a.getTravelTime() + "");
        }
    }
}
