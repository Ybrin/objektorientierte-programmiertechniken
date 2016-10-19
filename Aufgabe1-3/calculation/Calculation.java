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
     * returns strategy of given group
     *
     * @param group group of squirrels
     * @return Strategy strategy of group of squirrels
     */
    public static Strategy getGroupStrategy(Group group) {
        return Strategy.strategyForGroup(group);
    }

    /**
     * calculates new size of the group after one year
     *
     * @param group group of squirrels
     * @return int new size of group of squirrel
     */
    public static int calculateGroupsizeAfterAYear(Group group) {
        int size = group.getGroupsize();

        if (size == 0) {
            return 0;
        }

        int surviving = group.getGroupsize() - (int) (group.getGroupsize() * group.getDeathRate());

        int food = Calculation.getTotalAmountOfFoodPerGroup(group);
        int foodPerSquirrel = food / group.getGroupsize();
        if (foodPerSquirrel > Squirrel.NEEDED_FOOD_FOR_SURVIVAL) {
            int foodLeft = ((Calculation.getTotalAmountOfFoodPerGroup(group) / group.getGroupsize()) - Squirrel.NEEDED_FOOD_FOR_SURVIVAL) * group.getGroupsize();
            int foodNeededPerSquirrel = Squirrel.NEEDED_FOOD_FOR_CHILDBEARING - Squirrel.NEEDED_FOOD_FOR_SURVIVAL;

            int matured = foodLeft / foodNeededPerSquirrel;

            // Just couples can have children
            matured = (matured % 2 == 0) ? matured : matured - 1;

            surviving += matured * Squirrel.APPROXIMATE_CHILDBIRTH;
        } else {
            surviving = food / Squirrel.NEEDED_FOOD_FOR_SURVIVAL;
        }

        return (surviving >= 0) ? surviving : 0;
    }


    /**
     * returns the total number of food collected by all groups
     *
     * @param population total simulation of squirrels
     * @return int total number of food collected by all groups
     */
    public static int getTotalAmountOfFood(Population population) {
        int totalAmount = 0;
        for (Group group : population.getGroups()) {
            totalAmount += group.getCollectedFoodPerIndividual() * group.getGroupsize();
            // totalAmount += group.getHuntableFoodPerIndiviual() * group.getGroupsize();
        }
        return totalAmount;
    }


    /**
     * returns the total amount of food for given group
     *
     * @param group group of squirrels
     * @return int total number of food for given group
     */
    public static int getTotalAmountOfFoodPerGroup(Group group) {
        int totalAmount = 0;
        totalAmount += (int) ((group.getCollectedFoodPerIndividual() * group.getGroupsize()) * group.getRecoveredOwnFood());
        totalAmount += group.getHuntableFoodPerIndiviual() * group.getGroupsize();

        // totalAmount += (int) (Calculation.getTotalAmountOfFood(group.getPopulation()) * group.getFoundForeignFood());
        // Calculate foreign food as relative amount of food which the others lost
        int foreign = 0;
        for (Group g : group.getPopulation().getGroups()) {
            foreign += (int) ((g.getCollectedFoodPerIndividual() * g.getGroupsize()) * (1 - g.getRecoveredOwnFood()));
        }
        foreign = foreign - (int) ((group.getCollectedFoodPerIndividual() * group.getGroupsize()) * (1 - group.getRecoveredOwnFood()));

        foreign = (int) (foreign * group.getFoundForeignFood());

        totalAmount += foreign;

        return totalAmount;
    }


}
