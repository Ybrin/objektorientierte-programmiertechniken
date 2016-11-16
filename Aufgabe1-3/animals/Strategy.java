package animals;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by Sabrina on 12.10.2016.
 */
public class Strategy {

    private static final String[] allLifegoals = {"prolific", "delimitation & expansion of territory",
            "achievement & observance of dominance", "many & comfortable nests"};

    private List<String> lifegoals = new ArrayList<String>();
    private SurvivalStrategies strategyToSurvive;

    public Strategy(SurvivalStrategies strategyToSurvive) {
        this.strategyToSurvive = strategyToSurvive;
        setLifegoals();
    }

    /**
     * chooses the number of and the life goals of a squirrel.
     * Sets the lifegoals to the randomly chosen elements.
     */
    private void setLifegoals() {
        // Maximum number of life goals: 3
        int numberOfLifegoals = (new Random()).nextInt(4);
        if (numberOfLifegoals == 0) {
            numberOfLifegoals = 1;
        }
        for (int i = 0; i < numberOfLifegoals; i++) {
            int random = (new Random()).nextInt(4);
            if (!lifegoals.contains(allLifegoals[random])) {
                this.lifegoals.add(allLifegoals[random]);
            } else {
                i -= 1;
            }
        }
    }

    public List<String> getLifegoals() {
        return lifegoals;
    }

    public SurvivalStrategies getStrategyToSurvive() {
        return strategyToSurvive;
    }
}
