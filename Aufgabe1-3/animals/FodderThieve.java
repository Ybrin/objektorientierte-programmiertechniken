package animals;

/**
 * Created by koray on 19/10/2016.
 */
public class FodderThieve implements Animal {

    private int needed_food_for_Survival;
    private int needed_food_for_childbearing;
    Strategy strategy;

    public FodderThieve(int needed_food_for_Survival, int needed_food_for_childbearing, Strategy strategy) {
        this.needed_food_for_Survival = needed_food_for_Survival;
        this.needed_food_for_childbearing = needed_food_for_childbearing;
        this.strategy = strategy;
    }

    public int getNeeded_food_for_Survival() {
        return needed_food_for_Survival;
    }

    public int getNeeded_food_for_childbearing() {
        return needed_food_for_childbearing;
    }

    public Strategy getStrategy() {
        return strategy;
    }
}
