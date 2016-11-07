package ecosystem;

import calculation.Calculation;
import simulation.Simulation;

/**
 * Created by koray on 19/10/2016.
 */
public class Ecosystem {

    private int amountOfFindableFood;

    public Ecosystem(int amountOfFindableFood) {
        this.amountOfFindableFood = amountOfFindableFood;
    }

    public int getAmountOfFindableFood() {
        return amountOfFindableFood;
    }

    public void setAmountOfFindableFood(int amountOfFindableFood) {
        this.amountOfFindableFood = amountOfFindableFood;
    }
}
