package wohnhoehle;

/**
 * Created by Sabrina on 10.12.2016.
 */
public class ErdhoehleKlein extends BaseErdhoehle {

    public ErdhoehleKlein(double volumen, int monatsmiete, double durchmesser){
        super(volumen, monatsmiete, durchmesser);
    }

    public boolean canHostZwerghamster() {
        return true;
    }
}
