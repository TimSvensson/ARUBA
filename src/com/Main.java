package com;

import java.util.ArrayList;
import java.util.List;
import com.google.gson.*;

public class Main {

	public static void main(String [] args) {

		System.out.println("Hello world.");

		/* Agent and mission data is received from Semantix */

		/* Conversion of the data to Java Objects */

		/* Initiate the API(s) */

		/* Send requests for the travel times between each agents address and the mission address */

		/* Extract the relevant data from the API responses, put the traveltime in the Agent Objects and create
		 * a list/array of agents */

		/* Send the list/array to the Sorting Algorithm that will sort the agents based on the least amount of
		 * traveltime */

		/* Conversion of this list to Semantix's code format */

		/* Send the list to Semantix */




		// Sorting algorithm test:
        List<Agent> listOfAgents = new ArrayList<Agent>();
        SortingList sortingList = new SortingList(listOfAgents);
        for (int i = 5; i > 0; i--) {
            Agent newAgent = new Agent(new Position(
                    new Geocoordinate(i, i),
                    "" + i + "", "" + i + "",
                    "" + i + "", "" + i + "",
                    "" + i + "", "" + i + ""),
                    "" + i + "",
                    "" + i + "",
                    "" + i + "", i);
            sortingList.addAgent(newAgent);
            System.out.println("New agent " + newAgent.getFirstName() + " has a travelTime of " + newAgent.getTravelTime() + "");
        }

        System.out.println("sortingList contains " + sortingList.getSize() + " agents.");

        sortingList.printList();
        int i = 3;
        Agent newAgent = new Agent(new Position(
                new Geocoordinate(i, i),
                "" + i + "", "" + i + "",
                "" + i + "", "" + i + "",
                "" + i + "", "" + i + ""),
                "" + i + "",
                "" + i + "",
                "" + i + "", i);
        sortingList.addAgent(newAgent);
        System.out.println("sortingList contains " + sortingList.getSize() + " agents.");
        sortingList.printList();

        // JSON test
        Gson g = new Gson();
        String sortingListJSON = g.toJson(sortingList);
        System.out.println(sortingListJSON);

        SortingList newList = g.fromJson(sortingListJSON, SortingList.class);

        System.out.println("newList contains " + newList.getSize() + " agents.");
        newList.printList();
	}
}

/*
 * Fixa:
 *
 * - Tolkobjekt
 * - Uppdragsobjekt
 * - Resultatobjekt: Rankad lista med tolkar, ranken baseras på hur kort restid de har till uppdraget
 *
 * - Översättarmetod för indata från Semantix
 * - Översättarmetod för utdata till Semantix
 *
 * - Importera biblioteken som API:erna använder sig av. Detta så att vi kan återskapa objekten som vi
 *   får tillbaka efter att ha skickat requests.
 *
 * - Alternativ till verbos information i utdatat:
 *   i) Debugging information, t.ex. profileringsinfo (tidskonsumtion osv.)
 *
 *
 *    Main-loop:
 *
 * 1. Tolkdata och uppdragsdata tas emot från Semantix.
 * 2. Översättning av indatan till Javaobjekt.
 * 3. Sätta upp en liten miljö där API:erna initieras.
 * 4. Skicka iväg requests för vägbeskrivningar och restid från varje tolks adress till uppdragets adress
 * 5. Utvinna rätt information från API:erna, sätta in restid i tolkobjekten och skapa en lista med tolkar
 * 6. Skicka listan med tolkar till sorteringsalgoritmen som sorterar tolkarna efter minst restid.
 *    Alltså, minst restid längst fram i listan och längst restid längst bak.
 * 7. Översätta denna lista till rätt format.
 * 8. Skicka listan till Semantix.
 * */