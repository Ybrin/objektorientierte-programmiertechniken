package versteck;

/**
 * Created by Sabrina on 04.12.2016.
 */
public abstract class Versteckabs implements Versteck{

    private int nummer;
    private double volumen;

    public Versteckabs(int nummer, double volumen){
        this.nummer = nummer;
        this.volumen = volumen;
    }

    public int nummer(){
        return this.nummer;
    }

    public double volumen(){
        return this.volumen;
    }


}
