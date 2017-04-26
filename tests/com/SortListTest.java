package com;

import com.Sorting.SortList;
import org.junit.Test;
import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.*;

/**
 * Created by desiree on 2017-04-18.
 */
public class SortListTest {


    Geocoordinate geoTestHelp1 = new Geocoordinate(59.8415562, 17.6477043);
    Position positionTestHelp1 = new Position(geoTestHelp1, "Institutionen för informationsteknologi, Lägerhyddsvägen 2", "Sweden", "", "Uppsala", "752 37", "75");
    Assignment interpretationSite = new Assignment(positionTestHelp1, "42", "Carl", 4, 6);


    Geocoordinate geoTestHelp2 = new Geocoordinate(59.8513422, 17.592865999999958);
    Position positionTestHelp2 = new Position(geoTestHelp2, "Flogstavägen", "Uppsala", "", "Sweden", "75272", "75");
    Agent interpreter1 = new Agent(positionTestHelp2, "333", "Carl", "Eriksson");

    Geocoordinate geoTestHelp3 = new Geocoordinate(59.9208594, 16.606327999999962);
    Position positionTestHelp3 = new Position(geoTestHelp3, "", "Sala", "", "Sweden", "", "73");
    Agent interpreter2 = new Agent(positionTestHelp3, "666", "Bengt", "Göteborg");

    Route route1 = new Route(535364.567, 2222, "car");
    Route route2 = new Route(872981923, 384, "car");

    public TravelRoutes travelSortListTest = new TravelRoutes(interpreter1, interpretationSite, route1);

    public TravelRoutes travelSortListTest2 = new TravelRoutes(interpreter2, interpretationSite, route2);

    public SortList sortListTest = new SortList();


   // Ska jag göra tester för detta? Vad menas i såna fall med criteria?

    @Test
    public void testgetList() throws Exception {
        AgentRoute agentRoute1 = new AgentRoute(travelSortListTest.getAgent(), travelSortListTest.getRoute(0));
        AgentRoute agentRoute2 = new AgentRoute(travelSortListTest2.getAgent(), travelSortListTest2.getRoute(0));

        sortListTest.addToList(travelSortListTest);
        sortListTest.addToList(travelSortListTest2);

        sortListTest.sortList();

        AgentRoute listAgentRoute1 = (AgentRoute) sortListTest.getAgentRoute(0);
        AgentRoute listAgentRoute2 = (AgentRoute) sortListTest.getAgentRoute(1);

        assertEquals(listAgentRoute1.getAgent().getId() , agentRoute2.getAgent().getId());
        assertEquals(listAgentRoute2.getAgent().getId() , agentRoute1.getAgent().getId());

        assertEquals(listAgentRoute1.getRoute(), agentRoute2.getRoute());
        assertEquals(listAgentRoute2.getRoute(), agentRoute1.getRoute());

       // sortListTest.addToList(agentTest2);
        //assertEquals( sortListTest.getList(), listOfAgentsTest);
    }

    // Jag förstår inte hur jag påverkar Taget
    @Test
    public void testgetTarget() throws Exception {
        sortListTest.addToList(travelSortListTest);
        sortListTest.addToList(travelSortListTest2);

        assertEquals(interpretationSite.getId(), ((Assignment) sortListTest.getTarget()).getId());
    }

}