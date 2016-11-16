package ecosystem;

import calculation.Calculation;
import simulation.Simulation;

/**
 * Created by koray on 19/10/2016.
 */
public class Ecosystem {

    private int amountOfFindableFood;

    /**
     * Konstruktor of Economy  consistinc of findablefood
     * @param amountOfFindableFood
     */
    public Ecosystem(int amountOfFindableFood) {
        this.amountOfFindableFood = amountOfFindableFood;
    }

    /**
     * getter amount of findable food
     *
     * @return amount of findable food in economie
     */
    public int getAmountOfFindableFood() {
        return amountOfFindableFood;
    }

    /**
     * setter amount of findable food
     *
     * @param amountOfFindableFood
     */
    public void setAmountOfFindableFood(int amountOfFindableFood) {
        this.amountOfFindableFood = amountOfFindableFood;
    }
}
