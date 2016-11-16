package calculation;

/**
 * Created by Sabrina on 12.10.2016.
 */
public class Calculation {

    /**
     * Calculate a randomised first calculation of Preditors
     * if it is inhabited
     *the amount of Preditors normaly is (but does not have to be ) les than in unhabitat ariers
     *
     *@param amountSquirrels current amount of squirrels
     * @param isInhabitedByHumans if true it is inhabited by humans
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
     * Try to calculate a randomised first calculation of fodder thieves
     *as in calculateAmountOfPredators the amount of fodder thiefs depends on the inhabitents of humans
     * in this case there thend to be more whene the arier is inhabited and les when not
     *
     * @param amountSquirrels amount of current squirrels
     * @param isInhabitedByHumans if humans live in an certan arrier
     * @return amount fodder thievs
     */
    public static int calculateAmountOfFodderThieves(int amountSquirrels, boolean isInhabitedByHumans) {
        int amountFodderThieve;
        if (isInhabitedByHumans) {
            amountFodderThieve = (int) (amountSquirrels * (Math.random() * 0.7));
        } else {
            amountFodderThieve = (int) (amountSquirrels * (Math.random()) * 0.5);
        }

        return amountFodderThieve;
    }


    /**
     * calculates the amount of new Trees, use radomisation
     * seperats between inhabited places (human) and not inhabited
     * only one out of 1000 grows a tree
     *
     * @param amountOfTrees ERROR: not needed, calculation it is needed, is to find in Simulation
     * @param isInhabitedByHumans inhabited of humans or not
     * @param amountOfLeftFood food left
     *
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
     *
     * @param amountHumans amount of humans living in the arier
     * @param amountOfnewTrees amount of new trees (trees that started growing this year)
     * @param amountTrees amount of already existing trees
     * @return amount of findable food in the area
     */
    public static int getNewAmountOfFindableFood(int amountTrees, int amountOfnewTrees, int amountHumans) {
        return amountTrees * 100 + amountOfnewTrees * 20 + amountHumans * 50;
    }

    /**
     * Probability depends on inhabited by humans or not
     *
     * if an arier is inhabited by humans, the food is more likly to be unhalthy
     *
     * @param isInhabitedByHumans if humans life in a cerrten arier
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
