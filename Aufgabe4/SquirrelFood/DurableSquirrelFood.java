package SquirrelFood;

import SquirrelFood.SquirrelFood;

/**
 * Created by Aniela on 16.11.2016.
 */
public abstract class DurableSquirrelFood implements SquirrelFood{

    /**
     *
     *if the food is bad in les than 2 day, it wont be buried
     *
     * @return buriable
     * @autor Aniela
     */
    public abstract boolean toBeBuried();
}
