package com;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

/**
 *
 */
public class Main {

    public static void main(String [] args) {

        String graphHopperKey = "";
        String mapBoxKey = "";
        String googleKey = "";

        Parser p = new Parser();
        String jsonInput = p.JsonParserToJava();

        // READ API-KEYS FROM FILE

        try {
            KeyGetter kg = new KeyGetter();

            mapBoxKey = kg.getMapBoxKey();
            graphHopperKey = kg.getGHKey();
            googleKey = kg.getGoogleKey();
        } catch (IOException e) {
            e.printStackTrace();
        }

        ARUBA aruba = new ARUBA(jsonInput, graphHopperKey, googleKey, mapBoxKey);

        // TODO return this to outside the application
        System.out.print("Output: " + aruba.getSortedJSON());

        System.exit(0);
    }

    private static class KeyGetter {

        final String fileName = "api_keys.txt";
        String workingDirectory;

        String ghKey;
        String googleKey;
        String mapBoxKey;

        public KeyGetter() throws IOException {

            setWorkingDirectory();

            System.out.println("workingDirectory=" + this.workingDirectory);

            getFileContent(this.workingDirectory);

            System.out.println("GraphHopper=" + this.getGHKey());
            System.out.println("MapBox=" + this.getMapBoxKey());
            System.out.println("Google=" + this.getGoogleKey());
        }

        private void setWorkingDirectory() {

            // Code taken from
            // http://stackoverflow.com/questions/11113974/what-is-the-cross-platform-way-of-obtaining-the-path-to-the-local-application-da

            //here, we assign the name of the OS, according to Java, to a variable...
            String OS = (System.getProperty("os.name")).toUpperCase();

            //to determine what the workingDirectory is.
            //if it is some version of Windows
            if (OS.contains("WIN")) {
                //it is simply the location of the "AppData" folder
                this.workingDirectory = System.getenv("AppData");
            }

            //Otherwise, we assume Linux or Mac
            else {
                //in either case, we would start in the user's home directory
                workingDirectory = System.getProperty("user.home");
                //if we are on a Mac, we are not done, we look for "Application Support"
                workingDirectory += "/Library";
            }

            workingDirectory += "/ARUBA/" + fileName;
        }

        private void getFileContent(String file) throws IOException {

            Path path = Paths.get(file);

            Scanner s = new Scanner(path);

            while (s.hasNext()) {
                switch (s.next().toLowerCase()) {
                    case "graphhopper":
                        ghKey = s.next();
                        break;
                    case "google":
                        googleKey = s.next();
                        break;
                    case "mapbox":
                        mapBoxKey = s.next();
                        break;
                    default:
                }
            }
        }

        public String getGHKey() {
            return this.ghKey;
        }

        public String getGoogleKey() {
            return this.googleKey;
        }

        public String getMapBoxKey() {
            return this.mapBoxKey;
        }

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
 * - Input.java ska kunna ha en eller flera Assignments och en eller flera Agents.
 *
 * Skicka vilket/vilka API/(API:er och dess/deras API-nycklel/nycklar i JSON-objektet i argumentet till main.
 *
 *
 */