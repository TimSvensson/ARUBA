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
 * @version JDK 1.8
 * @since JDK 1.8
 */

package com;

public class Assignment {
    private Position position;
    private String id;
    private String clientName;
    private int startTime;
    private int endTime;

    /**
     * @author Created by Haubir -  haubir.mariwani@fasbros.it
     *                              jagheterhaubir@gmail.com
     *
     * Constructs the Assignment object with it's respective attributes.
     * @param position      - the position of the Assignment
     * @param id            - the id of the Assignment
     * @param clientName    - the name of the client
     * @param startTime     - The time the Assignment starts
     * @param endTime       - The time the Assignment ends
     */
    @Deprecated
    public Assignment(Position position, String id, String clientName, int startTime, int endTime) {
        this.position = position;
        this.id = id;
        this.clientName = clientName;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    /**
     * Constructs the Assignment object with it's respective attributes. Without the time.
     * @param position      - the position of the Assignment
     * @param id            - the id of the Assignment
     * @param clientName    - the name of the client
     */
    public Assignment(Position position, String id, String clientName) {
        this.position = position;
        this.id = id;
        this.clientName = clientName;
    }

    /**
     * @author Created by Haubir -  haubir.mariwani@fasbros.it
     *                              jagheterhaubir@gmail.com
     *
     * Returns the id of the Assignemnt.
     * @return id
     */
    public String getId() {
        return id;
    }

    /**
     * @author Created by Haubir -  haubir.mariwani@fasbros.it
     *                              jagheterhaubir@gmail.com
     *
     * Sets the id of the Assignment to the parameter.
     * @param id - the id to be set
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @author Created by Haubir -  haubir.mariwani@fasbros.it
     *                              jagheterhaubir@gmail.com
     *
     * Returns the position of the Assignment.
     * @return position
     */
    public Position getPosition() {
        return position;
    }

    /**
     * @author Created by Haubir -  haubir.mariwani@fasbros.it
     *                              jagheterhaubir@gmail.com
     *
     * Sets the position of the Assignment to the parameter.
     * @param position - the position to be set
     */
    public void setPosition(Position position) {
        this.position = position;
    }

    /**
     * @author Created by Haubir -  haubir.mariwani@fasbros.it
     *                              jagheterhaubir@gmail.com
     *
     * Returns the name of the client.
     * @return clientName
     */
    public String getClientName() {
        return clientName;
    }

    /**
     * @author Created by Haubir -  haubir.mariwani@fasbros.it
     *                              jagheterhaubir@gmail.com
     *
     * Sets the name of the client for the Assignment.
     * @param clientName - the name to be set
     */
    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    /**
     * @author Created by Haubir -  haubir.mariwani@fasbros.it
     *                              jagheterhaubir@gmail.com
     *
     * Returns the starting time of the Assignment.
     * @return startTime
     */
    public int getStartTime() {
        return startTime;
    }

    /**
     * @author Created by Haubir -  haubir.mariwani@fasbros.it
     *                              jagheterhaubir@gmail.com
     *
     * Sets the starting time of the Assignment.
     * @param startTime - the time to be set
     */
    public void setStartTime(int startTime) {
        this.startTime = startTime;
    }

    /**
     * @author Created by Haubir -  haubir.mariwani@fasbros.it
     *                              jagheterhaubir@gmail.com
     *
     * Returns the ending time of the Assignment.
     * @return endTime
     */
    public int getEndTime() {
        return endTime;
    }

    /**
     * @author Created by Haubir -  haubir.mariwani@fasbros.it
     *                              jagheterhaubir@gmail.com
     *
     * Sets the ending time of the Assignment.
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
