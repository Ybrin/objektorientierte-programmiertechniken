import main.Fruit;
import main.Nut;
import main.SquirelFood;
import main.SquirelRanking;
import sorted.Clustered;
import sorted.Sorted;

import java.util.Iterator;

/**
 * Created by Sabrina on 26.11.2016.
 */
public class Test {

    /*
    * ******* AUFGABENAUFTEILUNG *******
    *
    * - Sabrina: Nut, Fruit, SquirlFood, SquirelRanking
    * - Aniela: Sorted, Before, SortedNode
    * - Koray: Clustered, ClusteredNode, Test, Sorted überarbeitet damit es mit Clustered zusammenpasst
    *
     */

    // Not very beautiful but this is just a test
    public static Clustered<String, Nut> nuts;
    public static Clustered<String, Fruit> fruits;

    public static void main(String[] args) {
        System.out.println("************** TEST NUMBER 1 **************");
        testSorted();
        testClusteredInteger();
        testClusteredString();
        testClusteredFruit();

        testAssigning();
    }

    private static void testSorted() {
        Sorted<Nut> sortedNuts = new Sorted<Nut>(new Nut(1.2, 0.8, 'A'));
        sortedNuts.add(new Nut(0.8, 0.2, 'B'));
        sortedNuts.add(new Nut(0.9, 0.4, 'C'));
        sortedNuts.add(new Nut(0.7, 0.7, 'D'));
        sortedNuts.add(new Nut(0.4, 0.8, 'E'));
        sortedNuts.add(new Nut(0.2, 0.3, 'F'));
        sortedNuts.add(new Nut(0.8, 0.1, 'G'));

        System.out.println("******* BATCH *******");
        for (Nut n : sortedNuts) {
            printNut(n);
        }

        sortedNuts.remove(0);
        sortedNuts.remove(2);

        System.out.println("******* BATCH *******");
        for (Nut n : sortedNuts) {
            printNut(n);
        }

        sortedNuts.add(new Nut(1.2, 0.8, 'A'));
        sortedNuts.add(new Nut(0.7, 0.7, 'D'));

        System.out.println("******* BATCH *******");
        for (Nut n : sortedNuts) {
            printNut(n);
        }

        int count = 0;
        Iterator<Nut> iterator = sortedNuts.iterator();
        while (iterator.hasNext()) {
            Nut n = iterator.next();

            if (count % 2 == 0) {
                iterator.remove();
            }
            count++;
        }

        System.out.println("******* BATCH *******");
        for (Nut n : sortedNuts) {
            printNut(n);
        }
    }

    private static void testClusteredInteger() {
        SquirelRanking first = new SquirelRanking(1.2);
        Integer[] ints = new Integer[] {1, 2, 3};
        Clustered<Integer, SquirelRanking> clustered = new Clustered<Integer, SquirelRanking>(first, ints);

        clustered.add(new SquirelRanking(0.9));
        clustered.add(new SquirelRanking(0.4), ints);
        clustered.add(new SquirelRanking(1.5));
        clustered.add(new SquirelRanking(1.0), ints);
        clustered.add(new SquirelRanking(0.234));
        clustered.add(new SquirelRanking(0.7), ints);
        clustered.add(new SquirelRanking(2.9));

        System.out.println("******* BATCH *******");
        for (SquirelRanking r : clustered) {
            printSquirelRanking(r);
        }

        clustered.remove(2);
        clustered.remove(2, 1);
        clustered.remove(1, 3);
        clustered.remove(1, 4);

        System.out.println("******* BATCH *******");
        for (SquirelRanking r : clustered) {
            printSquirelRanking(r);
        }

        clustered.add(new SquirelRanking(0.4), ints);
        clustered.add(new SquirelRanking(2.2));

        System.out.println("******* BATCH *******");
        for (SquirelRanking r : clustered) {
            printSquirelRanking(r);
        }

        int count = 0;
        Iterator<SquirelRanking> iterator = clustered.iterator(2);
        while (iterator.hasNext()) {
            SquirelRanking n = iterator.next();

            if (count % 2 == 0) {
                iterator.remove();
            }
            count++;
        }

        System.out.println("******* BATCH *******");
        for (SquirelRanking r : clustered) {
            printSquirelRanking(r);
        }
    }

