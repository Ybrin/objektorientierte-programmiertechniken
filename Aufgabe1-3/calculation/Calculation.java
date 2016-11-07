package calculation;

import simulation.Group;
import simulation.Population;
import animals.Squirrel;
import animals.Strategy;

/**
 * Created by Sabrina on 12.10.2016.
 */
public class Calculation {

    /**
     * Try to calculate a randomised first calculation
     *
     * @return amount predators
     */
    private static int calculateAmoutOfPredators(int amountSquirrels, boolean isInhabitedByHumans) {
        int amountPredators;
        if (isInhabitedByHumans) {
            amountPredators = (int) (amountSquirrels * (Math.random() * 0.3));
        } else {
            amountPredators = (int) (amountSquirrels * (Math.random() * 0.7));
        }

        return amountPredators;
    }

    /**
     * Try to calculate a randomised first calculation
     *
     * @return amount fodder thievs
     */
    private static int calculateAmountOfFodderThieve(int amountSquirrels, boolean isInhabitedByHumans) {
        int amountFodderThieve;
        if (isInhabitedByHumans) {
            amountFodderThieve = (int) (amountSquirrels * (Math.random() * 0.7));
        } else {
            amountFodderThieve = (int) (amountSquirrels * (Math.random()) * 0.5);
        }

        return amountFodderThieve;
    }


    /**
     * calculates the new amount of Trees
     * seperats between inhabited places (human) and not inhabited
     *
     * @param amountOfLeftFood food left
     * @return New amount of trees
     */
    public static int getNewAmountOfTrees(int amountOfTrees, int amountOfLeftFood, boolean isInhabitedByHumans) {
        int amountOfnewTrees;
        if (amountOfLeftFood != 0) {
            amountOfnewTrees = amountOfLeftFood / 2;
        } else {
            amountOfnewTrees = 0;
        }
        if (isInhabitedByHumans) {
            amountOfnewTrees = amountOfnewTrees - (int) (amountOfnewTrees * (Math.random() * (0.8)));
        } else {
            amountOfnewTrees = amountOfnewTrees - (int) (amountOfnewTrees * (Math.random() * (0.2)));
        }

        return amountOfnewTrees;
    }

    /**
     * calculates the findable food resources (including findable food from human)
     *
     * @return amount of findable food in the area
     */
    public static int getNewAmoutOfFindableFood(int amountTrees, int amountOfnewTrees, int amountHumans, boolean isInhabitedByHumans) {
        int amountOfFindableFood;
        amountOfFindableFood = (amountTrees - amountOfnewTrees) * 10;

        return amountOfFindableFood;
    }

    /**
     * Probability depends on inhabited by humans or not
     *
     * @return if the food is healthy or not
     */
    public boolean healthyFood(boolean isInhabitedByHumans) {
        boolean health = true;
        if (isInhabitedByHumans) {
            if (Math.random() * 1 > 0.6) {
                health = false;
            }
        } else {
            if ((Math.random() * 1) > 0.8) {
                health = false;
            }
        }
        return health;
    }

}
