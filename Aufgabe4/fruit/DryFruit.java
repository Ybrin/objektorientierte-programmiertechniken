package fruit;

import squirrelFood.DurableSquirrelFood;

/**
 * Created by Aniela on 16.11.2016.
 */

public class DryFruit extends DurableSquirrelFood implements Fruit {

    private int fromMonth;
    private int toMonth;

    /**
     * Constructor of DryFruit food
     *
     * @param eat_within_days The eat_within_days value
     * @param carb            The carb value
     * @param fat             The fat value
     * @param protein         The protein value
     * @param fromMonth       The first month in which this food can be typically found.
     *                        This MUST be a value from 1 to 12 where
     *                        1 means January and 12 December
     * @param toMonth         The last month in which this food can be typically found.
     *                        This MUST be a value from 1 to 12 where
     *                        1 means January and 12 December
     */
    public DryFruit(int eat_within_days, double carb, double fat, double protein, int fromMonth, int toMonth) {
        super(eat_within_days, carb, fat, protein, false);
        this.fromMonth = fromMonth;
        this.toMonth = toMonth;
    }

    @Override
    public int fromMonth() {
        return fromMonth;
    }

    @Override
    public int toMonth() {
        return toMonth;
    }
}
