package cone;

import nut.OpenSeam;
import squirrelFood.DurableSquirrelFood;
import squirrelFood.VegetarianSquirrelFood;

/**
 * Created by Aniela on 16.11.2016.
 */
public class Cone extends DurableSquirrelFood implements VegetarianSquirrelFood {

    private int currentSeams;

    /**
     * Constructor of Cone food
     *
     * @param eat_within_days The eat_within_days value
     * @param carb            The carb value
     * @param fat             The fat value
     * @param protein         The protein value
     * @autor Aniela
     */
    public Cone(int eat_within_days, double carb, double fat, double protein, int initialSeams) {
        super(eat_within_days, carb, fat, protein, false);
        this.currentSeams = initialSeams;
    }

    /**
     * Returns the current amount of seams inside this cone.
     *
     * @return The current amount of seams inside this instance of cone.
     */
    public int seams() {
        return currentSeams;
    }

    /**
     * Returns a new instance of OpenSeam which represents a seam taken from this cone,
     * or null if there are no seams left inside this cone.
     * <p>
     * The new instance of OpenSeam will have the <code>bury</code> value 'true', or
     * they will be recommended to be buried to increase durability.
     *
     * @return The new instance of OpenSeam which represents one seam of this cone, or null if there are no cones left
     */
    public OpenSeam crack() {
        if (currentSeams > 0) {
            currentSeams--;
            return new OpenSeam(eatWithinDays(), carb(), fat(), protein(), true);
        } else {
            return null;
        }
    }
}
