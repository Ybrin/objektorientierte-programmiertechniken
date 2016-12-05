package versteck;

/**
 * Created by Sabrina on 05.12.2016.
 */
public interface IBaumversteck extends Versteck {

    /**
     * returnt die Hoehe des Baumverstecks
     *
     * @return Hoehe des Baumverstecks
     */
    int getHoehe();

    /**
     * returnt die Baumart, die der Baum des Verstecks hat
     *
     * @return Baumart des Verstecks
     */
    String getBaumart();
}
