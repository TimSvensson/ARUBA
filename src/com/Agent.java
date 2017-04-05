package com;

// import java.util.ArrayList;

import java.util.Comparator;

/**
 * Created by Haubir on 4/5/17.
 */
public class Agent implements Comparable<Agent> {
    private Position position;
    private String id;
    private String firstName;
    private String surName;
    private int travelTime;
    /* int distance; */
    /* roadDirections; */
    /*
    travelMode;
    Boolean isWorking;
    ArrayList<Assignment> assignments;
    schema;
    */

    public Agent(Position position, String id, String firstName, String surName, int travelTime) {
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
