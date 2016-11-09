package animals;

/**
 * Created by koray on 08/11/2016.
 */
public enum Sex {

    MALE,
    FEMALE;

    public static Sex random() {
        return (Math.random() > 0.5) ? Sex.MALE : Sex.MALE;
    }
}
