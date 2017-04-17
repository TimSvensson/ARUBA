package com.GoogleAPITests;

import com.GoogleAPI.DirectionsGoogle;
import com.google.maps.GeoApiContext;
import com.google.maps.errors.ApiException;
import org.junit.Test;

import java.io.IOException;

/**
 * Created by timsvensson on 12/04/17.
 */
public class GoogleDirectionsAPITest {
    // Google Maps Directions API test
    String apiKey = "AIzaSyC3SJNwOjapbbdwGZlanF1mC83UGEbWH7s";
    GeoApiContext context = new GeoApiContext().setApiKey(apiKey);
    String destAddress = "751 45";
    String [] firstNames        = {    "Haubir",               "Desireé",              "Tim"};
    String [] lastNames         = {    "Mariwani",             "Björkman",             "Svensson"};
    @Test
    public void function() throws InterruptedException, ApiException, IOException {
        //DirectionsGoogle.DirectionsTest directionsTest = new DirectionsGoogle.DirectionsTest(context, apiKey, destAddress);

    }
}
