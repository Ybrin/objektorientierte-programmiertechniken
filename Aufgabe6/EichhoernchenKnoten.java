import versteck.Versteck;

/**
 * Created by Aniela on 05.12.2016.
 */
public class EichhoernchenKnoten {

    private Versteck versteck;
    private EichhoernchenKnoten nechstes;

    /**
     * Erstellt einen neuen EichhoernchenKnoten mit dem Versteck versteck
     * versteck darf nicht null sein
     *
     * @param versteck
     */
    public EichhoernchenKnoten(Versteck versteck) {
        this.versteck = versteck;
    }

    /**
     * Gibt das Verseck des aktuellen EichhoernchenKnoten aus
     *
     * @return versteck
     */
    public Versteck getVersteck() {
        return versteck;
    }

    /**
     * Gibt den EichhoernchenKnoten aus der als naechstes in der Klasse gespeichert ist
     * falls nicht festgelegt ist dieser null
     *
     * @return EichhoernchenKnoten
     */
    public EichhoernchenKnoten getNechstes() {
        return nechstes;
    }

    /**
     * Methode zum festlegen des naechsten EichhoernchenKnoten in der Klasse
     *
     * @param nechstes
     */
    public void setNechstes(EichhoernchenKnoten nechstes) {
        this.nechstes = nechstes;
    }

}
