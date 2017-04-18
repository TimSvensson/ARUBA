package com.GraphHopperDirectionsAPITests;

import com.Agent;
import com.Assignment;
import com.Geocoordinate;
import com.GraphHopperDirectionsAPI.GHMatrixAPI;
import com.Position;
import org.junit.Test;


/**
 * Created by timsvensson on 12/04/17.
 */
public class GHMatrixAPITest {

    public String apiKey = "7992858f-c567-4ae8-b47c-f409b65f91f4";
    public GHMatrixAPI ghm = new GHMatrixAPI(apiKey);

    public Geocoordinate geoCoord1 = new Geocoordinate(49.6724, 11.3494);
    public Position pos1 = new Position(geoCoord1, "", "", "", "","", "");
    public Agent ag1 = new Agent(pos1, "", "Haubir", "Mariwani", -1, -1);

    public Geocoordinate asGeoCoord1 = new Geocoordinate(49.6550, 11.4180);
    public Position asPos1 = new Position(asGeoCoord1, "", "", "", "", "", "");
    public Assignment as1 = new Assignment(asPos1, "", "Tim", 1200, 1200);

    @Test
    public void calculateDistances() {

        ghm.AddAgent(ag1);
        ghm.AddAssignment(as1);

        if (ghm.CalculateDistances()) {
            System.out.println(ghm.getRoutes().toString());
        } else {
            System.out.println(ghm.getError());
        }

    }

    @Test
    public void getRoutes() {
    }

    @Test
    public void getRoutes1() {
    }

    @Test
    public void getRoutes2() {
    }

}