/*
 * Project: ARUBA 
 * Class:   RobustnessTest
 *
 * Version info
 * Created: 09/05/17
 * Creator: Tim Svensson
 *
 * Copyright notice
 * Property of Fasbros IT. Do not copy, alter, distribute, or sell in any way unless given explicit permission.
 */

package com;

import com.google.gson.Gson;

import org.junit.Test;

import java.util.ArrayList;

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
public class RobustnessTest {

    private RandomAgent randomAgent = new RandomAgent();
    Parser parser = new Parser();
    Gson gson = new Gson();

    private Position assignmentPosition = new Position("Lägerhydsvägen 2", "Uppsala",
                                                       "Uppsala", "Sweden", "75237", "");
    private Assignment assignment = new Assignment(assignmentPosition, "Polacksbacken",
                                                         "IT-Sektionen");

    // Driftsäkerhet
    @Test
    public void GHDisabled() {

        ArrayList<Agent> agents = randomAgent.getAgents(10);

        for (Agent a : agents) {
            assert(a.getPosition() != null);
        }

        Input jsonInput = new Input(this.assignment, agents);
        String arubaArg = this.gson.toJson(jsonInput);

        ARUBA aruba = new ARUBA(arubaArg,"incorrect api key", KeyGetter.getGoogleKey(),
                                KeyGetter.getMapBoxKey());

        String result = aruba.getSortedJSON();


    }

    @Test
    public void GoogleDisabled() {
        ArrayList<Agent> agents = randomAgent.getAgents(10);

        for (Agent a : agents) {
            assert(a.getPosition() != null);
        }

        Input jsonInput = new Input(this.assignment, agents);
        String arubaArg = this.gson.toJson(jsonInput);

        ARUBA aruba = new ARUBA(arubaArg, KeyGetter.getGHKey(), "incorrect api key",
                                KeyGetter.getMapBoxKey());

        String result = aruba.getSortedJSON();
    }

//    @Test
//    public void GHGeocodeGoogleRouting() {
//
//    }

//    @Test
//    public void GoogleGeocodeGHRouting() {
//
//    }

    // Stresstester

    // TODO Hundra

    @Test
    public void tvåhundraAgentTest() {

        // TODO Add time checks

        // TODO Increase number of agents
        ArrayList<Agent> agents = randomAgent.getAgents(20);

        for (Agent a : agents) {
            assert(a.getPosition() != null);
        }

        Input jsonInput = new Input(this.assignment, agents);
        String arubaArg = this.gson.toJson(jsonInput);

        ARUBA aruba = new ARUBA(arubaArg,KeyGetter.getGHKey(), KeyGetter.getGoogleKey(),
                                KeyGetter.getMapBoxKey());

        String result = aruba.getSortedJSON();
    }

    // TODO femhundra

    // TODO tusen
}
