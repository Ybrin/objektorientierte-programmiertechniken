import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Consumer;

/**
 * Created by Aniela on 24.11.2016.
 */
public class Sorted implements java.lang.Iterable {

    Iterator iterator;

    public Sorted(Iterator iterator) {
        this.iterator = iterator;
    }

    public void add(Before before){

    }

    public void remove(Before before){

        Before first=(Before) this;
        Before help;
        while (iterator.hasNext()){
            Before secund = (Before)iterator.next();
            if(first.equals(before)){
                iterator.next();

            }
            help= first;
            first=secund;
        }
    }

    @Override
    public Iterator iterator() {
        Before x = (Before) this;
        while (iterator.hasNext()){
            Before y = (Before)iterator.next();
            if(x.before(y)){

            }
           x=y;
        }
       return iterator;
    }

    @Override
    public void forEach(Consumer action) {

    }

    @Override
    public Spliterator spliterator() {
        return null;
    }
}
