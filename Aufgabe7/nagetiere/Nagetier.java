package nagetiere;

import wohnhoehle.Wohnhoehle;

import java.util.List;

/**
 * Created by Sabrina on 12.12.2016.
 */
public abstract class Nagetier {

    protected Wohnhoehle wohnhoehle;

    public abstract Wohnhoehle vermiete(List<Wohnhoehle> wohnhoehleList);

    public Wohnhoehle getWohnhoehle() {
        return wohnhoehle;
    }

    public void setWohnhoehle(Wohnhoehle wohnhoehle) {
        this.wohnhoehle = wohnhoehle;
    }
}
