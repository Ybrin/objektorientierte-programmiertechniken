package ecosystem;

import simulation.Simulation;

/**
 * Created by koray on 19/10/2016.
 */
public class Ecosystem {

    Simulation simulation;

    int amountSquirrels;
    int amountTrees;
    int amountPreditors;
    int amountFodderThieve;
    int amountOfFindableFood;
    int space;
    int amountOfnewTrees;

    public Ecosystem(Simulation simulation, int amountSquirrels, int amountTrees, int amountOfFindableFood, int space, int amountOfnewTrees) {
        this.simulation = simulation;
        this.amountSquirrels = amountSquirrels;
        this.amountTrees = amountTrees;
        //first rendomised try
        this.amountPreditors = calculateAmoutOfPreditors();
        this.amountFodderThieve =calculateAmoutOfPreditors() ;
        this.amountOfFindableFood = amountOfFindableFood;
        this.space = space;
        this.amountOfnewTrees = amountOfnewTrees;
    }

    public Simulation getSimulation() {
        return simulation;
    }

    public void setSimulation(Simulation simulation) {
        this.simulation = simulation;
    }

    public int getAmountSquirrels() {
        return amountSquirrels;
    }

    public void setAmountSquirrels(int amountSquirrels) {
        this.amountSquirrels = amountSquirrels;
    }

    public int getAmountTrees() {
        return amountTrees;
    }

    public void setAmountTrees(int amountTrees) {
        this.amountTrees = amountTrees;
    }

    public int getAmountPreditors() {


        return amountPreditors;
    }

    public void setAmountPreditors(int amountPreditors) {
        this.amountPreditors = amountPreditors;
    }

    public void setAmountFodderThieve(int amountFodderThieve) {
        this.amountFodderThieve = amountFodderThieve;
    }

    public int getAmountFodderThieve() {
        return amountFodderThieve;
    }

    public int getAmountOfFindableFood() {
        return amountOfFindableFood;
    }

    public void setAmountOfFindableFood(int amountOfFindableFood) {
        this.amountOfFindableFood = amountOfFindableFood;
    }

    public int getSpace() {
        return space;
    }

    public void setSpace(int space) {
        this.space = space;
    }

    public int getAmountOfnewTrees() {
        return amountOfnewTrees;
    }

    public void setAmountOfnewTrees(int amountOfnewTrees) {
        this.amountOfnewTrees = amountOfnewTrees;
    }

    /**
     *
     * Try to calculate a randomised first calculation
     *
     * @return amount Preditor
     */
    private int calculateAmoutOfPreditors(){
        if(simulation.isInhabitedByHumans()==true){
            amountPreditors=(int)(amountSquirrels*(Math.random()*0.3));
        }else{
            amountPreditors=(int)(amountSquirrels*(Math.random()*0.7));
        }

        return amountPreditors;
    }


    /**
     *
     * Try to calculate a randomised first calculation
     *
     * @return amount fodder thievs
     */
    private int calculateAmountOfFodderThieve(){
        if(simulation.isInhabitedByHumans()==true){
            amountFodderThieve=(int)(amountSquirrels*(Math.random()*0.7));
        }else{
            amountFodderThieve=(int)(amountSquirrels*(Math.random())*0.5);
        }

        return amountFodderThieve;
    }



    /**
     *
     * calculates the new amount of Trees
     * seperats between inhabited places (human) and not inhabited
     *
     * @param amountOfLeftFood
     */
    public void newAmountOfTrees(int amountOfLeftFood){
        double tree =  0;
        if(amountOfLeftFood!=0){
           tree= amountOfLeftFood/2;
            amountOfnewTrees=(int)tree;
        }else{
            amountOfnewTrees=0;
        }
        tree += amountTrees;
        if(simulation.isInhabitedByHumans()==true){
            tree=tree-(tree*(Math.random()*(0.8)));
        }else{
            tree=tree-(tree*(Math.random()*(0.2)));
        }
       amountTrees= (int)tree;
    }

    /**
     *
     * calculates the findable food resorses (including findable food from human)
     *
     * @return amount of findable food in the arier
     */
    public int newAmoutOfFindableFood(){
        amountOfFindableFood=(amountTrees-amountOfnewTrees)*10;
        if(simulation.isInhabitedByHumans()==true){
            amountOfnewTrees+=(simulation.getAmountHumans())*(0.5+(Math.random()*(1-0.5)));

        }
        return amountOfFindableFood;
    }

    /**
     *
     * propability depends on inherited by humans or not
     *
     * @return if the food is healthie or not
     */
    public boolean helthyFood(){
        boolean health=true;
        if(simulation.isInhabitedByHumans()==true){
            if(Math.random()*1>0.6){
                health=false;
            }
        }else {
            if((Math.random()*1)>0.8){
                health=false;
            }
        }
        return health;
    }


}
