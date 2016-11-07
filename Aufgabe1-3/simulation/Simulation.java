package simulation;

import calculation.Calculation;
import ecosystem.Ecosystem;

/**
 * Created by koray on 19/10/2016.
 */
public class Simulation {

    //used to find amount of available food
    private int amountHumans;

    private int amountSquirrels;
    private int amountPredators;
    private int amountTrees;

    private Ecosystem ecosystem;

    private boolean InhabitedByHumans;
    /**
     * Initializes a new Simulation which calculates new years and the resulting amount of squirrels
     * @param initialSquirrels The initial amount of squirrels
     * @param initialPredators The initial amount of predators
     * @param initialTrees The initial amount of trees
     */
    public Simulation(int initialSquirrels, int initialPredators, int initialTrees, int amountHumans, boolean isInhabitedByHumans) {
        this.amountSquirrels = initialSquirrels;
        this.amountPredators = initialPredators;
        this.amountTrees = initialTrees;

        this.amountHumans = amountHumans;
        this.InhabitedByHumans=isInhabitedByHumans;
        this.ecosystem = new Ecosystem(Calculation.getNewAmoutOfFindableFood(amountTrees, 0, amountHumans, isInhabitedByHumans));

    }

    // TODO Implement this
    public void calculateNewYear() {

    }


    // Getters

    public int getAmountHumans() {
        return amountHumans;
    }

    public int getAmountSquirrels() {
        return amountSquirrels;
    }

    public int getAmountPredators() {
        return amountPredators;
    }

    public int getAmountTrees() {
        return amountTrees;
    }
}
