package com.GraphHopperDirectionsAPITests;

import com.Agent;
import com.Assignment;
import com.Geocoordinate;
import com.GraphHopperDirectionsAPI.GHMatrixAPI;
import com.Position;
import org.junit.jupiter.api.Test;

/**
 * Created by timsvensson on 12/04/17.
 */
public class GHMatrixAPITest {

    String apiKey = "7992858f-c567-4ae8-b47c-f409b65f91f4";
    GHMatrixAPI ghm = new GHMatrixAPI(apiKey);

    Geocoordinate geoCoord1 = new Geocoordinate(49.6724, 11.3494);
    Position pos1 = new Position(geoCoord1, "", "", "", "","", "");
    Agent ag1 = new Agent(pos1, "", "Haubir", "Mariwani", -1, -1);

    Geocoordinate asGeoCoord1 = new Geocoordinate(49.6550, 11.4180);
    Position asPos1 = new Position(asGeoCoord1, "", "", "", "", "", "");
    Assignment as1 = new Assignment(asPos1, "", "Tim", 1200, 1200);

    @Test
    void calculateDistances() {

        ghm.AddAgent(ag1);
        ghm.AddAssignment(as1);

        if (ghm.CalculateDistances()) {
            System.out.println(ghm.getRoutes().toString());
        } else {
            System.out.println(ghm.getError());
        }

    }

    @Test
    void getRoutes() {
    }

    @Test
    void getRoutes1() {
    }

    @Test
    void getRoutes2() {
    }

}