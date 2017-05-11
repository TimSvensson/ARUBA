package com.GoogleAPITests;

import com.*;
import com.ARUBAExceptions.NoResultsException;
import com.ARUBAExceptions.ModeOfTransportException;
import com.ARUBAExceptions.NoAgentsExcpetions;
import com.ARUBAExceptions.NoAssignmentsException;
import com.GoogleAPI.DirectionsGoogle;
import com.google.maps.errors.ApiException;
import org.junit.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

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

    public List<List> init() {

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

        List<List> list = new ArrayList<>();
        list.add(agents);
        list.add(assignments);

        return list;
    }

    @Test
    public void calculateDistances() throws InterruptedException, ApiException, IOException, ModeOfTransportException,
            NoAssignmentsException, NoAgentsExcpetions, NoResultsException {
        DirectionsGoogle directionsGoogle = new DirectionsGoogle();

        List<List> list = init();
        List<Agent> agentList = list.get(0);
        List<Assignment> assignmentList = list.get(1);

        List<TravelRoutes> travelRoutesList = directionsGoogle.calculateRoutes(agentList, assignmentList, "car");

        assertEquals(travelRoutesList.size(), (assignmentList.size() * agentList.size()));
    }

}
