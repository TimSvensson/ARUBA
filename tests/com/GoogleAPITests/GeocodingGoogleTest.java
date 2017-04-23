package com.GoogleAPITests;


import com.GoogleAPI.GeocodingGoogle;
import com.google.maps.errors.ApiException;
import org.junit.Test;

import java.io.IOException;

/**
 * Created by timsvensson on 12/04/17.
 */
public class GeocodingGoogleTest {
    String address = "Uppsala Business Park";


    /*public GeocodingGoogle init() throws InterruptedException, ApiException, IOException {
        GeocodingGoogle geocodingGoogle = new GeocodingGoogle(address);

        return geocodingGoogle;
    }*/
    @Test
    public void Modify() throws InterruptedException, ApiException, IOException {
//        GeocodingGoogle geocodingGoogle = init();
//        geocodingGoogle.modify("Uppsala Science Park");
//
//        assert("Uppsala Science Park".equals(geocodingGoogle.getInputString()));
    }

    @Test
    public void GetLatitude() {

    }

    @Test
    public void GetLongitude() {

    }

    @Test
    public void GetFormattedAddress() {

    }

    @Test
    public void GetResults() {

    }

}
