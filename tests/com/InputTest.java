package com;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by desiree on 2017-04-11.
 */
public class InputTest {
    //Creates one agent or the misssion
    Geocoordinate geoTestHelp1 = new Geocoordinate(1222, 6666);
    Position positionTestHelp1 = new Position(geoTestHelp1, "Ringvalla", "Sala", "", "Sweden", "733 96", "");
    Agent agentTestHelp1 = new Agent(positionTestHelp1 , "332", "Carl", "Eriksson");

    //Creates a second agent
    Geocoordinate geoTestHelp2 = new Geocoordinate(2222, 6666);
    Position positionTestHelp2 = new Position(geoTestHelp2, "Flogsta", "Uppsala", "", "Sweden", "75272", "");
    Agent agentTestHelp2 = new Agent(positionTestHelp2 , "333", "Tim", "Svensson");

    //Create assignment and therefor the client
    Geocoordinate geoTestHelpass = new Geocoordinate(2221, 6666);
    Position positionTestHelpass = new Position(geoTestHelpass, "", "", "", "", "", "");
    Assignment assTestHelp = new Assignment(positionTestHelpass, "42", "Johan", 4, 6);


    @Test
    public void getAssignment() throws Exception {
    }

    @Test
    public void setAssignment() throws Exception {
    }

    @Test
    public void getAgents() throws Exception {
    }

    @Test
    public void setAgents() throws Exception {
    }
}
