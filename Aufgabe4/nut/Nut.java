package nut;

import squirrelFood.DurableSquirrelFood;
import squirrelFood.VegetarianSquirrelFood;

/**
 * Created by Aniela on 16.11.2016.
 */
public class Nut extends DurableSquirrelFood implements VegetarianSquirrelFood {

    /**
     * Constructor of Nut food
     *
     * @param eat_within_days The eat_within_days value
     * @param carb            The carb value
     * @param fat             The fat value
     * @param protein         The protein value
     */
    public Nut(int eat_within_days, double carb, double fat, double protein) {
        super(eat_within_days, carb, fat, protein, true);
    }

    /**
     * Returns the cracked state of this Nut, which is an OpenSeam with the same
     * carb(), fat() and protein() values but a durability which was halved.
     * <p>
     * buryable should represent whether the resulting OpenSeam is recommended to be
     * buried or not.
     *
     * @param buryable Whether or not it is recommended to bury the resulting OpenSeam
     * @return The new instance of OpenSeam which represents this Nut in a cracked state.
     */
    public OpenSeam crack(boolean buryable) {
        return new OpenSeam(eatWithinDays() / 2, carb(), fat(), protein(), buryable);
    }
}
