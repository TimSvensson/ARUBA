package com;

import com.google.maps.GeoApiContext;
import com.google.maps.GeocodingApi;
import com.google.maps.errors.ApiException;
import com.google.maps.model.GeocodingResult;

import java.io.IOException;

/**
 * Created by Haubir on 4/7/17.
 */
public class GeocodeLocation {
    private double destLatitude;
    private double destLongitude;
    private String formattedAddress;
    private GeocodingResult[] results;

    public GeocodeLocation(GeoApiContext context, String destAddress) throws InterruptedException, ApiException, IOException {
        this.modify(context, destAddress);
    }

    public double getDestLatitude() {
        return destLatitude;
    }

    public double getDestLongitude() {
        return destLongitude;
    }

    public String getFormattedAddress() {
        return formattedAddress;
    }

    public GeocodingResult[] getResults() {
        return results;
    }

    public void modify(GeoApiContext context, String destAddress) throws InterruptedException, ApiException, IOException {
        this.results = GeocodingApi.geocode(context, destAddress).await();
        this.formattedAddress = results[0].formattedAddress;
        this.destLatitude = results[0].geometry.location.lat;
        this.destLongitude = results[0].geometry.location.lng;
    }
}
