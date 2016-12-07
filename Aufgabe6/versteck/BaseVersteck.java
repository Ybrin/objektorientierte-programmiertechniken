package versteck;

/**
 * Created by Sabrina on 05.12.2016.
 */
public abstract class BaseVersteck implements Versteck {

    private int nummer;
    private double volumen;
    private Nahrungsmittel futter;

    private int anzahlNuesse = 0;
    private double gewichtSamen = 0;

    private double xKoor;
    private double yKoor;

    /**
     * Erzeugt ein neues Versteck
     *
     * @param nummer  Nummer des Verstecks
     * @param volumen Volumen des Verstecks
     * @param futter  Nahrungsmittelart des Verstecks
     * @param xKoor   x-Koordinate relativ zum Nest gesehen
     * @param yKoor   y-Koordinate relativ zum Nest gesehen
     */
    public BaseVersteck(int nummer, double volumen, Nahrungsmittel futter, double xKoor, double yKoor) {
        this.nummer = nummer;
        this.volumen = volumen;
        this.futter = futter;

        this.xKoor = xKoor;
        this.yKoor = yKoor;
    }

    public int nummer() {
        return this.nummer;
    }

    public double volumen() {
        return this.volumen;
    }

    public Nahrungsmittel futter() {
        return this.futter;
    }

    public double entfernungNest(){
        return Math.sqrt(Math.pow(xKoor, 2)+Math.pow(yKoor,2));
    }


    /**
     * verringert die Futtermenge im Versteck um die Anzahl menge
     *
     * @param menge hoehe der ab zu ziehenden Futter menge
     */
    public void futterVerringern(double menge) {
        if (futter == Nahrungsmittel.SAMEN) {
            this.gewichtSamen -= menge;
        } else if (futter == Nahrungsmittel.NUESSE) {
            this.anzahlNuesse -= (int) menge;
        }
    }

    /**
     * Erhoeht das gelagerte Futter
     *
     * @param d Anzahl der Nuesse oder Gewicht der Samen, die zusätzlich im Versteck gelagert werden
     */
    public void futterErhoehehn(double d) {
        if (futter == Nahrungsmittel.SAMEN) {
            this.gewichtSamen += d;
        } else if (futter == Nahrungsmittel.NUESSE) {
            this.anzahlNuesse += (int) d;
        }
    }

    /**
     * Aendert die Nahrungsmittelart, die im Versteck gelagert wird
     *
     * Alte Informationen gehen verloren
     *
     * Macht nichts wenn bereits diese Nahrungsmittelart gesetzt ist
     *
     * @param futter Nahrungsmittelart, die ab jetzt im Versteck gelagert wird
     */
    public void nahrungsmittelartAendern(Nahrungsmittel futter) {
        if (futter == this.futter) return;

        this.futter = futter;
        if (futter == Nahrungsmittel.NUESSE) {
            this.gewichtSamen = 0;
        } else if (futter == Nahrungsmittel.SAMEN) {
            this.anzahlNuesse = 0;
        }
    }

    /**
     * returnt die Anzahl der Nuesse oder das Gewicht der Samen
     *
     * @return Anzahl der Nuesse oder Gewicht der Samen
     */
    public double nahrungsmittelMenge() {
        switch (futter) {
            case NUESSE:
                return anzahlNuesse;
            case SAMEN:
                return gewichtSamen;
        }

        return 0;
    }
}
