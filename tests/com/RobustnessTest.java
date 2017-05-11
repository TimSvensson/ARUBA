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

    private Position assignmentPosition = new Position("Lägerhydsvägen 2", "Uppsala",
                                                             "Uppsala", "Sweden", "75237", "");
    private Assignment assignment = new Assignment(assignmentPosition, "Polacksbacken",
                                                         "IT-Sektionen");

    private Position [] agPos = {
            new Position("", "Uppsala", "", "Sweden", "", ""),
            new Position("", "Stockholm", "", "Sweden", "", ""),
            new Position("", "Västerås", "", "Sweden", "", ""),
            new Position("", "Eskilstuna", "", "Sweden", "", ""),
            new Position("", "Sala", "", "Sweden", "", ""),
            new Position("", "", "","Sweden", "", "75")
    };

    private Agent [] agents = {
            new Agent(agPos[0], "0", "A", "AA"),
            new Agent(agPos[1], "1", "B", "BB"),
            new Agent(agPos[2], "2", "C", "CC"),
            new Agent(agPos[3], "3", "D", "DD"),
            new Agent(agPos[4], "4", "E", "EE"),
            new Agent(agPos[5], "5", "F", "FF"),
    };

    @Test
    public void GHDisabled() {
        Parser parser = new Parser();
        Gson g = new Gson();

        ArrayList<Agent> ags = new ArrayList<>();
        for (Agent a : this.agents) {
            ags.add(a);
        }

        Input jsonInput = new Input(this.assignment, ags);
        String arubaArg = g.toJson(jsonInput);

        ARUBA aruba = new ARUBA(arubaArg,"", KeyGetter.getGoogleKey(), KeyGetter.getMapBoxKey());

        String result = aruba.getSortedJSON();


    }

    @Test
    public void GoogleDisabled() {

    }

    @Test
    public void GHGeocodeGoogleRouting() {

    }

    @Test
    public void GoogleGeocodeGHRouting() {

    }

}
