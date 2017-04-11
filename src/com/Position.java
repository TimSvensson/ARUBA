/**
 *
 * A position in the world.
 * <p>
 * This object contains one or several types of information about a place:
 *
 *      - Geocoordinates
 *      - Address
 *      - City
 *      - Country
 *      - Postcode
 *      - Zip - The two first digits in the postcode
 *
 * @author Created by Haubir -  haubir.mariwani@fasbros.it
 *                              jagheterhaubir@gmail.com
 * @version //What version of java is current
 * @since April 5th of 2017
 */

package com;

public class Position {
    private Geocoordinate geocoordinate;
    private String address;
    private String city;
    private String county;
    private String country;
    private String postcode;
    private String zip;

    public Position(Geocoordinate geocoordinate, String address, String city, String county, String country, String postcode, String zip) {
        this.geocoordinate = geocoordinate;
        this.address = address;
        this.city = city;
        this.county = county;
        this.country = country;
        this.postcode = postcode;
        this.zip = zip;
    }

    public Position(String zip) {
        new Position(new Geocoordinate(0,0), "", "", "", "", "", zip);
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
