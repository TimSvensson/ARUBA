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
 * @since April 5th of 2017
 */

package com;

public class Agent implements Comparable<Agent> {
    private Position position;
    private int id;
    private String firstName;
    private String surName;
    private int travelTime;
    //private int distance;

    /*
    roadDirections;
    travelMode;
    Boolean isWorking;
    ArrayList<Assignment> assignments;
    schema;
    */

    public Agent(Position position, int id, String firstName, String surName, int travelTime) {
        this.position = position;
        this.id = id;
        this.firstName = firstName;
        this.surName = surName;
        this.travelTime = travelTime;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    /*public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }*/

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public int getTravelTime() {
        return travelTime;
    }

    public void setTravelTime(int travelTime) {
        this.travelTime = travelTime;
    }

    @Override
    public int compareTo(Agent o) {
        return this.travelTime - o.travelTime;
    }

    /*public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }*/

    /*public Boolean getWorking() {
        return isWorking;
    }

    public void setWorking(Boolean working) {
        isWorking = working;
    }*/
}
