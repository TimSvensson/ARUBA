/**
 *
 * An agent.
 * <p>
 * An agent that is available for an assignment. The Agent object contains important information
 * about the agent, that will be used when the program finds out how long it takes for the agent
 * to reach an assignment's position. The agent only has a zip as position.
 *
 * @author Created by Haubir -  haubir.mariwani@fasbros.it
 *                              jagheterhaubir@gmail.com
 * @version //What version of java is current
 * @since April 11th of 2017
 */

package com;

public class Agent implements Comparable<Agent> {
    private Position position;
    private String id;
    private String firstName;
    private String surName;
    private long travelTime;
    private long distance;

    /*
    roadDirections;
    travelMode;
    Boolean isWorking;
    ArrayList<Assignment> assignments;
    schema;
    */

    /**
     * @author Created by Haubir -  haubir.mariwani@fasbros.it
     *                              jagheterhaubir@gmail.com
     * Constructs an Agent object
     * @param position
     * @param id
     * @param firstName
     * @param surName
     * @param travelTime
     * @param distance
     */
    public Agent(Position position, String id, String firstName, String surName, long travelTime, long distance) {
        this.position = position;
        this.id = id;
        this.firstName = firstName;
        this.surName = surName;
        this.travelTime = travelTime;
        this.distance = distance;
    }

    /**
     * @author Created by Haubir -  haubir.mariwani@fasbros.it
     *                              jagheterhaubir@gmail.com
     * Returns the Position object of the Agent
     * @return position
     */
    public Position getPosition() {
        return position;
    }

    /**
     * @author Created by Haubir -  haubir.mariwani@fasbros.it
     *                              jagheterhaubir@gmail.com
     * Sets the Agent's position to the parameter
     * @param position
     */
    public void setPosition(Position position) {
        this.position = position;
    }

    /*public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }*/

    /**
     * @author Created by Haubir -  haubir.mariwani@fasbros.it
     *                              jagheterhaubir@gmail.com
     * Returns the first name of the Agent
     * @return firstName
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * @author Created by Haubir -  haubir.mariwani@fasbros.it
     *                              jagheterhaubir@gmail.com
     * Sets the first name of the Agent to the parameter
     * @param firstName
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * @author Created by Haubir -  haubir.mariwani@fasbros.it
     *                              jagheterhaubir@gmail.com
     * Returns the surname of the Agent
     * @return surName
     */
    public String getSurName() {
        return surName;
    }

    /**
     * @author Created by Haubir -  haubir.mariwani@fasbros.it
     *                              jagheterhaubir@gmail.com
     * Sets the surname of the Agent to the parameter
     * @param surName
     */
    public void setSurName(String surName) {
        this.surName = surName;
    }

    /**
     * @author Created by Haubir -  haubir.mariwani@fasbros.it
     *                              jagheterhaubir@gmail.com
     * Returns the Agents traveltime to the Assignment
     * @return travelTime
     */
    public long getTravelTime() {
        return travelTime;
    }

    /**
     * @author Created by Haubir -  haubir.mariwani@fasbros.it
     *                              jagheterhaubir@gmail.com
     * Sets the Agents traveltime to the Assignment, to the parameter
     * @param travelTime
     */
    public void setTravelTime(int travelTime) {
        this.travelTime = travelTime;
    }

    /**
     * @author Created by Haubir -  haubir.mariwani@fasbros.it
     *                              jagheterhaubir@gmail.com
     * Returns the Agents distance to the Assignment
     * @return distance
     */
    public long getDistance() {
        return distance;
    }

    /**
     * @author Created by Haubir -  haubir.mariwani@fasbros.it
     *                              jagheterhaubir@gmail.com
     * Sets the Agents distance to the Assignment, to the parameter
     * @param distance
     */
    public void setDistance(long distance) {
        this.distance = distance;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

/*
     * @author Created by Haubir -  haubir.mariwani@fasbros.it
     *                              jagheterhaubir@gmail.com
     * Tells whether the Agent is currently working or not. True if working, else false.
     * @return isWorking
     */

    /*public Boolean isWorking() {
        return isWorking;
    }*/

    /*
     * @author Created by Haubir -  haubir.mariwani@fasbros.it
     *                              jagheterhaubir@gmail.com
     * Sets the Agent's working status to True or False. True if working, else false.
     * @param working
     */
    /*public void setWorking(Boolean working) {
        isWorking = working;
    }*/

    /**
     * @author Created by Haubir -  haubir.mariwani@fasbros.it
     *                              jagheterhaubir@gmail.com
     * This method decides the criteria on which the SortingList object sorts the list of Agents.
     * Based on the traveltimes of this object and Agent o, the value that is returned can be:
     *
     *      < 0 - if this objects travelTime is a smaller value than the one of the Agent o.
     *      = 0 - if this objects travelTime is the same value than the one of the Agent o.
     *      > 0 - if this objects travelTime is a bigger value than the one of the Agent o.
     *
     * It overrides the compareTo() method in the Comparable interface.
     * @param o
     * @return the difference of the two traveltimes.
     */
    @Override
    public int compareTo(Agent o) {
        if (this.travelTime - o.travelTime < 0)         return -1;
        else if (this.travelTime - o.travelTime == 0)   return 0;
        else                                            return 1;
    }

    @Override
    public String toString() {
        return this.firstName + " " + this.surName + " " + this.id;
    }
}

/*
* { 
*      ”interpretationSite”: { 
*         ”zip”: ”42” 
*      },
*       ”interpreter”: {
*          ”id”: ”42”,
*          ”position”: {
*             ”residenceZip”: ”42”
*          }
*       }, 
*       ”interpreter”: {
*           ”id”: ”4242”,
*          ”position”: {
*             ”residenceZip”: ”43”
*          }
*       }
*  }
*
* */