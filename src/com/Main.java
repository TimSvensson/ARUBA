/**
 * Main is what starts ARUBA.
 *
 * @version JDK 1.8
 * @since JDK 1.8
 */

package com;

/**
 * The main class with take a JSON-object that it will process though ARUBA. The result will then
 * be returned as printed JSON-object.
 */
public class Main {

    public static void main(String [] args) {

        Parser p = new Parser();
        String jsonInput = p.JsonParserToJava();

        // READ API-KEYS FROM FILE

        ARUBA aruba = new ARUBA(jsonInput, KeyGetter.getGHKey(), KeyGetter.getGoogleKey(), KeyGetter
                .getMapBoxKey());

        // TODO return this to outside the application
        System.out.print(aruba.getSortedJSON());

        System.exit(0);
    }
}
