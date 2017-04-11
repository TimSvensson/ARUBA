package com;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by desiree on 2017-04-11.
 */
public class AgentTest {
    public Geocoordinate geoTestHelp = new Geocoordinate(2222, 6666);
    public Position positionTestHelp = new Position(geoTestHelp, "", "", "", "", "", "");
    public  Agent agentTest = new Agent(positionTestHelp , "333", "Carl", "Eriksson", 22, 657);

    @Test
    public void getPosition() throws Exception {
        assertEquals("",agentTest.getPosition().getZip());
        assertEquals("",agentTest.getPosition().getPostcode());
        assertEquals("",agentTest.getPosition().getCountry());
        assertEquals("",agentTest.getPosition().getCounty());
        assertEquals("",agentTest.getPosition().getCity());
        assertEquals("",agentTest.getPosition().getAddress());
    }

    @Test
    public void setPosition() throws Exception {
        Position posHelp = new Position(geoTestHelp, "Ringvalla", "Sala", "", "Sweden", "733 96", "");
        agentTest.setPosition(posHelp);

        assertEquals("",agentTest.getPosition().getZip());
        assertEquals("733 96",agentTest.getPosition().getPostcode());
        assertEquals("Sweden",agentTest.getPosition().getCountry());
        assertEquals("",agentTest.getPosition().getCounty());
        assertEquals("Sala",agentTest.getPosition().getCity());
        assertEquals("Ringvalla",agentTest.getPosition().getAddress());
    }

    @Test
    public void getFirstName() throws Exception {
        assertEquals("Carl", agentTest.getFirstName());
    }

    @Test
    public void setFirstName() throws Exception {
        agentTest.setFirstName("Johan");
        assertEquals("Johan", agentTest.getFirstName());
    }

    @Test
    public void getSurName() throws Exception {
        assertEquals("Eriksson", agentTest.getSurName());
    }

    @Test
    public void setSurName() throws Exception {
        agentTest.setSurName("Svensson");
        assertEquals("Svensson", agentTest.getSurName());
    }

    @Test
    public void getTravelTime() throws Exception {
        assertEquals(22, agentTest.getTravelTime());
    }

    @Test
    public void setTravelTime() throws Exception {
        agentTest.setTravelTime(333);
        assertEquals(333, agentTest.getTravelTime());
    }

    @Test
    public void compareTo() throws Exception {
        Agent agentHelp = new Agent(positionTestHelp , "323", "Bert", "Carlsson", 5, 50);
        assertEquals(1,agentTest.compareTo(agentHelp));
    }

    @Test
    public void getDistance() throws Exception {
        assertEquals(657, agentTest.getDistance());
    }

    @Test
    public void setDistance() throws Exception {
        agentTest.setDistance(444);
        assertEquals(444, agentTest.getDistance());
    }

}
