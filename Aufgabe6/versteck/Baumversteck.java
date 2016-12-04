package versteck;

/**
 * Created by Sabrina on 04.12.2016.
 */
public class Baumversteck extends Versteckabs{

    private String baumart;
    private int hoehe;

    public Baumversteck(int nummer, double volumen, String baumart, int hoehe){
        super(nummer, volumen);
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
