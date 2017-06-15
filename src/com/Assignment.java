/*
 * Project: ARUBA
 * Class:   Assignment
 *
 * Version info
 * Created: 4/11/17
 * Creator: Haubir Mariwani
 *
 * Copyright notice
 * Property of Fasbros IT. Do not copy, alter, distribute, or sell in any way unless given explicit permission.
 */

package com;

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
 * @since April 11th of 2017
 */
public class Assignment {
    private Position position;
    private String id;
    private String clientName;
    private int startTime;
    private int endTime;

    /**
     * @author Created by Haubir -  haubir.mariwani@fasbros.it
     *
     * Constructs the Assignment object with its respective attributes.
     *
     * @param position      - the position of the Assignment
     * @param id            - the id of the Assignment
     * @param clientName    - the name of the client
     * @param startTime     - the time the Assignment starts
     * @param endTime       - the time the Assignment ends
     */
    @Deprecated
    public Assignment(Position position, String id, String clientName, int startTime, int endTime) {
        this.position = position;
        this.id = id;
        this.clientName = clientName;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public Assignment(Position position, String id, String clientName) {
        this.position = position;
        this.id = id;
        this.clientName = clientName;
    }

    /**
     * @author Created by Haubir -  haubir.mariwani@fasbros.it
     *
     * Constructs the Assignment object with a position and an id.
     *
     * @param position      - the position of the Assignment
     * @param id            - the id of the Assignment
     */
    public Assignment(Position position, String id) {
        this.position = position;
        this.id = id;
    }

    /**
     * @author Created by Haubir -  haubir.mariwani@fasbros.it
     *
     * Returns the id of the Assignemnt.
     *
     * @return id
     */
    public String getId() {
        return id;
    }

    /**
     * @author Created by Haubir -  haubir.mariwani@fasbros.it
     *
     * Sets the id of the Assignment to the parameter.
     *
     * @param id - the id to be set
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @author Created by Haubir -  haubir.mariwani@fasbros.it
     *
     * Returns the position of the Assignment.
     *
     * @return position
     */
    public Position getPosition() {
        return position;
    }

    /**
     * @author Created by Haubir -  haubir.mariwani@fasbros.it
     *
     * Sets the position of the Assignment to the parameter.
     *
     * @param position - the position to be set
     */
    public void setPosition(Position position) {
        this.position = position;
    }

    /**
     * @author Created by Haubir -  haubir.mariwani@fasbros.it
     *
     * Returns the name of the client.
     *
     * @return clientName
     */
    public String getClientName() {
        return clientName;
    }

    /**
     * @author Created by Haubir -  haubir.mariwani@fasbros.it
     *
     * Sets the name of the client for the Assignment.
     *
     * @param clientName - the name to be set
     */
    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    /**
     * @author Created by Haubir -  haubir.mariwani@fasbros.it
     *
     * Returns the starting time of the Assignment.
     *
     * @return startTime
     */
    public int getStartTime() {
        return startTime;
    }

    /**
     * @author Created by Haubir -  haubir.mariwani@fasbros.it
     *
     * Sets the starting time of the Assignment.
     *
     * @param startTime - the time to be set
     */
    public void setStartTime(int startTime) {
        this.startTime = startTime;
    }

    /**
     * @author Created by Haubir -  haubir.mariwani@fasbros.it
     *
     * Returns the ending time of the Assignment.
     *
     * @return endTime
     */
    public int getEndTime() {
        return endTime;
    }

    /**
     * @author Created by Haubir -  haubir.mariwani@fasbros.it
     *
     * Sets the ending time of the Assignment.
     *
     * @param endTime - the time to be set
     */
    public void setEndTime(int endTime) {
        this.endTime = endTime;
    }

    @Override
    public String toString() {
        return this.getClientName() + " " + this.getId();
    }
}
