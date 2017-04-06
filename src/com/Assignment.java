/**
 *
 * An assignment.
 * <p>
 * An assignment that needs an agent. The Assignment object contains important information
 * about the assignment, that will be used when the program finds out how long it takes for the agents
 * to reach the assignment's position.
 *
 * @author Created by Haubir -  haubir.mariwani@fasbros.it
 *                              jagheterhaubir@gmail.com
 * @version //What version of java is current
 * @since April 5th of 2017
 */

package com;

public class Assignment {
    private Position position;
    private int id;
    private String clientName;
    private int startTime;
    private int endTime;

    public Assignment(Position position, int id, String clientName, int startTime, int endTime) {
        this.position = position;
        this.id = id;
        this.clientName = clientName;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public int getStartTime() {
        return startTime;
    }

    public void setStartTime(int startTime) {
        this.startTime = startTime;
    }

    public int getEndTime() {
        return endTime;
    }

    public void setEndTime(int endTime) {
        this.endTime = endTime;
    }
}
