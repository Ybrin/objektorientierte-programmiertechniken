/**
 * Created by Sabrina on 26.11.2016.
 */
public class Fruit extends SquirelFood {

    private int durability;

    public Fruit (double energy, double fat, int durability){
        super(energy, fat);
        this.durability = durability;
    }

}
