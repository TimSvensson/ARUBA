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

import com.ARUBAExceptions.NoResultsException;
import com.Geocoordinate;
import com.Interface.GeocodingInterface;
import com.Position;
import io.swagger.client.ApiException;
import io.swagger.client.api.GeocodingApi;
import io.swagger.client.model.GeocodingResult;
import io.swagger.client.model.Location;

/**
 * Provides geocoding and reverse-geocoding functionality using GraphHopper's Geocode API.
 *
 * @author Tim Svensson <tim.svensson@fasbros.it>
 * @version JDK 1.8
 * @since JDK 1.8
 */
public class GHGeocodingAPI implements GeocodingInterface {

    public enum GHGeocodeProvider {DEFAULT, NOMINATIM, OPENCAGEDATA}

    //<editor-fold desc="Member Variables">
    private String apiKey;
    private GHGeocodeProvider ghGeocodeProvider = GHGeocodeProvider.DEFAULT;

    private GeocodingResult geocodingResult;
    private Position positionResult;
    private int resultLimit = 0;
    //</editor-fold>

    public GHGeocodingAPI(String apiKey) {
        this.apiKey = apiKey;
    }

    //<editor-fold desc="Getters&Setters">
    public Position getPositionResult() {
        return positionResult;
    }

    public int getResultLimit() {
        return resultLimit;
    }

    public void setResultLimit(int resultLimit) {
        this.resultLimit = resultLimit;
    }

    public void setGhGeocodeProvider(GHGeocodeProvider ghGeocodeProvider) {
        this.ghGeocodeProvider = ghGeocodeProvider;
    }

    public GeocodingResult getGeocodingResult() {
        return geocodingResult;
    }
    //</editor-fold>

    //<editor-fold desc="Public Methods">
    @Override
    public boolean geocode(Position position) throws NoResultsException {

        GeocodingApi apiInstance = new GeocodingApi();

        // String | If you do forward geocoding, then this would be a textual description of the
        // adress you are looking for. If you do reverse geocoding this would be in lat,lon.
        String q = position.toString();

        // String | Display the search results for the specified locale. Currently French (fr),
        // English (en), German (de) and Italian (it) are supported. If the locale wasn't found the
        // default (en) is used.
        String locale = "en";

        // Integer | Specify the maximum number of returned results
        if (this.getResultLimit() <= 0) {
            this.setResultLimit(1);
        }

        // Boolean | Set to true to do a reverse Geocoding request
        Boolean reverse = false;

        // String | The location bias in the format 'latitude,longitude' e.g.
        // point=45.93272,11.58803
        String point = "";

        // String | Can be either, default, nominatim, opencagedata
        String provider = getProvider();

        if (getResult(apiInstance, q, locale, reverse, point, provider) == false) {
            return false;
        }

        Location l = this.geocodingResult.getHits().get(0);
        String street = "";
        if (l.getStreet() != null) {
            street += l.getStreet();
            if (l.getHousenumber() != null) {
                street += " " + l.getHousenumber();
            }
        }
        this.positionResult = new Position(
                new Geocoordinate(l.getPoint().getLat(), l.getPoint().getLng()),
                street,
                l.getCity(),
                l.getState(),
                l.getCountry(),
                l.getPostcode(),
                ""
        );

        return true;
    }

    @Override
    public boolean reverseGeocode(Position position) {

        // TODO Write tests

        GeocodingApi apiInstance = new GeocodingApi();

        // String | If you do forward geocoding, then this would be a textual description of the
        // adress you are looking for. If you do reverse geocoding this would be in lat,lon.
        String q = position.getGeocoordinate().getLatitude() + "," +
                position.getGeocoordinate().getLongitude();

        // String | Display the search results for the specified locale. Currently French (fr),
        // English (en), German (de) and Italian (it) are supported. If the locale wasn't found the
        // default (en) is used.
        String locale = "en";

        // Integer | Specify the maximum number of returned results
        if (this.getResultLimit() <= 0) {
            this.setResultLimit(1);
        }

        // Boolean | Set to true to do a reverse Geocoding request
        Boolean reverse = true;

        // String | The location bias in the format 'latitude,longitude' e.g.
        // point=45.93272,11.58803
        String point = "";

        // String | Can be either, default, nominatim, opencagedata
        String provider = getProvider();

        if (getResult(apiInstance, q, locale, reverse, point, provider)) {
            return false;
        }

        Location l = geocodingResult.getHits().get(0);
        String street = "";
        if (l.getStreet() != null) {
            street += l.getStreet();
            if (l.getHousenumber() != null) {
                street += " " + l.getHousenumber();
            }
        }
        positionResult = new Position(
                new Geocoordinate(l.getPoint().getLat(), l.getPoint().getLng()),
                street,
                l.getCity(),
                l.getState(),
                l.getCountry(),
                l.getPostcode(),
                ""
        );

        return true;
    }
    //</editor-fold>

    //<editor-fold desc="Private Methods">

    /**
     * Executes the API-call to Graphhoppers Geocoding API. Used for both Geocoding and Reverse
     * Geocoding, the desired functionality is specified using a boolean.
     *
     * @param apiInstance The instance of the Graphhopper Java client.
     * @param q Query string.
     * @param locale Represents what language the result is to be written in.
     * @param reverse Specifies if the call will geocode or reverse-geocode.
     * @param point The location bias in the format 'latitude,longitude'.
     * @param provider Which Geocode provider is to be used.
     * @return True if the API-call was made successfully, otherwise false.
     */
    private boolean getResult(GeocodingApi apiInstance, String q, String locale, Boolean reverse,
                              String point, String provider) {
        try {
            this.geocodingResult = apiInstance.geocodeGet(this.apiKey, q, locale,
                    this.getResultLimit(), reverse, point, provider);
        } catch (ApiException e) {
            return false;
        }
        return true;
    }

    /**
     * Returns the provider used to get the Reverse Geocoding or Geocoding results in the API-call.
     * @return The provider used.
     */
    private String getProvider() {
        String provider = "";
        switch (this.ghGeocodeProvider) {
            case DEFAULT:
                provider = "default";
                break;
            case NOMINATIM:
                provider = "nominatim";
                break;
            case OPENCAGEDATA:
                provider = "opencagedata";
                break;
//            default:
//                throw new IOException("ghGeocodeProvider is null");
        }
        return provider;
    }
    //</editor-fold>
}
