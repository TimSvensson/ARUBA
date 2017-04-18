/*
 * Project: ARUBA
 * Class:   GeocodingGoogle
 *
 * Version info
 * Created: 18/04/17
 * Creator: Haubir Mariwani
 *
 * Copyright notice
 * Property of Fasbros IT. Do not copy, alter, distribute, or sell in any way unless given explicit permission.
 */


package com.GoogleAPI;

import com.Interface.GeocodingInterface;
import com.google.maps.GeoApiContext;
import com.google.maps.GeocodingApi;
import com.google.maps.errors.ApiException;
import com.google.maps.model.GeocodingResult;

import java.io.IOException;

/**
 * Handles the functionalities and duties of the Google Geocoding API in this system.
 * <p>
 * Upon receiving an address to geocode, the GeocodingGoogle object makes a request to
 * the Google Geocoding API and receives the corresponding geocodes for the address, and
 * stores them within the object.
 *
 * </p>
 *
 * @author Haubir Mariwani <haubir.mariwani@fasbros.it>
 * @version JDK 1.8
 * @since JDK 1.8
 */
public class GeocodingGoogle implements GeocodingInterface {
    String apiKey = "AIzaSyC3SJNwOjapbbdwGZlanF1mC83UGEbWH7s";
    GeoApiContext context = new GeoApiContext().setApiKey(apiKey);
    private double latitude;
    private double longitude;
    private String formattedAddress;
    private GeocodingResult[] results;

    /**
     * Constructs the GeocodingGoogle object by passing the parameter string to the modify() method
     * that makes the request to the Google Geocoding API and sets the local variables.
     *
     * @param address - the address that is to be geocoded
     * @throws InterruptedException - In case the request in modify() is interrupted
     * @throws ApiException - In case the request in modify() is disturbed by an APIException
     * @throws IOException - In case the request in modify() is disturbed by an IOException
     */
    public GeocodingGoogle(String address) throws InterruptedException, ApiException, IOException {
        this.modify(address);
    }

    /**
     * Returns the latitude of the location that was geocoded
     *
     * @return latitude
     */
    public double getLatitude() {
        return latitude;
    }

    /**
     * Returns the longitude of the location that was geocoded
     *
     * @return longitude
     */
    public double getLongitude() {
        return longitude;
    }

    /**
     * Returns the address of the location that was geocoded
     *
     * @return formattedAddress
     */
    public String getFormattedAddress() {
        return formattedAddress;
    }

    /**
     * Returns the results that were received from the request in modify()
     *
     * @return results
     */
    public GeocodingResult[] getResults() {
        return results;
    }

    /**
     * Modifies the object by making a request to the Google Geocoding API for the geocodes
     * of the parameter address and then storing the results in the object's attributes.
     *
     * @param address - the address that is to be geocoded
     */
    // TODO!! Måste kunna spara alla resultat i result-arrayen.
    public void modify(String address) throws InterruptedException, ApiException, IOException {
        this.results = GeocodingApi.geocode(this.context, address).await();
        this.formattedAddress = this.results[0].formattedAddress;
        this.latitude = this.results[0].geometry.location.lat;
        this.longitude = this.results[0].geometry.location.lng;
    }
}

