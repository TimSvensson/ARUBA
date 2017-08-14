/*
 * Project: ARUBA
 * Class:   GeocodingGoogle
 *
 * Version info
 * Created: 4/18/17
 * Creator: Haubir Mariwani
 *
 * Copyright notice
 * Property of Fasbros IT. Do not copy, alter, distribute, or sell in any way unless given explicit permission.
 */

package com.GoogleAPI;

import com.ARUBAExceptions.NoResultsException;
import com.Geocoordinate;
import com.Interface.GeocodingInterface;
import com.Position;
import com.Zip;
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
 * Inherits from the GoogleMaps class and implements the GeocodingInterface.
 * <p>
 * Supports geocoding and reverse geocoding functionalities.
 *
 * </p>
 *
 * @author Haubir Mariwani <haubir.mariwani@fasbros.it>
 * @version JDK 1.8
 * @since JDK 1.8
 */
public class GeocodingGoogle extends GoogleMaps implements GeocodingInterface{

    public GeocodingGoogle(String apiKey) {
        super(apiKey);
    }

    /**
     * Takes the geocoordinates of a position and gives out complete information about the location
     *
     * @throws NoResultsException
     *
     * @param position
     * @return true if the reverse geocoding was successful
     */
    @Override
    public boolean geocode(Position position) throws NoResultsException {
        Geocoordinate g = new Geocoordinate(0, 0);

        String location = position.getMostPreciseLocation();

        position.setGeocoordinate(new Geocoordinate(-1, -1));
        try {

            if (location.toLowerCase().equals("zip")) {
                //findZipGeocoordinates(position); // The real implementation that is costly.
                setZipGeocoordinate(position); // The temporary, free implementation
            }
            else {

                GeocodingResult[] geocodingResults = GeocodingApi.geocode(this.context, location).await();

                if (geocodingResults.length == 0) return false;

                double newLatitude = geocodingResults[0].geometry.location.lat;
                double newLongitude = geocodingResults[0].geometry.location.lng;
                g = new Geocoordinate(newLatitude, newLongitude);
                position.setGeocoordinate(g);

            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ApiException e) {
            e.printStackTrace();
        }
        return position.getGeocoordinate().equals(g);
    }

    /**
     * Takes the geocoordinates of a position and gives out complete information about the location
     *
     * @throws NoResultsException
     *
     * @param position
     * @return true if the reverse geocoding was successful
     */
    @Override
    public boolean reverseGeocode(Position position) throws NoResultsException {
        String newAddress = null;
        Geocoordinate g = position.getGeocoordinate();
        LatLng latLng = new LatLng(g.getLatitude(), g.getLongitude());

        try {
            GeocodingResult[] geocodingResults = GeocodingApi.reverseGeocode(this.context, latLng).await();

            if (geocodingResults.length == 0) {
                throw new NoResultsException("GeocodingGoogle.reverseGeocode: No results were found...");
            }

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
                        case POSTAL_CODE:
                            postCodeComponent = a;
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
                        default:
                            break;
                    }

                }
            }

            // Sets the address attribute
            String newStreetNo = streetNoComponent.longName;
            String newRoute = routeComponent.longName;
            newAddress = newRoute + " " + newStreetNo;
            position.setAddress(newAddress);

            // Sets the postcode attribute
            String newPostCode = postCodeComponent.longName;
            position.setPostcode(newPostCode);

            // Sets the zip attribute
            String newZip = newPostCode.substring(0, 2);
            position.setZip(newZip);

            // Sets the city attribute
            String newCity = cityComponent.longName;
            position.setCity(newCity);

            // Sets the county attribute
            String newCounty = countyComponent.longName;
            position.setCounty(newCounty);

            // Sets the country attribute
            String newCountry = countryComponent.longName;
            position.setCountry(newCountry);

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

