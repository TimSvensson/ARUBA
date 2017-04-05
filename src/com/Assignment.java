package com;

/**
 * Created by Haubir on 4/5/17.
 */
public class Assignment {
    Position position;
    String id;
    String clientName;
    int startTime;
    int endTime;

    public Assignment(Position position, String id, String clientName, int startTime, int endTime) {
        this.position = position;
        this.id = id;
        this.clientName = clientName;
        this.startTime = startTime;
        this.endTime = endTime;
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
