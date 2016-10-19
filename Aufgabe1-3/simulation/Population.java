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
     * @param groups
     */
    public Population(List<Group> groups){
        this.groups = groups;
        for (Group group : this.groups) {
            group.setPopulation(this);
        }
    }

    public List<Group> getGroups() {
        return groups;
    }

    /**
     * Calculates the amount of different strategies used by all groups
     * @return amount of different strategies
     */
    public int getDifferentStrategies() {
        // Reset different strategies
        differentStrategies = 0;

        Map<Strategy, Boolean> enumCheck = new TreeMap<>();

        for(Strategy s : Strategy.values()){
            enumCheck.put(s, false);
        }

        for (int i = 0; i < groups.size(); i++){
            Group group = groups.get(i);
            if(enumCheck.containsKey(group.getStrategy())){
                enumCheck.replace(group.getStrategy(), true);
            }
        }

        for(Strategy s : Strategy.values()){
            if(enumCheck.get(s)){
                differentStrategies++;
            }
        }

        return differentStrategies;
    }
}
