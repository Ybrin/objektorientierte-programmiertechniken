package fruit;

/**
 * Created by Sabrina on 22.11.2016.
 */
public class Mushroom extends Fruit implements FreshFruit {

    public Mushroom(int toMonth, double carb, double fat, double protein, int eatWithinDays, int fromMonth, double water) {
        this.toMonth = toMonth;
        this.carb = carb;
        this.fat = fat;
        this.protein = protein;
        this.eatWithinDays = eatWithinDays;
        this.fromMonth = fromMonth;
        this.water = water;
    }

    public DryFruit dry(){
        int neatWithinDays = this.eatWithinDays * 10;
        double nwater = this.water / 100 * 45;

        DryFruit dried = new DriedMushroom(toMonth, carb, fat, protein, neatWithinDays, fromMonth, nwater);
        return dried;
    }
}

