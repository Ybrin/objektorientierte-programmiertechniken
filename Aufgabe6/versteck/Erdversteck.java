package versteck;

/**
 * Created by Sabrina on 04.12.2016.
 */
public class Erdversteck extends BaseVersteck implements IErdversteck {

    /**
     * Erzeugt ein neues Erdversteck
     *
     * @param nummer        Nummer des Verstecks
     * @param volumen       Volumen des Verstecks
     * @param futter        Nahrungsmittelart des Verstecks
     * @param xKoor         x-Koordinate relativ zum Nest gesehen
     * @param yKoor         y-Koordinate relativ zum Nest gesehen
     */
    public Erdversteck(int nummer, double volumen, Nahrungsmittel futter, double xKoor, double yKoor){
        super(nummer, volumen, futter, xKoor, yKoor);
    }
}
