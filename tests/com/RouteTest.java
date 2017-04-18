package com;

import org.junit.Test;
import org.junit.Test;

//import static org.junit.Assertions.*;
import static org.testng.AssertJUnit.*;

/**
 * Created by timsvensson on 17/04/17.
 */
public class RouteTest {

    String vehicle = "foot";
    double distance = 1337;
    long time = 9001;
    Route route = new Route(distance, time, vehicle);

    @Test
    public void getDistance() {
        assertEquals(distance, route.getDistance());
    }

    @Test
    public void getTime() {
        assertEquals(time, route.getTime());
    }

    @Test
    public void getModeOfTransport() {
        assertTrue(route.getModeOfTransport().equals(vehicle));
    }

}