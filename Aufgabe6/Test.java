import eichhoernchen.Eichhoernchen;
import kolonie.Kolonie;
import versteck.*;

/**
 * Created by Sabrina on 04.12.2016.
 */
public class Test {

   /*
   ---------------------aufteilung---------------------
   Sabrina: versteck packet + Verstecke Test
   Aniela: Eichhoernchen + EichhoernchenKnoten + eichhoernchen.Eichhoernchen Test
   Koray: kolonie.Kolonie + kolonie.Kolonie Test + toString bei Eichhoernchen + überarbeiten von Testfällen
    */
    public static void main(String[] args) {

        /*
        ------------------------------ Verstecke Test ----------------------------------
         */

        Versteck versteck1 = new Baumversteck(1, 8.4, Nahrungsmittel.NUESSE, "Buche", 14, 12.0, 13.7);
        Versteck versteck2 = new Erdversteck(2, 17.4, Nahrungsmittel.SAMEN, 32.7, 19.0);

        System.out.println(versteck1.nummer());
        System.out.println(versteck1.volumen());
        System.out.println(versteck1.futter());
        versteck1.nahrungsmittelartAendern(Nahrungsmittel.SAMEN);
        versteck1.futterErhoehehn(78);
        System.out.println(versteck1.nahrungsmittelMenge());

        if (versteck1 instanceof IBaumversteck) {
            IBaumversteck baumversteck = (IBaumversteck) versteck1;
            System.out.println(baumversteck.getBaumart());
            System.out.println(baumversteck.getHoehe());
        }

        System.out.println(versteck2.nummer());
        System.out.println(versteck2.volumen());
        System.out.println(versteck2.futter());
        versteck2.nahrungsmittelartAendern(Nahrungsmittel.NUESSE);
        versteck2.futterErhoehehn(66);
        System.out.println(versteck2.nahrungsmittelMenge());

        if (versteck2 instanceof IErdversteck) {
            IErdversteck erdversteck = (IErdversteck) versteck2;
            System.out.println(erdversteck.entfernungNest());
        }

        /*
        --------------------------------- Eichhoernchen Test -----------------------------------
         */
        Eichhoernchen eichhoernchen1 = new Eichhoernchen("Hanna");
        Eichhoernchen eichhoernchen2 = new Eichhoernchen("Milo");

        double nuesse =eichhoernchen1.durchschnittlicheAnzahlNuesse(null);
        System.out.println("durchschnitt an nüssen:"+nuesse);

        eichhoernchen1.versteckHinzufuegen(versteck2);
        eichhoernchen1.erhoeheMenge(33,versteck2);
        nuesse =eichhoernchen1.durchschnittlicheAnzahlNuesse(IErdversteck.class);
        System.out.println("durchschnitt an nüssen:"+nuesse);
        System.out.println("maximale anzahl nüssen gesamt:"+eichhoernchen1.maximalAnzahlNuesse(null));
        System.out.println("maximale anzahl nüsse Bäume:"+eichhoernchen1.maximalAnzahlNuesse(IBaumversteck.class));

        eichhoernchen2.versteckHinzufuegen(versteck1);
        eichhoernchen2.versteckHinzufuegen(versteck2);

        System.out.println("gesamte menge versteck 1:"+eichhoernchen2.menge(versteck1));
        System.out.println("gesamte menge versteck 2:"+eichhoernchen2.menge(versteck2));

        System.out.println("Nahrungs art vorher"+versteck2.futter());
        eichhoernchen2.neuerInhalt(versteck2,Nahrungsmittel.SAMEN);
        System.out.println("Nahrungs art nacher"+versteck2.futter());

        System.out.println("anzahl Samen "+eichhoernchen2.maximalAnzahlSamen(null));
        System.out.println("durchschnitts anzahl Samen Erdverstecke "+eichhoernchen2.durchschnittlicheAnzahlSamen(IErdversteck.class));

        Versteck versteck3 = new Erdversteck(10,200,Nahrungsmittel.SAMEN,0.9,0.5);

        eichhoernchen1.versteckHinzufuegen(versteck3);
        eichhoernchen1.versteckHinzufuegen(versteck1);

        eichhoernchen1.erhoeheMenge(20,versteck3);

        System.out.println("durchschnitts entfernung Samen "+ eichhoernchen1.durchschnittlicheEntfernung(Nahrungsmittel.SAMEN));
        System.out.println("durchschnitts Höhe "+ eichhoernchen1.durchschnittlicheHoehe());
        System.out.println("durchschnitts Volumen Nüsse "+eichhoernchen1.durchschnittlichesVolumenNahrungsmittel(Nahrungsmittel.NUESSE));
        System.out.println("durchschnitts Volumen Samen "+eichhoernchen1.durchschnittlichesVolumenNahrungsmittel(Nahrungsmittel.SAMEN));
        System.out.println("durchschnitts Volumen gesamt "+eichhoernchen1.durchschnittlichesVolumenTyp(null));

        System.out.println("menge v3 "+eichhoernchen1.menge(versteck3));
        eichhoernchen1.verringereMenge(5,versteck3);
        System.out.println("menge v3"+eichhoernchen1.menge(versteck3));
        System.out.println("gesamt menge "+(eichhoernchen1.maximalAnzahlSamen(null)+eichhoernchen1.maximalAnzahlNuesse(null)));
        eichhoernchen1.versteckEntfernen(versteck3);
        System.out.println("gesamt menge ohne 3 "+(eichhoernchen1.maximalAnzahlSamen(null)+eichhoernchen1.maximalAnzahlNuesse(null)));

        /*
        ------------------------------------ kolonie.Kolonie Test ------------------------------------------
         */

        System.out.println();
        System.out.println();

        Eichhoernchen eichhoernchen3 = new Eichhoernchen("Lena");
        eichhoernchen3.versteckHinzufuegen(versteck3);
        Eichhoernchen eichhoernchen4 = new Eichhoernchen("Lisa");
        eichhoernchen4.versteckHinzufuegen(versteck1);

        Kolonie kolonie1 = new Kolonie("kolonieone");

        kolonie1.addSquirrel(eichhoernchen1);
        kolonie1.addSquirrel(eichhoernchen2);
        kolonie1.addSquirrel(eichhoernchen3);
        kolonie1.addSquirrel(eichhoernchen4);

        kolonie1.removeSquirrel(eichhoernchen1);
        kolonie1.removeSquirrel("Milo");
        kolonie1.removeSquirrel("---ShouldNotBeInTheListAndShouldDoNothing---");

        kolonie1.printDescription();

        eichhoernchen4.versteckEntfernen(versteck1);

        eichhoernchen3.versteckEntfernen(versteck1);
        eichhoernchen3.versteckEntfernen(versteck2);

        Kolonie kolonie2 = new Kolonie("kolonietwo");

        kolonie2.addSquirrel(eichhoernchen1);
        kolonie2.addSquirrel(eichhoernchen2);
        kolonie2.addSquirrel(eichhoernchen4);

        kolonie2.removeSquirrel(eichhoernchen3);
        kolonie2.removeSquirrel("Lena");
        kolonie2.removeSquirrel("---ShouldNotBeInTheListAndShouldDoNothing---");

        kolonie2.printDescription();
    }
}
