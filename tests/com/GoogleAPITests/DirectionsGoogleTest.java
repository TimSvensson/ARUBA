package com.GoogleAPITests;

import com.Agent;
import com.Assignment;
import com.Geocoordinate;
import com.GoogleAPI.DirectionsGoogle;
import com.Position;
import com.google.maps.errors.ApiException;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by timsvensson on 12/04/17.
 */
public class DirectionsGoogleTest {
    String [] agentFirstNames       = {     "Haubir",               "Desireé",              "Tim"};
    String [] agentLastNames        = {     "Mariwani",             "Björkman",             "Svensson"};
    String [] agentAddresses        = {     "Sernanders Väg 7",     "Flogstavägen 73A",     "Flogstavägen 77B"};
    String [] agentIDs              = {     "45",                   "7",                    "0"};
    String [] agentPostcodes        = {     "752 61",               "752 72",               "752 72"};

    String [] assignmentAddresses   = {     "Uppsala Business Park",    "Dragarbrunn",      "Ångströmslaboratoriet"};
    String [] assignmentIDs         = {     "42",                       "666",              "99999"};
    String [] assignmentClientNames = {     "Migrationsverket",         "Carl Nordstrand",  "Polisen Uppsala"};
    int [] assignmentStartTimes     = {     111,                        222,                333};
    int [] assignmentEndTimes       = {     444,                        555,                666};
    List<Agent> agents = new ArrayList<Agent>();
    List<Assignment> assignments = new ArrayList<Assignment>();

    public DirectionsGoogle init() {


        for (double i = 0; i < agentAddresses.length; i++) {
            Geocoordinate geoCoord = new Geocoordinate(49.6724 + i, 11.3494 + i);
            Position pos = new Position(geoCoord, agentAddresses[(int) i], "Uppsala", "Uppsala län", "Sweden", agentPostcodes[(int) i], "75");
            Agent agent = new Agent(pos, agentIDs[(int) i], agentFirstNames[(int) i], agentLastNames[(int) i]);
            agents.add(agent);

            // if (i == agentAddresses.length - 1) i = 0;
        }

        for (double i = 0; i < assignmentAddresses.length; i++) {
            Geocoordinate geoCoord = new Geocoordinate(49.6724 + i, 11.3494 + i);
            Position pos = new Position(geoCoord, assignmentAddresses[(int) i], "Uppsala", "Uppsala län", "Sweden", "" + i + "", "75");
            Assignment assignment = new Assignment(pos, assignmentIDs[(int) i], assignmentClientNames[(int) i], assignmentStartTimes[(int) i], assignmentEndTimes[(int) i]);
            assignments.add(assignment);

            // if (i == assignmentAddresses.length - 1) i = 0;
        }

        DirectionsGoogle directionsGoogle = new DirectionsGoogle(agents, assignments);

        return directionsGoogle;
    }

    @Test
    public void testGetAgents() {
        DirectionsGoogle directionsGoogle = init();

        assert(agents.equals(directionsGoogle.getAgents()));
    }

    @Test
    public void addAgent() {
        Geocoordinate geoCoord = new Geocoordinate(49.6724 , 11.3494 );
        Position pos = new Position(geoCoord, "Drottninggatan 19", "Uppsala", "Uppsala län", "Sweden", "117 56", "75");
        Agent agent = new Agent(pos, "666", "Haidar", "Smith");

        DirectionsGoogle directionsGoogle = init();

        directionsGoogle.addAgent(agent);
        int size = directionsGoogle.getAgents().size();

        assert(agent.getId().equals(directionsGoogle.getAgents().get(size - 1).getId()));
    }

    @Test
    public void addAgents() {
        DirectionsGoogle directionsGoogle = new DirectionsGoogle(new ArrayList<Agent>(), new ArrayList<Assignment>());
        directionsGoogle.addAgents(agents);

        assert(agents.equals(directionsGoogle.getAgents()));
    }

    @Test
    public void testGetAssignments() {
        DirectionsGoogle directionsGoogle = init();

        assert(assignments.equals(directionsGoogle.getAssignments()));
    }

    @Test
    public void addAssignment() {
        Geocoordinate geoCoord = new Geocoordinate(49.6724, 11.3494);
        Position pos = new Position(geoCoord, "Uppsala Centrum", "Uppsala", "Uppsala län", "Sweden", "752 55", "75");
        Assignment assignment = new Assignment(pos, "555", "LeBron", 1, 10);

        DirectionsGoogle directionsGoogle = init();

        directionsGoogle.addAssignment(assignment);
        int size = directionsGoogle.getAssignments().size();

        assert(assignment.getId().equals(directionsGoogle.getAssignments().get(size - 1).getId()));
    }

    @Test
    public void addAssignments() {
        DirectionsGoogle directionsGoogle = new DirectionsGoogle(new ArrayList<Agent>(), new ArrayList<Assignment>());
        directionsGoogle.addAssignments(assignments);

        assert(assignments.equals(directionsGoogle.getAssignments()));
    }

    @Test
    public void testGetRoutes() {

    }

    @Test
    public void testGetAgentRoutes() {

    }

    @Test
    public void testGetAssignmentRoutes() {

    }

    @Test
    public void calculateDistances() throws InterruptedException, ApiException, IOException {
        DirectionsGoogle directionsGoogle = init();

        assert(directionsGoogle.calculateRoutes());
    }

}
