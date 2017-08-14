/*
 * Project: ARUBA
 * Class:   Position
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
 * A position in the world.
 * <p>
 * This object contains one or several types of information about a place:
 * <p>
 * - Geocoordinates
 * - Address
 * - City
 * - Country
 * - Postcode
 * - Zip - The two first digits in the postcode
 *
 * @author Created by Haubir -  haubir.mariwani@fasbros.it
 * @version //What version of java is current
 * @since April 11th of 2017
 */
public class Position {
    private Geocoordinate geocoordinate;
    //private String name;
    private String address;
    private String city;
    private String county;
    private String country;
    private String postcode;
    private String zip;

    /**
     * @param geocoordinate - the Geocoordinates of the Position
     * @param address       - the address of the Position
     * @param city          - the city of the Position
     * @param county        - the county of the Position
     * @param country       - the country of the Position
     * @param postcode      - the postcode of the Position
     * @param zip           - the zip of the Position
     *
     * @author Created by Haubir -  haubir.mariwani@fasbros.it
     * jagheterhaubir@gmail.com
     * <p>
     * Constructs a Position object with its respective attributes
     */
    public Position(Geocoordinate geocoordinate, String address, String city, String county,
                    String country, String postcode, String zip) {
        this.geocoordinate = geocoordinate;
        this.address = address;
        this.city = city;
        this.county = county;
        this.country = country;
        this.postcode = postcode;
        this.zip = zip;
    }

    /**
     * @author Created by Haubir -  haubir.mariwani@fasbros.it
     * jagheterhaubir@gmail.com
     * <p>
     * Constructs an empty Position object
     */
    public Position() {
    }

    /**
     * @param address  - the address of the Position
     * @param city     - the city of the Position
     * @param county   - the county of the Position
     * @param country  - the country of the Position
     * @param postcode - the postcode of the Position
     * @param zip      - the zip of the Position
     *
     * @author Created by Haubir -  haubir.mariwani@fasbros.it
     * jagheterhaubir@gmail.com
     * <p>
     * Constructs a Position object without a geocoordinate
     */
    public Position(String address, String city, String county, String country, String postcode,
                    String zip) {
        this.address = address;
        this.city = city;
        this.county = county;
        this.country = country;
        this.postcode = postcode;
        this.zip = zip;
    }

    /*
    public Position(String name, String address, String city, String county, String country, String postcode, String zip) {
        this.name = name;
        this.address = address;
        this.city = city;
        this.county = county;
        this.country = country;
        this.postcode = postcode;
        this.zip = zip;
    }*/

    /**
     * Constructs a Position object with a Geocoordinate
     */
    public Position(Geocoordinate geocoordinate) {
        this.geocoordinate = geocoordinate;
    }

    /**
     * @param zip - the zip of the Position.
     *
     * @author Created by Haubir -  haubir.mariwani@fasbros.it
     * jagheterhaubir@gmail.com
     * <p>
     * Alternative constructor for the Position object. Only the zip will be set, the rest of the attributes will
     * be set to either zero or empty strings. Only for testing/developing purposes until further notice.
     */
    public Position(String zip) {
        new Position(new Geocoordinate(0, 0), "", "", "", "", "", zip);
    }

    /**
     * Checks if the Position object has a Geocoordinate.
     *
     * @return true if there is a Geocoordinate, false otherwise
     *
     * @author Created by Tim -  tim.svensson@fasbros.it
     */
    public boolean hasGeocoordinate() {
        return getGeocoordinate() != null && getGeocoordinate().getLongitude() >= 0 &&
                getGeocoordinate().getLatitude() >= 0;
    }

    /**
     * Checks if a string is not empty. Serves as an auxilliary method for the usingZip() method below.
     *
     * @param s
     *
     * @return true if the string isn't empty, false otherwise
     *
     * @author Created by Tim -  tim.svensson@fasbros.it
     */
    private boolean stringNotEmpty(String s) {
        return !(s == null || s.isEmpty() || s.equals(""));
    }

    /**
     * Checks if the most precise positionformat of the Position object is a Zip
     *
     * @return true if Zip is the most precise format, false otherwise
     *
     * @author Created by Tim -  tim.svensson@fasbros.it
     */
    public boolean usingZip() {

        if (hasGeocoordinate()) {
            return false;
        }

        if (stringNotEmpty(this.postcode) || stringNotEmpty(this.city)
                || stringNotEmpty(this.address)) {
            return false;
        }

        if (!stringNotEmpty(this.zip)) {
            return false;
        }

        return true;
    }

    /**
     * @return geocoordinate
     *
     * @author Created by Haubir -  haubir.mariwani@fasbros.it
     * jagheterhaubir@gmail.com
     * <p>
     * Returns the geocoordinates of the Position.
     */
    public Geocoordinate getGeocoordinate() {
        return geocoordinate;
    }

    /**
     * @param geocoordinate - the geocoordinates to be set
     *
     * @author Created by Haubir -  haubir.mariwani@fasbros.it
     * jagheterhaubir@gmail.com
     * <p>
     * Sets the geocoordinates of the Position
     */
    public void setGeocoordinate(Geocoordinate geocoordinate) {
        this.geocoordinate = geocoordinate;
    }

    /**
     * @return address
     *
     * @author Created by Haubir -  haubir.mariwani@fasbros.it
     * jagheterhaubir@gmail.com
     * <p>
     * Returns the address of the Position.
     */
    public String getAddress() {
        return address;
    }

