package versteck;

/**
 * Created by Sabrina on 05.12.2016.
 */
public interface Versteck {
    /**
     * returnt die Nummer des Verstecks
     * @return Nummer des Verstecks
     */
    public int nummer();

    /**
     * returnt das Volumen des Verstecks
     * @return Volumen des Verstecks
     */
    public double volumen();

    /**
     * returnt die Art des Nahrungsmittels
     * @return Nahrungsmittelart, die im Versteck gelagert wird
     */
    public Nahrungsmittel futter();

    /**
     * ändert die Nahrungsmittelart, die im Versteck gelagert wird
     * Alte Informationen gehen verloren
     * @param futter Nahrungsmittelart, die ab jetzt im Versteck gelagert wird, ungleich null
     */
    public void nahrungsmittelartAendern(Nahrungsmittel futter);

    /**
     * erhoeht das Gewicht der im Versteck gelagerten Samen oder die Anzahl der im Versteck gelagerten Nuesse
     * Wenn das Nahrungsmittel Nuesse ist erwartet diese Methode als Parameter eine ganze Zahl um die Anzahl an
     * Nuessen zu erhöhen. Wenn es Samen sind, erwartet die Methode eine Zahl die das Gewicht der Samen, um die
     * der derzeitige Stand erhöht werden soll beschreibt (beliebig genau).
     * @param d Anzahl der Nuesse oder Gewicht der Samen, die zusätzlich im Versteck gelagert werden
     */
    public void futterErhoehehn(double d);

    /**
     * returnt die Nahrungsmittelmenge, die sich im Versteck befindet
     * @return Nahrungsmittelmenge, die sich im Versteck befindet
     */
    public double nahrungsmittelMenge();

    /**
     * verringert die Futtermenge im Versteck um die Anzahl menge
     * @param menge hoehe der ab zu ziehenden Futter menge
     */
    public void futterVerringern(double menge);

    /**
     * returnt die Entfernung zum Nest des Eichhoernchens
     *
     * @return Entfernung zum Nest
     */
    public double entfernungNest();
}
