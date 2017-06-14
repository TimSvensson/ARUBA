/*
 * Project: ARUBA
 * Class:   Geocoordinate
 *
 * Version info
 * Created: 4/5/17
 * Creator: Haubir Mariwani
 *
 * Copyright notice
 * Property of Fasbros IT. Do not copy, alter, distribute, or sell in any way unless given explicit permission.
 */

package com;

/**
 *
 * A geocoordinate.
 * <p>
 * This object contains a positions latitude and longitude values.
 *
 * @author Created by Haubir -  haubir.mariwani@fasbros.it
 *
 * @version //What version of java is current
 * @since April 5th of 2017
 */
public class Geocoordinate {
    private double latitude;
    private double longitude;

    /**
     * Constructs a Geocoordinate object.
     *
     * @param latitude
     * @param longitude
     */
    public Geocoordinate(double latitude, double longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    /**
     * Returns the latitude of the object.
     *
     * @return latitude
     */
    public double getLatitude() {
        return latitude;
    }

    /**
     * Sets the latitude of the object to the input latitude.
     *
     * @param latitude
     */
    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    /**
     * Returns the longitude of the object.
     *
     * @return longitude
     */
    public double getLongitude() {
        return longitude;
    }

    /**
     * Sets the longitude of the object to the input latitude.
     *
     * @param longitude
     */
    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    @Override
    public String toString() {
        return latitude + ", " + longitude;
    }

    public boolean equals(Geocoordinate g) {
        return (this.latitude == g.getLatitude() && this.longitude == g.getLongitude());
    }
}
