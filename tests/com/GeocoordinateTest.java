package com;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

/**
 * Created by timsvensson on 20/04/17.
 */
public class GeocoordinateTest {

    Geocoordinate g;

    double lat;
    double lon;
    double tmp;

    @Before
    public void setUp() throws Exception {
        lat = 1;
        lon = 2;
        tmp = 3;

        g = new Geocoordinate(lat, lon);
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void getLatitude() throws Exception {
        assertEquals(lat, g.getLatitude(), 0);
    }

    @Test
    public void setLatitude() throws Exception {
        g.setLatitude(tmp);
        assertEquals(tmp, g.getLatitude(),0);
    }

    @Test
    public void getLongitude() throws Exception {
        assertEquals(lon, g.getLongitude(), 0);
    }

    @Test
    public void setLongitude() throws Exception {
        g.setLongitude(tmp);
        assertEquals(tmp, g.getLongitude(), 0);
    }



}
