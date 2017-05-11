package com;

//import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by timsvensson on 11/04/17.
 */
public class AreaCalc {


    public AreaCalc() {}
    /*
    Stöd för zip: Vad krävs? Skriv ner allt. (flytta till ARUBA 0.3)
        Hantera zip-input
        Översätt zip till vilken stad/vilket område som det refererar till, ta hjälp av postkodssökningen
        Avgöra hur detta område ska användas vid beräkning av avstånd (en punkt för hela området?)
        www.Postnummerservice.se
        http://www.cartesia.se/produkter/kartdata/postnummerkartor/
    */

    Position findZipGeocooridinates(String zip) {
        List<Position> positionList = findAllPostCodes(zip);

        List<Position> geocodedPostCodes = geocodePostCodes(positionList);

        Position toReturn = new Position();
        toReturn.setGeocoordinate(getMiddlePostCodeGeoCoord(geocodedPostCodes));

        return toReturn;
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

/*        String toFormat = Double.toString(avgPostCode);
        System.out.println("getMiddlePostCode: toFormat = " + toFormat);

        String formatted = StringUtils.rightPad(toFormat, 5, '0');
        System.out.println("getMiddlePostCode: formatted = " + formatted);*/

        return new Geocoordinate(avgLat, avgLng);
    }


    double average(List<Double> list) {
        double sum = 0;
        for (double i : list) sum += i;
        double avg = sum / list.size();

        return avg;
    }

    List<Position> findAllPostCodes(String zip) {
        List<Position> positions = new ArrayList<>();

        // Gör anrop till valfritt API för att hitta alla postkoder inom zip:en

        List<String> postCodeList = new ArrayList<>();

        // Tillfällig lösning för algoritmens skull
        for (int i = 0; i < 1000; i++) {
            String toFormat = zip + "" + i + "";
            /*String formatted = StringUtils.rightPad(toFormat, 5, '0');
            postCodeList.add(formatted);*/
        }

        for (String postCode : postCodeList) {
            Position p = new Position();
            p.setPostcode(postCode);
            positions.add(p);
        }

        return positions;
    }

    List<Position> geocodePostCodes(List<Position> positions) {
        return positions;
    }

    /*
    Stöd för postkodssökning: Vad krävs? Skriv ner allt.
        Hantera postkods-input
        Postkod := postnummer + postort. ALLTID!
        Översätt till en position (en punkt)
        Ge detta som input till routing-api:t
    */

    public static void main(String [] args) {
        AreaCalc areaCalc = new AreaCalc();

        Zip zip = new Zip(75);
        String zipString = "" + zip.getZip() + "";
        
    }
}
