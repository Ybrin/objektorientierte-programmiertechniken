package versteck;

/**
 * Created by Sabrina on 05.12.2016.
 */
public abstract class BaseVersteck implements Versteck {
    protected int nummer;
    protected double volumen;
    protected Nahrungsmittel futter;

    protected int anzahlNuesse = 0;
    protected double gewichtSamen = 0;

    /**
     * Erzeugt ein neues Versteck
     *
     * @param nummer        Nummer des Verstecks
     * @param volumen       Volumen des Verstecks
     * @param futter        Nahrungsmittelart des Verstecks
     */
    public BaseVersteck(int nummer, double volumen, Nahrungsmittel futter){
        this.nummer = nummer;
        this.volumen = volumen;
        this.futter = futter;
    }

    public int nummer(){
        return this.nummer;
    }

    public double volumen(){
        return this.volumen;
    }

    public Nahrungsmittel futter() {
        return this.futter;
    }


    /**
     * verringert die Futtermenge im Versteck um die Anzahl menge
     * @param menge hoehe der ab zu ziehenden Futter menge
     */
    public void futterVerringern(double menge){
        if (futter == Nahrungsmittel.SAMEN){
            this.gewichtSamen -=  menge;
        } else if (futter == Nahrungsmittel.NUESSE) {
            this.anzahlNuesse -= (int) menge;
        }
    }

    /**
     * Erhoeht das gelagerte Futter
     *
     * @param d Anzahl der Nuesse oder Gewicht der Samen, die zusätzlich im Versteck gelagert werden
     */
    public void futterErhoehehn(double d){
        if (futter == Nahrungsmittel.SAMEN){
            this.gewichtSamen +=  d;
        } else if (futter == Nahrungsmittel.NUESSE) {
            this.anzahlNuesse += (int) d;
        }
    }

    /**
     * Aendert die Nahrungsmittelart, die im Versteck gelagert wird
     *
     * @param futter Nahrungsmittelart, die ab jetzt im Versteck gelagert wird
     */
    public void nahrungsmittelartAendern(Nahrungsmittel futter){
        this.futter = futter;
        if(futter == Nahrungsmittel.NUESSE){
            this.gewichtSamen = 0;
        }
        else if (futter == Nahrungsmittel.SAMEN){
            this.anzahlNuesse = 0;
        }
    }

    /**
     * returnt die Anzahl der Nuesse oder das Gewicht der Samen
     *
     * @return Anzahl der Nuesse oder Gewicht der Samen
     */
    public double nahrungsmittelMenge(){
        return (futter == Nahrungsmittel.NUESSE ? this.anzahlNuesse : this.gewichtSamen);
    }
}
