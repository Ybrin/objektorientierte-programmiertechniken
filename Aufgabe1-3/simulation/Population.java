package simulation;

import animals.Strategy;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by Sabrina on 12.10.2016.
 */
public class Population {

    private List<Group> groups;
    private int differentStrategies;

    /**
     * initializes new instance of simulation and calculates the number of different strategies
     *
     * @param groups
     */
    public Population(List<Group> groups) {
        this.groups = groups;
        for (Group group : this.groups) {
            group.setPopulation(this);
        }
    }

    public List<Group> getGroups() {
        return groups;
    }
}
