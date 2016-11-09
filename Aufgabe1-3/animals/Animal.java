package animals;

/**
 * Created by koray on 19/10/2016.
 */
public interface Animal {

    int getNeeded_food_for_Survival();

    int getNeeded_food_for_childbearing();

    Strategy getStrategy();

    void calculateYearPass(int collectedFood, boolean healthyFood);

    boolean isDead();

    boolean isProlific();

    Sex getSex();
}
