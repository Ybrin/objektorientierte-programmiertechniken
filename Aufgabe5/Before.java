/**
 * Created by Aniela on 24.11.2016.
 */
public interface Before {


    /**
     * compares an Methode parameter with an other object(this)
     * if x.equals(y)=true, before has to be false
     * if a.before(b)=true and b.before(c)=true than a.before(c)=true
     * if a.before(b)=true, b.before(a) must not be true
     * for the same unchanched parameters the result must stay the same
     *
     *
     * @return if o is before this
     * @param o an Object of tipe Before
     * @autor Aniela
     */
    public boolean before(Before o);
}
