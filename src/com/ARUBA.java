package com;

import com.ARUBAExceptions.*;
import com.GoogleAPI.DirectionsGoogle;
import com.GoogleAPI.GeocodingGoogle;
import com.GraphHopperDirectionsAPI.GHGeocodingAPI;
import com.GraphHopperDirectionsAPI.GHMatrixAPI;

import java.util.ArrayList;
import java.util.List;

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
    //    public final static Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

    //    private enum API {GraphHopper, Google, MapBox}

    private final String JSONInput;

    // TODO Move these to files which are imported locally in the different APIs
    private final String graphHopperKey;
    private final String googleKey;
    private final String mapBoxKey; // API not implemented

    public ARUBA(String JSONInput, String graphHopperKey, String googleKey, String mapBoxKey) {
        this.JSONInput = JSONInput;
        this.graphHopperKey = graphHopperKey;
        this.googleKey = googleKey;
        this.mapBoxKey = mapBoxKey;
    }

    //<editor-fold desc="Public Methods">
    /**
     * Returns an ordered list of Agents sorted after whom has the shortest time to travel to the
     * designated assignment.
     *
     * <p>
     * This method does the following:
     * 1) It parses the JSON-object stored in the field variable JSONInput. It saves all the
     * Assignments and Agents in two different ArrayLists.
     * 2) It geocodes all the Agents and Assignemntes position in order to get the most accurate
     * position data possible
     * 3) It uses a Direction class to get the distance and travel time between all Agents and
     * all Assignments.
     * 4) It sorts the Agents after whom has the shortest time to travel to each of the Assignments
     * 5) It converts the ordered list of Agents to a JSON-object and returns it to the user.
     * </p>
     *
     * @return A JSON-object representing a sorted list of Agents ordered after whom has the
     * shortest time to travel to the specified Assignment.
     */
    public String getSortedJSON() { //TODO Change name

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

        String modeOfTransport = "car";

        // API Calls

        // Geocode all Assignments
        for (Assignment a : assignments) {
            Position pos = a.getPosition();
            if (pos.hasGeocoordinate()) {
                continue;
            }
            a.setPosition(geocode(pos));

            // TODO In case of failure, tell the user what went wrong
        }

        // Geocode all Agents
        int tmp = 0;
        for (Agent a : agents) {
            System.out.print(tmp + " ");
            Position pos = a.getPosition();
            if (pos.hasGeocoordinate()) {
                continue;
            }
            a.setPosition(geocode(pos));
            tmp++;
        }

        ArrayList<TravelRoutes> tr = (ArrayList<TravelRoutes>) route(agents, assignments,
                                                                     modeOfTransport);

        // Sorting & output
        Output output = new Output(tr);

        return output.getJSONrepresentation();
    }
    //</editor-fold>

    //<editor-fold desc="Private Methods">

    /**
     * Takes in a position and, using the most detailed position information in the object,
     * attempts to geocode the position in order to obtain a lat-lan coordinate pair.
     *
     * @param p The position to be geocoded.
     * @return If the geocoding was successful returns the Position object, otherwise null.
     */
    private Position geocode(Position p) {
        // TODO Make the system remember if an API is not working

        System.out.println(p);

        if (p.usingZip()) { // Geocode using ZIP
//            System.out.println("Using Zip"); // TODO Remove
            Zip z = new Zip(Integer.parseInt(p.getZip()));
            p.setGeocoordinate(z.getGeocoordinate());
            return p;
        } else {

            // Geocode using GraphHopper
            GHGeocodingAPI ghg = new GHGeocodingAPI(this.graphHopperKey);
            try {
                System.out.println("Using GH Geocode API");
                if (ghg.geocode(p)) {
                    return ghg.getPositionResult();
                }
            } catch (NoResultsException e) {
                e.printStackTrace();
            }

            // Geocode using Google
            GeocodingGoogle gg = new GeocodingGoogle(this.googleKey);
            try {
//                System.out.println("Using Google Geocode API"); // TODO Remove
                if (gg.geocode(p)) {
//                    System.out.println(p); // TODO Remove
                    return p;
                }
            } catch (NoResultsException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    /**
     * Creates an ArrayList of TravelRoutes containing the distances and travel times between all
     * the agents and alla the assignments.
     *
     * @param agents All the Agents.
     * @param assignments All the Assignments.
     * @param modeOfTransport The vehicle to be used in this routing call.
     * @return If the routing call was successful it returns an ArrayList of TravelRoutes,
     * otherwise it returns null.
     */
    private List<TravelRoutes> route(List<Agent> agents, List<Assignment> assignments,
                                     String modeOfTransport) {
        // TODO Make the system remember if an API is not working

        for (int i = 0; i < agents.size(); ) {

            Agent a = agents.get(i);
            if (a.getPosition() == null || !a.getPosition().hasGeocoordinate()) {
//                System.out.println("Removing " + a.toString());
                agents.remove(i);
            }
            i++;
        }

        for (Assignment a : assignments) {
            assert a.getPosition() != null : a.toString() + "'s position is null.";
            assert a.getPosition().hasGeocoordinate() : a.toString() + " does not have lat-lng.";
        }

        // Route using GraphHopper
        GHMatrixAPI ghm = new GHMatrixAPI(this.graphHopperKey);
        try {
//            System.out.println("Using GH Matrix API"); // TODO Remove
            return ghm.calculateRoutes(agents, assignments, modeOfTransport);
        } catch (NoAgentsException | HasErrorsException | ModeOfTransportException |
                NoAssignmentsException | IllegalStateException | NullPointerException e) {
//            System.out.println("GH not working.");
            //            e.printStackTrace();
        }

        // Route using Google
        DirectionsGoogle dg = new DirectionsGoogle(this.googleKey);
        try {
//            System.out.println("Using Google Directions API"); // TODO Remove
            return dg.calculateRoutes(agents, assignments, modeOfTransport);
        } catch (NoAgentsException | NoAssignmentsException | NoResultsException |
                ModeOfTransportException e) {
            e.printStackTrace();
        }

        return null;
    }
    //</editor-fold>
}
