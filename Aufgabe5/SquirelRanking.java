/**
 * Created by Sabrina on 26.11.2016.
 */
public class SquirelRanking{ // implements Before <...> {

    private final double number;

    public SquirelRanking(double number){
        this.number = number;
    }


    private boolean before(SquirelRanking y){
        return number >= 2*y.number;
    }

}
