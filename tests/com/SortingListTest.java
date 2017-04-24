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

    public Geocoordinate geoTestHelp = new Geocoordinate(2222, 6666);
    public Position positionTestHelp = new Position(geoTestHelp, "", "", "", "", "", "");
    public Agent agentTest = new Agent(positionTestHelp , "333", "Carl", "Eriksson");
    public Agent agentTest2 = new Agent(positionTestHelp, "334", "Johan", "Back");
    public Agent agentTest3 = new Agent(positionTestHelp, "335", "Axel", "Holland");

    public SortingList sortListTest = new SortingList();

    public SortingList sortListTest2 = new SortingList();

   // Ska jag göra tester för detta? Vad menas i såna fall med criteria?

    @Test
    public void testgetList() throws Exception {
        List<Agent> listOfAgentsTest = new ArrayList<Agent>();
        assertEquals( sortListTest.getList(), listOfAgentsTest);

        listOfAgentsTest.add(agentTest);
        sortListTest.addToList(agentTest);
        assertEquals( sortListTest.getList(), listOfAgentsTest);

        listOfAgentsTest.add(agentTest2);
        sortListTest.addToList(agentTest2);
        assertEquals( sortListTest.getList(), listOfAgentsTest);
    }

    // Jag förstår inte hur jag påverkar Taget
    @Test
    public void testgetTarget() throws Exception {

    }

}