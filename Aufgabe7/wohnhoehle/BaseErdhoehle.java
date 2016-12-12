package wohnhoehle;

import nagetiere.Nagetier;
import nagetiere.Ziesel;
import nagetiere.Zwerghamster;

/**
 * Created by Sabrina on 10.12.2016.
 */
public class BaseErdhoehle extends Wohnhoehle {

    private double durchmesser;

    public BaseErdhoehle(double volumen, int monatsmiete, double durchmesser){
        super(volumen, monatsmiete);
        this.durchmesser = durchmesser;
    }
}
