package nagetiere;

import wohnhoehle.Wohnhoehle;

import java.util.List;

/**
 * Created by Sabrina on 12.12.2016.
 */
public class Eichhoernchen extends Nagetier {

    @Override
    public Wohnhoehle vermiete(List<Wohnhoehle> wohnhoehleList) {
        for (Wohnhoehle w : wohnhoehleList) {
            if (w.canHostEichhoernchen()) return w;
        }

        for (Wohnhoehle w : wohnhoehleList) {
            if (w.canHostGrauhoernchen()) return w;
        }

        return null;
    }
}
