package animals;

import animals.Animal;
import calculation.Calculation;
import ecosystem.Ecosystem;

/**
 * Created by Sabrina on 12.10.2016.
 */

public class Squirrel implements Animal {

    private boolean dead;
    private Sex sex;
    private int age;
    private boolean prolific;
    private double deathrate;
    private int needed_food_for_Survival;
    private int needed_food_for_childbearing;
    private Strategy strategy;

    private DeathReason deathReason;

    public Squirrel(int needed_food_for_Survival, int age, Sex sex, Strategy strategyOfTheMother) {
        this.strategy = new Strategy(strategyOfTheMother.getStrategyToSurvive());

        this.needed_food_for_Survival = needed_food_for_Survival;
        this.needed_food_for_childbearing = getNeededFoodForChildbearing();
        this.age = age;
        this.sex = sex;
        this.dead = false;

        /*
         * calculates the deathrate of a squirrel according to their strategy to survive
         */

        if (strategyOfTheMother.getStrategyToSurvive() == SurvivalStrategies.COLLECTING) {
            deathrate = 0;
        } else if (strategyOfTheMother.getStrategyToSurvive() == SurvivalStrategies.TOBEFED) {
            deathrate = age * (10 * Math.random());
        } else if (strategyOfTheMother.getStrategyToSurvive() == SurvivalStrategies.STEALING) {
            deathrate = age * (5 * Math.random());
        } else if (strategyOfTheMother.getStrategyToSurvive() == SurvivalStrategies.COMBINATING) {
            deathrate = age * (7 * Math.random());
        }

        /*
         * calculates if a squirrel is prolific
         */
        prolific = this.age < 7;
    }

    /**
     * Calculates a year pass for this Squirrel
     *
     * @param collectedFood amount of collected food in a year
     * @param healthyFood if the food was healthy
     */
    public void calculateYearPass(int collectedFood, boolean healthyFood) {
        if (dead) return;

        calculateStarved(collectedFood, healthyFood);

        if (dead) return;

        calculateSenility();

        if (dead) return;

        age++;
    }

    /**
     * Set this squirrel to EATEN (by Predators) state
     */
    public void setEaten() {
        dead = true;
        deathReason = DeathReason.EATEN;
        prolific = false;
    }

    /**
     * calculates if the squirrel starved
     *
     * @param food amount of food it collected
     * @param healthy if th collected food was healthy
     */
    private void calculateStarved(int food, boolean healthy) {
        if (food < needed_food_for_Survival) {
            dead = true;
            prolific = false;
            deathReason = DeathReason.STARVED;
            return;
        }

        if (!healthy) {
            if (Math.random() < 0.01) {
                dead = true;
                prolific = false;
                deathReason = DeathReason.STARVED;
                return;
            }
        }

        prolific = food > needed_food_for_childbearing && this.age < 7;
    }

    /**
     * Calculates whether the squirrel dies because of its age or not
     */
    private void calculateSenility() {
        int rank = 0;
        if (strategy.getLifegoals().contains("many & comfortable nests")) {
            rank += 5;
        }
        if (strategy.getLifegoals().contains("prolific")) {
            rank += 1;
        }
        if (strategy.getLifegoals().contains("delimitation & expansion of territory")) {
            rank -= 2;
        }
        if (strategy.getLifegoals().contains("achievement & observance of dominance")) {
            rank -= 3;
        }

        double factor = (rank == 0) ? 0 : 1 / rank;

        int ageToDie = 9 + ((Math.random() < factor) ? (int) (3 * Math.random()) : (int) (5 * Math.random()));

        if (age >= ageToDie) {
            dead = true;
            prolific = true;
            deathReason = DeathReason.SENILITY;
        }
    }

    /**
     * Calculates the amount of food the squirrel needs to be prolific.
     *
     * @return int Needed food for the squirrel to be prolific
     */
    private int getNeededFoodForChildbearing() {
        int food = needed_food_for_Survival;
        if (strategy.getLifegoals().contains("prolific")) {
            food += (int) (5 * Math.random());
        } else {
            food += (int) (2 * Math.random());
        }
        return food;
    }

    /**
     * calculates the death rate for the squirrel after a year,
     * according to strategy, predators and fodder thieves
     *
     * @param amountFodderThieve Amount of FodderThieves
     * @param amountPredators    Amount of Predators
     * @param amountSquirrels    Amount of Squirrels
     */
    @Deprecated
    private void calculateDeathrate(int amountFodderThieve, int amountPredators, int amountSquirrels) {
        if (strategy.getStrategyToSurvive() == SurvivalStrategies.COLLECTING) {

        } else if (strategy.getStrategyToSurvive() == SurvivalStrategies.TOBEFED) {
            deathrate = deathrate + (10 * Math.random());
        } else if (strategy.getStrategyToSurvive() == SurvivalStrategies.STEALING) {
            deathrate = deathrate + (5 * Math.random());
        } else if (strategy.getStrategyToSurvive() == SurvivalStrategies.COMBINATING) {
            deathrate = deathrate + (7 * Math.random());
        }
        int allAnimals = amountFodderThieve + amountPredators + amountSquirrels;
        int predator = (allAnimals / 100) * amountPredators;
        if (predator <= 25) {
            deathrate = deathrate + (2.5 * Math.random());
        } else if (predator <= 50) {
            deathrate = deathrate + (5 * Math.random());
        } else if (predator <= 75) {
            deathReason = DeathReason.EATEN;
            deathrate = deathrate + (7.5 * Math.random());
        } else {
            deathReason = DeathReason.EATEN;
            deathrate = 100;
        }
        int fodderthives = (allAnimals / 100) * amountFodderThieve;
        if (fodderthives <= 25) {
            deathrate = deathrate - (0.5 * Math.random());
        } else if (fodderthives <= 50) {
            deathrate = deathrate - (2.5 * Math.random());
        } else if (fodderthives <= 75) {
            deathrate = deathrate - (5 * Math.random());
        } else {
            deathrate = deathrate - (7.5 * Math.random());
        }
        calculateDead();
    }

    /**
     * calculates if a squirrel is dead
     */
    @Deprecated
    private void calculateDead() {
        if (deathrate >= 100) {
            dead = true;
            prolific = false;
        }
    }

    public boolean isDead() {
        return dead;
    }

    public DeathReason getDeathReason() {
        return deathReason;
    }

    public double getDeathrate() {
        return deathrate;
    }

    public int getAge() {
        return age;
    }

    public Sex getSex() {
        return sex;
    }

    public boolean isProlific() {
        return prolific;
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
