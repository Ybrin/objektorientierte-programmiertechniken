package SquirrelFood;

/**
 * Created by Aniela on 22.11.2016.
 */
public class PerishableSquirrelFood extends DurableSquirrelFood{

    int eat_within_days;
    double crab;
    double fat;
    double protein;

    /**
     * Constructor of Perishable food
     *
     * @param eat_within_days
     * @param crab
     * @param fat
     * @param protein
     * @autor Aniela
     */
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

    /**
     * can't be used for storage
     *
     * @return false
     */
    @Override
    public boolean toBeBuried() {
        return false;
    }
}


