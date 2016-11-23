package squirrelFood;

/**
 * Created by Aniela on 22.11.2016.
 */
public class PerishableSquirrelFood implements SquirrelFood {

    private int eat_within_days;
    private double carb;
    private double fat;
    private double protein;

    /**
     * Constructor of Perishable food
     *
     * @param eat_within_days The eat_within_days value
     * @param carb            The carb value
     * @param fat             The fat value
     * @param protein         The protein value
     * @autor Aniela
     */
    public PerishableSquirrelFood(int eat_within_days, double carb, double fat, double protein) {
        this.eat_within_days = eat_within_days;
        this.carb = carb;
        this.fat = fat;
        this.protein = protein;
    }

    @Override
    public int eatWithinDays() {
        return eat_within_days;
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


