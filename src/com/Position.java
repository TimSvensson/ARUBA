package com;

/**
 * Created by Haubir on 4/5/17.
 */
public class Position {
    Geocoordinate geocoordinate;
    String address;
    String city;
    String county;
    String country;
    String postcode;
    String zip;

    public Position(Geocoordinate geocoordinate, String address, String city, String county, String country, String postcode, String zip) {
        this.geocoordinate = geocoordinate;
        this.address = address;
        this.city = city;
        this.county = county;
        this.country = country;
        this.postcode = postcode;
        this.zip = zip;
    }

    public Geocoordinate getGeocoordinate() {
        return geocoordinate;
    }

    public void setGeocoordinate(Geocoordinate geocoordinate) {
        this.geocoordinate = geocoordinate;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCounty() {
        return county;
    }

    public void setCounty(String county) {
        this.county = county;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }
}
