package SquirrelFood;

/**
 * Created by Aniela on 22.11.2016.
 */
public class VegetarienSquirrelFood extends DurableSquirrelFood{
    int eat_within_days;
    double crab;
    double fat;
    double protein;

    /**
     * Constructor Vegatarian Food
     *
     * @param eat_within_days
     * @param crab
     * @param fat
     * @param protein
     * @autor Aniela
     */
    public VegetarienSquirrelFood(int eat_within_days, double crab, double fat, double protein) {
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
     * can be used for storage, if the foods lifetime is long anouth
     *
     * @return true/false
     * @autor Aniela
     */
    @Override
    public boolean toBeBuried() {
        boolean buriable=false;
        if(this.eatWithinDays()>20){
            buriable = true;
        }
        return buriable;
    }
}

