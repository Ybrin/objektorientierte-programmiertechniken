package main;

/**
 * Created by Sabrina on 26.11.2016.
 */
public class SquirelRanking implements Before<SquirelRanking> {

    private final double value;

    public SquirelRanking(double value) {
        this.value = value;
    }

    /**
     * Returns true if the value in this object is at least the double of the value in y
     *
     * @param y The SquirelRanking to test against the value
     * @return True if the value in this object is at least the double of the value in y, false otherwise
     */
    public boolean before(SquirelRanking y) {
        return value >= 2 * y.value;
    }

    public double getValue() {
        return value;
    }
}
