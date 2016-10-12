package population;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sabrina on 12.10.2016.
 */
public class Population {

    private List<Group> groups;
    private int differentStrategies;

    /**
     * initializes new instance of population and calculates the number of different strategies
     * @param groups
     */
    public Population(List<Group> groups){
        this.groups = groups;
    }

    public List<Group> getGroups() {
        return groups;
    }
}
