package squirrelFood;

/**
 * Created by Aniela on 16.11.2016.
 */
public class DurableSquirrelFood implements SquirrelFood {

    private int eat_within_days;
    private double carb;
    private double fat;
    private double protein;
    private boolean bury;

    /**
     * Constructor of Durable food
     *
     * @param eat_within_days The eat_within_days value
     * @param carb            The carb value
     * @param fat             The fat value
     * @param protein         The protein value
     * @param bury            Whether this food is recommended to be buried or not
     * @autor Aniela
     */
    public DurableSquirrelFood(int eat_within_days, double carb, double fat, double protein, boolean bury) {
        this.eat_within_days = eat_within_days;
        this.carb = carb;
        this.fat = fat;
        this.protein = protein;
        this.bury = bury;
    }

    /**
     * Returns true iff it is recommended to bury this food
     *
     * @return buriable
     * @autor Aniela
     */
    public boolean toBeBuried() {
        return bury;
    }

    /**
     * days till uneatable.
     * Return value depends on <code>toBeBuried()</code>.
     * <p>
     * If toBeBuried is true, the given eat_within_days value will be doubled,
     * if not eat_within_days will be returned
     *
     * @return amount of days
     */
    @Override
    public int eatWithinDays() {
        return bury ? eat_within_days * 2 : eat_within_days;
    }

    @Override
    public double carb() {
        return carb;
    }

    @Override
    public double fat() {
        return fat;
    }

    @Override
    public double protein() {
        return protein;
    }
}
