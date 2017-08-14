/*
 * Project: ARUBA 
 * Class:   SortList
 *
 * Version info
 * Created: 4/25/17
 * Creator: Haubir Mariwani
 *
 * Copyright notice
 * Property of Fasbros IT. Do not copy, alter, distribute, or sell in any way unless given explicit permission.
 */

package com.Sorting;

import com.Agent;
import com.AgentRoute;
import com.Assignment;
import com.TravelRoutes;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Handles the sorting functionalities of the system. Contains the inner class ListElement.
 * <p>
 * Sorts it's list based on each ListElements traveltime to the target Assignment.
 * </p>
 *
 * @author Haubir Mariwani <haubir.mariwani@fasbros.it>
 * @version JDK 1.8
 * @since JDK 1.8
 */
public class SortList {
    private Assignment target;
    private List<ListElement> list = new ArrayList<>();

    /**
     * The element that will be added to the list of the SortList object.
     * <p>
     * This element holds the object that is inserted into the list, and
     * its sorting criteria (the traveltime).
     * </p>
     *
     * @author Haubir Mariwani <haubir.mariwani@fasbros.it>
     * @version JDK 1.8
     * @since JDK 1.8
     */
    private class ListElement implements Comparable<ListElement> {
        private double travelTime;
        private AgentRoute agentRoute;

        /**
         * Constructs a ListElement object.
         *
         * @param criteria
         * @param agentRoute
         */
        protected ListElement(double criteria, AgentRoute agentRoute) {
            this.travelTime = criteria;
            this.agentRoute = agentRoute;
        }

        /**
         * Returns the agentRoute object.
         *
         * @return agentRoute
         */
        protected AgentRoute getAgentRoute() {
            return agentRoute;
        }

        /**
         * Sets input AgentRoute object as the agentRoute attribute
         * @param agentRoute
         */
        protected void setAgentRoute(AgentRoute agentRoute) {
            this.agentRoute = agentRoute;
        }

        /**
         * @author Created by Haubir -  haubir.mariwani@fasbros.it
         *
         * This method decides how the SortList object will sort the list of ListElements.
         *
         * It overrides the compareTo() method in the Comparable interface.
         * @param o
         * @return  -1 - if this element's travelTime has a smaller value than the one of the parameter element.
         *          0  - if this element's travelTime has the same value as the one of the parameter element.
         *          1  - if this element's travelTime has a bigger value than the one of the parameter element.
         */
        @Override
        public int compareTo(ListElement o) {
            if (this.travelTime - o.travelTime < 0)             return -1;
            else if (this.travelTime - o.travelTime == 0)       return  0;
            else                                                return  1;
        }
    }

    /**
     * @author Created by Haubir -  haubir.mariwani@fasbros.it
     *
     * Empty constructor. The list is created empty when this constructor is used.
     */
    public SortList(){}

    /**
     * @author Created by Haubir -  haubir.mariwani@fasbros.it
     *
     * Constructor that takes a list as argument and adds it's elements to the objects own list.
     */
    public SortList(List<TravelRoutes> newList) {
        for (TravelRoutes object : newList) {
            this.addToList(object);
        }
    }

    /**
     * Returns the list.
     *
     * @return The list.
     */
    public List<ListElement> getList() {
        return this.list;
    }

    /**
     * Returns the target upon which the list sorts it's elements.
     *
     * @return The target.
     */
    public Assignment getTarget() {
        return target;
    }

    /**
     * Adds an element to the list.
     *
     * @param travelRoutes
     *
     * @return true if the element was successfully added, otherwise false.
     */
    public boolean addToList(TravelRoutes travelRoutes) {
        boolean added = false;

        Agent agent = travelRoutes.getAgent();

        if (this.findID(agent)) return false;

        if (this.isEmpty()) this.target = travelRoutes.getAssignment();

        AgentRoute agentRoute = new AgentRoute(travelRoutes.getAgent(), travelRoutes.getRoute(0));
        double criteria = agentRoute.getRoute().getTime();
        ListElement element = new ListElement(criteria, agentRoute);
        this.list.add(element);

        added = true;
        
        return added;
    }

    /**
     * @author Created by Desiree Bjorkman -  desiree.bjorkman@fasbros.it
     *
     * Checks to see if the agent already excist in the sorting list by ID.
     * @param agent - an Agent
     * @return idExists - an boolean
     */
    private boolean findID(Agent agent) {
        boolean idExists = false;

        if (this.isEmpty()) {
            idExists = false;
        }
        else {
            for (int i = 0; i < this.list.size(); i++) {
                AgentRoute agentRoute = this.list.get(i).getAgentRoute();
                Agent listAgent = agentRoute.getAgent();

                if (listAgent.getId().equals(agent.getId())) {
                    idExists = true;
                    break;
                }
            }
        }

        return idExists;
    }

    /**
     * Sorts the list according to the criteria of the ListElements.
     *
     * @return true if the list was successfully sorted, otherwise false.
     */
    public boolean sortList() {
        if (this.isEmpty()) return false;

        Collections.sort(this.list);

        return true;
    }

    /**
     * Checks if the list is empty.
     *
     * @return true if empty, else false.
     */
    public boolean isEmpty() {
        return this.list.size() == 0;
    }

    /**
     * Returns the AgentRoute object at the given index in the ArrayList.
     *
     * @param index
     * @return the AgentRoute object
     */
    public AgentRoute getAgentRoute(int index) {
        return this.list.get(index).getAgentRoute();
    }
}
