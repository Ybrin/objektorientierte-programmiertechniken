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
        Group group1 = new Group(1000, 50, 10, 0.8, 0.1, 0.13);
        Group group2 = new Group(1000, 20, 8, 0.8, 0.4, 0.16);
        Group group3 = new Group(1000, 40, 9, 0.8, 0.2, 0.14);
        Group group4 = new Group(1000, 30, 20, 0.8, 0.2, 0.12);
        Group group5 = new Group(1000, 60, 5, 0.84, 0.1, 0.15);

        List<Group> groups = new ArrayList<Group>();

        groups.add(group1);
        groups.add(group2);
        groups.add(group3);
        groups.add(group4);
        groups.add(group5);

        Population population = new Population(groups);

        for (Group group : groups) {
            for (int i = 0; i < 10; i++) {
                int size = Calculation.calculateGroupsizeAfterAYear(group);
                group.setGroupsize(size);
                System.out.println(i + ": " + size);
            }
            System.out.println("******* NEXT *******");
        }
    }
}
