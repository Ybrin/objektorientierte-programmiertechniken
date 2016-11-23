package fruit;


import squirrelFood.VegetarianSquirrelFood;

/**
 * Created by Aniela on 16.11.2016.
 */
public interface Fruit extends VegetarianSquirrelFood {

    /**
     * Returns the first month of a year in which this
     * type of Fruit can be typically found in the nature.
     *
     * @return The month which is a value from 1 to 12 where 1 means January and 12 December
     */
    int fromMonth();

    /**
     * Returns the last month of a year in which this
     * type of Fruit can be typically found in the nature.
     *
     * @return The month which is a value from 1 to 12 where 1 means January and 12 December
     */
    int toMonth();
}
