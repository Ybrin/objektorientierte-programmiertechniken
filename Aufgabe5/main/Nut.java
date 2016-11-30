package main;

/**
 * Created by Sabrina on 26.11.2016.
 */
public class Nut extends SquirelFood {

    private char nutshell;

    /**
     * Creates a new instance of Nut with the given values.
     *
     * nutshell must be a char from 'A' to 'G'
     *
     * @param energy The energy
     * @param fat The fat
     * @param nutshell A char from 'A' to 'G'
     */
    public Nut(double energy, double fat, char nutshell) {
        super(energy, fat);
        this.nutshell = nutshell;
    }

    public char getNutshell() {
        return nutshell;
    }
}
