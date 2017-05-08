/*
 * Project: ARUBA
 * Class:   HtmlFormatter
 *
 * Version info
 * Created: 4/11/17
 * Creator: Haubir Mariwani
 *
 * Copyright notice
 * Property of Fasbros IT. Do not copy, alter, distribute, or sell in any way unless given explicit permission.
 */

package com;

import com.google.gson.Gson;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.lang.reflect.Type;
import java.util.ArrayList;


/**
 * Class summary.
 * <p>
 * Class Description.
 * </p>
 *
 * @author Haubir Mariwani <haubir.mariwani@fasbros.it>
 * @version JDK 1.8
 * @since 4/17/17
 */
public class Parser {
    private Gson g = new Gson();

    /**
     * Constructs a Parser object that operated with a Gson parser.
     * WARNING: Not complete yet. To be extended with further parsing possibilites!
     */
    public Parser() {}

    /**
     * JSON output parser, converts objects to JSON strings
     * @param obj - the object to be converted
     * @return the JSON string
     */
    public String toJson(Object obj) {
        return g.toJson(obj);
    }

    /**
     * JSON input parser, converts JSON strings to a specified object
     * @param str - JSON string to be converted
     * @param cl - The desired class of the object
     *
     * @return the desired object
     */
    public <T> T fromJson(String str, Type cl) {
        return g.fromJson(str, cl);
    }

    /**
     * Tells whether the user wants debugging information or not
     *
     *
     * @return true or false
     */
    public boolean isDebugMode(String JSONInput) {
        Input received = g.fromJson(JSONInput, Input.class);

        return received.isDebugMode();
    }

    /**
     * Finds out what the format of the JSONInput was.
     *
     * @param JSONInput
     * @return the position format in String representation
     */
    public String findPositionFormat(String JSONInput) {
        Input received = g.fromJson(JSONInput, Input.class);

        Position assignmentPosition = received.getAssignment().getPosition();

        return findPositionFormat(assignmentPosition);
    }

    /**
     * Finds out what the position format the input Position is of.
     *
     * @param position
     * @return the position format in String representation
     */
    public String findPositionFormat(Position position) {
        String toReturn = "";

        if (position.getGeocoordinate() != null) {
            toReturn = "geocoordinate";
        }
        else if (!(position.getAddress().equals("")) ||
                !(position.getAddress() == null)){
            toReturn = "address";
        }
        else if (!(position.getPostcode().equals("")) ||
                !(position.getPostcode() == null)){
            toReturn = "postcode";
        }
        else if (!(position.getZip().equals("")) ||
                !(position.getZip() == null)) {
            toReturn = "zip";
        }
        else if (!(position.getCity().equals("")) ||
                !(position.getCity() == null)){
            toReturn = "city";
        }
        else if (!(position.getCounty().equals("")) ||
                !(position.getCounty() == null)){
            toReturn = "county";
        }
        else if (!(position.getCountry().equals("")) ||
                !(position.getCountry() == null)){
            toReturn = "country";
        }
        else {
            toReturn = "";
        }

        return toReturn;
    }

    public String getLocation(String format, Position position) {
        String location = "";

        switch (format.toLowerCase()) {
            case "geocoordinate":
                location = position.getGeocoordinate().getGoogleString();
                break;
            case "address":
                location = position.getAddress();
                break;
            case "postcode":
                location = position.getPostcode() + " " + position.getCity();
                break;
            case "zip":
                int zipNo = Integer.parseInt(position.getZip());
                location = new Zip(zipNo).getGeocoordinate().getGoogleString();
                break;
            case "city":
                location = position.getCity();
                break;
            case "county":
                location = position.getCounty();
                break;
            case "country":
                location = position.getCountry();
                break;
            default:
                break;
        }

        return location;
    }

    public String JsonParserToJava(){
        Geocoordinate geoTestHelp1 = new Geocoordinate(59.8415562, 17.6477043);
        Position positionTestHelp1 = new Position(geoTestHelp1, "Institutionen för informationsteknologi, Lägerhyddsvägen 2", "Sweden", "", "Uppsala", "752 37", "75");
        Assignment interpretationSite = new Assignment(positionTestHelp1, "42", "Carl", 4, 6);


        Geocoordinate geoTestHelp2 = new Geocoordinate(59.8513422, 17.592865999999958);
        Position positionTestHelp2 = new Position(geoTestHelp2, "Flogstavägen", "Uppsala", "", "Sweden", "75272", "75");
        Agent interpreter1 = new Agent(positionTestHelp2, "333", "Carl", "Eriksson");

        Geocoordinate geoTestHelp3 = new Geocoordinate(59.9208594, 16.606327999999962);
        Position positionTestHelp3 = new Position(geoTestHelp3, "", "Sala", "", "Sweden", "", "73");
        Agent interpreter2 = new Agent(positionTestHelp3, "666", "Bengt", "Göteborg");

        Geocoordinate geoTestHelp4 = new Geocoordinate(59.850354, 17.584603);
        Position positionTestHelp4 = new Position(geoTestHelp3, "Flogstavägen 77B", "Uppsala",
                                                  "Uppsala län", "Sweden",
                                                  "", "73");
        Agent interpreter3 = new Agent(positionTestHelp3, "939393", "Tim","Svensson");

        ArrayList<Agent> list = new ArrayList<Agent>();
        list.add(interpreter1);
        list.add(interpreter2);
        list.add(interpreter3);
        Input jsonObjectEnd = new Input(interpretationSite, list);
        Gson g = new Gson();
        String jsonOrder = g.toJson(jsonObjectEnd);

        //Input receivedOrder = g.fromJson(jsonOrder, Input.class);
        return jsonOrder;
    }
}
