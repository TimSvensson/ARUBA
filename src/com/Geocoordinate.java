package com;

/**
 * Object used to hold a coordinate consisting of a latitude, longitude pair.
 *
 * @author Created by Haubir -  haubir.mariwani@fasbros.it jagheterhaubir@gmail.com
 * @version JDK 1.8
 * @since JDK 1.8
 */
public class Geocoordinate {
    private double latitude;
    private double longitude;

    public Geocoordinate(double latitude, double longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

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
