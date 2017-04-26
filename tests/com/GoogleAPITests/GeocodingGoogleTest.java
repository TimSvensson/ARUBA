package com.GoogleAPITests;


import com.GoogleAPI.GeocodingGoogle;
import com.Position;
import com.google.maps.GeoApiContext;
import com.google.maps.GeocodingApi;
import com.google.maps.errors.ApiException;
import com.google.maps.model.GeocodingResult;
import org.junit.Test;

import java.io.IOException;

/**
 * Created by timsvensson on 12/04/17.
 */
public class GeocodingGoogleTest {
    String apiKey = "AIzaSyC3SJNwOjapbbdwGZlanF1mC83UGEbWH7s";
    GeoApiContext context = new GeoApiContext().setApiKey(apiKey);

    @Test
    public void geocode() {

    }

    @Test
    public void reverseGeocode(){
    }

    @Test
    public void getInputString() {

    }

    @Test
    public void getLatitude() {

    }

    @Test
    public void getLongitude() {

    }

    @Test
    public void getFormattedAddress() {

    }

    @Test
    public void getResults() {

    }

    @Test
    public void modify() throws InterruptedException, ApiException, IOException {

    }

}
