/*
 * Project: ARUBA 
 * Class:   JsonObjectTest
 *
 * Version info
 * Created: 2017-04-20
 * Creator: Desireé Björkman
 *
 * Copyright notice
 * Property of Fasbros IT. Do not copy, alter, distribute, or sell in any way unless given explicit permission.
 */

package com;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
/**
 * Class .summary.
 * Create a json-object to use for tests.
 * Class Description.
 * This is not a test class but it is intended only to be used
 * for the tests and no more. It generates desired json object to
 * be used in the ARUBATest.
 *
 * @author Desireé Björkman <desiree.bjorkman@fasbros.it>
 * @version JDK 1.8
 * @since JDK 1.8
 *
 * @return json object
 */



public class JsonObjectTest {
    public static void main(String[] args) throws IOException {

        Geocoordinate geoTestHelp1 = new Geocoordinate(2222, 6666);
        Position positionTestHelp1 = new Position(geoTestHelp1, "", "", "", "", "", "");
        Assignment interpretationSite = new Assignment(positionTestHelp1, "42", "Carl", 4, 6);


        Geocoordinate geoTestHelp2 = new Geocoordinate(2222, 6665);
        Position positionTestHelp2 = new Position(geoTestHelp2, "", "", "", "", "", "");
        Agent interpreter1 = new Agent(positionTestHelp2, "333", "Carl", "Eriksson");

        Geocoordinate geoTestHelp3 = new Geocoordinate(2222, 6666);
        Position positionTestHelp3 = new Position(geoTestHelp3, "", "", "", "", "", "");
        Agent interpreter2 = new Agent(positionTestHelp3, "333", "Bengt", "Göteborg");

        ArrayList<Object> list = new ArrayList<Object>();
        list.add(interpretationSite);
        list.add(interpreter1);
        list.add(interpreter2);

        // Change the name of the FileOutPutStream to determine what file it's saved in.
        try (Writer writer = new OutputStreamWriter(new FileOutputStream("Input.json"), "UTF-8")) {

            Gson gson = new GsonBuilder().create();

            gson.toJson(list, writer);

        }
    }
}