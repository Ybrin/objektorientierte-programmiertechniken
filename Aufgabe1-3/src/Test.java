import calculation.Calculation;
import population.Group;
import population.Population;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sabrina on 12.10.2016.
 */
public class Test {

    public static void main(String[] args) {
        Group group1 = new Group(1000, 30, 10, 0.8, 0.1, 0.13);
        Group group2 = new Group(1000, 15, 8, 0.8, 0.4, 0.16);
        Group group3 = new Group(1000, 30, 9, 0.8, 0.2, 0.14);
        Group group4 = new Group(1000, 25, 20, 0.8, 0.2, 0.12);
        Group group5 = new Group(1000, 10, 5, 0.74, 0.1, 0.15);
        Group group6 = new Group(1000, 10, 20, 0.85, 0.15, 0.15);

        List<Group> groups = new ArrayList<Group>();

        groups.add(group1);
        groups.add(group2);
        groups.add(group3);
        groups.add(group4);
        groups.add(group5);
        groups.add(group6);

        Population population = new Population(groups);

        for (Group group : groups) {
            System.out.println("******* The following group has the " + group.getStrategy().toString() + " Strategy! *******");
            System.out.println("  * Starting with a group size of " + group.getGroupsize());

            int oldSize = group.getGroupsize();
            for (int i = 0; i < 10; i++) {
                group.simulateYearPass();
                System.out.println(i + ": " + group.getGroupsize());
            }
            // Reset group size to have a unique simulation for the other groups
            group.setGroupsize(oldSize);
            System.out.println("******* NEXT *******");
        }
    }
}
