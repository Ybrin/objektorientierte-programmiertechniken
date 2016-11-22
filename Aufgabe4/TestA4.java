import Fruit.Mushroom;
import SquirrelFood.DurableSquirrelFood;
import SquirrelFood.SquirrelFood;
import SquirrelFood.VegetarienSquirrelFood;
import SquirrelFood.PerishableSquirrelFood;

/**
 * Created by Sabrina on 22.11.2016.
 */



    /*
    * ******* AUFGABE 4 *******
    *
    * Arbeitsaufteilung:    Sabrina: Fruit Package
    *                       Aniela: SquirrelFood Package
    *                       Koray:
    *
    *  ******* AUFGABE 4 *******
     */


public class TestA4 {
    public static void main(String[] args) {

        Mushroom mushroom = new Mushroom(12,3.3,0.3,3.1,120,9,91);
        mushroom.dry();
        DurableSquirrelFood v = new VegetarienSquirrelFood(50,3,3,3);
        DurableSquirrelFood p = new PerishableSquirrelFood(3,4,5,6);
        v.carb();
        System.out.println(v.toBeBuried());
        System.out.println(p.toBeBuried());
    }
}
