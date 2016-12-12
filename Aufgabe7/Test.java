import wohnhoehle.*;

/**
 * Created by Sabrina on 10.12.2016.
 */
public class Test {

    public static void main(String[] args) {
        Wohnhoehle wohnhoehle1 = new ErdhoehleGross(9.5, 89, 12.4);
        Wohnhoehle wohnhoehle2 = new ErdhoehleGross(20.4, 143, 32.5);
        Wohnhoehle wohnhoehle3 = new BaumhoehleGross(24.8, 150, 14);
        Wohnhoehle wohnhoehle4 = new BaumhoehleKlein(7.9, 56, 12);


        Wohnungsamt wohnungsamt = new Wohnungsamt();

        wohnungsamt.frei(wohnhoehle1);
        wohnungsamt.frei(wohnhoehle2);
        wohnungsamt.frei(wohnhoehle3);
        wohnungsamt.frei(wohnhoehle4);

        wohnungsamt.gesamtvolumen();
    }
}
