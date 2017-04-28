package com;

import com.GraphHopperDirectionsAPI.GHMatrixAPI;
import com.Sorting.SortingList;

import java.util.ArrayList;
import java.util.List;
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

    private enum APIs {GraphHopper, Google, MapBox}

    private final String JSONInput;

    // TODO Move these to files which are imported locally in the different APIs
    private final String GraphHopperKey;
    private final String GoogleKey; // TODO Add
    private final String MapBoxKey; // TODO Add

    public ARUBA(String JSONInput, String graphHopperKey, String googleKey, String mapBoxKey) {
        this.JSONInput = JSONInput;
        GraphHopperKey = graphHopperKey;
        GoogleKey = googleKey;
        MapBoxKey = mapBoxKey;
    }


    public String getSortedJSON() {

        // PARSER
        Parser p = new Parser();

        Input received = p.fromJson(JSONInput, Input.class);
        String posFormat = p.findPositionFormat(JSONInput);

        // Detects the format of the Assignment's position
        System.out.println("posFormat: " + posFormat);

        System.out.println("JSONInput: " + JSONInput);

        List<Agent> agents = received.getAgents();
        List<Assignment> assignments = new ArrayList<>();
        assignments.add(received.getAssignment());
        // API Calls

        // TODO Create logic for choosing API

        // GH API

        // TODO Check if geocoding is needed
        // TODO Implement geocoding

        GHMatrixAPI ghm = new GHMatrixAPI(this.GraphHopperKey);

        ghm.addAgents(agents);
        ghm.addAssignments(assignments);
        ghm.setModeOfTransport("car");

        if (!ghm.calculateRoutes()) {
            System.out.println("ERRORS IN GHM:\r\n" + ghm.getError().toString());
            // TODO Handle errors
        }

        ArrayList<TravelRoutes> tr = ghm.getRoutes();

        // Sorting & output
        Output output = new Output(tr);
        output.JSONformat();

        return output.getJSONrepresentation();

        /*
        try {
            Debugger.setup();
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Problems with creating the log files");
        }
*/
//        System.out.println("Hello world.");

		/* Agent and mission data is received from Semantix */

		/* Conversion of the data to Java Objects */
//        Parser parser = new Parser();

		/* Initiate the API(s) */
//        String apiKey = "AIzaSyC3SJNwOjapbbdwGZlanF1mC83UGEbWH7s";
//        GeoApiContext context = new GeoApiContext().setApiKey(apiKey);

		/* Send requests for the travel times between each agents address and the mission address */

		/* Extract the relevant data from the API responses, put the traveltime in the Agent Objects
		 and create
		 * a list/array of agents */

		/* Send the list/array to the Sorting Algorithm that will sort the agents based on the least
		 amount of
		 * traveltime */

		/* Conversion of this list to Semantix's code format */

		/* Send the list to Semantix */



        // Google Maps Directions API test
//        String destAddress = "Dragarbrunn";

//        String [] firstNames        = {    "Haubir",               "Desireé",              "Tim"};
//        String [] lastNames         = {    "Mariwani",             "Björkman",
        // "Svensson"};


        // Google Maps Geocoding API test

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

        Input newOrder = new Input(newAssignment, agentArray);
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
