package com;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by desiree on 2017-04-11.
 */
public class InputTest {
    //Creates one agent or the misssion
    public Geocoordinate geoTestHelp1 = new Geocoordinate(1222, 6666);
    public Position positionTestHelp1 = new Position(geoTestHelp1, "Ringvalla", "Sala", "", "Sweden", "733 96", "");
    public  Agent agentTestHelp1 = new Agent(positionTestHelp1 , "332", "Carl", "Eriksson");

    //Creates a second agent
    public Geocoordinate geoTestHelp2 = new Geocoordinate(2222, 6666);
    public Position positionTestHelp2 = new Position(geoTestHelp2, "Flogsta", "Uppsala", "", "Sweden", "75272", "");
    public  Agent agentTestHelp2 = new Agent(positionTestHelp2 , "333", "Tim", "Svensson");

    //Ceate assignment and therefor the client
    public Geocoordinate geoTestHelpass = new Geocoordinate(2221, 6666);
    public Position positionTestHelpass = new Position(geoTestHelpass, "", "", "", "", "", "");
    public Assignment assTestHelp = new Assignment(positionTestHelpass, "42", "Johan", 4, 6);


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
