package com;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by timsvensson on 17/04/17.
 */
class RouteTest {

    String vehicle = "foot";
    double distance = 1337;
    long time = 9001;
    Route route = new Route(distance, time, vehicle);

    @Test
    void getDistance() {
        assertEquals(distance, route.getDistance());
    }

    @Test
    void getTime() {
        assertEquals(time, route.getTime());
    }

    @Test
    void getModeOfTransport() {
        assertTrue(route.getModeOfTransport().equals(vehicle));
    }

}