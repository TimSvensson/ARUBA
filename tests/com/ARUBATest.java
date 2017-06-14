package com;

import com.Sorting.SortList;
import com.google.gson.Gson;
import java.util.ArrayList;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by desiree on 2017-04-25.
 */
public class ARUBATest {

    Geocoordinate geoTestHelp1 = new Geocoordinate(59.8415562, 17.6477043);
    Position positionTestHelp1 = new Position(geoTestHelp1, "Institutionen för informationsteknologi, Lägerhyddsvägen 2", "Sweden", "", "Uppsala", "752 37", "75");
    Assignment interpretationSite = new Assignment(positionTestHelp1, "42", "Göran", 4, 6);

    Agent interpreterSameLocation = new Agent(positionTestHelp1, "122", "Bengt", "Göteborg");

    Geocoordinate geoTestHelp2 = new Geocoordinate(59.9208594, 16.606327999999962);
    Position positionTestHelp2 = new Position(geoTestHelp2, "", "Sala", "", "Sweden", "", "73");
    Agent interpreter1 = new Agent(positionTestHelp2, "123", "Bengt", "Göteborg");

    Geocoordinate geoTestHelp3 = new Geocoordinate(59.8513422, 17.592865999999958);
    Position positionTestHelp3 = new Position(geoTestHelp3, "Flogstavägen", "Uppsala", "", "Sweden", "75272", "75");
    Agent interpreter2 = new Agent(positionTestHelp3, "124", "Carl", "Eriksson");

    Geocoordinate geoTestHelp4 = new Geocoordinate(59.60990049999999, 16.544809100000066);
    Position positionTestHelp4 = new Position(geoTestHelp4, "", "Västerås", "", "Sweden", "", "");
    Agent interpreter3 = new Agent(positionTestHelp4, "125", "Lena", "Skansen");

    Geocoordinate geoTestHelp5 = new Geocoordinate(65.584819, 22.156702600000017);
    Position positionTestHelp5 = new Position(geoTestHelp5, "", "Luleå", "", "Sweden", "", "");
    Agent interpreter4 = new Agent(positionTestHelp5, "126", "Anna", "Linberg");

    Geocoordinate geoTestHelp6 = new Geocoordinate(55.4295051, 13.82003080000004);
    Position positionTestHelp6 = new Position(geoTestHelp6, "", "Ystad", "", "Sweden", "", "");
    Agent interpreter5 = new Agent(positionTestHelp6, "127", "Bertil", "Halmström");

    Geocoordinate geoTestHelp7 = new Geocoordinate(59.32932349999999, 18.068580800000063);
    Position positionTestHelp7 = new Position(geoTestHelp7, "", "Stocholm", "", "Sweden", "", "");
    Agent interpreter6 = new Agent(positionTestHelp7, "128", "Sven", "Öst");

    Agent interpreterCopy = new Agent(positionTestHelp7, "129", "Lars", "Åre");

    String graphHopperKey = "7992858f-c567-4ae8-b47c-f409b65f91f4";
    String mapBoxKey = "";
    String googleKey = "AIzaSyC3SJNwOjapbbdwGZlanF1mC83UGEbWH7s";


    /**
     * Finns 3 olika test fall:
     * 1. Lägg till ett flertal och se att den sorterar sig korrekt.
     * 2. Om någon är på exakt samma plats som assignment
     * 3. Om två personer är på exakt samma plats?
     * @throws Exception
     */

    @Test
    public void SimulationTest() throws Exception{
        ArrayList<Agent> list = new ArrayList<Agent>();
        list.add(interpreter1);
        list.add(interpreter2);
        list.add(interpreter3);
        Input jsonObjectEnd = new Input(interpretationSite, list);

        Gson g = new Gson();
        String jsonOrder1 = g.toJson(jsonObjectEnd);

        ARUBA aruba = new ARUBA(jsonOrder1, graphHopperKey, googleKey, mapBoxKey);

        String recived = aruba.getSortedJSON();
        Output outputTest = g.fromJson(recived, Output.class);
        SortList sortListTest = outputTest.getSortList();
        AgentRoute agentRoute = sortListTest.getAgentRoute(0);

        assertEquals(agentRoute.getAgent().getId(), interpreter3.getId());
        //System.out.print(aruba.getSortedJSON());
    }
    @Test
    public void SimulationTest2() throws Exception{
        ArrayList<Agent> list = new ArrayList<Agent>();
        list.add(interpreterSameLocation);
        list.add(interpreter1);
        list.add(interpreter2);
        Input jsonObjectEnd = new Input(interpretationSite, list);

        Gson g = new Gson();
        String jsonOrder = g.toJson(jsonObjectEnd);

        ARUBA aruba = new ARUBA(jsonOrder, graphHopperKey, googleKey, mapBoxKey);

        String recived = aruba.getSortedJSON();
        Output outputTest = g.fromJson(recived, Output.class);
        SortList sortListTest = outputTest.getSortList();
        AgentRoute agentRoute = sortListTest.getAgentRoute(0);

        assertEquals(agentRoute.getAgent().getId(), interpreterSameLocation.getId());
        //System.out.print(aruba.getSortedJSON());
    }
    @Test
    public void SimulationTest3() throws Exception{
        ArrayList<Agent> list = new ArrayList<Agent>();
        list.add(interpreter5);
        list.add(interpreter6);
        list.add(interpreterCopy);
        Input jsonObjectEnd = new Input(interpretationSite, list);

        Gson g = new Gson();
        String jsonOrder = g.toJson(jsonObjectEnd);

        ARUBA aruba = new ARUBA(jsonOrder, graphHopperKey, googleKey, mapBoxKey);

        String recived = aruba.getSortedJSON();
        Output outputTest = g.fromJson(recived, Output.class);
        SortList sortListTest = outputTest.getSortList();
        AgentRoute agentRoute = sortListTest.getAgentRoute(0);

        assertEquals(agentRoute.getAgent().getId(), interpreter6.getId());
        assertNotEquals(agentRoute.getAgent().getId(), interpreterCopy.getId());
        //System.out.print(aruba.getSortedJSON());
    }

}

