package versteck;

/**
 * Created by Sabrina on 04.12.2016.
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
     * @param futter Nahrungsmittelart, die ab jetzt im Versteck gelagert wird
     */
    public void nahrungsmittelartAendern(Nahrungsmittel futter);

    /**
     * erhoeht das Gewicht der im Varsteck gelagerten Samen oder die Anzahl der im Versteck gelagerten Nuesse
     * @param d Anzahl der Nuesse oder Gewicht der Samen, die zusätzlich im Versteck gelagert werden
     */
    public void futterErhoehehn(double d);

    /**
     * returnt die Nahrungsmittelmenge, die sich im Versteck befindet
     * @return Nahrungsmittelmenge, die sich im Versteck befindet
     */
    public double nahrungsmittelMenge();

    /**
     * returnt die Hoehe des Baumverstecks
     * @return Hoehe des Baumverstecks
     */
    public int getHoehe();

    /**
     * returnt den Namen der Baumart die fuer das Baumversteck genutzt wird
     * @return Name der Baumart
     */
    public String getBaumart();

    /**
     * returnt die Entfernung des Verstecks zum Nest
     * @return Entfernung zum Nest
     */
    public double entfernungNest();
}
