/**
 * Class to read all the API-keys from a file. Does not need to be instantiated to be used.
 * <p>
 * Looks for a file containing the different API keys in the %APPDATA%/ARUBA/api_keys.txt
 * on PC and in the ~/Library/ARUBA/api_keys.txt on mac or Linux. All methods in the KeyGetter
 * are static and as such can be called without instantiating the class.
 * </p>
 *
 * @author Tim Svensson <tim.svensson@fasbros.it>
 * @version JDK 1.8
 * @since JDK 1.8
 */

package com;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class KeyGetter {

    /**
     * Creates the path to the 'api_keys.txt' file and is OS-dependent.
     * @return The path to the 'api_keys.txt'
     */
    private static String getWorkingDirectory() {

        String workingDirectory;
        final String fileName = "api_keys.txt";

        // Code taken from
        // http://stackoverflow.com/questions/11113974/what-is-the-cross-platform-way-of-obtaining-the-path-to-the-local-application-da

        //here, we assign the name of the OS, according to Java, to a variable...
        String OS = (System.getProperty("os.name")).toUpperCase();

        //to determine what the workingDirectory is.
        //if it is some version of Windows
        if (OS.contains("WIN")) {
            //it is simply the location of the "AppData" folder
            workingDirectory = System.getenv("AppData");
        }

        //Otherwise, we assume Linux or Mac
        else {
            //in either case, we would start in the user's home directory
            workingDirectory = System.getProperty("user.home");
            //if we are on a Mac, we are not done, we look for "Application Support"
            workingDirectory += "/Library";
        }

        workingDirectory += "/ARUBA/" + fileName;
        System.out.println(workingDirectory);

        return workingDirectory;
    }

    /**
     * Finds and returns the api key in the file api_key.txt
     * @param api The api
     * @return The api key
     */
    private static String getAPIKeyFromFile(String api)  {

        Path path = Paths.get(getWorkingDirectory());
        Scanner s;
        try {
            s = new Scanner(path);
            while (s.hasNext()) {
                if (s.next().toLowerCase().equals(api.toLowerCase())) {
                    String apiKey = s.next();
                    System.out.println(api + "\t" + apiKey);
                    return apiKey;
                } else {
                    s.next();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String getGHKey() {
        return getAPIKeyFromFile("GraphHopper");
    }

    public static String getGoogleKey() {
        return getAPIKeyFromFile("Google");
    }

    public static String getMapBoxKey() {return getAPIKeyFromFile("MapBox"); }

}
