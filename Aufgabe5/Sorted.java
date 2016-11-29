import java.lang.reflect.Type;
import java.util.*;
import java.util.function.Consumer;

/**
 * Created by Aniela on 24.11.2016.
 */
public class Sorted implements java.lang.Iterable {



    Iterator iterator;
    List <Before> beforeList;

    /**
     * Construkor
     * @param iterator
     * @autor Aniela
     */
    public Sorted(Iterator iterator) {

        beforeList=new ArrayList<>();
        this.iterator = beforeList.iterator();
    }

    /**
     * addes Before object into list
     * @param before
     * @autor aniela
     */
    public void add(Before before){

        beforeList.add( before);
        //iterator=beforeList.iterator();
    }

    /**
     * removes Object from iterator
     * @param before
     * @autor aniela
     */
    public void remove(Before before){

        while (iterator.hasNext()){

            if(iterator.next().equals(before)){
                iterator.remove();
            }
        }
    }

    /**
     *
     * creats new iterator
     *
     * @return iterator
     * @autor Aniela
     */
    @Override
    public Iterator iterator() {
        Iterator<Before> iterator = new Iterator<Before>() {

            private int currentIndex = 0;

            @Override
            public boolean hasNext() {
                return currentIndex < beforeList.size() && beforeList.get(currentIndex)!= null;
            }

            @Override
            public Before next() {
                Before before=beforeList.get(currentIndex);
               /* if(beforeList.get(currentIndex).before(beforeList.get(currentIndex+1))){
                   before= beforeList.get(currentIndex);
                }else{
                    before= beforeList.get(currentIndex+1);
                }*/
                return before;
            }

            @Override
            public void remove() {
                beforeList.set(currentIndex,beforeList.get(currentIndex+1));
                for(int current = currentIndex+1; current<beforeList.size(); current++){
                    if(beforeList.get(current+1).before(beforeList.get(current))){
                        beforeList.set(current+1,beforeList.get(current+2));
                        beforeList.set(current,beforeList.get(current+1));
                    }else{
                        beforeList.set(current,beforeList.get(current+1));
                        beforeList.set(current+1,beforeList.get(current+2));
                    }
                }
            }
        };

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
