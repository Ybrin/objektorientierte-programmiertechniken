package kolonie;

import eichhoernchen.Eichhoernchen;

/**
 * Created by Sabrina on 04.12.2016.
 */
public class Kolonie {

    private final String name;
    private Node first;

    /**
     * Initializes a new instance of Kolonie with the given name
     *
     * @param name The name to set (unchangeable)
     */
    public Kolonie(String name) {
        this.name = name;
    }

    /**
     * Adds the given (non null) squirrel to the list.
     *
     * @param eichhoernchen The squirrel to add to the list. Must be a non null value.
     */
    public void addSquirrel(Eichhoernchen eichhoernchen) {
        if (first == null) {
            first = new Node(eichhoernchen);
            return;
        }

        Node current = first;
        while (current.getNext() != null) {
            current = current.getNext();
        }

        current.setNext(new Node(eichhoernchen));
    }

    /**
     * Removes the given squirrel from the list. The given squirrel is expected
     * to be a non null value
     * If there is more than one squirrel with this name, the first one will be removed.
     * <p>
     * The given squirrel will be tested against name equality. If there is no name equivalent
     * element in the list (e.g.: listElem.getName() != eichhoernchen.getName() for every element in the list)
     * this method does nothing.
     *
     * @param eichhoernchen The squirrel which should be removed (non null)
     */
    public void removeSquirrel(Eichhoernchen eichhoernchen) {
        if (first == null) return;

        Object firstSquirrel = first.getElement();
        if (firstSquirrel instanceof Eichhoernchen && ((Eichhoernchen) firstSquirrel).getName().equals(eichhoernchen.getName())) {
            first = first.getNext();
            return;
        }

        Node current = first.getNext();
        Node before = first;
        while (current != null && current.getElement() instanceof Eichhoernchen &&
                !((Eichhoernchen) current.getElement()).getName().equals(eichhoernchen.getName())) {
            before = current;
            current = current.getNext();
        }

        if (current != null && current.getElement() instanceof Eichhoernchen &&
                ((Eichhoernchen) current.getElement()).getName().equals(eichhoernchen.getName())) {
            before.setNext(current.getNext());
        }
    }

    /**
     * Removes the given squirrel name from the list. The given squirrel name is expected
     * to be a non null value
     * If there is more than one squirrel with this name, the first one will be removed.
     * <p>
     * The given squirrel will be tested against name equality. If there is no name equivalent
     * element in the list (e.g.: listElem.getName() != eichhoernchen for every element in the list)
     * this method does nothing.
     *
     * @param eichhoernchen The squirrel name which should be removed (non null)
     */
    public void removeSquirrel(String eichhoernchen) {
        if (first == null) return;

        Object firstSquirrel = first.getElement();
        if (firstSquirrel instanceof Eichhoernchen && ((Eichhoernchen) firstSquirrel).getName().equals(eichhoernchen)) {
            first = first.getNext();
            return;
        }

        Node current = first.getNext();
        Node before = first;
        while (current != null && current.getElement() instanceof Eichhoernchen &&
                !((Eichhoernchen) current.getElement()).getName().equals(eichhoernchen)) {
            before = current;
            current = current.getNext();
        }

        if (current != null && current.getElement() instanceof Eichhoernchen &&
                ((Eichhoernchen) current.getElement()).getName().equals(eichhoernchen)) {
            before.setNext(current.getNext());
        }
    }

    /**
     * Prints a textual representation of this instance of Kolonie to stdout
     */
    public void printDescription() {
        System.out.println("******* SHOWING THE KOLONIE WITH THE NAME " + name + " *******");
        Node current = first;
        while (current != null) {
            Object elem = current.getElement();
            if (elem instanceof Eichhoernchen) {
                System.out.println(elem.toString());
                System.out.println();
            }

            current = current.getNext();
        }
    }
}
