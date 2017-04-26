/*
 * Project: ARUBA 
 * Class:   ParserTest
 *
 * Version info
 * Created: 4/26/17
 * Creator: Haubir Mariwani
 *
 * Copyright notice
 * Property of Fasbros IT. Do not copy, alter, distribute, or sell in any way unless given explicit permission.
 */

package com;

import com.google.gson.Gson;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Class summary.
 * <p>
 * Class Description.
 * </p>
 *
 * @author Haubir Mariwani <haubir.mariwani@fasbros.it>
 * @version JDK 1.8
 * @since JDK 1.8
 */
public class ParserTest {
    Parser parser = new Parser();

    Geocoordinate geoTestHelp1 = new Geocoordinate(1222, 6666);
    Position positionTestHelp1 = new Position(geoTestHelp1, "Ringvalla", "Sala", "", "Sweden", "733 96", "");
    Agent agentTestHelp1 = new Agent(positionTestHelp1 , "332", "Carl", "Eriksson");

    //Creates a second agent
    Geocoordinate geoTestHelp2 = new Geocoordinate(2222, 6666);
    Position positionTestHelp2 = new Position(geoTestHelp2, "Flogsta", "Uppsala", "", "Sweden", "75272", "");
    Agent agentTestHelp2 = new Agent(positionTestHelp2 , "333", "Tim", "Svensson");

    List<Agent> agents = new ArrayList<>();

    //Create assignment and therefor the client
    Geocoordinate geoTestHelpass = new Geocoordinate(2221, 6666);
    Position positionTestHelpass = new Position(geoTestHelpass, "", "", "", "", "", "");
    Assignment assTestHelp = new Assignment(positionTestHelpass, "42", "Johan", 4, 6);

    Input input = new Input(assTestHelp, agents, true);

    @Test
    public void toJson() throws Exception {
        agents.add(agentTestHelp1);
        agents.add(agentTestHelp2);
        input.setAgents(agents);

        String gsonInput = new Gson().toJson(input);
        String parserInput = parser.toJson(input);

        assertEquals(gsonInput, parserInput);
    }

    @Test
    public void fromJson() throws Exception {
        agents.add(agentTestHelp1);
        agents.add(agentTestHelp2);
        input.setAgents(agents);

        String gsonInput = new Gson().toJson(input);

        Input parserInput = parser.fromJson(gsonInput, Input.class);

        assertEquals(input, parserInput);
    }

    @Test
    public void isDebugMode() throws Exception {
        agents.add(agentTestHelp1);
        agents.add(agentTestHelp2);
        input.setAgents(agents);

        String gsonInput = new Gson().toJson(input);

        assert(parser.isDebugMode(gsonInput));
    }

    @Test
    public void findPositionFormat() throws Exception {
        String gsonInput = new Gson().toJson(input);
        String positionFormat = parser.findPositionFormat(gsonInput);

        assertEquals("geocoordinate", positionFormat);

        Position positionTestHelpass0 = new Position(null, "Sernanders Väg 7", "", "", "", "", "");

        assTestHelp.setPosition(positionTestHelpass0);
        input.setAssignment(assTestHelp);

        String gsonInput0 = new Gson().toJson(input);
        String positionFormat0 = parser.findPositionFormat(gsonInput0);

        assertEquals("address", positionFormat0);

        Position positionTestHelpass1 = new Position(null, "", "Uppsala", "", "", "", "");

        assTestHelp.setPosition(positionTestHelpass1);
        input.setAssignment(assTestHelp);

        String gsonInput1 = new Gson().toJson(input);
        String positionFormat1 = parser.findPositionFormat(gsonInput1);

        assertEquals("city", positionFormat1);

        Position positionTestHelpass2 = new Position(null, "", "", "Uppsala län", "", "", "");

        assTestHelp.setPosition(positionTestHelpass2);
        input.setAssignment(assTestHelp);

        String gsonInput2 = new Gson().toJson(input);
        String positionFormat2 = parser.findPositionFormat(gsonInput2);

        assertEquals("country", positionFormat2);

        Position positionTestHelpass3 = new Position(null, "", "", "", "Sverige", "", "");

        assTestHelp.setPosition(positionTestHelpass3);
        input.setAssignment(assTestHelp);

        String gsonInput3 = new Gson().toJson(input);
        String positionFormat3 = parser.findPositionFormat(gsonInput3);

        assertEquals("address", positionFormat3);

        Position positionTestHelpass4 = new Position(null, "", "", "", "", "752 61", "");

        assTestHelp.setPosition(positionTestHelpass4);
        input.setAssignment(assTestHelp);

        String gsonInput4 = new Gson().toJson(input);
        String positionFormat4 = parser.findPositionFormat(gsonInput4);

        assertEquals("address", positionFormat4);

        Position positionTestHelpass5 = new Position(null, "", "", "", "", "", "75");

        assTestHelp.setPosition(positionTestHelpass5);
        input.setAssignment(assTestHelp);

        String gsonInput5 = new Gson().toJson(input);
        String positionFormat5 = parser.findPositionFormat(gsonInput5);

        assertEquals("address", positionFormat5);
    }

}