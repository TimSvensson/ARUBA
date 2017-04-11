package com;

import com.google.maps.GeoApiContext;
import com.google.maps.errors.ApiException;

import java.io.IOException;

import static com.google.maps.model.TravelMode.DRIVING;

/**
 * Created by Haubir on 4/7/17.
 */
public class DirectionsTest {
    private String [] addresses         = {    "Sernanders Väg 7",     "Flogstavägen 73A",     "Flogstavägen 77B"};
    private int [] travelDistances;
    private int [] travelTimes;

    public DirectionsTest(GeoApiContext context, String apiKey, String destAddress) throws InterruptedException, ApiException, IOException {
        DirectionsValues [] agentDirectionsList = new DirectionsValues[addresses.length];
        this.travelDistances = new int[addresses.length];
        this.travelTimes = new int[addresses.length];

        for(int i = 0; i < addresses.length; i++) {
            DirectionsValues agentDirections = new DirectionsValues(context, this.addresses[i], destAddress, DRIVING);
            agentDirectionsList[i] = agentDirections;
            this.travelDistances[i] = agentDirections.getTotalDistance();
            this.travelTimes[i] = agentDirections.getTotalDuration();
        }
    }

    public String[] getAddresses() {
        return addresses;
    }

    public void setAddresses(String[] addresses) {
        this.addresses = addresses;
    }

    public int[] getTravelDistances() {
        return travelDistances;
    }

    public int[] getTravelTimes() {
        return travelTimes;
    }
}
