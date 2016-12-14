package wohnungsamt;

import nagetiere.Kolonie;
import nagetiere.Nagetier;
import wohnhoehle.Wohnhoehle;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sabrina on 12.12.2016.
 */
public class Wohnungsamt {

    private List<Wohnhoehle> wohnhoehlen = new ArrayList<Wohnhoehle>();

    /**
     * gliedert eine freie Wohnhoehle in den Bestand des Wohnungsamts ein
     * @param wohnhoehle eine neue Wohnhoehle
     */
    public void frei(Wohnhoehle wohnhoehle){

        wohnhoehlen.add(wohnhoehle);
    }

    /**
     * Druckt das gesamte verfügbare Volumen dieses Wohnungsamts in stdout
     */
    public void gesamtvolumen(){
        double gesvolumen = 0;
        for (Wohnhoehle aWohnhoehlen : wohnhoehlen) {
            gesvolumen += aWohnhoehlen.getVolume();
        }
        System.out.println("Gesamtvolumen: " + gesvolumen);
    }

    /**
     * Rents an available cave to the given rodent, if any.
     * If there is an available cave, it will be automatically set as the
     * new cave of the rodent.
     * Returns the new cave of the rodent or null if there are no valid caves left.
     *
     * @param nagetier The rodent you want a cave for. Must be a non-null value.
     * @return A cave or null if there is no one left.
     */
    public Wohnhoehle vermiete(Nagetier nagetier) {
        Wohnhoehle w = nagetier.vermiete(wohnhoehlen);
        if (w == null) return null;

        nagetier.setWohnhoehle(w);

        wohnhoehlen.remove(w);

        return w;
    }
}
