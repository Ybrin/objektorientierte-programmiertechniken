package animals;

import animals.Animal;
import ecosystem.Ecosystem;

/**
 * Created by Sabrina on 12.10.2016.
 */

/**
 * will be added:
 * *intelligence of the squirrel (remembers where it's food is, confuses potential fodder thieves,..)
 *
 */

public class Squirrel implements Animal {

    Ecosystem ecosystem;

    private boolean isdead;
    private boolean sex;
    private int age;
    private boolean prolific;
    private double health;
    private double deathrate;
    private int needed_food_for_Survival;
    private int needed_food_for_childbearing;
    Strategy strategyOfTheMother;
    Strategy strategy;


    public Squirrel(int needed_food_for_Survival, double health, int age, boolean sex, Strategy strategyOfTheMother) {

        this.strategyOfTheMother = strategyOfTheMother;
        this.needed_food_for_childbearing = getNeededFoodForChildbearing(this);
        this.needed_food_for_Survival = needed_food_for_Survival;
        this.health = health;
        this.age = age;
        this.sex = sex;
        this.isdead = false;

        /**
         * calculates the deathrate of a squirrel according to their strategy to survive
         */

        if(strategyOfTheMother.getStrategyToSurvive() == SurvivalStrategies.COLLECTING){
            deathrate = 0;
        } else if (strategyOfTheMother.getStrategyToSurvive() == SurvivalStrategies.TOBEFED){
            deathrate = age*(10*Math.random());
        } else if (strategyOfTheMother.getStrategyToSurvive() == SurvivalStrategies.STEALING){
            deathrate = age*(5*Math.random());
        } else if (strategyOfTheMother.getStrategyToSurvive() == SurvivalStrategies.COMBINATING){
            deathrate = age*(7*Math.random());
        }

        /**
         * calculates if a squirrel is prolific
         */
        if(this.age >= 5){
            prolific = false;
        } else{
            prolific = true;
        }
    }

    /**
     * calculates the strategy of the squirrel, under consideration of the mothers strategy
     */
    private void calculateStrategy(){
        this.strategy.setStrategyToSurvive(strategyOfTheMother.getStrategyToSurvive());
        this.strategy.getLifegoals();
    }

    /**
     * calculates the amount of food a squirrel with the life goal prolific needs
     * @param squirrel
     * @return int returns the needed food for squirrels with prolific as a life goal
     */
    private int getNeededFoodForChildbearing(Squirrel squirrel){
        int food = squirrel.getNeeded_food_for_Survival();
        if(strategy.getLifegoals().contains("prolific")){
            food += (int) (20*Math.random());
        }
        return food;
    }

    /**
     * calculates the health of the squirrel, according to inedibility of the food
     */
    private void calculateHealth(){
        if(!ecosystem.helthyFood()){
            this.health = health-(10*Math.random());
        }
        this.deathrate = deathrate - health;
        isDead();
    }


    /**
     * calculates the death rate for the squirrel after a year,
     * according to strategy, predators and fodder thieves
     */
    private void calculateDeathrate(){
        if (strategy.getStrategyToSurvive() == SurvivalStrategies.COLLECTING){

        } else if (strategy.getStrategyToSurvive() == SurvivalStrategies.TOBEFED){
            deathrate = deathrate - (10*Math.random());
        } else if (strategy.getStrategyToSurvive() == SurvivalStrategies.STEALING){
            deathrate = deathrate - (5*Math.random());
        } else if (strategy.getStrategyToSurvive() == SurvivalStrategies.COMBINATING){
            deathrate = deathrate - (7*Math.random());
        }
        int allAnimals = ecosystem.getAmountFodderThieve()+ecosystem.getAmountPreditors()+ecosystem.getAmountSquirrels();
        int predator = (allAnimals/100)*ecosystem.getAmountPreditors();
        if(predator <= 25){
            deathrate = deathrate - (2.5*Math.random());
        } else if (predator <= 50){
            deathrate = deathrate - (5*Math.random());
        } else if (predator <= 75){
            deathrate = deathrate - (7.5*Math.random());
        } else {
            deathrate = 100;
        }
        int fodderthives = (allAnimals/100)*ecosystem.getAmountFodderThieve();
        if(fodderthives <= 25){
            deathrate = deathrate - (0.5*Math.random());
        } else if (fodderthives <= 50){
            deathrate = deathrate - (2.5*Math.random());
        } else if (fodderthives <= 75){
            deathrate = deathrate - (5*Math.random());
        } else {
            deathrate = deathrate - (7.5*Math.random());
        }
        isDead();
    }

    private void isDead(){
        if(deathrate == 100){
            isdead = true;
        }
    }

    public double getHealth() {
        return health;
    }

    public double getDeathrate() {
        return deathrate;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isSex() {
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
