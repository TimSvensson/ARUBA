package com;

/**
 * Created by Haubir on 4/5/17.
 */
public class Geocoordinate {
    private int latitude;
    private int longitude;

    public Geocoordinate(int latitude, int longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public int getLatitude() {
        return latitude;
    }

    public void setLatitude(int latitude) {
        this.latitude = latitude;
    }

    public int getLongitude() {
        return longitude;
    }

    public void setLongitude(int longitude) {
        this.longitude = longitude;
    }
}
