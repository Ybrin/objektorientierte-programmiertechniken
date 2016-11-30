package sorted;

/**
 * Created by koray on 30/11/2016.
 */
public class ClusteredNode<T, U> {

    private U element;
    // If clusters is null, it will be treated as if it was empty
    private T[] clusters;
    private ClusteredNode<T, U> next;

    /**
     * Constructs a new ClusteredNode with element as its element and clusters as its clusters.
     * <p>
     * element may not be null.
     *
     * @param element
     */
    public ClusteredNode(U element, T[] clusters) {
        this.element = element;
        this.clusters = clusters;
    }

    /**
     * Returns true if there is at least one element in this list which has this cluster.
     *
     * @param cluster The cluster
     * @return True if there is an element with the given cluster
     */
    public boolean hasNext(T cluster) {
        ClusteredNode<T, U> current = next;
        while (current != null) {
            if (current.clusters == null) {
                current = current.next;
                continue;
            }

            for (T c : current.clusters) {
                if (cluster.equals(c)) return true;
            }

            current = current.next;
        }

        return false;
    }

    public boolean hasCluster(T cluster) {
        if (clusters == null) return false;

        for (T c : clusters) {
            if (cluster.equals(c)) return true;
        }
        return false;
    }

    /**
     * Returns the element for this node.
     *
     * @return The element for this node
     */
    public U getElement() {
        return element;
    }

    /**
     * Returns the next node or null if there is no next node.
     *
     * @return The next node or null
     */
    public ClusteredNode<T, U> getNext() {
        return next;
    }

    /**
     * Sets the next node of this node.
     *
     * @param next The next node of this node
     */
    public void setNext(ClusteredNode<T, U> next) {
        this.next = next;
    }

    public T[] getClusters() {
        return clusters;
    }
}
