package com;

import org.junit.Test;
import org.junit.Test;

//import static org.junit.Assertions.*;
import static org.testng.AssertJUnit.*;

/**
 * Tests for Route.java.
 * <p>
 * Tests the basic functionality of the Route class. Assures that it stores the correct values in the correct member
 * variables. Mostly sanity checks to catch any strange errors that may or may not occure.
 * </p>
 *
 * @author Tim Svensson <tim.svensson@fasbros.it>
 * @version JDK 1.8
 * @since JDK 1.8
 */
public class RouteTest {

    private String vehicle = "foot";
    private double distance = 1337;
    private long time = 9001;
    private Route route = new Route(distance, time, vehicle);

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