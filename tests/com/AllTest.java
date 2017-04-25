package com;

import com.GoogleAPITests.*;
import com.GraphHopperDirectionsAPITests.*;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * Created by Desiree on 2017-04-11.
 */

/*
 * When you have created a new Test.class you need to add it manually in
 * Suitclasses like below.
 * For the moment there does not need to be anything int the AllTest class.
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({
        DirectionsGoogleTest.class,
        GeocodingGoogleTest.class,

        GHMatrixAPITest.class,
        GHGeocodingAPITest.class,

        AgentTest.class,
        AssignmentTest.class,
        OrderTest.class,
        PositionTest.class,
        RouteTest.class,
        TravelRoutesTest.class,
        SortingListTest.class,
        GeocoordinateTest.class,
})

public final class AllTest {}