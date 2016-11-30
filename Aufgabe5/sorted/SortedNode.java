package sorted;

/**
 * Created by koray on 30/11/2016.
 */
public class SortedNode<T> {

    private T element;
    private SortedNode<T> next;

    /**
     * Constructs a new SortedNode with element as its element.
     * <p>
     * element may not be null.
     *
     * @param element
     */
    public SortedNode(T element) {
        this.element = element;
    }

    /**
     * Returns the element for this node.
     *
     * @return The element for this node
     */
    public T getElement() {
        return element;
    }

    /**
     * Returns the next node or null if there is no next node.
     *
     * @return The next node or null
     */
    public SortedNode<T> getNext() {
        return next;
    }

    /**
     * Sets the next node of this node.
     *
     * @param next The next node of this node
     */
    public void setNext(SortedNode<T> next) {
        this.next = next;
    }
}
