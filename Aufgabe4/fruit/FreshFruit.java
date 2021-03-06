package fruit;

import squirrelFood.PerishableSquirrelFood;

/**
 * Created by Aniela on 16.11.2016.
 */
public class FreshFruit extends PerishableSquirrelFood implements Fruit {

    private int fromMonth;
    private int toMonth;

    /**
     * Constructor of FreshFruit food
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
    public FreshFruit(int eat_within_days, double carb, double fat, double protein, int fromMonth, int toMonth) {
        super(eat_within_days, carb, fat, protein);
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

    /**
     * Returns a new instance of DryFruit which represents this FreshFruit in a dry state.
     * Which means that this fruit was dried in order to be 20 times as durable as with the
     * fresh state.
     * <p>
     * carb(), fat() and protein() value for the instance of DryFruit will stay the same as
     * they are with this FreshFruit.
     *
     * @return The dried fruit which represents this fruit in a dried state, much more durable.
     */
    public DryFruit dry() {
        return new DryFruit(eatWithinDays() * 20, carb(), fat(), protein(), fromMonth, toMonth);
    }
}
