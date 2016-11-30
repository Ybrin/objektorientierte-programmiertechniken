package main;

/**
 * Created by Aniela on 24.11.2016.
 */
public interface Before<A> {

    /**
     * Compares the given parameter <code>o</code> with <code>this</code>
     * <p>
     * Expects <code>o</code> to be a non-null value
     * <p>
     * <p>
     * For three variables <code>x</code>, <code>y</code> and <code>z</code>, the following will apply:
     * <p>
     * If <code>x.equals(y)</code> returns true, <code>x.before(y)</code> returns <code>false</code>
     * <p>
     * If x.before(y) and y.before(z) return true, x.before(z) returns true
     * <p>
     * If x.before(y) returns true, y.before(x) returns false
     * <p>
     * The result of <code>before</code> is idempotent for all unchanged values.
     *
     * @param o The parameter which should be compared against <code>this</code>
     * @return true if <code>this</code> is before <code>o</code>
     */
    boolean before(A o);
}
