package sorted;

import main.Before;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Created by koray on 30/11/2016.
 */
public class Clustered<A, B extends Before<? super B>> extends Sorted<B> {

    private ClusteredNode<A, B> first;

    /**
     * Constructs a new instance of Sorted with the given firstElement
     * as the initial value and clusters as clusters for the initial values.
     *
     * @param firstElement The first element which should be added to Sorted
     */
    public Clustered(B firstElement, A[] clusters) {
        super(firstElement);
        this.first = new ClusteredNode<A, B>(firstElement, clusters);
    }

    /**
     * Constructs a new instance of Sorted with the given firstElement
     * as the initial value.
     *
     * @param firstElement The first element which should be added to Sorted
     */
    public Clustered(B firstElement) {
        this(firstElement, null);
    }

    /**
     * Adds the given parameter <code>before</code> with the given clusters to the list
     *
     * @param element The object which should be added to the list
     * @param clusters The clusters which should be added to the element
     */
    public void add(B element, A[] clusters) {
        if (element.before(first.getElement())) {
            ClusteredNode<A, B> newFirst = new ClusteredNode<A, B>(element, clusters);
            newFirst.setNext(first);
            this.first = newFirst;
            return;
        }

        ClusteredNode<A, B> current = first;
        while (current.getNext() != null && current.getNext().getElement().before(element)) {
            current = current.getNext();
        }

        ClusteredNode<A, B> newNext = new ClusteredNode<A, B>(element, clusters);
        newNext.setNext(current.getNext());

        current.setNext(newNext);
    }

    /**
     * Adds the given parameter <code>before</code> to the list without clusters.
     *
     * @param element The object which should be added to the list
     */
    public void add(B element) {
        add(element, null);
    }

    /**
     * Returns the current size of this Sorted list.
     *
     * @return Current size of this list
     */
    public int size() {
        int i = 0;
        ClusteredNode<A, B> current = first;
        while (current != null) {
            current = current.getNext();
            i++;
        }

        return i;
    }

    /**
     * Returns the current size of this Sorted list with the given cluster.
     *
     * @param cluster The cluster
     * @return Current size of this list
     */
    public int size(A cluster) {
        int i = 0;
        ClusteredNode<A, B> current = first;
        while (current != null) {
            current = current.getNext();
            if (current.hasCluster(cluster)) i++;
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
    public B get(int i) {
        if (i < 0) {
            throw new IndexOutOfBoundsException("The parameter i must be bigger than or equal 0.");
        }

        int currentIndex = 0;
        ClusteredNode<A, B> currentElement = first;

        while (i != currentIndex && currentElement != null) {
            currentIndex++;
            currentElement = currentElement.getNext();
        }

        return currentElement == null ? null : currentElement.getElement();
    }

    /**
     * Returns the ith element of this list with the given cluster or null if the index exceeds the range
     * of this list.
     * <p>
     * i must be bigger than or equal 0
     * <p>
     * This List starts counting with 0.
     *
     * @param i The index of the element you want
     * @param cluster The cluster
     * @return The ith element of this list with the given cluster or null
     */
    public B get(int i, A cluster) {
        if (i < 0) {
            throw new IndexOutOfBoundsException("The parameter i must be bigger than or equal 0.");
        }

        int currentIndex = 0;
        ClusteredNode<A, B> currentElement = first;

        while (currentElement != null) {
            if (i == currentIndex && currentElement.hasCluster(cluster)) return currentElement.getElement();
            if (currentElement.hasCluster(cluster)) currentIndex++;
            currentElement = currentElement.getNext();
        }

        return null;
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
        ClusteredNode<A, B> currentElement = first;
        while (currentIndex != i && currentElement.getNext() != null) {
            currentIndex++;
            currentElement = currentElement.getNext();
        }

        if (currentElement.getNext() != null) {
            ClusteredNode<A, B> newNext = currentElement.getNext().getNext();
            currentElement.setNext(newNext);
        }
    }

    /**
     * Removes the given index from this list with the given cluster if there are at least i + 1 elements in this list.
     * <p>
     * Does nothing if there are less than i + 1 elements in this list.
     * <p>
     * i MUST be bigger than or equal 0
     *
     * @param i The index of the element you want to remove
     */
    public void remove(int i, A cluster) {
        if (i < 0) {
            throw new IndexOutOfBoundsException("The parameter i must be bigger than or equal 0.");
        }

        if (i == 0 && first.hasCluster(cluster)) {
            first = first.getNext();
            return;
        } else if (i == 0 && !first.hasCluster(cluster)) {
            ClusteredNode<A, B> currentElement = first;
            while (currentElement.getNext() != null) {
                if (currentElement.getNext().hasCluster(cluster)) {
                    currentElement.setNext(currentElement.getNext().getNext());
                    return;
                }
                currentElement = currentElement.getNext();
            }
        }

        int currentIndex = 1;
        // currentElement.getNext() will be the ith element
        // (or the element we want to remove once we reached the index)
        ClusteredNode<A, B> currentElement = first;
        while (currentElement.getNext() != null) {
            if (currentIndex == i && currentElement.getNext().hasCluster(cluster)) {
                currentElement.setNext(currentElement.getNext().getNext());
                return;
            }
            if (currentElement.getNext().hasCluster(cluster)) currentIndex++;
            currentElement = currentElement.getNext();
        }
    }

    @Override
    public Iterator<B> iterator() {
        return new ClusteredIterator<B>();
    }

    public Iterator<B> iterator(A cluster) {
        return new ClusteredIterator<B>(cluster);
    }

    private boolean hasNext(int after, A cluster) {
        if (after < 0) {
            throw new IndexOutOfBoundsException("The parameter i must be bigger than or equal 0.");
        }

        int currentIndex = 0;
        ClusteredNode<A, B> currentElement = first;

        while (after != currentIndex && currentElement != null) {
            currentIndex++;
            currentElement = currentElement.getNext();
        }

        return currentElement != null && currentElement.hasNext(cluster);
    }

    private class ClusteredIterator<T extends B> extends SortedIterator<B> {

        // The cluster
        private A cluster;

        // Next element to return
        private int cursor = 0;
        // Index of last element returned; -1 if no such
        private int lastRet = -1;
        private int fixedSize;

        public ClusteredIterator() {
            super();
            if (cluster == null) {
                fixedSize = size();
            } else {
                fixedSize = size(cluster);
            }
        }

        public ClusteredIterator(A cluster) {
            this();
            this.cluster = cluster;
        }

        @Override
        public boolean hasNext() {
            if (cluster == null) {
                return cursor < fixedSize;
            } else {
                return Clustered.this.hasNext((cursor - 1 >= 0) ? cursor - 1 : 0, cluster);
            }
        }

        @Override
        public B next() {
            concurrentModification();

            if (cursor >= fixedSize) {
                throw new NoSuchElementException("The Iterator is out of range.");
            }

            B current = cluster == null ? get(cursor) : get(cursor, cluster);
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

            if (cluster == null) {
                Clustered.this.remove(lastRet);
            } else {
                Clustered.this.remove(lastRet, cluster);
            }
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
