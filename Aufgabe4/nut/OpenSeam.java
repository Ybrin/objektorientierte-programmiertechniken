package nut;

import squirrelFood.DurableSquirrelFood;
import squirrelFood.VegetarianSquirrelFood;

/**
 * Created by Aniela on 16.11.2016.
 */
public class OpenSeam extends DurableSquirrelFood implements VegetarianSquirrelFood {

    /**
     * Constructor of OpenSeam food
     *
     * @param eat_within_days The eat_within_days value
     * @param carb            The carb value
     * @param fat             The fat value
     * @param protein         The protein value
     * @param bury            Whether this food is recommended to be buried or not
     */
    public OpenSeam(int eat_within_days, double carb, double fat, double protein, boolean bury) {
        super(eat_within_days, carb, fat, protein, bury);
    }
}
