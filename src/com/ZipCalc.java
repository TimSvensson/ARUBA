package com;

import com.ARUBAExceptions.NoResultsException;
import com.GoogleAPI.GeocodingGoogle;
// TODO: Uncomment the row below
//import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by timsvensson on 11/04/17.
 */
public class ZipCalc {


    public ZipCalc() {}
    /*
    Stöd för zip: Vad krävs? Skriv ner allt. (flytta till ARUBA 0.3)
        Hantera zip-input
        Översätt zip till vilken stad/vilket område som det refererar till, ta hjälp av postkodssökningen
        Avgöra hur detta område ska användas vid beräkning av avstånd (en punkt för hela området?)
        www.Postnummerservice.se
        http://www.cartesia.se/produkter/kartdata/postnummerkartor/
    */
/*
    public Geocoordinate findZipGeocooridinates(String zip) {
        List<Position> positionList = findAllPostCodes(zip);

        List<Position> geocodedPostCodes = null;

        try {
            geocodedPostCodes = geocodePostCodes(positionList);
        } catch (NoResultsException e) {
            e.printStackTrace();
        }

        return getMiddlePostCodeGeoCoord(geocodedPostCodes);
    }

    Geocoordinate getMiddlePostCodeGeoCoord(List<Position> positionsList) {
        List<Double> latList = new ArrayList<>();
        List<Double> lngList = new ArrayList<>();

        for (Position p : positionsList) {
            latList.add(p.getGeocoordinate().getLatitude());
            lngList.add(p.getGeocoordinate().getLongitude());
        }

        double avgLat = average(latList);
        double avgLng = average(lngList);


        return new Geocoordinate(avgLat, avgLng);
    }


    double average(List<Double> list) {
        double sum = 0;
        for (double i : list) sum += i;
        double avg = sum / list.size();

        return avg;
    }

    List<Position> findAllPostCodes(String zip) {
        // Gör anrop till valfritt API för att hitta alla postkoder inom zip:en
        List<Position> postCodeList = new ArrayList<>();

        // Tillfällig lösning för algoritmens skull
        for (int i = 0; i < 1000; i++) {
            String toFormat = zip + "" + i + "";
            // TODO: Uncomment the row below
            // String formatted = StringUtils.rightPad(toFormat, 5, '0');
            Position p = new Position();
            // TODO: Uncomment the row below
            // p.setPostcode(formatted);
            postCodeList.add(p);
        }

        return postCodeList;
    }

    List<Position> geocodePostCodes(List<Position> positions) throws NoResultsException {
        GeocodingGoogle geocodingGoogle = new GeocodingGoogle();

        for (Position p : positions) if (!geocodingGoogle.geocode(p)) positions.remove(p);

        return positions;
    }
*/
    /*
    Stöd för postkodssökning: Vad krävs? Skriv ner allt.
        Hantera postkods-input
        Postkod := postnummer + postort. ALLTID!
        Översätt till en position (en punkt)
        Ge detta som input till routing-api:t
    */
}
