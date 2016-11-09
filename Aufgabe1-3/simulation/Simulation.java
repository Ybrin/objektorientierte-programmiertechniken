package simulation;

import animals.*;
import calculation.Calculation;
import ecosystem.Ecosystem;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.function.Predicate;

/**
 * Created by koray on 19/10/2016.
 */
public class Simulation {

    //used to find amount of available food
    private int amountHumans;

    private int amountTrees;

    private List<Squirrel> squirrels = new ArrayList<Squirrel>();
    private List<Predator> predators = new ArrayList<Predator>();

    private Ecosystem ecosystem;

    private List<Squirrel> deadSquirrels = new ArrayList<Squirrel>();

    /**
     * Initializes a new Simulation which calculates new years and the resulting amount of squirrels
     *
     * @param initialSquirrels The initial amount of squirrels
     * @param initialPredators The initial amount of predators
     * @param initialTrees     The initial amount of trees
     */
    public Simulation(int initialSquirrels, int initialPredators, int initialTrees, int amountHumans) {
        this.amountTrees = initialTrees;

        this.amountHumans = amountHumans;

        this.ecosystem = new Ecosystem(Calculation.getNewAmountOfFindableFood(amountTrees, 0, amountHumans));

        initialAnimalCreation(initialSquirrels, initialPredators);
    }

    /**
     * Calculates a new year pass for this Simulation system
     */
    public void calculateNewYear() {
        calculateAnimalsYearPass();
        calculateSquirrelChildBearing(squirrels);
        calculatePredatorChildBearing(predators);

        int newTrees = Calculation.getNewAmountOfTrees(amountTrees, (int) (ecosystem.getAmountOfFindableFood() * 0.8), false);
        newTrees += Calculation.getNewAmountOfTrees(amountTrees, (int) (ecosystem.getAmountOfFindableFood() * 0.2), true);

        // Some trees die
        amountTrees = amountTrees - (int) (amountTrees * ((Math.random() > 0.5) ? 0.1 : 0.2));

        // Calculate new food for next year
        ecosystem.setAmountOfFindableFood(Calculation.getNewAmountOfFindableFood(amountTrees, newTrees, amountHumans));

        // Add new trees
        amountTrees += newTrees;
    }

    private void initialAnimalCreation(int amountSquirrels, int amountPredators) {
        for (int i = 0; i < amountSquirrels; i++) {
            Squirrel squirrel = new Squirrel((int) (60 * Math.random()), (int) (2 * Math.random()), (Math.random() > 0.5) ? Sex.MALE : Sex.FEMALE, randomStrategy());

            squirrels.add(squirrel);
        }

        for (int i = 0; i < amountPredators; i++) {
            int survival = (int) (4 * Math.random()) + 2;
            Predator predator = new Predator(survival, survival + 2, randomStrategy(), (Math.random() > 0.5) ? Sex.MALE : Sex.FEMALE);

            predators.add(predator);
        }
    }

    /**
     * Calculates a year pass for all animals
     */
    private void calculateAnimalsYearPass() {
        // Squirrels
        for (Squirrel squirrel : squirrels) {
            double rank = 1;
            if (squirrel.getStrategy().getLifegoals().contains("many & comfortable nests")) {
                rank -= 0.0;
            }
            if (squirrel.getStrategy().getLifegoals().contains("prolific")) {
                rank -= 0.1;
            }
            if (squirrel.getStrategy().getLifegoals().contains("delimitation & expansion of territory")) {
                rank += 1.6;
            }
            if (squirrel.getStrategy().getLifegoals().contains("achievement & observance of dominance")) {
                rank += 2.8;
            }

            int food = (int) (squirrel.getNeeded_food_for_Survival() * rank);
            food = (ecosystem.getAmountOfFindableFood() >= food) ? food : ecosystem.getAmountOfFindableFood();

            ecosystem.setAmountOfFindableFood(ecosystem.getAmountOfFindableFood() - food);

            // 20% probability for a region to be inhabited by human
            squirrel.calculateYearPass(food, Calculation.healthyFood((Math.random() > 0.8)));
        }

        for (Iterator<Squirrel> iter = squirrels.listIterator(); iter.hasNext(); ) {
            Squirrel s = iter.next();
            if (s.isDead()) {
                deadSquirrels.add(s);
                iter.remove();
            }
        }

        // Predators
        for (Predator predator : predators) {
            double rank = 1;
            if (predator.getStrategy().getLifegoals().contains("many & comfortable nests")) {
                rank -= 0.1;
            }
            if (predator.getStrategy().getLifegoals().contains("prolific")) {
                rank -= 0.2;
            }
            if (predator.getStrategy().getLifegoals().contains("delimitation & expansion of territory")) {
                rank += 0.4;
            }
            if (predator.getStrategy().getLifegoals().contains("achievement & observance of dominance")) {
                rank += 0.5;
            }

            int food = (int) (predator.getNeeded_food_for_Survival() * rank);
            food = (squirrels.size() >= food) ? food : squirrels.size();

            for (int i = 0; i < food; i++) {
                int e = (new Random()).nextInt(squirrels.size());
                squirrels.get(e).setEaten();
                deadSquirrels.add(squirrels.get(e));
                squirrels.remove(e);
            }

            // 20% probability for a region to be inhabited by human
            predator.calculateYearPass(food, Calculation.healthyFood((Math.random() > 0.8)));
        }

        for (Iterator<Predator> iter = predators.listIterator(); iter.hasNext(); ) {
            Predator p = iter.next();
            if (p.isDead()) {
                iter.remove();
            }
        }
    }

