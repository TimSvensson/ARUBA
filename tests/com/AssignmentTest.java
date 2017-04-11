package com;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by desiree on 2017-04-11.
 */
public class AssignmentTest {
    public Geocoordinate geoTestHelp = new Geocoordinate(2222, 6666);
    public Position positionTestHelp = new Position(geoTestHelp, "", "", "", "", "", "");
    public Assignment assTest = new Assignment(positionTestHelp, 42, "Carl", 4, 6);

    @Test
    public void getId() throws Exception {
        assertEquals( 42,assTest.getId());
    }

    @Test
    public void setId() throws Exception {
        assTest.setId(55);
        assertEquals(55, assTest.getId());
    }

    @Test
    public void getPosition() throws Exception {
        Geocoordinate geoHelp = new Geocoordinate(2222, 6666);
        Position posHelp = new Position(geoTestHelp, "", "", "", "", "", "");

        assertTrue(assTest.getPosition().getAddress() == "");
        assertTrue(assTest.getPosition().getCity() == "");
        assertTrue(assTest.getPosition().getCountry() == "");
        assertTrue(assTest.getPosition().getPostcode() == "");
        assertTrue(assTest.getPosition().getZip() == "");
    }

    @Test
    public void setPosition() throws Exception {
        Geocoordinate geoHelp = new Geocoordinate(2222, 6666);
        Position newPosition = new Position(geoTestHelp, "", "Uppsala", "", "", "", "");
        assTest.setPosition(newPosition);

        assertTrue(assTest.getPosition().getAddress() == "");
        assertTrue(assTest.getPosition().getCity() == "Uppsala");
        assertTrue(assTest.getPosition().getCountry() == "");
        assertTrue(assTest.getPosition().getPostcode() == "");
        assertTrue(assTest.getPosition().getZip() == "");
    }

    @Test
    public void getClientName() throws Exception {
        assertEquals("Carl", assTest.getClientName());
    }

    @Test
    public void setClientName() throws Exception {
        assTest.setClientName("Johan");
        assertEquals("Johan", assTest.getClientName());
    }

    @Test
    public void getStartTime() throws Exception {
        assertEquals(4, assTest.getStartTime());
    }

    @Test
    public void setStartTime() throws Exception {
        assTest.setStartTime(5);
        assertEquals(5, assTest.getStartTime());
    }

    @Test
    public void getEndTime() throws Exception {
        assertEquals(6, assTest.getEndTime());

    }

    @Test
    public void setEndTime() throws Exception {
        assTest.setEndTime(8);
        assertEquals(8, assTest.getEndTime());
    }

}