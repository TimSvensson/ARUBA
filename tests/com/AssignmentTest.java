package com;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by desiree on 2017-04-11.
 * Tests for assignment.java, at this point it's just basic.
 */
public class AssignmentTest {
    Geocoordinate geoTestHelp = new Geocoordinate(2222, 6666);
    Position positionTestHelp = new Position(geoTestHelp, "", "", "", "", "", "");
    Assignment assTest = new Assignment(positionTestHelp, "42", "Carl", 4, 6);

    @Test
    public void getId() throws Exception {
        assertEquals( "42",assTest.getId());
    }

    @Test
    public void setId() throws Exception {
        assTest.setId("12");
        assTest.setId("55");
        assertEquals("55", assTest.getId());
    }

    @Test
    public void getPosition() throws Exception {
        assertTrue(assTest.getPosition().getAddress() == "");
        assertTrue(assTest.getPosition().getCity() == "");
        assertTrue(assTest.getPosition().getCountry() == "");
        assertTrue(assTest.getPosition().getPostcode() == "");
        assertTrue(assTest.getPosition().getZip() == "");
    }

    @Test
    public void setPosition() throws Exception {
        Geocoordinate geoHelp = new Geocoordinate(2222, 6666);
        Position newPosition = new Position(geoHelp, "", "Uppsala", "", "", "", "");
        assTest.setPosition(newPosition);

        assertTrue(assTest.getPosition().getAddress() == "");
        assertTrue(assTest.getPosition().getCity() == "Uppsala");
        assertTrue(assTest.getPosition().getCountry() == "");
        assertTrue(assTest.getPosition().getPostcode() == "");
        assertTrue(assTest.getPosition().getZip() == "");
        assertEquals(geoHelp, assTest.getPosition().getGeocoordinate());
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