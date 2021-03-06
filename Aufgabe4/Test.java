import cone.Cone;
import fruit.DryFruit;
import fruit.FreshFruit;
import fruit.Fruit;
import nut.Nut;
import squirrelFood.DurableSquirrelFood;
import squirrelFood.VegetarianSquirrelFood;
import squirrelFood.PerishableSquirrelFood;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sabrina on 22.11.2016.
 */



    /*
    * ******* AUFGABE 4 *******
    *
    * Arbeitsaufteilung:    Sabrina: fruit Package
    *                       Aniela: squirrelFood Package
    *                       Koray: nut + cone packages + überarbeiten der Test Klasse
    *
    *  ******* AUFGABE 4 *******
     */

    /*
    * ******* SquirrelFood *******
    * SquirrelFood can't be a subtype of any other types because it is the supertype
    * of every single other type implemented in this assignment.
    *
     */

    /*
    * ******* VegetarianSquirrelFood *******
    *
    * We don't have much details about this type but what we know is that
    * VegetarianSquirrelFood is food which is vegetarian and which is eaten
    * by squirrels because non-vegetarian food may not be durable enough.
    * We don't know whether vegetarian food is always durable or not, which
    * means that we can't tag it to 'durable' or 'perishable'.
    * But VegetarianSquirrelFood is by all means a SquirrelFood because each
    * elements are equal in both types.
    *
     */

    /*
    * ******* PerishableSquirrelFood / DurableSquirrelFood *******
    * PerishableSquirrelFood is not a DurableSquirrelFood because it does not need a bury value and
    * eatWithinDays() is not dependent upon another value (bury)
    * ----> DurableSquirrelFood is also not a PerishableSquirrelFood because of same reason.
    *
    * PerishableSquirrelFood and DurableSquirrelFood are also not a main.Fruit because a main.Fruit has the
    * fromMonth() and toMonth() values which represent when these types of food can be found.
    * The types PerishableSquirrelFood and DurableSquirrelFood don't need these values so they
    * can't be a subclass of main.Fruit.
    *
    * PerishableSquirrelFood and DurableSquirrelFood are also not a Cone because a Cone has the method
    * seams which returns the number of seams within this cone which is not required (and would be very wrong)
    * for PerishableSquirrelFood and DurableSquirrelFood
    *
     */

    /*
    * ******* main.Nut / main.Fruit / Cone *******
    * Nuts are not Fruits because Fruits have the values fromMonth() and toMonth() which
    * are not needed by Nuts and would be wrong. So main.Nut is not a subtype of main.Fruit.
    *
    * main.Nut is also not a subtype of PerishableSquirrelFood because eatWithinDays() within
    * PerishableSquirrelFood is not dependent upon the value bury, which Fruits depend upon due to
    * the fact that they are subtypes of DurableSquirrelFood
    *
    * main.Fruit is not a main.Nut for the same exact reason.
    *
    * FreshFruit is a PerishableSquirrelFood and can therefore not be a DurableSquirrelFood because that
    * would mean eatWithinDays() must be dependent from the value bury but this is wrong for
    * PerishableSquirrelFood.
    *
    * DryFruit is not a PerishableSquirrelFood because eatWithinDays() must be dependent upon bury and
    * PerishableSquirrelFood disallows that indirectly.
    *
    * Cones are not Fruits because Fruits have the values fromMonth() and toMonth() which
    * are not needed by Cones and would be wrong. So Cone is not a subtype of main.Fruit.
    *
    * Cone is also not a subtype of main.Nut because bury must be false for a Cone and true for a main.Nut which
    * makes them incompatible.
     */


public class Test {

    public static void main(String[] args) {

        List<DurableSquirrelFood> durableSquirrelFoods = new ArrayList<DurableSquirrelFood>();

        durableSquirrelFoods.add(new Nut(100, 0.1, 0.4, 0.5));
        durableSquirrelFoods.add(new DryFruit(80, 0.2, 0.2, 0.6, 8, 12));
        durableSquirrelFoods.add(new Cone(120, 0.2, 0.3, 0.5, 30));
        durableSquirrelFoods.add(new DurableSquirrelFood(40, 0.3, 0.4, 0.3, true));

        for (DurableSquirrelFood d : durableSquirrelFoods) {
            // A special feature of every DurableSquirrelFood
            System.out.println(d.toBeBuried());

            // Every DurableSquirrelFood is a subtype of SquirrelFood but eatWithinDays iss dependent upon bury
            System.out.println(d.eatWithinDays());
        }

        List<Fruit> fruits = new ArrayList<Fruit>();

        fruits.add(new FreshFruit(20, 0.4, 0.4, 0.2, 2, 5));
        fruits.add(new DryFruit(20, 0.4, 0.4, 0.2, 2, 5));

        for (Fruit fruit : fruits) {
            System.out.println(fruit.fromMonth());
            System.out.println(fruit.toMonth());
        }
    }
}
