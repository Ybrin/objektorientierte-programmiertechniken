package main;

/**
 * Created by Sabrina on 26.11.2016.
 */
public abstract class SquirelFood implements Before<SquirelFood> {

    private final double energy;
    private final double fat;

    public SquirelFood(double energy, double fat) {
        this.energy = energy;
        this.fat = fat;
    }

    /**
     * Returns true if the energy or the fat of this object is at least 20% higher than the
     * the corresponding value of y.
     *
     * @param y The SquirelFood to test agains energy and fat
     * @return True if fat or energy in this object is at least 20% higher than the corresponding
     * value in y, false otherwise
     */
    public boolean before(SquirelFood y) {
        return this.fat >= 1.2 * y.fat || this.energy >= 1.2 * y.energy;
    }

    public double getEnergy() {
        return energy;
    }

    public double getFat() {
        return fat;
    }
}
