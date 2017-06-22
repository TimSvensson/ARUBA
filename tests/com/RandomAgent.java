/*
 * Project: ARUBA 
 * Class:   RandomAgent
 *
 * Version info
 * Created: 13/05/17
 * Creator: Tim Svensson
 *
 * Copyright notice
 * Property of Fasbros IT. Do not copy, alter, distribute, or sell in any way unless given explicit permission.
 */

package com;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Generates a set of agents with randomly selected attributes.
 * <p>
 * Class Description.
 * </p>
 *
 * @author Tim Svensson <tim.svensson@fasbros.it>
 * @version JDK 1.8
 * @since JDK 1.8
 */
public class RandomAgent {

    private int [] zipRange = {10, 98};
    private String [] cities = {
            "Stockholm",
            "Västerås",
            "Eskilstuna",
            "Kiruna",
            "Luleå",
            "Uppsala",
            "Göteborg",
            "Malmö",
            "Karlstad",
            "Kristianstad",
            "Lund",
            "norrköping",
            "Linköping",
            "Alingsås",
            "Arboga",
            "Arvika",
            "Askersund",
            "Avaskär",
            "Boden",
            "Borås",
            "Broo",
            "Enköping",
            "Falköping",
            "Falsterbo",
            "Falun",
            "Filipstad",
            "Flen",
            "Gävle",
            "Haparanda"
    };

    /**
     * Creates a set of Agent-objects using a predetermined set of characteristics selected at
     * random.
     *
     * @author Tim Svensson
     * @param numberOfAgents The number of agents to be pseudo-randomly created
     * @return An ArrayList of agents with pseudo-random attributes
     */
    public ArrayList<Agent> getAgents(int numberOfAgents) {

        ArrayList<Agent> agents = new ArrayList<>();

        for (int i = 0; i < numberOfAgents; i++) {

            Position p = new Position();
            p.setCountry("Sweden");

            // 0 for zip, 1 for city
            int zipOrCity = ThreadLocalRandom.current().nextInt(0, 2);

            if (zipOrCity == 0) {
                int zipNum;
                // A zip may not be any of the following numbers: 48, 49
                do {
                    zipNum = ThreadLocalRandom.current().nextInt(this.zipRange[0],
                                                              this.zipRange[1] + 1);
                } while (zipNum < this.zipRange[0] || zipNum > this.zipRange[1]
                         || zipNum == 48 || zipNum == 49);

                Zip zip = new Zip(zipNum);
                p.setZip(String.valueOf(zip.getZip()));
            } else {
                String city = this.cities[ThreadLocalRandom.current().nextInt(0,
                                                                              this.cities.length)];
                p.setCity(city);
            }

            Agent a = new Agent(p, Integer.toString(i), Integer.toString(i), Integer.toString(i));

            // Check if the Agent's position is null; if null, the assertion will fail.
            assert a.getPosition() != null: a.toString() + "'s position is null!";

            agents.add(a);
        }

        return agents;

    }

}
