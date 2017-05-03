/*
 * Project: ARUBA
 * Class:   GeocodingGoogle
 *
 * Version info
 * Created: 18/04/17
 * Creator: Haubir Mariwani
 *
 * Copyright notice
 * Property of Fasbros IT. Do not copy, alter, distribute, or sell in any way unless given explicit permission.
 */

package com.GoogleAPI;

import com.Geocoordinate;
import com.Interface.GeocodingInterface;
import com.Position;
import com.google.maps.GeoApiContext;
import com.google.maps.GeocodingApi;
import com.google.maps.errors.ApiException;
import com.google.maps.model.AddressComponent;
import com.google.maps.model.AddressComponentType;
import com.google.maps.model.GeocodingResult;
import com.google.maps.model.LatLng;

import java.io.IOException;

/**
 * Handles the functionalities and duties of the Google Geocoding API in this system.
 * <p>
 * Upon receiving an address to geocode, the GeocodingGoogle object makes a request to
 * the Google Geocoding API and receives the corresponding geocodes for the address, and
 * stores them within the object.
 *
 * </p>
 *
 * @author Haubir Mariwani <haubir.mariwani@fasbros.it>
 * @version JDK 1.8
 * @since JDK 1.8
 */
public class GeocodingGoogle implements GeocodingInterface {
    String apiKey = "AIzaSyC3SJNwOjapbbdwGZlanF1mC83UGEbWH7s";
    GeoApiContext context = new GeoApiContext().setApiKey(apiKey);

    /**
     * Constructs the GeocodingGoogle object that is used for the
     * functionalities of the Google Maps Geocoding API.
     *
     */
    public GeocodingGoogle() {

    }

    /**
     * Takes the geocoordinates of a position and gives out complete information about the location
     *
     * @param position
     * @return true if the reverse geocoding was successful
     */
    @Override
    public boolean geocode(Position position) {
        Geocoordinate g = new Geocoordinate(0, 0);
        position.setGeocoordinate(new Geocoordinate(-1, -1));

        try {
            GeocodingResult[] geocodingResults = GeocodingApi.geocode(this.context, position.getAddress()).await();
            double newLatitude = geocodingResults[0].geometry.location.lat;
            double newLongitude = geocodingResults[0].geometry.location.lng;
            g = new Geocoordinate(newLatitude, newLongitude);
            position.setGeocoordinate(g);

        } catch (ApiException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return position.getGeocoordinate().equals(g);
    }

    /**
     * Takes the geocoordinates of a position and gives out complete information about the location
     *
     * @param position
     * @return true if the reverse geocoding was successful
     */
    @Override
    public boolean reverseGeocode(Position position) {
        String newAddress = null;
        Geocoordinate g = position.getGeocoordinate();
        LatLng latLng = new LatLng(g.getLatitude(), g.getLongitude());

        try {
            GeocodingResult[] geocodingResults = GeocodingApi.reverseGeocode(this.context, latLng).await();

            AddressComponent streetNoComponent = null;
            AddressComponent routeComponent = null;
            AddressComponent cityComponent = null;
            AddressComponent countyComponent = null;
            AddressComponent countryComponent = null;
            AddressComponent postCodeComponent = null;

            for (AddressComponent a : geocodingResults[0].addressComponents) {
                for (AddressComponentType aType : a.types) {
                    switch (aType) {
                        case STREET_NUMBER:
                            streetNoComponent = a;
                            break;
                        case ROUTE:
                            routeComponent = a;
                            break;
                        case LOCALITY:
                            cityComponent = a;
                            break;
                        case ADMINISTRATIVE_AREA_LEVEL_1:
                            countyComponent = a;
                            break;
                        case COUNTRY:
                            countryComponent = a;
                            break;
                        case POSTAL_CODE:
                            postCodeComponent = a;
                            break;
                        default:
                            break;
                    }

                }
            }

            String newStreetNo = streetNoComponent.longName;
            String newRoute = routeComponent.longName;
            newAddress = newRoute + " " + newStreetNo;
            position.setAddress(newAddress);

            String newCity = cityComponent.longName;
            position.setCity(newCity);

            String newCounty = countyComponent.longName;
            position.setCounty(newCounty);

            String newCountry = countryComponent.longName;
            position.setCountry(newCountry);

            String newPostCode = postCodeComponent.longName;
            position.setPostcode(newPostCode);

        } catch (ApiException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return position.getAddress().equals(newAddress);
    }
}

