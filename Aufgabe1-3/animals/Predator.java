package animals;

/**
 * Created by koray on 19/10/2016.
 */
public class Predator implements Animal {

    private int needed_food_for_Survival;
    private int needed_food_for_childbearing;
    private Strategy strategy;
    private boolean dead = false;
    private boolean prolific = false;
    private Sex sex;


    public Predator(int needed_food_for_Survival, int needed_food_for_childbearing, Strategy strategy, Sex sex) {
        this.needed_food_for_Survival = needed_food_for_Survival;
        this.needed_food_for_childbearing = needed_food_for_childbearing;
        this.strategy = strategy;
        this.sex = sex;
    }

    /**
     * calculates if the predator survives a year
     *
     * @param collectedFood how much food the predator has collected in a year
     * @param healthyFood if the food was healthy
     */
    public void calculateYearPass(int collectedFood, boolean healthyFood) {
        if (dead) return;

        if (!(collectedFood > needed_food_for_Survival)) {
            dead = true;
            prolific = false;
            return;
        }

        prolific = collectedFood > needed_food_for_childbearing;
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

    public boolean isDead() {
        return dead;
    }

    public boolean isProlific() {
        return prolific;
    }

    public Sex getSex() {
        return sex;
    }
}
