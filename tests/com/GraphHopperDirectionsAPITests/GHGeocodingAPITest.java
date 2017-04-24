/*
 * Project: ARUBA
 * Class:   GHGeocodingAPI
 *
 * Version info
 * Created: 12/04/17
 * Creator: Tim Svensson
 *
 * Copyright notice
 * Property of Fasbros IT. Do not copy, alter, distribute, or sell in any way unless given explicit permission.
 */

package com.GraphHopperDirectionsAPITests;

import com.GraphHopperDirectionsAPI.GHGeocodingAPI;
import com.Position;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Class summary.
 * <p>
 * Class Description.
 * </p>
 *
 * @author Tim Svensson <tim.svensson@fasbros.it>
 * @version JDK 1.8
 * @since JDK 1.8
 */
public class GHGeocodingAPITest {

    private GHGeocodingAPI ghGeocodingAPI;

    private Position p0;
    private Position p1;
    private Position p2;
    private Position p3;

    private String apiKey = "7992858f-c567-4ae8-b47c-f409b65f91f4";

    @Before
    public void setUp() throws Exception {
        this.ghGeocodingAPI = new GHGeocodingAPI(apiKey);

        this.p0 = new Position("","Östermalm","","Sweden",
                "","");
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void geocode() throws Exception {
        this.ghGeocodingAPI.setGhGeocodeProvider(GHGeocodingAPI.GHGeocodeProvider.OPENCAGEDATA);
        this.ghGeocodingAPI.setResultLimit(1);
        assertTrue(this.ghGeocodingAPI.geocode(p0));
        System.out.println(this.ghGeocodingAPI.getGeocodingResult().toString());
        System.out.println(this.ghGeocodingAPI.getPositionResult().toString());
    }

    @Test
    public void reverseGeocode() throws Exception {
    }

}