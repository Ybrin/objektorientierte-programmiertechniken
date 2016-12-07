package eichhoernchen;

import versteck.Versteck;

/**
 * Created by Aniela on 05.12.2016.
 */
public class EichhoernchenKnoten {

    private Versteck versteck;
    private EichhoernchenKnoten nechstes;

    /**
     * Erstellt einen neuen eichhoernchen.EichhoernchenKnoten mit dem Versteck versteck
     * versteck darf nicht null sein
     *
     * @param versteck
     */
    public EichhoernchenKnoten(Versteck versteck) {
        this.versteck = versteck;
    }

    /**
     * Gibt das Verseck des aktuellen eichhoernchen.EichhoernchenKnoten aus
     *
     * @return versteck
     */
    public Versteck getVersteck() {
        return versteck;
    }

    /**
     * Gibt den eichhoernchen.EichhoernchenKnoten aus der als naechstes in der Klasse gespeichert ist
     * falls nicht festgelegt ist dieser null
     *
     * @return eichhoernchen.EichhoernchenKnoten
     */
    public EichhoernchenKnoten getNechstes() {
        return nechstes;
    }

    /**
     * Methode zum festlegen des naechsten eichhoernchen.EichhoernchenKnoten in der Klasse
     *
     * @param nechstes Das naechste Element
     */
    public void setNechstes(EichhoernchenKnoten nechstes) {
        this.nechstes = nechstes;
    }

}
