package com.GraphHopperDirectionsAPITests;

import com.*;
import com.GraphHopperDirectionsAPI.GHMatrixAPI;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


/**
 * Tests for GHMatrixAPI.java.
 * <p>
 * Class Description.
 * </p>
 *
 * @author Tim Svensson <tim.svensson@fasbros.it>
 * @version JDK 1.8
 * @since JDK 1.8
 */
public class GHMatrixAPITest {

    private String apiKey = "7992858f-c567-4ae8-b47c-f409b65f91f4";
    private GHMatrixAPI ghm = new GHMatrixAPI(apiKey);

    private Geocoordinate agGC1 = new Geocoordinate(49.6724, 11.3494);
    private Position agPos1 = new Position(agGC1, "", "", "", "","", "");
    private Agent ag1 = new Agent(agPos1, "", "Haubir", "Mariwani", -1, -1);

    private Geocoordinate asGC1 = new Geocoordinate(49.6550, 11.4180);
    private Position asPos1 = new Position(asGC1, "", "", "", "", "", "");
    private Assignment as1 = new Assignment(asPos1, "", "Tim", 1200, 1200);

    @Test
    public void oneAgentOneAssignment() {

        ghm.addAgent(ag1);
        ghm.addAssignment(as1);

        // Check Calculations were done without error
        assertTrue(ghm.doCalculation());

        // Check that there are TravelsRoutes in ghm
        ArrayList<TravelRoutes> travelRoutes = ghm.getRoutes();
        assertFalse(travelRoutes.isEmpty());

        // Check that the correct info was received
        TravelRoutes tr = travelRoutes.get(0);

        assertTrue(tr.getAgent().equals(ag1));
        assertTrue(tr.getAssignment().equals(as1));

        assertTrue(tr.getRoute(0).getModeOfTransport().equals("car"));
        assertEquals(tr.getRoute(0).getDistance(), 9736.0, 0.1);
        assertEquals(tr.getRoute(0).getTime(), 634000);
    }

    @Test
    public void oneAgentManyAssignments() {

    }

    @Test
    public void manyAgentsOneAssignment() {

    }

    @Test
    public void manyAgentsManyAssignments() {

    }

    @Test
    public void getRoutes() {
//        assertTrue(false);
    }

    @Test
    public void getRoutes1() {
//        assertTrue(false);
    }

    @Test
    public void getRoutes2() {
//        assertTrue(false);
    }

}