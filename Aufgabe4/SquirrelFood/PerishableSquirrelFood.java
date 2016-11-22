package SquirrelFood;

/**
 * Created by Aniela on 22.11.2016.
 */
public class PerishableSquirrelFood extends DurableSquirrelFood{

    int eat_within_days;
    double crab;
    double fat;
    double protein;

    public PerishableSquirrelFood(int eat_within_days, double crab, double fat, double protein) {
        this.eat_within_days = eat_within_days;
        this.crab = crab;
        this.fat = fat;
        this.protein = protein;
    }

    @Override
    public int eatWithinDays(){
        return eat_within_days;
    }

    @Override
    public double carb() {
        return crab;
    }

    @Override
    public double fat() {
        return fat;
    }

    @Override
    public double protein() {
        return protein;
    }

    @Override
    public boolean toBeBuried() {
        return false;
    }
}


