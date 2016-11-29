/**
 * Created by Sabrina on 26.11.2016.
 */
public abstract class SquirelFood implements Before <SquirelFood>{

    protected final double energy;
    protected final double fat;

    public SquirelFood(double energy, double fat){
        this.energy = energy;
        this.fat = fat;
    }

    /**
     * calculates if the energy or the fat of x is at least 20% higher than the energy or the fat of y
     *
     * @param  y another SquirelFood
     * @return
     */
    public boolean before(SquirelFood y){

        return this.fat >= 1.2*y.fat || this.energy >= 1.2*y.energy;

    }

}
