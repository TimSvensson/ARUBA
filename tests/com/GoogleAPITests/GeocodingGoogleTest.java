package com.GoogleAPITests;


import com.Geocoordinate;
import com.GoogleAPI.GeocodingGoogle;
import com.Position;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by timsvensson on 12/04/17.
 */
public class GeocodingGoogleTest {
    GeocodingGoogle geocodingGoogle = new GeocodingGoogle();

    Position position1 = new Position(new Geocoordinate(0.000, 0.000),"Sernanders väg 7", "Uppsala", "Uppsala län", "Sweden", "752 61", "75");
    Geocoordinate geocoordinate1 = new Geocoordinate(59.8507334,17.59078569999997);

    Position position2 = new Position(new Geocoordinate(0.000, 0.000),"Råcksta Gårdsväg 23", "Stockholm", "Stockholms län", "Sweden", "162 54", "16");
    Geocoordinate geocoordinate2 = new Geocoordinate(59.35468299999999,17.887079599999993);

    Position position3 = new Position(new Geocoordinate(0.000, 0.000),"Skattegårdsvägen 390", "Stockholm", "Stockholms län", "Sweden", "162 45", "16");
    Geocoordinate geocoordinate3 = new Geocoordinate(59.3776421,17.84364210000001);

    Position position4 = new Position(new Geocoordinate(0.000, 0.000),"Luthagsesplanaden 91", "Uppsala", "Uppsala län", "Sweden", "752 71", "75");
    Geocoordinate geocoordinate4 = new Geocoordinate(59.85368039999999,17.599490599999967);

    Position position5 = new Position(new Geocoordinate(0.000, 0.000),"Flogstavägen 77B", "Uppsala", "Uppsala län", "Sweden", "752 72", "75");
    Geocoordinate geocoordinate5 = new Geocoordinate(59.85036530000001,17.58458089999999);

    Position position6 = new Position(new Geocoordinate(0.000, 0.000),"Marknadsgatan 1", "Uppsala", "Uppsala län", "Sweden", "754 31", "75");
    Geocoordinate geocoordinate6 = new Geocoordinate(59.87719869999999,17.6740273);


    @Test
    public void geocode() {
        assert(geocodingGoogle.geocode(position1));
        assert(geocodingGoogle.geocode(position2));
        assert(geocodingGoogle.geocode(position3));
        assert(geocodingGoogle.geocode(position4));
        assert(geocodingGoogle.geocode(position5));
        assert(geocodingGoogle.geocode(position6));

        if (geocoordinate2.equals(position2.getGeocoordinate())) {
            assertEquals(geocoordinate1, position1.getGeocoordinate());
            assertEquals(geocoordinate2, position2.getGeocoordinate());
            assertEquals(geocoordinate3, position3.getGeocoordinate());
            assertEquals(geocoordinate4, position4.getGeocoordinate());
            assertEquals(geocoordinate5, position5.getGeocoordinate());
            assertEquals(geocoordinate6, position6.getGeocoordinate());
        }
        else {
            assert((geocoordinate1.getLatitude() - position1.getGeocoordinate().getLatitude()) < 0.000000001);
            assert((geocoordinate2.getLatitude() - position2.getGeocoordinate().getLatitude()) < 0.000000001);
            assert((geocoordinate3.getLatitude() - position3.getGeocoordinate().getLatitude()) < 0.000000001);
            assert((geocoordinate4.getLatitude() - position4.getGeocoordinate().getLatitude()) < 0.000000001);
            assert((geocoordinate5.getLatitude() - position5.getGeocoordinate().getLatitude()) < 0.000000001);
            System.out.println(geocoordinate6.getLatitude());
            System.out.println(position6.getGeocoordinate().getLatitude());
            System.out.println();
            assert((geocoordinate6.getLatitude() - position6.getGeocoordinate().getLatitude()) < 0.000000001);

            assert((geocoordinate1.getLongitude() - position1.getGeocoordinate().getLongitude()) < 0.000000001);
            assert((geocoordinate2.getLongitude() - position2.getGeocoordinate().getLongitude()) < 0.000000001);
            assert((geocoordinate3.getLongitude() - position3.getGeocoordinate().getLongitude()) < 0.000000001);
            assert((geocoordinate4.getLongitude() - position4.getGeocoordinate().getLongitude()) < 0.000000001);
            assert((geocoordinate5.getLongitude() - position5.getGeocoordinate().getLongitude()) < 0.000000001);
            assert((geocoordinate6.getLongitude() - position6.getGeocoordinate().getLongitude()) < 0.000000001);
        }
    }

    @Test
    public void reverseGeocode() {
        position1.setGeocoordinate(geocoordinate1);
        position2.setGeocoordinate(geocoordinate2);
        position3.setGeocoordinate(geocoordinate3);
        position4.setGeocoordinate(geocoordinate4);
        position5.setGeocoordinate(geocoordinate5);
        position6.setGeocoordinate(geocoordinate6);

        assert(geocodingGoogle.reverseGeocode(position1));
        assert(geocodingGoogle.reverseGeocode(position2));
        assert(geocodingGoogle.reverseGeocode(position3));
        assert(geocodingGoogle.reverseGeocode(position4));
        assert(geocodingGoogle.reverseGeocode(position5));
        assert(geocodingGoogle.reverseGeocode(position6));

        assertEquals("Sernanders väg 7", position1.getAddress());
        assertEquals("Uppsala", position1.getCity());
        assertEquals("Uppsala län", position1.getCounty());
        assertEquals("Sweden", position1.getCountry());
        assertEquals("752 61", position1.getPostcode());

        assertEquals("Råcksta gårdsväg 23", position2.getAddress());
        assertEquals("Stockholm", position2.getCity());
        assertEquals("Stockholms län", position2.getCounty());
        assertEquals("Sweden", position2.getCountry());
        assertEquals("162 54", position2.getPostcode());

        assertEquals("Skattegårdsvägen 390", position3.getAddress());
        assertEquals("Stockholm", position3.getCity());
        assertEquals("Stockholms län", position3.getCounty());
        assertEquals("Sweden", position3.getCountry());
        assertEquals("162 45", position3.getPostcode());

        assertEquals("Luthagsesplanaden 91", position4.getAddress());
        assertEquals("Uppsala", position4.getCity());
        assertEquals("Uppsala län", position4.getCounty());
        assertEquals("Sweden", position4.getCountry());
        assertEquals("752 71", position4.getPostcode());

        assertEquals("Flogstavägen 77B", position5.getAddress());
        assertEquals("Uppsala", position5.getCity());
        assertEquals("Uppsala län", position5.getCounty());
        assertEquals("Sweden", position5.getCountry());
        assertEquals("752 72", position5.getPostcode());

        assertEquals("Marknadsgatan 1", position6.getAddress());
        assertEquals("Uppsala", position6.getCity());
        assertEquals("Uppsala län", position6.getCounty());
        assertEquals("Sweden", position6.getCountry());
        assertEquals("754 60", position6.getPostcode());
    }
}
