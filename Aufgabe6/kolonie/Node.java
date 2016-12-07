package kolonie;

/**
 * Created by koray on 07/12/2016.
 */
public class Node {

    private Object element;
    private Node next;

    public Node(Object element) {
        this.element = element;
    }

    public Object getElement() {
        return element;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}
