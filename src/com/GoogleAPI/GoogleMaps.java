/*
 * Project: ARUBA 
 * Class:   GoogleClass
 *
 * Version info
 * Created: 5/9/17
 * Creator: Haubir Mariwani
 *
 * Copyright notice
 * Property of Fasbros IT. Do not copy, alter, distribute, or sell in any way unless given explicit permission.
 */

package com.GoogleAPI;

import com.ZipCalc;
import com.Position;
import com.Zip;
import com.google.maps.GeoApiContext;

/**
 * Class summary.
 * <p>
 * Class Description.
 * </p>
 *
 * @author Haubir Mariwani <haubir.mariwani@fasbros.it>
 * @version JDK 1.8
 * @since JDK 1.8
 */
public class GoogleMaps {
    GeoApiContext context = new GeoApiContext();

    /**
     * Constructs the GeocodingGoogle object that is used for the
     * functionalities of the Google Maps Geocoding API.
     *
     */
    public GoogleMaps(String apiKey) {
        this.context.setApiKey(apiKey);
    }

/*
    // The real implementation that is costly.
    public void findZipGeocoordinates(Position position) {
        ZipCalc zipCalc = new ZipCalc();
        position.setGeocoordinate(zipCalc.findZipGeocooridinates(position.getZip()));
    }
*/
    // The temporary, free implementation
    public void setZipGeocoordinate(Position position) {
        position.setGeocoordinate(new Zip(Integer.parseInt(position.getZip())).getGeocoordinate());
    }
}