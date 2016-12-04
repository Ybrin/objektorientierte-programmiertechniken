package versteck;

/**
 * Created by Sabrina on 04.12.2016.
 */
public class Erdversteck extends Versteckabs{

    private double xKoor;
    private double yKoor;

    private Nahrungsmittel futter;

    private int anzahlNuesse;
    private double gewichtSamen;

    public Erdversteck(int nummer, double volumen, double xKoor, double yKoor, Nahrungsmittel futter){
        super(nummer, volumen);
        this.xKoor = xKoor;
        this.yKoor = yKoor;
        this.futter = futter;
    }

    public double entfernungNest(){
        return Math.sqrt(Math.pow(xKoor, 2)+Math.pow(yKoor,2));
    }

    public void change(double d){
        if(futter == Nahrungsmittel.NUESSE){
            this.anzahlNuesse+=d;
        } else if (futter == Nahrungsmittel.SAMEN){
            this.gewichtSamen+=d;
        }
    }

    public void nahrungsmittelartAendern(Nahrungsmittel futter){
        this.futter = futter;
        if(futter == Nahrungsmittel.NUESSE){
            this.gewichtSamen = 0;
        }
        else {
            this.anzahlNuesse = 0;
        }
    }

    public double getNahrungsmittel(){
        return (this.futter == Nahrungsmittel.NUESSE ? this.anzahlNuesse : this.gewichtSamen);
    }


}
