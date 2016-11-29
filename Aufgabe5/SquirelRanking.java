/**
 * Created by Sabrina on 26.11.2016.
 */
public class SquirelRanking implements Before <SquirelRanking> {

    private final double number;

    public SquirelRanking(double number){
        this.number = number;
    }

    /**
     * calculates if the number in x is at least the double of the value in y
     *
     * @param y another SquirelRanking
     * @return
     */
    public boolean before(SquirelRanking y){
        return number >= 2*y.number;
    }

}
