package versteck;

/**
 * Created by Sabrina on 04.12.2016.
 */
public abstract class Versteckabs implements Versteck{

    private int nummer;
    private double volumen;
    private Nahrungsmittel futter;

    private int anzahlNuesse = 0;
    private double gewichtSamen = 0;


    /**
     * Erzeugt ein neues Versteck
     *
     * @param nummer        Nummer des Verstecks
     * @param volumen       Volumen des Verstecks
     * @param futter        Nahrungsmittelart des Verstecks
     */
    public Versteckabs(int nummer, double volumen, Nahrungsmittel futter){
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
     * Erhoeht das gelagerte Futter
     *
     * @param d Anzahl der Nuesse oder Gewicht der Samen, die zusätzlich im Versteck gelagert werden
     */
    public void futterErhoehehn(double d){
        if(futter == Nahrungsmittel.NUESSE){
            this.anzahlNuesse += (int) d;
        } else if (futter == Nahrungsmittel.SAMEN){
            this.gewichtSamen +=  d;
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

    public double nahrungsmittelMenge(){
        return (futter == Nahrungsmittel.NUESSE ? this.anzahlNuesse : this.gewichtSamen);
    }


}
