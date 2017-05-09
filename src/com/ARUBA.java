package com;

import com.ARUBAExceptions.*;
import com.GoogleAPI.DirectionsGoogle;
import com.GoogleAPI.GeocodingGoogle;
import com.GraphHopperDirectionsAPI.GHGeocodingAPI;
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

//    private enum API {GraphHopper, Google, MapBox}

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

        String modeOfTransport = "car";
        // API Calls

        // TODO Create logic for choosing API

        // GH API

        // TODO Check if geocoding is needed
        // TODO Implement geocoding

        for (Agent a : agents) {
            Position pos = a.getPosition();

            if (pos.hasGeocoordinate()) {
                continue;
            }

            a.setPosition(geocode(pos));
        }

        ArrayList<TravelRoutes> tr = (ArrayList<TravelRoutes>) route(agents, assignments, modeOfTransport);

        // Sorting & output
        Output output = new Output(tr);
        output.JSONformat();

        return output.getJSONrepresentation();
    }

    private Position geocode(Position p) {

        if (p.usingZip()) {
            Zip z = new Zip(Integer.getInteger(p.getZip()));
            p.setGeocoordinate(z.getGeocoordinate());
        } else {
            // Geocode using GraphHopper
            GHGeocodingAPI ghg = new GHGeocodingAPI(this.GraphHopperKey);
            try {
                if (ghg.geocode(p)) {
                    return ghg.getPositionResult();
                }
            } catch (GoogleNoResultsException e) {
                e.printStackTrace();
            }

            // Geocode using Google
            GeocodingGoogle gg = new GeocodingGoogle();
            try {
                if (gg.geocode(p)) {
                    return p;
                }
            } catch (GoogleNoResultsException e) {
                e.printStackTrace();
            }
        }

        return null;
    }

    private List<TravelRoutes> route(List<Agent> agents, List<Assignment> assignments,
                                          String modeOfTransport) {
        // Route using GraphHopper
        GHMatrixAPI ghm = new GHMatrixAPI(this.GraphHopperKey);
        try {
            return ghm.calculateRoutes(agents, assignments,
                                                               modeOfTransport);
        } catch (NoAgentsExcpetions | RoutingResponsErrorsException | ModeOfTransportException |
                NoAssignmentsException e) {
            e.printStackTrace();
        }

        // Route using Google
        DirectionsGoogle dg = new DirectionsGoogle();
        try {
            return dg.calculateRoutes(agents, assignments, modeOfTransport);
        } catch (NoAgentsExcpetions | NoAssignmentsException | GoogleNoResultsException |
                ModeOfTransportException e) {
            e.printStackTrace();
        }

        return null;
    }
}
