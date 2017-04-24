/*
 * Project: ARUBA 
 * Class:   SortList
 *
 * Version info
 * Created: 4/22/17
 * Creator: Haubir Mariwani
 *
 * Copyright notice
 * Property of Fasbros IT. Do not copy, alter, distribute, or sell in any way unless given explicit permission.
 */

package com.Sorting;

import com.Interface.SortingInterface;
import com.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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
public class SortingList<T> implements SortingInterface {
    private List<ListElement> list = new ArrayList<>();
    private Object target;
    private ListElement first;
    private ListElement last;
    
    /**
     * The element that will be added to the list of the SortingList object.
     * <p>
     * This element holds the object that is inserted into the list, and also it's sorting criteria.
     * </p>
     *
     * @author Haubir Mariwani <haubir.mariwani@fasbros.it>
     * @version JDK 1.8
     * @since JDK 1.8
     */
    private class ListElement implements Comparable<ListElement> {
        private double criteria;
        private Object object;

        protected ListElement(double criteria, Object object) {
            this.criteria = criteria;
            this.object = object;
        }

        protected double getCriteria() {
            return criteria;
        }

        protected void setCriteria(double criteria) {
            this.criteria = criteria;
        }

        protected Object getObject() {
            return object;
        }

        protected void setObject(Object object) {
            this.object = object;
        }

        /**
         * @author Created by Haubir -  haubir.mariwani@fasbros.it
         *                              jagheterhaubir@gmail.com
         * This method decides the criteria on which the SortingList object sorts the list of Agents.
         *
         * It overrides the compareTo() method in the Comparable interface.
         * @param o
         * @return  -1 - if this element's criteria has a smaller value than the one of the parameter element.
         *          0  - if this element's criteria has the same value as the one of the parameter element.
         *          1  - if this element's criteria has a bigger value than the one of the parameter element.
         */
        @Override
        public int compareTo(ListElement o) {
            if (this.criteria - o.criteria < 0)             return -1;
            else if (this.criteria - o.criteria == 0)       return  0;
            else                                            return  1;
        }
    }

    /**
     * @author Created by Haubir -  haubir.mariwani@fasbros.it
     *                              jagheterhaubir@gmail.com
     *
     * Empty constructor. The list is created empty when this constructor is used.
     */
    public SortingList(){}

    /**
     * @author Created by Haubir -  haubir.mariwani@fasbros.it
     *                              jagheterhaubir@gmail.com
     *
     * Constructor that takes a list as argument and adds it's elements to the objects own list.
     */
    public SortingList(List<T> newList) {
        for (T object : newList) {
            this.addToList(object);
        }
    }

    /**
     * Returns the list.
     *
     * @return The list.
     */
    @Override
    public List<ListElement> getList() {
        return this.list;
    }

    /**
     * Returns the target upon which the list sorts it's elements.
     *
     * @return The target.
     */
    public Object getTarget() {
        return target;
    }

    /**
     * Adds an element to the list.
     *
     * @param object
     *
     * @return true if the element was successfully added, otherwise false.
     */
    @Override
    public boolean addToList(Object object) {
        boolean added = false;

        if (object instanceof TravelRoutes) {
            TravelRoutes travelRoutes = (TravelRoutes) object;
            Agent agent = travelRoutes.getAgent();

            if (this.findID(agent)) return false;

            if (this.isEmpty()) this.target = travelRoutes.getAssignment();

            AgentRoute agentRoute = new AgentRoute(travelRoutes.getAgent(), travelRoutes.getRoute(0));
            double criteria = agentRoute.getRoute().getTime();
            ListElement element = new ListElement(criteria, agentRoute);
            this.list.add(element);

            if (this.list.size() == 1) this.first = element;

            this.last = element;
            added = true;
        }

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
                AgentRoute agentRoute = (AgentRoute) this.list.get(i).getObject();
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
    @Override
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
}