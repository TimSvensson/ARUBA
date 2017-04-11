package com;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by desiree on 2017-04-11.
 * Tests for position.java, at this point it's just basic.
 */
public class PositionTest {
    public Geocoordinate geoTestHelp = new Geocoordinate(2222, 6666);
    public Position positionTest = new Position(geoTestHelp, "", "", "", "Sweden", "", "");

    @Test
    public void getGeocoordinate() throws Exception {
        assertEquals(2222 ,positionTest.getGeocoordinate().getLatitude());
        assertEquals(6666, positionTest.getGeocoordinate().getLongitude());
    }

    @Test
    public void setGeocoordinate() throws Exception {
        Geocoordinate geoHelp = new Geocoordinate(2228,6668);
        positionTest.setGeocoordinate(geoHelp);
        assertEquals(2228 ,positionTest.getGeocoordinate().getLatitude());
        assertEquals(6668, positionTest.getGeocoordinate().getLongitude());
    }

    @Test
    public void getAddress() throws Exception {
        assertEquals("", positionTest.getAddress());
    }

    @Test
    public void setAddress() throws Exception {
        positionTest.setAddress("Ringvalla 130");
        assertEquals("Ringvalla 130", positionTest.getAddress());
    }

    @Test
    public void getCity() throws Exception {
        assertEquals("", positionTest.getCity());
    }

    @Test
    public void setCity() throws Exception {
        positionTest.setCity("Uppsala");
        assertEquals("Uppsala", positionTest.getCity());
    }

    @Test
    public void getCounty() throws Exception {
        assertEquals("", positionTest.getCounty());
    }

    @Test
    public void setCounty() throws Exception {
        positionTest.setCounty("Kansas");
        assertEquals("Kansas", positionTest.getCounty());
    }

    @Test
    public void getCountry() throws Exception {
        assertEquals("Sweden", positionTest.getCountry());
    }

    @Test
    public void setCountry() throws Exception {
        positionTest.setCountry("Poland");
        assertEquals("Poland", positionTest.getCountry());
    }

    @Test
    public void getPostcode() throws Exception {
        assertEquals("", positionTest.getPostcode());
    }

    @Test
    public void setPostcode() throws Exception {
        positionTest.setPostcode("75272");
        assertEquals("75272", positionTest.getPostcode());
    }

    @Test
    public void getZip() throws Exception {
        assertEquals("", positionTest.getZip());
    }

    @Test
    public void setZip() throws Exception {
        positionTest.setZip("42");
        assertEquals("42", positionTest.getZip());
    }

}