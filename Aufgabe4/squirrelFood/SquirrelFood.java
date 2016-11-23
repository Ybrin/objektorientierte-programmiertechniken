package squirrelFood;

/**
 * Created by Aniela on 16.11.2016.
 */
public interface SquirrelFood {
    /**
     * days till uneatable
     *
     * @return amount of days
     * @autor Aniela
     */
    int eatWithinDays();

    /**
     * carb part in food
     *
     * @return carb
     * @autor Aniela
     */
    double carb();

    /**
     * fat part in food
     *
     * @return fat
     * @autor Aniela
     */
    double fat();

    /**
     * protein part in food
     *
     * @return protein
     * @autor Aniela
     */
    double protein();
}
