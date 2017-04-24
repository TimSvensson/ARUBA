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
    public Agent agentTest = new Agent(positionTestHelp , "333", "Carl", "Eriksson", 22, 657);
    public Agent agentTest2 = new Agent(positionTestHelp, "334", "Johan", "Back", 55, 1000);
    public Agent agentTest3 = new Agent(positionTestHelp, "335", "Axel", "Holland", 6, 100);

    public SortingList sortListTest = new SortingList();

    public SortingList sortListTest2 = new SortingList();

    @Test
    public void testGetListOfAgents() throws Exception {
        List<Agent> listOfAgentsTest = new ArrayList<Agent>();
        assertEquals( sortListTest.getListOfAgents(), listOfAgentsTest);

        listOfAgentsTest.add(agentTest);
        sortListTest.addAgent(agentTest);
        assertEquals( sortListTest.getListOfAgents(), listOfAgentsTest);

        listOfAgentsTest.add(agentTest2);
        sortListTest.addAgent(agentTest2);
        assertEquals( sortListTest.getListOfAgents(), listOfAgentsTest);
    }

    @Test
    public void testGetAgent() throws Exception {
        sortListTest.addAgent(agentTest);
        sortListTest.addAgent(agentTest2);
        assertEquals(sortListTest.getAgent(1), agentTest2);
    }

    @Test
    public void testGetSize() throws Exception {
        sortListTest.addAgent(agentTest);
        sortListTest.addAgent(agentTest2);
        sortListTest.addAgent(agentTest3);

        assertTrue(sortListTest.getSize() == 3);
        assertTrue(sortListTest2.getSize() == 0);
    }

    @Test
    public void testAddAgent() throws Exception {
        sortListTest.addAgent(agentTest);
        sortListTest.addAgent(agentTest2);
        sortListTest.addAgent(agentTest2);
        sortListTest.addAgent(agentTest2);
        sortListTest.addAgent(agentTest2);
        sortListTest.addAgent(agentTest3);

        assertTrue(sortListTest.getSize() == 3);
        }

  @Test
    public void testPrintList() throws Exception {
    }

}