package wohnhoehle;

/**
 * Created by Sabrina on 10.12.2016.
 */
public class BaseBaumhoehle extends Wohnhoehle {

    private int hoehe;

    public BaseBaumhoehle(double volumen, int monatsmiete, int hoehe){
        super(volumen, monatsmiete);
        this.hoehe = hoehe;
    }
}
