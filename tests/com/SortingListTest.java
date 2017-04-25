package com;

import com.Sorting.SortingList;
import org.junit.Test;
import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.*;

/**
 * Created by desiree on 2017-04-18.
 */
public class SortingListTest {


    Geocoordinate geoTestHelp1 = new Geocoordinate(59.8415562, 17.6477043);
    Position positionTestHelp1 = new Position(geoTestHelp1, "Institutionen för informationsteknologi, Lägerhyddsvägen 2", "Sweden", "", "Uppsala", "752 37", "75");
    Assignment interpretationSite = new Assignment(positionTestHelp1, "42", "Carl", 4, 6);


    Geocoordinate geoTestHelp2 = new Geocoordinate(59.8513422, 17.592865999999958);
    Position positionTestHelp2 = new Position(geoTestHelp2, "Flogstavägen", "Uppsala", "", "Sweden", "75272", "75");
    Agent interpreter1 = new Agent(positionTestHelp2, "333", "Carl", "Eriksson");

    Geocoordinate geoTestHelp3 = new Geocoordinate(59.9208594, 16.606327999999962);
    Position positionTestHelp3 = new Position(geoTestHelp3, "", "Sala", "", "Sweden", "", "73");
    Agent interpreter2 = new Agent(positionTestHelp3, "333", "Bengt", "Göteborg");

    public TravelRoutes travelSortListTest = new TravelRoutes(interpreter1, interpretationSite);

    public TravelRoutes travelSortListTest2 = new TravelRoutes(interpreter2, interpretationSite);

    public SortingList sortListTest = new SortingList();


   // Ska jag göra tester för detta? Vad menas i såna fall med criteria?

    @Test
    public void testgetList() throws Exception {
        AgentRoute agentRoute = new AgentRoute(travelSortListTest.getAgent(), travelSortListTest.getRoute(0));

        sortListTest.addToList(interpreter1);
        assertEquals( sortListTest.getList(),agentRoute );


       // sortListTest.addToList(agentTest2);
        //assertEquals( sortListTest.getList(), listOfAgentsTest);
    }

    // Jag förstår inte hur jag påverkar Taget
    @Test
    public void testgetTarget() throws Exception {

    }

}