    private static void testClusteredString() {
        Nut first = new Nut(0.2, 0.4, 'A');
        String[] strings = new String[] {"a", "b", "x"};
        Clustered<String, Nut> clustered = new Clustered<String, Nut>(first, strings);

        clustered.add(new Nut(0.8, 0.2, 'B'), strings);
        clustered.add(new Nut(0.9, 0.4, 'C'));
        clustered.add(new Nut(0.7, 0.7, 'D'), strings);
        clustered.add(new Nut(0.4, 0.8, 'E'), strings);
        clustered.add(new Nut(0.2, 0.3, 'F'));
        clustered.add(new Nut(0.8, 0.1, 'G'), strings);

        System.out.println("******* BATCH CLUSTERED NUT *******");
        for (Nut n : clustered) {
            printNut(n);
        }

        clustered.remove(2);
        clustered.remove(2, "a");
        clustered.remove(1, "b");
        clustered.remove(1, "g");

        System.out.println("******* BATCH CLUSTERED NUT *******");
        for (Nut n : clustered) {
            printNut(n);
        }

        clustered.add(new Nut(0.2, 0.3, 'F'));
        clustered.add(new Nut(0.8, 0.1, 'G'), strings);

        System.out.println("******* BATCH CLUSTERED NUT *******");
        for (Nut n : clustered) {
            printNut(n);
        }

        int count = 0;
        Iterator<Nut> iterator = clustered.iterator("a");
        while (iterator.hasNext()) {
            Nut n = iterator.next();

            if (count % 2 == 0) {
                iterator.remove();
            }
            count++;
        }

        System.out.println("******* BATCH *******");
        for (Nut r : clustered) {
            printNut(r);
        }

        nuts = clustered;
    }

    private static void testClusteredFruit() {
        Fruit first = new Fruit(0.2, 0.4, 2);
        String[] strings = new String[] {"a", "b", "x"};
        Clustered<String, Fruit> clustered = new Clustered<String, Fruit>(first, strings);

        clustered.add(new Fruit(0.8, 0.2, 1), strings);
        clustered.add(new Fruit(0.9, 0.4, 2));
        clustered.add(new Fruit(0.7, 0.7, 5), strings);
        clustered.add(new Fruit(0.4, 0.8, 3), strings);
        clustered.add(new Fruit(0.2, 0.3, 6));
        clustered.add(new Fruit(0.8, 0.1, 7), strings);

        System.out.println("******* BATCH CLUSTERED FRUIT *******");
        for (Fruit f : clustered) {
            printFruit(f);
        }

        clustered.remove(2);
        clustered.remove(2, "a");
        clustered.remove(1, "b");
        clustered.remove(1, "g");

        System.out.println("******* BATCH CLUSTERED FRUIT *******");
        for (Fruit f : clustered) {
            printFruit(f);
        }

        clustered.add(new Fruit(0.2, 0.3, 6));
        clustered.add(new Fruit(0.8, 0.1, 7), strings);

        System.out.println("******* BATCH CLUSTERED FRUIT *******");
        for (Fruit f : clustered) {
            printFruit(f);
        }

        fruits = clustered;
    }

    private static void testAssigning() {
        // ******* TEST NUMBER 2 *******
        System.out.println("************** TEST NUMBER 2 **************");
        Clustered<String, SquirelFood> clustered = new Clustered<String, SquirelFood>(new Fruit(1, 1, 1));

        for (Fruit f : fruits) {
            clustered.add(f);
        }

        for (Nut n : nuts) {
            clustered.add(n);
        }

        System.out.println("******* BATCH CLUSTERED FRUIT *******");
        for (SquirelFood f : clustered) {
            printSquirelFood(f);
        }

        clustered.remove(1);
        clustered.remove(2, "b");

        System.out.println("******* BATCH CLUSTERED FRUIT *******");
        for (SquirelFood f : clustered) {
            printSquirelFood(f);
        }

        // ******* TEST NUMBER 3 *******
        System.out.println("************** TEST NUMBER 3 **************");

        Sorted<SquirelFood> sorted = clustered;

        int count = 0;
        Iterator<SquirelFood> iterator = sorted.iterator();
        while (iterator.hasNext()) {
            SquirelFood n = iterator.next();

            if (count % 2 == 0) {
                iterator.remove();
            }
            count++;
        }

        System.out.println("******* BATCH CLUSTERED SQUIRELFOOD *******");
        for (SquirelFood f : sorted) {
            printSquirelFood(f);
        }

        sorted.add(new Fruit(1, 2, 4));
        sorted.add(new Fruit(3, 2.4, 4));
        sorted.add(new Nut(3, 2.4, 'F'));

        System.out.println("******* BATCH CLUSTERED SQUIRELFOOD *******");
        for (SquirelFood f : sorted) {
            printSquirelFood(f);
        }

        sorted.remove(1);
        sorted.remove(3);
        sorted.remove(2);
    }

    private static void printNut(Nut n) {
        System.out.println("******* NUT *******");
        System.out.println("Energy: " + n.getEnergy());
        System.out.println("Fat: " + n.getFat());
        System.out.println("Nutshell: " + n.getNutshell());
    }

    private static void printSquirelRanking(SquirelRanking r) {
        System.out.println("******* SQUIRELRANKING *******");
        System.out.println("Value: " + r.getValue());
    }

    private static void printFruit(Fruit f) {
        System.out.println("******* FRUIT *******");
        System.out.println("Energy: " + f.getEnergy());
        System.out.println("Fat: " + f.getFat());
        System.out.println("DURABILITY: " + f.getDurability());
    }

    private static void printSquirelFood(SquirelFood f) {
        System.out.println("******* SQUIRELFOOD *******");
        System.out.println("Energy: " + f.getEnergy());
        System.out.println("Fat: " + f.getFat());
    }
}
