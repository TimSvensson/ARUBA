/**
 * @author Created by Haubir -  haubir.mariwani@fasbros.it
 *                              jagheterhaubir@gmail.com
 *
 * A class that collects information about a DirectionsValues object.
 * <p>
 * The DirectionsTest object collects information about a DirectionsValues object.
 *
 * @version //What version of java is current
 * @since April 11th of 2017
 */

package com;

import com.google.maps.GeoApiContext;
import com.google.maps.errors.ApiException;

import java.io.IOException;

import static com.google.maps.model.TravelMode.DRIVING;

public class DirectionsTest {
    private String [] addresses         = {    "Sernanders Väg 7",     "Flogstavägen 73A",     "Flogstavägen 77B"};
    private long [] travelDistances;
    private long [] travelTimes;

    public DirectionsTest(GeoApiContext context, String apiKey, String destAddress) throws InterruptedException, ApiException, IOException {
        DirectionsValues [] agentDirectionsList = new DirectionsValues[addresses.length];
        this.travelDistances = new long[addresses.length];
        this.travelTimes = new long[addresses.length];

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

    public long[] getTravelDistances() {
        return travelDistances;
    }

    public long[] getTravelTimes() {
        return travelTimes;
    }
}
