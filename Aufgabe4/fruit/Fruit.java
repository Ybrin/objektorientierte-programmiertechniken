package Fruit;


import SquirrelFood.SquirrelFood;

/**
 * Created by Aniela on 16.11.2016.
 */
public abstract class Fruit implements SquirrelFood{

    protected int fromMonth;
    protected int toMonth;
    protected double carb;
    protected double fat;
    protected double protein;
    protected int eatWithinDays;
    protected double water;

    public int fromMonth() {
        return this.fromMonth;
    }

    public int toMonth() {
        return this.toMonth;
    }

    public double carb() {
        return this.carb;
    }

    public double fat() {
        return this.fat;
    }

    public double protein() {
        return this.protein;
    }

    public int eatWithinDays() {
        return this.eatWithinDays;
    }
}
