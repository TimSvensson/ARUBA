package com;

import com.Debug.Debugger;
import com.GoogleAPI.DirectionsGoogle;
import com.google.gson.Gson;
import com.google.maps.GeoApiContext;
import com.google.maps.errors.ApiException;

import java.io.IOException;
import java.util.logging.Logger;

/**
 * The Main entry point of the ARUBA application.
 * <p>
 * To be written.
 * </p>
 *
 * @author Tim Svensson <tim.svensson@fasbros.it>
 * @version JDK 1.8
 * @since JDK 1.8
 */
public class ARUBA {
    // use the classname for the logger, this way you can refactor
    public final static Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

    public void run() {

        try {
            Debugger.setup();
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Problems with creating the log files");
        }



        System.out.println("Hello world.");

		/* Agent and mission data is received from Semantix */

		/* Conversion of the data to Java Objects */
        Parser parser = new Parser();

		/* Initiate the API(s) */
        String apiKey = "AIzaSyC3SJNwOjapbbdwGZlanF1mC83UGEbWH7s";
        GeoApiContext context = new GeoApiContext().setApiKey(apiKey);

		/* Send requests for the travel times between each agents address and the mission address */

		/* Extract the relevant data from the API responses, put the traveltime in the Agent Objects and create
		 * a list/array of agents */

		/* Send the list/array to the Sorting Algorithm that will sort the agents based on the least amount of
		 * traveltime */

		/* Conversion of this list to Semantix's code format */

		/* Send the list to Semantix */



        // Google Maps Directions API test
        String destAddress = "751 45";

        String [] firstNames        = {    "Haubir",               "Desireé",              "Tim"};
        String [] lastNames         = {    "Mariwani",             "Björkman",             "Svensson"};


        // Google Maps Geocoding API test
        GeocodeLocation geocodeLocation = null;
        try {
            geocodeLocation = new GeocodeLocation(context, destAddress);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ApiException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("\nGeocodeLocation: ");
        System.out.println("Latitude: " + geocodeLocation.getDestLatitude() + "\n" + "Longitude: " + geocodeLocation.getDestLongitude());

        // JSON test
/*        Gson g = new Gson();

        Assignment newAssignment = new Assignment(new Position("75"), "666", "", 1, 100);
        String jsonNewAssignment = g.toJson(newAssignment);
        System.out.println(jsonNewAssignment);

        Agent [] agentArray = new Agent[sortingList.getSize()];
        for (int i = 0; i < sortingList.getSize(); i++) {
            agentArray[i] = sortingList.getAgent(i);
        }

        String jsonAgentArray = g.toJson(agentArray);
        System.out.println(jsonAgentArray);

        Order newOrder = new Order(newAssignment, agentArray);
        String jsonNewOrder = g.toJson(newOrder);
        System.out.println(jsonNewOrder);

        String sortingListJSON = g.toJson(sortingList);
        System.out.println(sortingListJSON);

        SortingList newList = g.fromJson(sortingListJSON, SortingList.class);

        System.out.println("newList contains " + newList.getSize() + " agents.");
        newList.printList();
*/
    }
}
