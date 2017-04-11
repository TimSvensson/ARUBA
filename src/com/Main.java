package com;

import com.google.gson.Gson;
import com.google.maps.GeoApiContext;
import com.google.maps.errors.ApiException;

import java.io.IOException;

/**
 *
 */
public class Main {

    public static void main(String [] args) throws InterruptedException, ApiException, IOException {
        String apiKey = "AIzaSyC3SJNwOjapbbdwGZlanF1mC83UGEbWH7s";
        GeoApiContext context = new GeoApiContext().setApiKey(apiKey);

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



        // Google Maps Directions API test
        String destAddress = "Lägerhyddsvägen 2";

        String [] firstNames        = {    "Haubir",               "Desireé",              "Tim"};
        String [] lastNames         = {    "Mariwani",             "Björkman",             "Svensson"};

        DirectionsTest directionsTest = new DirectionsTest(context, apiKey, destAddress);

        // Google Maps Geocoding API test
        GeocodeLocation geocodeLocation = new GeocodeLocation(context, destAddress);
        System.out.println("\nGeocodeLocation: ");
        System.out.println("Latitude: " + geocodeLocation.getDestLatitude() + "\n" + "Longitude: " + geocodeLocation.getDestLongitude());

        System.out.println("length of getAddresses(): " + directionsTest.getAddresses().length);
        for (int i = 0; i < directionsTest.getTravelDistances().length; i++) {
            System.out.println("directionsTest.getTravelDistances()[" + i + "]: " + directionsTest.getTravelDistances()[i]);
            System.out.println("directionsTest.getTravelTimes()[" + i + "]: " + directionsTest.getTravelTimes()[i]);
        }
        // Sorting algorithm test
        System.out.println("\nSortingList and DirectionsTest: ");
        SortingList sortingList =   new SortingList(directionsTest.getAddresses().length, firstNames, lastNames, directionsTest.getAddresses(),
                                                    directionsTest.getTravelDistances(), directionsTest.getTravelTimes());

        System.out.println("\nsortingList contains " + sortingList.getSize() + " agents.\n");
        sortingList.printList();

        // JSON test
        Gson g = new Gson();

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
 *
 * Att göra:
 *
 * - Stöd för adressökning: Vad krävs? Skriv ner allt.
 * - Stöd för postkodssökning: Vad krävs? Skriv ner allt.
 * - Stöd för zip: Vad krävs? Skriv ner allt.
 * - Stöd för staddsökning: Vad krävs? Skriv ner allt.
 * - Stöd för etc. : Vad krävs? Skriv ner allt.
 * - Ta medelvärdet av restiden från närmsta och längsta punkt inom en zon till klientens position
 * - Ta mittpunkten i zonen och kör restiden därifrån till klientens position
 * - Kolla närliggande zoner ifall ingen tolk finns i klientens zon. Fortsätt tills en tolk hittas
 * - Vi måste planera exakt hur skelettet ska se ut på måndag.
 * - Bam!
 * - Spara alla API nycklar i en fil och läsa in därifrån!
 * - En klass per API som ska implementera ett gemensamt interface.
 * - Gör interface för sorteringsalgoritmen så att den kan bli generisk.
 *      - Man ska kunna ange vilken objekttyp och sorteringskriteriet
 *
 * */