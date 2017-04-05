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

    public List<Agent> getListOfAgents() {
        return listOfAgents;
    }

    public int getSize() {
        return size;
    }

    public SortingList(List<Agent> list) {
        this.size = 0;
        for (Agent a : list) {
            this.listOfAgents.add(a);
            this.size++;
        }
        Collections.sort(listOfAgents);
    }

    public void addAgent(Agent a) {
        this.listOfAgents.add(a);
        this.size++;
        Collections.sort(listOfAgents);
    }

    public void printList() {
        for (Agent a : this.listOfAgents) {
            System.out.println("Agent " + a.getFirstName() + " has a travelTime of " + a.getTravelTime() + "");
        }
    }
}
