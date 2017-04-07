package com;

import com.google.maps.*;
import com.google.gson.*;
import com.google.maps.errors.ApiException;
import com.google.maps.model.DirectionsResult;
import com.google.maps.model.GeocodingResult;

import java.io.IOException;

import static com.google.maps.model.TravelMode.WALKING;

public class Main {

	public static void main(String [] args) throws InterruptedException, ApiException, IOException {

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



            /* Google Maps Directions API test */

            String apiKey = "AIzaSyC3SJNwOjapbbdwGZlanF1mC83UGEbWH7s";
            GeoApiContext context = new GeoApiContext().setApiKey(apiKey);

            String [] firstNames        = {    "Haubir",               "Desireé",              "Tim"};
            String [] lastNames         = {    "Mariwani",             "Björkman",             "Svensson"};
            String [] addresses         = {    "Sernanders Väg 7",     "Flogstavägen 73A",     "Flogstavägen 77B"};

            String destAddress = "Lägerhyddsvägen 2";

            DirectionsResult dirResult0 = DirectionsApi.getDirections(context, addresses[0], destAddress).mode(WALKING).await();
            DirectionsResult dirResult1 = DirectionsApi.getDirections(context, addresses[1], destAddress).mode(WALKING).await();
            DirectionsResult dirResult2 = DirectionsApi.getDirections(context, addresses[2], destAddress).mode(WALKING).await();

            int totalDistance0 = (int) dirResult0.routes[0].legs[0].distance.inMeters;
            int totalDuration0 = (int) dirResult0.routes[0].legs[0].duration.inSeconds;

            int totalDistance1 = (int) dirResult1.routes[0].legs[0].distance.inMeters;
            int totalDuration1 = (int) dirResult1.routes[0].legs[0].duration.inSeconds;

            int totalDistance2 = (int) dirResult2.routes[0].legs[0].distance.inMeters;
            int totalDuration2 = (int) dirResult2.routes[0].legs[0].duration.inSeconds;

            int [] travelDistances     =       {totalDistance0, totalDistance1, totalDistance2};
            int [] travelTimes         =       {totalDuration0, totalDuration1, totalDuration2};

            /* Google Maps Geocoding API test */
            GeocodingResult[] results = GeocodingApi.geocode(context, destAddress).await();
            System.out.println(results[0].formattedAddress);
            double destLatitude = results[0].geometry.location.lat;
            double destLongitude = results[0].geometry.location.lng;
            System.out.println("Latitude: " + destLatitude + "\n" + "Longitude: " + destLongitude);
            // Sorting algorithm test:
            SortingList sortingList = new SortingList(3, firstNames, lastNames, addresses, travelDistances, travelTimes);

            System.out.println("\nsortingList contains " + sortingList.getSize() + " agents.\n");

            sortingList.printList();

            // JSON test
            /*Gson g = new Gson();
            String sortingListJSON = g.toJson(sortingList);
            System.out.println(sortingListJSON);

            SortingList newList = g.fromJson(sortingListJSON, SortingList.class);

            System.out.println("newList contains " + newList.getSize() + " agents.");
            newList.printList();*/
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
 *
 *
 * */