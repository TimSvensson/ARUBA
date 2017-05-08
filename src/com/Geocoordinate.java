/**
 *
 * A geocoordinate.
 * <p>
 * This object contains a positions latitude and longitude values.
 *
 * @author Created by Haubir -  haubir.mariwani@fasbros.it
 *                              jagheterhaubir@gmail.com
 * @version //What version of java is current
 * @since April 5th of 2017
 */

package com;

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
        return "(lat=" + getLatitude() + ", lon=" + getLongitude() + ")";
    }

    public boolean equals(Geocoordinate g) {
        return (this.latitude == g.getLatitude() && this.longitude == g.getLongitude());
    }

    public String getGoogleString() {
        return latitude + ", " + longitude;
    }
}
