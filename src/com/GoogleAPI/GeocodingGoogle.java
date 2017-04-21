package com.GoogleAPI;

import com.Interface.GeocodingInterface;
import com.Position;

/**
 * Created by timsvensson on 11/04/17.
 */
public class GeocodingGoogle implements GeocodingInterface {


    @Override
    public boolean geocode(Position position) {
        return false;
    }

    @Override
    public boolean reverseGeocode(Position position) {
        return false;
    }
}
