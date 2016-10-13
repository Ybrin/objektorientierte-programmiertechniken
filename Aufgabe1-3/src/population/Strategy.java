package population;

/**
 * Created by Sabrina on 12.10.2016.
 */
public enum Strategy {

    STEALING,
    COLLECTING,
    COMBINATING,
    TOBEFED;

    public static Strategy strategyForGroup(Group group) {
        if (isCombinating(group)) {
            return COMBINATING;
        } else if (isStealing(group)) {
            return STEALING;
        } else if (isToBeFed(group)) {
            return TOBEFED;
        } else if (isCollecting(group)) {
            return COLLECTING;
        }

        // If they are neither of the above, they are collectors, but actually they are bad at everything
        return COLLECTING;
    }

    /**
     * Interpretation of what is meant to be a "Stealing" group.
     * It is just an interpretation, so it might not be always the perfect answer.
     *
     * @param group The group
     * @return True iff the group is stealing much of their food
     */
    public static boolean isStealing(Group group) {
        if (group.getFoundForeignFood() > 0.2) {
            return true;
        }

        return false;
    }

    /**
     * Interpretation of what is meant to be a "Collecting" group.
     * It is just an interpretation, so it might not be always the perfect answer.
     *
     * @param group The group
     * @return True iff the group is collecting much of their food
     */
    public static boolean isCollecting(Group group) {
        if (group.getCollectedFoodPerIndividual() > Squirrel.NEEDED_FOOD_FOR_SURVIVAL / 2) {
            return true;
        }

        return false;
    }

    /**
     * Interpretation of what is meant to be a "ToBeFed" group.
     * It is just an interpretation, so it might not be always the perfect answer.
     *
     * @param group The group
     * @return True iff the group is being fed much of their food
     */
    public static boolean isToBeFed(Group group) {
        if (group.getHuntableFoodPerIndiviual() > Squirrel.NEEDED_FOOD_FOR_SURVIVAL / 2) {
            return true;
        }

        return false;
    }

    /**
     * Returns true iff at least two of the three other enum values are interpreted as correct to the given group.
     *
     * @param group The group
     * @return True iff the group is combinating strategies
     */
    public static boolean isCombinating(Group group) {
        if (isStealing(group) && isCollecting(group)) {
            return true;
        } else if (isStealing(group) && isToBeFed(group)) {
            return true;
        } else if (isCollecting(group) && isToBeFed(group)) {
            return true;
        }

        return false;
    }

}
