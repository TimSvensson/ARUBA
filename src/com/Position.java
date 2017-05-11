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
 * @since April 11th of 2017
 */

package com;

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
     * @author Created by Haubir -  haubir.mariwani@fasbros.it
     *                              jagheterhaubir@gmail.com
     *
     * Constructs a Position object with its respective attributes
     * @param geocoordinate     - the Geocoordinates of the Position
     * @param address           - the address of the Position
     * @param city              - the city of the Position
     * @param county            - the county of the Position
     * @param country           - the country of the Position
     * @param postcode          - the postcode of the Position
     * @param zip               - the zip of the Position
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

    public Position() {
    }

    public Position(String address, String city, String county, String country, String postcode,
                    String zip) {
        this.address = address;
        this.city = city;
        this.county = county;
        this.country = country;
        this.postcode = postcode;
        this.zip = zip;
    }

/*    public Position(String name, String address, String city, String county, String country, String postcode, String zip) {
        this.name = name;
        this.address = address;
        this.city = city;
        this.county = county;
        this.country = country;
        this.postcode = postcode;
        this.zip = zip;
    }*/


    public Position(Geocoordinate geocoordinate) {

        this.geocoordinate = geocoordinate;
    }

    public boolean hasGeocoordinate() {
        return getGeocoordinate() != null && getGeocoordinate().getLongitude() >= 0 &&
               getGeocoordinate().getLatitude() >= 0;
    }

    public boolean usingZip() {
        if (getZip() != null || !getZip().isEmpty() || !getZip().equals("")) {
            if ((getAddress() == null || getAddress().equals("")) && (getCity() == null ||
                                                                      getCity().equals(""))) {
                return true;
            }
        }

        return false;
    }

    /**
     * @author Created by Haubir -  haubir.mariwani@fasbros.it
     *                              jagheterhaubir@gmail.com
     *
     * Alternative constructor for the Position object. Only the zip will be set, the rest of the attributes will
     * be set to either zero or empty strings. Only for testing/developing purposes until further notice.
     *
     * @param zip               - the zip of the Position.
     */
    public Position(String zip) {
        new Position(new Geocoordinate(0,0), "", "", "", "", "",
                     zip);
    }

    /**
     * @author Created by Haubir -  haubir.mariwani@fasbros.it
     *                              jagheterhaubir@gmail.com
     *
     * Returns the geocoordinates of the Position.
     * @return geocoordinate
     */
    public Geocoordinate getGeocoordinate() {
        return geocoordinate;
    }

    /**
     * @author Created by Haubir -  haubir.mariwani@fasbros.it
     *                              jagheterhaubir@gmail.com
     *
     * Sets the geocoordinates of the Position
     * @param geocoordinate - the geocoordinates to be set
     */
    public void setGeocoordinate(Geocoordinate geocoordinate) {
        this.geocoordinate = geocoordinate;
    }

    /**
     * @author Created by Haubir -  haubir.mariwani@fasbros.it
     *                              jagheterhaubir@gmail.com
     *
     * Returns the address of the Position.
     * @return address
     */
    public String getAddress() {
        return address;
    }

    /**
     * @author Created by Haubir -  haubir.mariwani@fasbros.it
     *                              jagheterhaubir@gmail.com
     *
     * Sets the address of the Position
     * @param address - the address to be set
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * @author Created by Haubir -  haubir.mariwani@fasbros.it
     *                              jagheterhaubir@gmail.com
     *
     * Returns the city of the Position
     * @return city
     */
    public String getCity() {
        return city;
    }

    /**
     * @author Created by Haubir -  haubir.mariwani@fasbros.it
     *                              jagheterhaubir@gmail.com
     *
     * Sets the geocoordinates of the Position
     * @param city - the city to be set
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * @author Created by Haubir -  haubir.mariwani@fasbros.it
     *                              jagheterhaubir@gmail.com
     *
     * Returns the county of the Position
     * @return county
     */
    public String getCounty() {
        return county;
    }

    /**
     * @author Created by Haubir -  haubir.mariwani@fasbros.it
     *                              jagheterhaubir@gmail.com
     *
     * Sets the county of the Position
     * @param county - the county to be set
     */
    public void setCounty(String county) {
        this.county = county;
    }

    /**
     * @author Created by Haubir -  haubir.mariwani@fasbros.it
     *                              jagheterhaubir@gmail.com
     *
     * Returns the country of the Position
     * @return country
     */
    public String getCountry() {
        return country;
    }

    /**
     * @author Created by Haubir -  haubir.mariwani@fasbros.it
     *                              jagheterhaubir@gmail.com
     *
     * Sets the country of the Position
     * @param country - the country to be set
     */
    public void setCountry(String country) {
        this.country = country;
    }

    /**
     * @author Created by Haubir -  haubir.mariwani@fasbros.it
     *                              jagheterhaubir@gmail.com
     *
     * Returns the postcode of the Position
     * @return postcode
     */
    public String getPostcode() {
        return postcode;
    }

    /**
     * @author Created by Haubir -  haubir.mariwani@fasbros.it
     *                              jagheterhaubir@gmail.com
     *
     * Sets the postcode of the Position
     * @param postcode - the postcode to be set
     */
    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    /**
     * @author Created by Haubir -  haubir.mariwani@fasbros.it
     *                              jagheterhaubir@gmail.com
     *
     * Returns the zip of the Position
     * @return zip
     */
    public String getZip() {
        return this.zip;
    }

    /**
     * @author Created by Haubir -  haubir.mariwani@fasbros.it
     *                              jagheterhaubir@gmail.com
     *
     * Sets the zip of the Position
     * @param zip - the zip to be set
     */
    public void setZip(String zip) {
        this.zip = zip;
    }

    @Override
    public String toString() {
        String s = "";

        // Coordinate
        if (this.getGeocoordinate() != null) {
            s += this.getGeocoordinate().toString();
        }
        // Address
        if ( !(this.getAddress() == null || this.getAddress().isEmpty() || this.getAddress()
                                                                               .equals("")) ) {
            if (!s.equals("")) {
                s += " ";
            }
            s += this.getAddress();
        }
        // Postal code
        if ( !(this.getPostcode() == null || this.getPostcode().isEmpty()
               || this.getPostcode().equals("")) ) {
            if (!s.equals("")) {
                s += " ";
            }
            s += this.getPostcode();
        }
        // City
        if ( !(this.getCity() == null || this.getCity().isEmpty() || this.getCity().equals("")) ) {
            if (!s.equals("")) {
                s += " ";
            }
            s += this.getCity();
        }
        // County
        if ( !(this.getCounty() == null || this.getCounty().isEmpty()
               || this.getCounty().equals("")) ) {
            if (!s.equals("")) {
                s += " ";
            }
            s += this.getCounty();
        }
        // Zip
        if ( !(this.getZip() == null || this.getZip().isEmpty() || this.getZip().equals("")) &&
                (this.getPostcode() == null || this.getPostcode().isEmpty()
                 || this.getPostcode().equals("")) ) {
            if (!s.equals("")) {
                s += " ";
            }
            s += this.getZip();
        }
        // Country
        if ( !(this.getCountry() == null || this.getCountry().isEmpty()
               || this.getCountry().equals("")) ) {
            if (!s.equals("")) {
                s += " ";
            }
            s += this.getCountry();
        }

        return s;
    }
}
