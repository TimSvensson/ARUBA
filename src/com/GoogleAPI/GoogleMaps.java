/*
 * Project: ARUBA 
 * Class:   GoogleMaps
 *
 * Version info
 * Created: 5/9/17
 * Creator: Haubir Mariwani
 *
 * Copyright notice
 * Property of Fasbros IT. Do not copy, alter, distribute, or sell in any way unless given explicit permission.
 */

package com.GoogleAPI;

// import com.ZipCalc;
import com.Position;
import com.Zip;
import com.google.maps.GeoApiContext;

/**
 * Superclass for the classes that handle the communication with their respective
 * Google Maps APIs.
 *
 * <p>
 * Holds a shared constructor and shared methods.
 * </p>
 *
 * @author Haubir Mariwani <haubir.mariwani@fasbros.it>
 * @version JDK 1.8
 * @since JDK 1.8
 */
public class GoogleMaps {
    /**
     * The entry point for communication with the various Google Maps APIs.
     */
    GeoApiContext context = new GeoApiContext();

    /**
     * Constructs a GoogleMaps object that is used to access
     * the functionalities of the various Google Maps APIs.
     * The API key is used to activate the GeoApiContext.
     */
    public GoogleMaps(String apiKey) {
        this.context.setApiKey(apiKey);
    }


    /**
     * Upon receiving a position that only has a Zip as information, this method
     * uses the functionalities of the ZipCalc class in order to geocode a Zip correctly
     * and then stores the geocoordinates in the Position object.
     *
     * WARNING: This method will generate payments. It will make up to 100 000
     * requests to the Google Maps Geocoding API, read about the pricing at:
     * https://developers.google.com/maps/pricing-and-plans/
     *
     * Note: The method is commented in order to avoid generating costs until the
     * company feels ready. To start using this functionality, simply remove the
     * comment notations here and at all the other places in the system where it
     * is implemented.
     *
     * @param position
     */
  /*  // The real implementation that is costly.
    public void findZipGeocoordinates(Position position) {
        ZipCalc zipCalc = new ZipCalc();
        position.setGeocoordinate(zipCalc.findZipGeocooridinates(position.getZip()));
    }
*/

    /**
     * Upon receiving a position that only has a Zip as information, this method
     * uses the functionalities of the temporary Zip class that conatins hardcoded
     * geocoordinates for all Swedish Zips. It stores the corresponding geocoordinates
     * in the Position object.
     *
     * Note: This implementation is free and does not make any API requests.
     *
     * @param position
     */
    // The temporary, free implementation
    public void setZipGeocoordinate(Position position) {
        position.setGeocoordinate(new Zip(Integer.parseInt(position.getZip())).getGeocoordinate());
    }
}