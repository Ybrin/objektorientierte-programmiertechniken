/**
 * Created by Sabrina on 26.11.2016.
 */
public abstract class SquirelFood { // implements Before <...>{

    protected final double energy;
    protected final double fat;

    public SquirelFood(double energy, double fat){
        this.energy = energy;
        this.fat = fat;
    }


    private boolean before(SquirelFood y){

        return this.fat >= 1.2*y.fat || this.energy >= 1.2*y.energy;

    }

}
