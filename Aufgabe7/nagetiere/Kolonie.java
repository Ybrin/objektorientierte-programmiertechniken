package nagetiere;

import wohnhoehle.Wohnhoehle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Sabrina on 12.12.2016.
 */
public class Kolonie {

    private List<Nagetier> nagetiere = new ArrayList<Nagetier>();

    public Kolonie() {
    }

    public Kolonie(Nagetier[] nagetiers) {
        this(Arrays.asList(nagetiers));
    }

    public Kolonie(List<Nagetier> initialElements) {
        nagetiere.addAll(initialElements);
    }

    public void add(Nagetier nagetier) {
        nagetiere.add(nagetier);
    }

    public List<Nagetier> getNagetiere() {
        return nagetiere;
    }

    /**
     * Prints the total volume of all caves for this colony to stdout
     */
    public void gesamtvolumen() {
        double gesvolumen = 0;
        for (Nagetier nagetier : nagetiere) {
            Wohnhoehle hoehle = nagetier.getWohnhoehle();
            if (hoehle != null) gesvolumen += hoehle.getVolume();
        }
        System.out.println("Gesamtvolumen dieser Kolonie: " + gesvolumen);
    }

    /**
     * Prints the total rent sum for all caves in this colony to stdout
     */
    public void gesamtmiete() {
        double gesamtMiete = 0;
        for (Nagetier nagetier : nagetiere) {
            Wohnhoehle wohnhoehle = nagetier.getWohnhoehle();
            if (wohnhoehle != null) gesamtMiete += wohnhoehle.getMonatsmiete();
        }

        System.out.println("Gesmtmiete dieser Kolonie: " + gesamtMiete);
    }
}
