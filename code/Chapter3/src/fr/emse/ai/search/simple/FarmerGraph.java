package fr.emse.ai.search.simple;

import fr.emse.ai.search.core.Problem;

import java.util.ArrayList;
import java.util.Collection;


public class FarmerGraph implements Problem {
    FarmerState initialState = new FarmerState(0, 0, 0, 0, Boat.This);
    FarmerState finalState = new FarmerState(1, 1, 1, 1, Boat.That);

    @Override
    public Object getInitialState() {
        return initialState;
    }

    @Override
    public boolean isGoal(Object state) {
        FarmerState g = (FarmerState) state;
        return (g.equals(finalState));
    }

    @Override
    public boolean isValid(Object state) {
        FarmerState n = (FarmerState) state;
        return n.Farmer>=0 && n.Farmer<=1 && n.Cabbage>=0 && n.Cabbage<=1
                && n.Goat>=0 && n.Goat<=1 && n.Wolf>=0 && n.Wolf<=1
                && (!(n.Farmer == 0 && n.Goat == 1 && n.Cabbage == 1)) && (!(n.Farmer== 1 && n.Goat == 0 && n.Cabbage == 0))
                && (!(n.Farmer == 0 && n.Goat == 1 && n.Wolf == 1)) && (!(n.Farmer == 1 && n.Goat == 0 && n.Wolf == 0));
    }

    @Override
    public Collection<Object> getActions(Object state) {
        ArrayList<Object> actions = new ArrayList<Object>();
        FarmerState s = ((FarmerState) state);
        if (s.boat==Boat.This){

            actions.add("action: Farmer moves to that side");
            actions.add("action: Farmer and Goat move to that side");
            actions.add("action: Farmer and Wolf move to that side");
            actions.add("action: Farmer and Cabbage move to that side");

        }else if (s.boat==Boat.That){
            actions.add("action: Farmer moves back to this side");
            actions.add("action: Farmer and Goat move back to this side");
            actions.add("action: Farmer and Wolf move back to this side");
            actions.add("action: Farmer and Cabbage move back to this side");
        }
        return actions;
    }
    @Override
    public Object getNextState(Object state,Object action){
        FarmerState now = ((FarmerState)state);
        if (action.equals("action: Farmer moves to that side")){return new FarmerState(now.Farmer+1,now.Goat,now.Wolf,now.Cabbage,Boat.That);}
        if (action.equals("action: Farmer and Goat move to that side")){return new FarmerState(now.Farmer+1,now.Goat+1,now.Wolf,now.Cabbage,Boat.That);}
        if (action.equals("action: Farmer and Wolf move to that side")){return new FarmerState(now.Farmer+1,now.Goat,now.Wolf+1,now.Cabbage,Boat.That);}
        if (action.equals("action: Farmer and Cabbage move to that side")){return new FarmerState(now.Farmer+1,now.Goat,now.Wolf,now.Cabbage+1,Boat.That);}
        if (action.equals("action: Farmer moves back to this side")){return new FarmerState(now.Farmer-1,now.Goat,now.Wolf,now.Cabbage,Boat.This);}
        if (action.equals("action: Farmer and Goat move back to this side")){return new FarmerState(now.Farmer-1,now.Goat-1,now.Wolf,now.Cabbage,Boat.This);}
        if (action.equals("action: Farmer and Wolf move back to this side")){return new FarmerState(now.Farmer-1,now.Goat,now.Wolf-1,now.Cabbage,Boat.This);}
        if (action.equals("action: Farmer and Cabbage move back to this side")){return new FarmerState(now.Farmer-1,now.Goat,now.Wolf,now.Cabbage-1,Boat.This);}
        return null;
    }
    @Override
    public double getStepCost(Object start, Object action, Object dest) {
        return 1;
    }
}