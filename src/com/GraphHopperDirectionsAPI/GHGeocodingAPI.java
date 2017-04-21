/*
 * Project: ARUBA 
 * Class:   GHGeocodingAPI
 *
 * Version info
 * Created: 12/04/17
 * Creator: Tim Svensson
 *
 * Copyright notice
 * Property of Fasbros IT. Do not copy, alter, distribute, or sell in any way unless given explicit permission.
 */

package com.GraphHopperDirectionsAPI;

import com.Interface.GeocodingInterface;
import com.Position;

/**
 * Class summary.
 * <p>
 * Class Description.
 * </p>
 *
 * @author Tim Svensson <tim.svensson@fasbros.it>
 * @version JDK 1.8
 * @since JDK 1.8
 */
public class GHGeocodingAPI implements GeocodingInterface {

    @Override
    public boolean geocode(Position position) {
        return false;
    }

    @Override
    public boolean reverseGeocode(Position position) {
        return false;
    }
}
