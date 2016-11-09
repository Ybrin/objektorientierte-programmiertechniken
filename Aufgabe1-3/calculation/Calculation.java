package calculation;

/**
 * Created by Sabrina on 12.10.2016.
 */
public class Calculation {

    /**
     * Calculate a randomised first calculation
     *
     * @return amount predators
     */
    @Deprecated
    private static int calculateAmountOfPredators(int amountSquirrels, boolean isInhabitedByHumans) {
        int amountPredators;
        if (isInhabitedByHumans) {
            amountPredators = (int) (amountSquirrels * (Math.random() * 0.3));
        } else {
            amountPredators = (int) (amountSquirrels * (Math.random() * 0.7));
        }

        return amountPredators;
    }

    /**
     * calculates the new amount of Trees
     * seperats between inhabited places (human) and not inhabited
     *
     * @param amountOfLeftFood food left
     * @return New amount of trees
     */
    public static int getNewAmountOfTrees(int amountOfTrees, int amountOfLeftFood, boolean isInhabitedByHumans) {
        int amountOfnewTrees = amountOfLeftFood / 1000;

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
    public static int getNewAmountOfFindableFood(int amountTrees, int amountOfnewTrees, int amountHumans) {
        return amountTrees * 100 + amountOfnewTrees * 20 + amountHumans * 50;
    }

    /**
     * Probability depends on inhabited by humans or not
     *
     * @return if the food is healthy or not
     */
    public static boolean healthyFood(boolean isInhabitedByHumans) {
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
