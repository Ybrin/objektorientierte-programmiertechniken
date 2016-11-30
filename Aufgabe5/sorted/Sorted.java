package sorted;

import main.Before;

import java.util.*;

/**
 * Created by Aniela on 24.11.2016.
 */
public class Sorted<A extends Before<? super A>> implements Iterable<A> {

    private SortedNode<A> first;

    /**
     * Constructs a new instance of Sorted with the given firstElement
     * as the initial value.
     *
     * @param firstElement The first element which should be added to Sorted
     */
    public Sorted(A firstElement) {
        this.first = new SortedNode<A>(firstElement);
    }

    /**
     * Constructs a new instance of Sorted with the given array of
     * elements as the initial values.
     * <p>
     * The array is expected to be non-null and have at least one value.
     *
     * @param elements The array of initial values
     */
    public Sorted(A[] elements) {
        if (elements.length < 1) throw new UnsupportedOperationException("You must provide at least one element.");

        this.first = new SortedNode<A>(elements[0]);

        for (int i = 1; i < elements.length; i++) {
            add(elements[i]);
        }
    }

    /**
     * Adds the given parameter <code>before</code> to the list
     *
     * @param element The object which should be added to the list
     * @autor aniela
     */
    public void add(A element) {
        if (element.before(first.getElement())) {
            SortedNode<A> newFirst = new SortedNode<A>(element);
            newFirst.setNext(first);
            this.first = newFirst;
            return;
        }

        SortedNode<A> current = first;
        while (current.getNext() != null && current.getNext().getElement().before(element)) {
            current = current.getNext();
        }

        SortedNode<A> newNext = new SortedNode<A>(element);
        newNext.setNext(current.getNext());

        current.setNext(newNext);
    }

    /**
     * Returns the current size of this Sorted list.
     *
     * @return Current size of this list
     */
    public int size() {
        int i = 0;
        SortedNode<A> current = first;
        while (current != null) {
            current = current.getNext();
            i++;
        }

        return i;
    }

    /**
     * Returns the ith element of this list or null if the index exceeds the range
     * of this list.
     * <p>
     * i must be bigger than or equal 0
     * <p>
     * This List starts counting with 0.
     *
     * @param i The index of the element you want
     * @return The ith element of this list or null
     */
    public A get(int i) {
        if (i < 0) {
            throw new IndexOutOfBoundsException("The parameter i must be bigger than or equal 0.");
        }

        int currentIndex = 0;
        SortedNode<A> currentElement = first;

        while (i != currentIndex && currentElement != null) {
            currentIndex++;
            currentElement = currentElement.getNext();
        }

        return currentElement == null ? null : currentElement.getElement();
    }

    /**
     * Removes the given index from this list if there are at least i + 1 elements in this list.
     * <p>
     * Does nothing if there are less than i + 1 elements in this list.
     * <p>
     * i MUST be bigger than or equal 0
     *
     * @param i The index of the element you want to remove
     */
    public void remove(int i) {
        if (i < 0) {
            throw new IndexOutOfBoundsException("The parameter i must be bigger than or equal 0.");
        }

        if (i == 0) {
            first = first.getNext();
            return;
        }

        int currentIndex = 1;
        // currentElement.getNext() will be the ith element
        // (or the element we want to remove once we reached the index)
        SortedNode<A> currentElement = first;
        while (currentIndex != i && currentElement.getNext() != null) {
            currentIndex++;
            currentElement = currentElement.getNext();
        }

        if (currentElement.getNext() != null) {
            SortedNode<A> newNext = currentElement.getNext().getNext();
            currentElement.setNext(newNext);
        }
    }

    @Override
    public Iterator<A> iterator() {
        return new SortedIterator<A>();
    }

    protected class SortedIterator<T extends A> implements Iterator<A> {

        // Next element to return
        private int cursor = 0;
        // Index of last element returned; -1 if no such
        private int lastRet = -1;
        private int fixedSize = size();

        @Override
        public boolean hasNext() {
            return cursor < fixedSize;
        }

        @Override
        public A next() {
            concurrentModification();

            if (cursor >= fixedSize) {
                throw new NoSuchElementException("The Iterator is out of range.");
            }

            A current = get(cursor);
            lastRet = cursor;
            cursor++;
            return current;
        }

        @Override
        public void remove() {
            if (lastRet < 0) {
                throw new IllegalStateException();
            }
            concurrentModification();

            Sorted.this.remove(lastRet);
            cursor = lastRet;
            lastRet = -1;
            fixedSize = size();
        }

        /**
         * Throws a ConcurrentModificationException if the size of Sorted was changed since
         * this iterator has started.
         */
        private void concurrentModification() {
            if (fixedSize != size()) {
                throw new ConcurrentModificationException();
            }
        }
    }
}
