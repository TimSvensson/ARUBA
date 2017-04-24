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

    @Test
    public void oneAgentOneAssignment() {

        GHMatrixAPI ghm = new GHMatrixAPI(apiKey);

        Geocoordinate agGC = new Geocoordinate(49.6724, 11.3494);
        Position agPos = new Position(agGC, "", "", "", "","", "");
        Agent agent = new Agent(agPos, "1", "Haubir", "Mariwani");

        Geocoordinate asGC = new Geocoordinate(49.6550, 11.4180);
        Position asPos = new Position(asGC, "", "", "", "", "", "");
        Assignment assignment = new Assignment(asPos, "0", "Tim", 1200, 1200);

        ArrayList<Agent> agents = new ArrayList<>();
        agents.add(agent);

        ArrayList<Assignment> assignments = new ArrayList<>();
        assignments.add(assignment);

        ghm.addAgents(agents);
        ghm.addAssignments(assignments);
        ghm.setModeOfTransport("car");

        // Check Calculations were done without error
        assertTrue(ghm.calculateRoutes());

        // Check that there are TravelsRoutes in ghm
        ArrayList<TravelRoutes> travelRoutes = ghm.getRoutes();
        assertFalse(travelRoutes.isEmpty());

        // Check that the correct info was received
        TravelRoutes tr = travelRoutes.get(0);

        assertTrue(tr.getAgent().equals(agent));
        assertTrue(tr.getAssignment().equals(assignment));

        assertTrue(tr.getRoute(0).getModeOfTransport().equals("car"));
        assertEquals(tr.getRoute(0).getDistance(), 9736.0, 0.1);
        assertEquals(tr.getRoute(0).getTime(), 634000);
    }

    @Test
    public void manyAgentsOneAssignment() {

        GHMatrixAPI ghm = new GHMatrixAPI(apiKey);

        Geocoordinate asGC = new Geocoordinate(59.840983, 17.649454);
        Position asPos = new Position(asGC, "", "", "", "", "", "");
        Assignment assignment = new Assignment(asPos, "0", "Polhacksbacken", 1200, 1200);

        ghm.addAssignment(assignment);

        Geocoordinate haubirGC = new Geocoordinate(59.850672, 17.590611);
        Position haubirPos = new Position(haubirGC, "", "", "", "","", "");
        Agent haubir = new Agent(haubirPos, "1", "Haubir", "Mariwani");

        Geocoordinate timGC = new Geocoordinate(59.850355, 17.584581);
        Position timPos = new Position(timGC, "", "", "", "","", "");
        Agent tim = new Agent(timPos, "2", "Tim", "Svensson");

        Geocoordinate dessGC = new Geocoordinate(59.850171, 17.582500);
        Position dessPos = new Position(dessGC, "", "", "", "","", "");
        Agent dess = new Agent(dessPos, "3", "Dessireé", "Björkman");

        Geocoordinate chrilleGC = new Geocoordinate(59.853686, 17.599512);
        Position chrillePos = new Position(chrilleGC, "", "", "", "","", "");
        Agent chrille = new Agent(chrillePos, "4", "Christian", "Gullberg");

        ArrayList<Agent> agents = new ArrayList<>();
        agents.add(haubir);
        agents.add(tim);
        agents.add(dess);
        agents.add(chrille);

        ghm.addAgents(agents);

        ghm.setModeOfTransport("car");

        assertTrue(ghm.calculateRoutes());

        ArrayList<TravelRoutes> tr = ghm.getRoutes();

        assertEquals(haubir, tr.get(0).getAgent());
        assertEquals(tim, tr.get(1).getAgent());
        assertEquals(dess, tr.get(2).getAgent());
        assertEquals(chrille, tr.get(3).getAgent());
    }
}