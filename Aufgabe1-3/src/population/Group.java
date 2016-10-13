package population;

import calculation.Calculation;

/**
 * Created by Sabrina on 12.10.2016.
 */
public class Group {

    private int collectedFoodPerIndividual;
    private int huntableFoodPerIndiviual;
    private double recoveredOwnFood;
    private double foundForeignFood;
    private double deathRate;
    private int groupsize;
    private Strategy strategy;

    private Population population;

    public Group(int groupsize, int collectedFoodPerIndividual, int huntableFoodPerIndiviual, double recoveredOwnFood, double foundForeignFood, double deathRate) {
        this.groupsize = groupsize;
        this.collectedFoodPerIndividual = collectedFoodPerIndividual;
        this.huntableFoodPerIndiviual = huntableFoodPerIndiviual;
        this.recoveredOwnFood = recoveredOwnFood;
        this.foundForeignFood = foundForeignFood;
        this.deathRate = deathRate;
        this.strategy = Calculation.getGroupStrategy(this);
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

    public Population getPopulation() {
        return population;
    }

    public void setPopulation(Population population) {
        this.population = population;
    }
}
