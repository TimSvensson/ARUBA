package com;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

/**
 * Created by timsvensson on 11/04/17.
 */
public class AreaCalc {


    public AreaCalc() {}
    /*
    Stöd för zip: Vad krävs? Skriv ner allt. (flytta till ARUBA 0.3)
        Hantera zip-input
        Översätt zip till vilken stad/vilket område som det refererar till, ta hjälp av postkodssökningen
        Avgöra hur detta område ska användas vid beräkning av avstånd (en punkt för hela området?)
        www.Postnummerservice.se
        http://www.cartesia.se/produkter/kartdata/postnummerkartor/
    */
    int [] getMiddleZip(int[] zips) {
        int [] zips_half = new int[zips.length / 2];

        while (zips_half.length > 2) {
            zips_half = halfArray(zips);
        }

        throw new NotImplementedException();
    }

    int [] halfArray(int [] orig) {
        int [] dest = new int[orig.length / 2];

        for (int i = 0, j = 0; i < dest.length; i++, j++) {
            dest[i] = (orig[j] + orig[j + 1]) / orig.length;
            j++;
            System.out.println("dest[i] = " + dest[i] + ", i = " + i + ", j = " + j);
        }

        return dest;
    }

    /*
    Stöd för postkodssökning: Vad krävs? Skriv ner allt.
        Hantera postkods-input
        Postkod := postnummer + postort. ALLTID!
        Översätt till en position (en punkt)
        Ge detta som input till routing-api:t
    */
    Position getMiddleZone(int zone) {
        throw new NotImplementedException();
    }

    public static void main(String [] args) {
        AreaCalc areaCalc = new AreaCalc();
        int [] zips = {32, 75, 43, 94, 16, 17, 11, 20, 83, 66};

        int [] result = areaCalc.getMiddleZip(zips);

        System.out.println(result);
    }
}
