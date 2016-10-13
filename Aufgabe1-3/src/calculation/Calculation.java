package calculation;

import population.Group;
import population.Population;
import population.Strategy;

import java.util.Map;

/**
 * Created by Sabrina on 12.10.2016.
 */
public class Calculation {

    /**
     * returns strategy of given group
     * @param group group of squirrels
     * @return Strategy strategy of group of squirrels
     *
     * rendomised Strategy
     */
    public static Strategy getGroupStrategy(Group group){
        int ran= (int)Math.round(Math.random()*3);

        if(ran==0){
            return Strategy.TOBEFED;
        }else if(ran==1){
            return Strategy.COLLECTING;
        }else if(ran==2){
            return Strategy.STEALING;
        }else if(ran==3){
            return Strategy.COMBINATING;
        }
        return null;
    }

    /**
     * calculates new size of the group after one year
     * @param group group of squirrels
     * @return int new size of group of squirrel
     *
     *
     * eventualy to change: did not use percent for 3 strategies and /or adjust percent for the last
     */
    public static int calculateGroupsizeAfterAYear (Group group){
        int size=group.getGroupsize();
        int surviving=group.getGroupsize()-(int)Math.round(group.getGroupsize()*group.getDeathRate());

        if(Strategy.TOBEFED==group.getStrategy()){
            surviving-=(int)Math.round(group.getGroupsize()*0.2);
            if(group.getFedFoodPerIndividual()*size/30>surviving){
                int leftamount=((int)group.getFedFoodPerIndividual()*size-surviving)*30;
                if(leftamount>20){
                    int notuseable=leftamount%20;
                    int calculate=leftamount-notuseable;
                    int parents=calculate/20;
                    surviving+=parents*2;
                }
            }else{
                surviving=(int)(group.getFedFoodPerIndividual()*size/30);
            }
            return surviving;

        }else if(Strategy.STEALING==group.getStrategy()){
            surviving-=(int)Math.round(group.getGroupsize()*0.2);// random number of squirrels dieing while hunting
            if(group.getHuntableFoodPerIndiviual()*size/30>surviving){
                int leftamount=((group.getHuntableFoodPerIndiviual()*size)-surviving)*30;
                if(leftamount>20){
                    int notuseable=leftamount%20;
                    int calculate=leftamount-notuseable;
                    int parents=calculate/20;
                    surviving+=parents*2;
                }
            }else{
                surviving=(int)((group.getHuntableFoodPerIndiviual()*size)/30);
            }
            return surviving;
        }else if(Strategy.COLLECTING==group.getStrategy()){
            surviving-=(int)Math.round(group.getGroupsize()*0.2);
            if(group.getCollectedFoodPerIndividual()*size/30>surviving){
                int leftamount=((int)group.getCollectedFoodPerIndividual()*size-surviving)*30;
                if(leftamount>20){
                    int notuseable=leftamount%20;
                    int calculate=leftamount-notuseable;
                    int parents=calculate/20;
                    surviving+=parents*2;
                }
            }else{
                surviving=(int)(group.getCollectedFoodPerIndividual()*size/30);
            }
            return surviving;

        }else  if(Strategy.COMBINATING==group.getStrategy()){
            surviving-=(int)Math.round(group.getGroupsize()*0.4);

            int founffood= (int)(group.getHuntableFoodPerIndiviual()*size*group.getFoundForeignFood());
            int ownfood=(int)(group.getCollectedFoodPerIndividual()*size*group.getRecoveredOwnFood());
            int fedfood= (int)(group.getFedFoodPerIndividual()*size*group.getFoundFedFood());
            int totalamount=fedfood+ownfood+founffood;

            if(totalamount/30>surviving){
                int leftamount=(totalamount-surviving)*30;
                if(leftamount>20){
                    int notuseable=leftamount%20;
                    int calculate=leftamount-notuseable;
                    int parents=calculate/20;
                    surviving+=parents*2;
                }
            }else{
                surviving=totalamount/30;
            }
            return surviving;
        }
        return surviving;
    }


    /**
     * returns the total number of food collected by all groups
     * @param population total population of squirrels
     * @return int total number of food collected by all groups
     */
    public static int getTotalAmountOfFood (Population population){
        int totalamout=0;
        for(Group group:population.getGroups()){
            int size= group.getGroupsize();
            if(group.getStrategy()==Strategy.COLLECTING){
                totalamout+=group.getCollectedFoodPerIndividual()*size;
            }else if(group.getStrategy()==Strategy.STEALING){
                totalamout+=group.getHuntableFoodPerIndiviual()*size;
            }else if(group.getStrategy()==Strategy.TOBEFED){
                totalamout+=group.getFedFoodPerIndividual()*size;
            }else if(group.getStrategy()==Strategy.COMBINATING){
                int founffood= (int)(group.getHuntableFoodPerIndiviual()*size*group.getFoundForeignFood());
                int ownfood=(int)(group.getCollectedFoodPerIndividual()*size*group.getRecoveredOwnFood());
                int fedfood= (int)(group.getFedFoodPerIndividual()*size*group.getFoundFedFood());
                totalamout=fedfood+ownfood+founffood;
            }
        }
        return totalamout;
    }


    /**
     * returns the total amount of food for given group
     * @param group group of squirrels
     * @return int total number of food for given group
     */
    public static int getTotalAmountOfFoodPerGroup(Group group){
        int totalamout=0;
        int size= group.getGroupsize();
        if(group.getStrategy()==Strategy.COLLECTING){
            totalamout+=group.getCollectedFoodPerIndividual()*size;
        }else if(group.getStrategy()==Strategy.STEALING){
            totalamout+=group.getHuntableFoodPerIndiviual()*size;
        }else if(group.getStrategy()==Strategy.TOBEFED){
            totalamout+=group.getFedFoodPerIndividual()*size;
        }else if(group.getStrategy()==Strategy.COMBINATING){
            int founffood= (int)(group.getHuntableFoodPerIndiviual()*size*group.getFoundForeignFood());
            int ownfood=(int)(group.getCollectedFoodPerIndividual()*size*group.getRecoveredOwnFood());
            int fedfood= (int)(group.getFedFoodPerIndividual()*size*group.getFoundFedFood());
            totalamout=fedfood+ownfood+founffood;
        }
        return totalamout;
    }





}
