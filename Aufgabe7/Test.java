import nagetiere.*;
import wohnhoehle.*;
import wohnungsamt.Wohnungsamt;

/**
 * Created by Sabrina on 10.12.2016.
 */
public class Test {

    /*
    * AUFGABENAUFTEILUNG:
    *  - Sabrina: Nagetiere Grundstruktur + erste Tests
    *  - Aniela: Wohnhoehle Grundstruktur + erste Tests
    *  - Koray: Wohnungsamt, vermiete Methode für nagetiere + fehlende Tests
     */

    public static void main(String[] args) {
        Wohnungsamt wohnungsamt = getWohnungsamt();

        System.out.println("******* INITIAL VALUES FOR WOHNUNGSAMT *******");
        wohnungsamt.gesamtvolumen();

        Kolonie kolonie1 = getKolonieOne();
        Kolonie kolonie2 = getKolonieTwo();
        Kolonie kolonie3 = getKolonieThree();
        Kolonie kolonie4 = getKolonieFour();

        Kolonie[] kolonien = new Kolonie[] {kolonie1, kolonie2, kolonie3, kolonie4};

        System.out.println("******* INITIAL VALUES FOR COLONIES *******");
        for (Kolonie k : kolonien) {
            System.out.println("*** NEW COLONY ***");
            k.gesamtmiete();
            k.gesamtvolumen();
        }

        System.out.println("******* POPULATING COLONIES *******");
        for (Kolonie k : kolonien) {
            System.out.println("*** NEW COLONY ***");
            for (Nagetier n : k.getNagetiere()) {
                if (wohnungsamt.vermiete(n) != null) {
                    System.out.println("Erfolgreich vermietet!");
                } else {
                    System.out.println("Leider gibt es keinen Platz mehr für dich...");
                }

                k.gesamtmiete();
                k.gesamtvolumen();
            }
        }

        System.out.println("******* FINAL WOHNUNGSAMT VALUES *******");

        wohnungsamt.gesamtvolumen();
    }

    private static Wohnungsamt getWohnungsamt() {
        Wohnungsamt wohnungsamt = new Wohnungsamt();

        for (int i = 0; i < 3; i++) {
            Wohnhoehle wohnhoehle1 = new ErdhoehleGross(9.5, 89, 12.4);
            Wohnhoehle wohnhoehle2 = new ErdhoehleGross(20.4, 143, 32.5);
            Wohnhoehle wohnhoehle3 = new BaumhoehleGross(24.8, 150, 14);
            Wohnhoehle wohnhoehle4 = new BaumhoehleKlein(7.9, 56, 12);
            Wohnhoehle wohnhoehle5 = new ErdhoehleKlein(9.5, 89, 12.4);
            Wohnhoehle wohnhoehle6 = new ErdhoehleGross(20.4, 143, 32.5);
            Wohnhoehle wohnhoehle7 = new BaumhoehleGross(24.8, 150, 14);
            Wohnhoehle wohnhoehle8 = new ErdhoehleKlein(7.9, 56, 12);

            wohnungsamt.frei(wohnhoehle1);
            wohnungsamt.frei(wohnhoehle2);
            wohnungsamt.frei(wohnhoehle3);
            wohnungsamt.frei(wohnhoehle4);
            wohnungsamt.frei(wohnhoehle5);
            wohnungsamt.frei(wohnhoehle6);
            wohnungsamt.frei(wohnhoehle7);
            wohnungsamt.frei(wohnhoehle8);
        }

        return wohnungsamt;
    }

    private static Kolonie getKolonieOne() {
        Nagetier nagetier1 = new Eichhoernchen();
        Nagetier nagetier2 = new Eichhoernchen();
        Nagetier nagetier3 = new Eichhoernchen();
        Nagetier nagetier4 = new Eichhoernchen();
        Nagetier nagetier5 = new Grauhoernchen();
        Nagetier nagetier6 = new Grauhoernchen();
        Nagetier nagetier7 = new Eichhoernchen();
        Nagetier nagetier8 = new Eichhoernchen();
        Nagetier nagetier9 = new Grauhoernchen();
        return new Kolonie(new Nagetier[]{nagetier1, nagetier2, nagetier3, nagetier4, nagetier5, nagetier6, nagetier7, nagetier8, nagetier9});
    }

    private static Kolonie getKolonieTwo() {
        Nagetier nagetier1 = new Zwerghamster();
        Nagetier nagetier2 = new Zwerghamster();
        Nagetier nagetier3 = new Zwerghamster();
        Nagetier nagetier4 = new Zwerghamster();
        Nagetier nagetier5 = new Ziesel();
        Nagetier nagetier6 = new Ziesel();
        Nagetier nagetier7 = new Ziesel();
        Nagetier nagetier8 = new Zwerghamster();
        Nagetier nagetier9 = new Ziesel();
        return new Kolonie(new Nagetier[]{nagetier1, nagetier2, nagetier3, nagetier4, nagetier5, nagetier6, nagetier7, nagetier8, nagetier9});
    }

    private static Kolonie getKolonieThree() {
        Nagetier nagetier1 = new Eichhoernchen();
        Nagetier nagetier2 = new Zwerghamster();
        Nagetier nagetier3 = new Ziesel();
        Nagetier nagetier4 = new Grauhoernchen();
        Nagetier nagetier5 = new Grauhoernchen();
        Nagetier nagetier6 = new Ziesel();
        Nagetier nagetier7 = new Ziesel();
        Nagetier nagetier8 = new Eichhoernchen();
        Nagetier nagetier9 = new Zwerghamster();
        return new Kolonie(new Nagetier[]{nagetier1, nagetier2, nagetier3, nagetier4, nagetier5, nagetier6, nagetier7, nagetier8, nagetier9});
    }

    private static Kolonie getKolonieFour() {
        Nagetier nagetier1 = new Zwerghamster();
        Nagetier nagetier2 = new Eichhoernchen();
        Nagetier nagetier3 = new Zwerghamster();
        Nagetier nagetier4 = new Zwerghamster();
        Nagetier nagetier5 = new Eichhoernchen();
        Nagetier nagetier6 = new Zwerghamster();
        Nagetier nagetier7 = new Eichhoernchen();
        Nagetier nagetier8 = new Eichhoernchen();
        Nagetier nagetier9 = new Zwerghamster();
        return new Kolonie(new Nagetier[]{nagetier1, nagetier2, nagetier3, nagetier4, nagetier5, nagetier6, nagetier7, nagetier8, nagetier9});
    }

}