    /**
     * @param address - the address to be set
     *
     * @author Created by Haubir -  haubir.mariwani@fasbros.it
     * jagheterhaubir@gmail.com
     * <p>
     * Sets the address of the Position
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * @return city
     *
     * @author Created by Haubir -  haubir.mariwani@fasbros.it
     * jagheterhaubir@gmail.com
     * <p>
     * Returns the city of the Position
     */
    public String getCity() {
        return city;
    }

    /**
     * @param city - the city to be set
     *
     * @author Created by Haubir -  haubir.mariwani@fasbros.it
     * jagheterhaubir@gmail.com
     * <p>
     * Sets the geocoordinates of the Position
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * @return county
     *
     * @author Created by Haubir -  haubir.mariwani@fasbros.it
     * jagheterhaubir@gmail.com
     * <p>
     * Returns the county of the Position
     */
    public String getCounty() {
        return county;
    }

    /**
     * @param county - the county to be set
     *
     * @author Created by Haubir -  haubir.mariwani@fasbros.it
     * jagheterhaubir@gmail.com
     * <p>
     * Sets the county of the Position
     */
    public void setCounty(String county) {
        this.county = county;
    }

    /**
     * @return country
     *
     * @author Created by Haubir -  haubir.mariwani@fasbros.it
     * jagheterhaubir@gmail.com
     * <p>
     * Returns the country of the Position
     */
    public String getCountry() {
        return country;
    }

    /**
     * @param country - the country to be set
     *
     * @author Created by Haubir -  haubir.mariwani@fasbros.it
     * jagheterhaubir@gmail.com
     * <p>
     * Sets the country of the Position
     */
    public void setCountry(String country) {
        this.country = country;
    }

    /**
     * @return postcode
     *
     * @author Created by Haubir -  haubir.mariwani@fasbros.it
     * jagheterhaubir@gmail.com
     * <p>
     * Returns the postcode of the Position
     */
    public String getPostcode() {
        return postcode;
    }

    /**
     * @param postcode - the postcode to be set
     *
     * @author Created by Haubir -  haubir.mariwani@fasbros.it
     * jagheterhaubir@gmail.com
     * <p>
     * Sets the postcode of the Position
     */
    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    /**
     * @return zip
     *
     * @author Created by Haubir -  haubir.mariwani@fasbros.it
     * jagheterhaubir@gmail.com
     * <p>
     * Returns the zip of the Position
     */
    public String getZip() {
        return this.zip;
    }

    /**
     * @param zip - the zip to be set
     *
     * @author Created by Haubir -  haubir.mariwani@fasbros.it
     * jagheterhaubir@gmail.com
     * <p>
     * Sets the zip of the Position
     */
    public void setZip(String zip) {
        this.zip = zip;
    }

    /**
     * Returns a string representation of the Position object which can be used for the GraphHopper requests
     *
     * @return the string representation
     *
     * @author Created by Tim -  tim.svensson@fasbros.it
     */
    @Override
    public String toString() {
        String s = "";

        // Coordinate
        if (this.getGeocoordinate() != null) {
            s += this.getGeocoordinate().toString();
        }
        // Address
        if (!(this.getAddress() == null || this.getAddress().isEmpty() || this.getAddress()
                .equals(""))) {
            if (!s.equals("")) {
                s += " ";
            }
            s += this.getAddress();
        }
        // Postal code
        if (!(this.getPostcode() == null || this.getPostcode().isEmpty()
                || this.getPostcode().equals(""))) {
            if (!s.equals("")) {
                s += " ";
            }
            s += this.getPostcode();
        }
        // City
        if (!(this.getCity() == null || this.getCity().isEmpty() || this.getCity().equals(""))) {
            if (!s.equals("")) {
                s += " ";
            }
            s += this.getCity();
        }
        // County
        if (!(this.getCounty() == null || this.getCounty().isEmpty()
                || this.getCounty().equals(""))) {
            if (!s.equals("")) {
                s += " ";
            }
            s += this.getCounty();
        }
        // Zip
        if (!(this.getZip() == null || this.getZip().isEmpty() || this.getZip().equals("")) &&
                (this.getPostcode() == null || this.getPostcode().isEmpty()
                        || this.getPostcode().equals(""))) {
            if (!s.equals("")) {
                s += " ";
            }
            s += this.getZip();
        }
        // Country
        if (!(this.getCountry() == null || this.getCountry().isEmpty()
                || this.getCountry().equals(""))) {
            if (!s.equals("")) {
                s += " ";
            }
            s += this.getCountry();
        }

        return s;
    }

    /**
     * Returns the most precise position format that the Position object has.
     *
     * @return position format in String representation
     *
     * @author Created by Haubir -  haubir.mariwani@fasbros.it
     * jagheterhaubir@gmail.com
     */
    public String getMostPreciseLocation() {
        String location = "";

        if (this.getGeocoordinate() != null) {
            location = this.getGeocoordinate().toString();
        } else if (!(this.getAddress() == null)) {
            location = this.getAddress();
        } else if (!(this.getPostcode() == null)) {
            location = this.getPostcode() + " " + this.getCity();
        } else if (!(this.getZip() == null)) {
            // Based on hardcoded geocoordinates retrieved manually
            int zipNo = Integer.parseInt(this.getZip());
            location = new Zip(zipNo).getGeocoordinate().toString();

            // Based on the ZipCalc implementation:
            // location = "zip";
        } else if (!(this.getCity() == null)) {
            location = this.getCity();
        } else if (!(this.getCounty() == null)) {
            location = this.getCounty();
        } else if (!(this.getCountry() == null)) {
            location = this.getCountry();
        } else {
            location = "";
        }

        return location;
    }
}