    /**
     * Calculates and creates new elements of squirrels born
     *
     * @param animals The list of squirrels
     */
    private void calculateSquirrelChildBearing(List<Squirrel> animals) {
        List<Squirrel> male = new ArrayList<Squirrel>();
        List<Squirrel> female = new ArrayList<Squirrel>();
        for (Squirrel animal : animals) {
            if (animal.getSex() == Sex.MALE && animal.isProlific()) {
                male.add(animal);
            } else if (animal.getSex() == Sex.FEMALE && animal.isProlific()) {
                female.add(animal);
            }
        }

        if (male.size() != 0 && female.size() != 0) {
            while (male.size() > female.size()) {
                male.remove(0);
            }
            while (female.size() > male.size()) {
                female.remove(0);
            }

            for (Squirrel aFemale : female) {
                // TODO This is not beautiful, this should be changed to be more dynamic
                Squirrel squirrelOne = new Squirrel(aFemale.getNeeded_food_for_Survival(), 0, Sex.random(), aFemale.getStrategy());
                Squirrel squirrelTwo = new Squirrel(aFemale.getNeeded_food_for_Survival(), 0, Sex.random(), aFemale.getStrategy());
                Squirrel squirrelThree = new Squirrel(aFemale.getNeeded_food_for_Survival(), 0, Sex.random(), aFemale.getStrategy());

                animals.add(squirrelOne);
                animals.add(squirrelTwo);
                animals.add(squirrelThree);
            }
        }
    }

    /**
     * Calculates and creates new elements of squirrels born
     *
     * @param animals The list of squirrels
     */
    private void calculatePredatorChildBearing(List<Predator> animals) {
        List<Predator> male = new ArrayList<Predator>();
        List<Predator> female = new ArrayList<Predator>();
        for (Predator animal : animals) {
            if (animal.getSex() == Sex.MALE && animal.isProlific()) {
                male.add(animal);
            } else if (animal.getSex() == Sex.FEMALE && animal.isProlific()) {
                female.add(animal);
            }
        }

        if (male.size() != 0 && female.size() != 0) {
            while (male.size() > female.size()) {
                male.remove(0);
            }
            while (female.size() > male.size()) {
                female.remove(0);
            }

            for (Predator aFemale : female) {
                // TODO This is not beautiful, this should be changed to be more dynamic
                Predator predatorOne = new Predator(aFemale.getNeeded_food_for_Survival(), aFemale.getNeeded_food_for_childbearing(), aFemale.getStrategy(), Sex.random());
                Predator predatorTwo = new Predator(aFemale.getNeeded_food_for_Survival(), aFemale.getNeeded_food_for_childbearing(), aFemale.getStrategy(), Sex.random());

                animals.add(predatorOne);
                animals.add(predatorTwo);
            }
        }
    }

    /**
     * Generates a random Strategy
     *
     * @return A Strategy
     */
    private Strategy randomStrategy() {
        Random random = new Random();

        SurvivalStrategies survivalStrategies = SurvivalStrategies.COMBINATING;

        switch (random.nextInt(4)) {
            case 0:
                survivalStrategies = SurvivalStrategies.COLLECTING;
                break;
            case 1:
                survivalStrategies = SurvivalStrategies.COMBINATING;
                break;
            case 2:
                survivalStrategies = SurvivalStrategies.STEALING;
                break;
            case 3:
                survivalStrategies = SurvivalStrategies.TOBEFED;
        }

        return new Strategy(survivalStrategies);
    }


    // Getters

    public int getAmountHumans() {
        return amountHumans;
    }

    public int getAmountSquirrels() {
        return squirrels.size();
    }

    public int getAmountPredators() {
        return predators.size();
    }

    public int getAmountTrees() {
        return amountTrees;
    }

    public int getDeadSquirrelsBySenility() {
        int dead = 0;
        for (Squirrel s : deadSquirrels) {
            if (s.getDeathReason() == DeathReason.SENILITY) dead++;
        }
        return dead;
    }

    public int getDeadSquirrelsByEaten() {
        int dead = 0;
        for (Squirrel s : deadSquirrels) {
            if (s.getDeathReason() == DeathReason.EATEN) dead++;
        }
        return dead;
    }

    public int getDeadSquirrelsByStarved() {
        int dead = 0;
        for (Squirrel s : deadSquirrels) {
            if (s.getDeathReason() == DeathReason.STARVED) dead++;
        }
        return dead;
    }
}
