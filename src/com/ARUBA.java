package com;

import com.ARUBAExceptions.*;
import com.GoogleAPI.DirectionsGoogle;
import com.GoogleAPI.GeocodingGoogle;
import com.GraphHopperDirectionsAPI.GHGeocodingAPI;
import com.GraphHopperDirectionsAPI.GHMatrixAPI;

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
        output.JSONformat();

        return output.getJSONrepresentation();
    }

    private Position geocode(Position p) {
        // TODO Make the system remember if an API is not working

        System.out.println(p);

        if (p.usingZip()) {
            System.out.println("Using Zip"); // TODO Remove
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
                System.out.println("Using Google Geocode API"); // TODO Remove
                if (gg.geocode(p)) {
                    System.out.println(p); // TODO Remove
                    return p;
                }
            } catch (NoResultsException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    private List<TravelRoutes> route(List<Agent> agents, List<Assignment> assignments,
                                          String modeOfTransport) {
        // TODO Make the system remember if an API is not working

        for (int i = 0; i < agents.size(); ) {

            Agent a = agents.get(i);
            if (a.getPosition() == null || !a.getPosition().hasGeocoordinate()) {

                System.out.println("Removing " + a.toString());

                agents.remove(i);
            }

            i++;
        }

        for (Assignment a : assignments) {
            assert a.getPosition() != null : a.toString() + "'s position is null.";
            assert a.getPosition().hasGeocoordinate() : a.toString() +
                                                        " does not have lat-lng.";
        }

        // Route using GraphHopper
        GHMatrixAPI ghm = new GHMatrixAPI(this.graphHopperKey);
        try {
            System.out.println("Using GH Matrix API"); // TODO Remove
            return ghm.calculateRoutes(agents, assignments, modeOfTransport);
        } catch ( NoAgentsExcpetions | RoutingResponsErrorsException | ModeOfTransportException
                | NoAssignmentsException | IllegalStateException | NullPointerException e) {
            System.out.println("GH not working.");
//            e.printStackTrace();
        }

        // Route using Google
        DirectionsGoogle dg = new DirectionsGoogle(this.googleKey);
        try {
            System.out.println("Using Google Directions API"); // TODO Remove
            return dg.calculateRoutes(agents, assignments, modeOfTransport);
        } catch (NoAgentsExcpetions | NoAssignmentsException | NoResultsException |
                ModeOfTransportException e) {
            e.printStackTrace();
        }

        return null;
    }
}
