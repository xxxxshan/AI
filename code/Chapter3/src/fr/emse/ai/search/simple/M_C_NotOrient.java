package fr.emse.ai.search.simple;


import fr.emse.ai.search.core.Problem;

import java.util.ArrayList;
import java.util.Collection;


public class M_C_NotOrient implements Problem{

    M_C_State initialState = new M_C_State(3,3,Position.LEFT,0,0);
    M_C_State finalState = new M_C_State(0,0,Position.RIGHT,3,3);
    @Override
    public Object getInitialState() {
        return initialState;
    }

    @Override
    public boolean isGoal(Object state) {
        M_C_State now= ((M_C_State)state);
        return (now.equals(finalState));//it spends me a longtime to figure out that "=="is different from "equals"
    }
    @Override
    public boolean isValid(Object state) {
        M_C_State now= ((M_C_State)state);
        if (now.missionaryLeft >= 0 && now.missionaryRight >= 0 && now.cannibalLeft >= 0 && now.cannibalRight >= 0
                && (now.missionaryLeft == 0 || now.missionaryLeft >= now.cannibalLeft)
                && (now.missionaryRight == 0 || now.missionaryRight >= now.cannibalRight)) {
            return true;
        }
        return false;
    }
    @Override //tree
    public Collection<Object> getActions(Object state) {
        ArrayList<Object> actions = new ArrayList<Object>();
        M_C_State s = ((M_C_State) state);

        if (s.boat==Position.LEFT) {
            actions.add("action: move 2 missionaries to right");
            actions.add("action: move 2 cannibals to right");
            actions.add("action: move 1 cannibal & 1 missionary to right");
            actions.add("action: move 1 cannibal to right");
            actions.add("action: move 1 missionary to right");
        } else if (s.boat==Position.RIGHT){
            actions.add("action: move 2 missionaries to left");
            actions.add("action: move 2 cannibals to left");
            actions.add("action: move 1 cannibal & 1 missionary to left");
            actions.add("action: move 1 cannibal to left");
            actions.add("action: move 1 missionary to left");
        }
        return actions;
    }
    @Override
    public Object getNextState(Object state, Object action) {
        M_C_State fresh =((M_C_State)state);

        if (action.equals("action: move 2 missionaries to right")) {return new M_C_State(fresh.cannibalLeft,fresh.missionaryLeft-2,Position.RIGHT,fresh.cannibalRight,fresh.missionaryRight+2);}
        if (action.equals("action: move 2 cannibals to right")) {return new M_C_State(fresh.cannibalLeft-2,fresh.missionaryLeft,Position.RIGHT,fresh.cannibalRight+2,fresh.missionaryRight);}
        if (action.equals("action: move 1 cannibal & 1 missionary to right")) {return new M_C_State(fresh.cannibalLeft-1,fresh.missionaryLeft-1,Position.RIGHT,fresh.cannibalRight+1,fresh.missionaryRight+1);}
        if (action.equals("action: move 1 missionary to right")) {return new M_C_State(fresh.cannibalLeft,fresh.missionaryLeft-1,Position.RIGHT,fresh.cannibalRight,fresh.missionaryRight+1);}
        if (action.equals("action: move 1 cannibal to right")) {return new M_C_State(fresh.cannibalLeft-1,fresh.missionaryLeft,Position.RIGHT,fresh.cannibalRight+1,fresh.missionaryRight);}
        if (action.equals("action: move 2 missionaries to left")) {return new M_C_State(fresh.cannibalLeft,fresh.missionaryLeft+2,Position.LEFT,fresh.cannibalRight,fresh.missionaryRight-2);}
        if (action.equals("action: move 2 cannibals to left")) {return new M_C_State(fresh.cannibalLeft+2,fresh.missionaryLeft,Position.LEFT,fresh.cannibalRight-2,fresh.missionaryRight);}
        if (action.equals("action: move 1 cannibal & 1 missionary to left")) {return new M_C_State(fresh.cannibalLeft+1,fresh.missionaryLeft+1,Position.LEFT,fresh.cannibalRight-1,fresh.missionaryRight-1);}
        if (action.equals("action: move 1 missionary to left")) {return new M_C_State(fresh.cannibalLeft,fresh.missionaryLeft+1,Position.LEFT,fresh.cannibalRight,fresh.missionaryRight-1);}
        if (action.equals("action: move 1 cannibal to left")) {return new M_C_State(fresh.cannibalLeft+1,fresh.missionaryLeft,Position.LEFT,fresh.cannibalRight-1,fresh.missionaryRight);}
        return  null;
    }
    @Override
    public double getStepCost(Object start, Object action, Object dest) {
        return 1;
    }
}
