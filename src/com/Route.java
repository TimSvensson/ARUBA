/*
 * Project: ARUBA
 * Class:   AllRoutes
 *
 * Version info
 * Created: 12/04/17
 * Creator: Tim Svensson
 *
 * Copyright notice
 * Property of Fasbros IT. Do not copy, alter, distribute, or sell in any way unless given explicit permission.
 */

package com;

/**
 * Saves a route as a distance, a time and a modeOfTransport.
 * <p>
 * Used in conjunction with the TravelRoutes class. Saves a specific route, the distance, the time, and the modeOfTransport used
 * between the origin and the destination.
 *
 * @author  Tim Svensson <tim.svensson@fasbros.it>
 * @version JDK 1.8
 * @since   JDK 1.8
 */
public class Route {

    //<editor-fold desc="Member variables">

    private double distance;
    private long time;
    private String modeOfTransport;
    // TODO Add unit variable for time and distance

    //</editor-fold>

    public Route(double distance, long time, String modeOfTransport) {
        this.distance = distance;
        this.time = time;
        this.modeOfTransport = modeOfTransport;
    }

    //<editor-fold desc="Getters">

    public double getDistance() {
        return distance;
    }

    public long getTime() {
        return time;
    }

    public String getModeOfTransport() {
        return modeOfTransport;
    }

    //</editor-fold>

    @Override
    public String toString() {
        // TODO imporve
        return "vehicle: " + modeOfTransport + ", distance: " + distance + " m, time: " + time + " s";
    }
}