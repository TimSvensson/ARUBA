package com;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

/**
 * Created by timsvensson on 11/04/17.
 */
public class AreaCalc {


    /*
    Stöd för zip: Vad krävs? Skriv ner allt. (flytta till ARUBA 0.3)
        Hantera zip-input
        Översätt zip till vilken stad/vilket område som det refererar till, ta hjälp av postkodssökningen
        Avgöra hur detta område ska användas vid beräkning av avstånd (en punkt för hela området?)
        www.Postnummerservice.se
        http://www.cartesia.se/produkter/kartdata/postnummerkartor/
    */
    Position GetMiddleZip(int zip) {
        throw new NotImplementedException();
    }

    /*
    Stöd för postkodssökning: Vad krävs? Skriv ner allt.
        Hantera postkods-input
        Postkod := postnummer + postort. ALLTID!
        Översätt till en position (en punkt)
        Ge detta som input till routing-api:t
    */
    Position GetMiddleZone(int zone) {
        throw new NotImplementedException();
    }

}
