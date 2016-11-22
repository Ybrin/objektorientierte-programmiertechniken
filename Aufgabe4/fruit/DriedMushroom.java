package fruit;

/**
 * Created by Sabrina on 22.11.2016.
 */
public class DriedMushroom extends Fruit implements DryFruit {

    public DriedMushroom(int toMonth, double carb, double fat, double protein, int eatWithinDays, int fromMonth, double water) {
        this.toMonth = toMonth;
        this.carb = carb;
        this.fat = fat;
        this.protein = protein;
        this.eatWithinDays = eatWithinDays;
        this.fromMonth = fromMonth;
        this.water = water;
    }


}
