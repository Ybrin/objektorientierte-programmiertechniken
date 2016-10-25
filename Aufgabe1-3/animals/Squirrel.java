package animals;

import animals.Animal;

/**
 * Created by Sabrina on 12.10.2016.
 */

/**
 * will be added: 
 * *how edible food is according to the habitat of the squirrel
 * *death rate according to the habitat, predators and fodder thieves
 * *intelligence of the squirrel (remembers where it's food is, confuses potential fodder thieves,..)
 *
 */

public class Squirrel implements Animal {

    private boolean sex;
    private int age;
    private boolean prolific;
    private double health;
    private double deathrate;
    private int needed_food_for_Survival;
    private int needed_food_for_childbearing;
    Strategy strategyOfTheMother;
    Strategy strategy;
    //habitat

    public Squirrel(int needed_food_for_Survival, double health, int age, boolean sex, Strategy strategyOfTheMother) {

        this.strategyOfTheMother = strategyOfTheMother;
        this.needed_food_for_childbearing = getNeededFoodForChildbearing(this);
        this.needed_food_for_Survival = needed_food_for_Survival;
        this.health = health;
        this.age = age;
        this.sex = sex;

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
     * @param good how eatable a food is (will be changed according to the habitat)
     */
    private void calculateHealth(boolean good){
        if(!good){
            this.health = health-(10*Math.random());
        }
        calculateDeathrate();
    }

    private void calculateDeathrate(){
        this.deathrate = 100 - health;
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
