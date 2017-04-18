package com;

import org.junit.Test;
import java.util.ArrayList;
import static org.testng.AssertJUnit.*;

/**
 * Created by timsvensson on 17/04/17.
 */
public class TravelRoutesTest {

    Position p0;
    Position p1;

    Agent ag = new Agent(p0, "agent", "A", "Gent", -1, -1);

    Assignment as = new Assignment(p1, "assignment", "Ass Ignment", -1, -1);

    double d0 = 1000;
    double d1 = 2000;
    double d2 = 3000;

    long t0 = 150;
    long t1 = 300;
    long t2 = 450;

    String v0 = "bike";
    String v1 = "car";
    String v2 = "foot";

    Route r0 = new Route(d0, t0, v0);
    Route r1 = new Route(d1, t1, v1);
    Route r2 = new Route(d2, t2, v2);

    ArrayList<Route> rs0 = new ArrayList<>(); // empty
    ArrayList<Route> rs1 = new ArrayList<>();
    ArrayList<Route> rs2 = new ArrayList<>();
    ArrayList<Route> rs3 = new ArrayList<>();

    TravelRoutes tr0; // no routes
    TravelRoutes tr1;
    TravelRoutes tr2;
    TravelRoutes tr3;

    public TravelRoutesTest() {

        // init rs1
        rs1.add(r0);

        // init rs2
        rs2.add(r0);
        rs2.add(r1);

        // init rs3
        rs3.add(r0);
        rs3.add(r1);
        rs3.add(r2);

        // init tr0
        tr0 = new TravelRoutes(ag, as);

        // init tr1
        tr1 = new TravelRoutes(ag, as, r1);

        // init tr2
        tr2 = new TravelRoutes(ag, as, rs2);

        // inti tr3
        tr3 = new TravelRoutes(ag, as, rs3);
    }

    @Test
    public void getAgent() throws Exception {
        assertTrue(tr0.getAgent().equals(ag));
        assertTrue(tr1.getAgent().equals(ag));
        assertTrue(tr2.getAgent().equals(ag));
        assertTrue(tr3.getAgent().equals(ag));
    }

    @Test
    public void getAssignment() throws Exception {
        assertTrue(tr0.getAssignment().equals(as));
        assertTrue(tr1.getAssignment().equals(as));
        assertTrue(tr2.getAssignment().equals(as));
        assertTrue(tr3.getAssignment().equals(as));
    }

    @Test
    public void getRoute() throws Exception {

    }

    @Test
    public void getRoutes() throws Exception {
        // tr0
        assertTrue(tr0.getRoutes().isEmpty());

        // tr1
        ArrayList<Route> tmp1 = tr1.getRoutes();

        assertFalse(tmp1.isEmpty());
        assertTrue(tmp1.get(0)==r1);

        // tr2
        ArrayList<Route> tmp2 = tr2.getRoutes();

        assertFalse(tmp2.isEmpty());
        assertTrue(tmp2.get(0)==r0);
        assertTrue(tmp2.get(1)==r1);

        // tr3
        ArrayList<Route> tmp3 = tr3.getRoutes();

        assertFalse(tmp3.isEmpty());
        assertTrue(tmp3.get(0)==r0);
        assertTrue(tmp3.get(1)==r1);
        assertTrue(tmp3.get(2)==r2);
    }

    @Test
    public void addRoute() throws Exception {

        // empty TravelRoutes
        TravelRoutes tmp0 = new TravelRoutes(ag, as);

        assertTrue(tmp0.getRoutes().isEmpty());

        tmp0.addRoute(r0);
        assertFalse(tmp0.getRoutes().isEmpty());

        tmp0.addRoute(r1);
        tmp0.addRoute(r2);

        assertTrue(tmp0.getRoute(0).equals(r0));
        assertTrue(tmp0.getRoute(1).equals(r1));
        assertTrue(tmp0.getRoute(2).equals(r2));

        // TravelRoute with one route
        TravelRoutes tmp1 = new TravelRoutes(ag, as, r0);

        assertFalse(tmp1.getRoutes().isEmpty());

        tmp1.addRoute(r1);
        tmp1.addRoute(r2);

        assertTrue(tmp1.getRoute(0).equals(r0));
        assertTrue(tmp1.getRoute(1).equals(r1));
        assertTrue(tmp1.getRoute(2).equals(r2));

        // TravelRoute with one route
        TravelRoutes tmp2 = new TravelRoutes(ag, as, rs1);

        assertFalse(tmp2.getRoutes().isEmpty());

        tmp2.addRoute(r1);
        tmp2.addRoute(r2);

        assertTrue(tmp2.getRoute(0).equals(r0));
        assertTrue(tmp2.getRoute(1).equals(r1));
        assertTrue(tmp2.getRoute(2).equals(r2));
    }

    @Test
    public void addRoutes() throws Exception {
        TravelRoutes tr = new TravelRoutes(ag, as);

        assertTrue(tr.getRoutes().isEmpty());

        tr.addRoutes(rs0);
        assertTrue(tr.getRoutes().isEmpty());

        tr.addRoutes(rs1);
        assertFalse(tr.getRoutes().isEmpty());

        tr.addRoutes(rs2);
        tr.addRoutes(rs3);

        assertTrue(tr.getRoute(0).equals(r0));
        assertTrue(tr.getRoute(1).equals(r0));
        assertTrue(tr.getRoute(2).equals(r1));
        assertTrue(tr.getRoute(3).equals(r0));
        assertTrue(tr.getRoute(4).equals(r1));
        assertTrue(tr.getRoute(5).equals(r2));
    }

}