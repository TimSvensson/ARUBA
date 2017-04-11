package com;

import com.google.maps.DirectionsApi;
import com.google.maps.GeoApiContext;
import com.google.maps.errors.ApiException;
import com.google.maps.model.DirectionsResult;
import com.google.maps.model.TravelMode;

import java.io.IOException;

import static com.google.maps.model.TravelMode.DRIVING;
import static com.google.maps.model.TravelMode.TRANSIT;
import static com.google.maps.model.TravelMode.WALKING;

/**
 * Created by Haubir on 4/7/17.
 */
public class DirectionsValues {
    private DirectionsResult dirResult;
    private int totalDistance;
    private int totalDuration;
/*
    public DirectionsValues(GeoApiContext context, String origAddress, String destAddress) throws InterruptedException, ApiException, IOException {
        new DirectionsValues(context, origAddress, destAddress, DRIVING);
        System.out.println("totalDistance: " + this.totalDistance);
        System.out.println("totalDuration: " + this.totalDuration);
    }
*/
    public DirectionsValues(GeoApiContext context, String origAddress, String destAddress, TravelMode mode) throws InterruptedException, ApiException, IOException {
        this.dirResult = DirectionsApi.getDirections(context, origAddress, destAddress).mode(mode).await();
        this.totalDistance = (int) this.dirResult.routes[0].legs[0].distance.inMeters;
        this.totalDuration = (int) this.dirResult.routes[0].legs[0].duration.inSeconds;
        System.out.println("totalDistance: " + this.totalDistance);
        System.out.println("totalDuration: " + this.totalDuration);
    }

    public DirectionsResult getDirResult() {
        return dirResult;
    }

    public int getTotalDistance() {
        return totalDistance;
    }

    public int getTotalDuration() {
        return totalDuration;
    }
}
