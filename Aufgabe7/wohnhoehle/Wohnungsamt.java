package wohnhoehle;

import nagetiere.Kolonie;
import nagetiere.Nagetier;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sabrina on 12.12.2016.
 */
public class Wohnungsamt {

    private List<Kolonie> kolonien;

    private List<Wohnhoehle> wohnhoehlen = new ArrayList<Wohnhoehle>();

    /**
     * gliedert eine freie Wohnhoehle in den Bestand des Wohnungsamts ein
     * @param wohnhoehle eine neue Wohnhoehle
     */
    public void frei(Wohnhoehle wohnhoehle){

        wohnhoehlen.add(wohnhoehle);
    }

    public void gesamtvolumen(){
        double gesvolumen = 0;
        for(int i = 0 ; i < wohnhoehlen.size(); i++){
            gesvolumen += wohnhoehlen.get(i).getVolume();
        }
        System.out.println("Gesamtvolumen: " + gesvolumen);
    }

}
