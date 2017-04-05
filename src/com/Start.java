package com;

public class Start {
	
	public static void main(String [] args) {
		
		System.out.println("Hello world.");
		
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
 * - Alternativ till verbos information i utdatat:
 *   i) Debugging information, t.ex. profileringsinfo (tidskonsumtion osv.)
 *
 *
 *   Main-loop:
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