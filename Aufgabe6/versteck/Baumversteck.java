package versteck;

/**
 * Created by Sabrina on 05.12.2016.
 */
public class Baumversteck extends BaseVersteck implements IBaumversteck {

    private String baumart;
    private int hoehe;

    /**
     * Erzeugt ein neues Baumversteck
     *
     * @param nummer        Nummer des Verstecks
     * @param volumen       Volumen des Verstecks
     * @param futter        Nahrungsmittelart des Verstecks
     * @param baumart       Baumart des Baumverstecks
     * @param hoehe         Hoehe des Baumverstecks
     */
    public Baumversteck(int nummer, double volumen, Nahrungsmittel futter, String baumart, int hoehe){
        super(nummer, volumen, futter);
        this.baumart = baumart;
        this.hoehe = hoehe;
    }

    public int getHoehe(){
        return this.hoehe;
    }

    public String getBaumart(){
        return this.baumart;
    }
}
