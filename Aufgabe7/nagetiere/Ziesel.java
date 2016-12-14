package nagetiere;

import wohnhoehle.Wohnhoehle;

import java.util.List;

/**
 * Created by Sabrina on 12.12.2016.
 */
public class Ziesel extends Nagetier {

    @Override
    public Wohnhoehle vermiete(List<Wohnhoehle> wohnhoehleList) {
        for (Wohnhoehle w : wohnhoehleList) {
            if (w.canHostZiesel()) return w;
        }

        return null;
    }
}
