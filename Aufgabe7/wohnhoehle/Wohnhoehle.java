package wohnhoehle;

/**
 * Created by Sabrina on 10.12.2016.
 */
public class Wohnhoehle {

    private double volumen;
    private int monatsmiete;

    public Wohnhoehle(double volumen, int monatsmiete){
        this.monatsmiete = monatsmiete;
        this.volumen = volumen;
    }

    public double getVolume(){
        return this.volumen;
    }

}
