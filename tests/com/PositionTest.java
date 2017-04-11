package com;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Created by desiree on 2017-04-07.
 */
public class PositionTest {
    public Geocoordinate geoTestHelp = new Geocoordinate(2222, 6666);
    public Position positionTest = new Position(geoTestHelp, "", "", "", "", "", "");

    @Test
    public void getAddress() throws Exception{
    assertEquals("", positionTest.getAddress());
    }

}