package population;

import calculation.Calculation;

/**
 * Created by Sabrina on 12.10.2016.
 */
public class Group {
// added parameters for fed food
    private int collectedFoodPerIndividual;
    private int huntableFoodPerIndiviual;
    private int fedFoodPerIndividual;
    private double foundFedFood;
    private double recoveredOwnFood;
    private double foundForeignFood;
    private double deathRate;
    private int groupsize;
    private Strategy strategy;

    public Group(int fedFood,double foundFedFood, int groupsize, int collectedFoodPerIndividual, int huntableFoodPerIndiviual, double recoveredOwnFood, double foundForeignFood, double deathRate) {
        this.groupsize = groupsize;
        this.collectedFoodPerIndividual = collectedFoodPerIndividual;
        this.huntableFoodPerIndiviual = huntableFoodPerIndiviual;
        this.recoveredOwnFood = recoveredOwnFood;
        this.foundForeignFood = foundForeignFood;
        this.deathRate = deathRate;
        this.fedFoodPerIndividual=fedFood;
        this.foundFedFood=foundFedFood;
        this.strategy = Calculation.getGroupStrategy(this);
    }

    public int getFedFoodPerIndividual() {
        return fedFoodPerIndividual;
    }

    public double getFoundFedFood() {
        return foundFedFood;
    }

    public Strategy getStrategy() {
        return strategy;
    }

    public int getHuntableFoodPerIndiviual() {
        return huntableFoodPerIndiviual;
    }

    public int getCollectedFoodPerIndividual() {
        return collectedFoodPerIndividual;
    }

    public double getRecoveredOwnFood() {
        return recoveredOwnFood;
    }

    public double getFoundForeignFood() {
        return foundForeignFood;
    }

    public double getDeathRate() {
        return deathRate;
    }

    public int getGroupsize() {
        return groupsize;
    }

    public void setGroupsize(int groupsize) {
        this.groupsize = groupsize;
    }
}
