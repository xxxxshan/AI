package fr.emse.ai.search.simple;

import fr.emse.ai.search.core.Problem;

import java.util.ArrayList;
import java.util.Collection;

public class TwoCansGraph implements Problem {
    final public static int MaxA=15;
    final public static int MaxB=5;
    TwoCansState initialState = new TwoCansState(12,4);
    TwoCansState finalState= new TwoCansState(0,5);

    @Override
    public Object getInitialState() {
        return initialState;
    }
    @Override
    public boolean isGoal(Object s){
        TwoCansState t = (TwoCansState)s;
        return ((t.equals(finalState)));
    }
    @Override
    public boolean isValid(Object s){
        TwoCansState a = ((TwoCansState)s);

            return a.nowA>=0 && a.nowB>=0;

    }
    @Override
    public Collection<Object> getActions(Object s){
        ArrayList<Object> actions = new ArrayList<Object>();
        TwoCansState b = ((TwoCansState)s);
        actions.add("action: empty A");
        actions.add("action: empty B");
        if ((b.nowA+b.nowB)>=MaxB){
        actions.add("action: filled B");}
        if ((b.nowA+b.nowB)>=MaxA){
            actions.add("action: filled A");}
        if ((b.nowA+b.nowB)<MaxB){
            actions.add("action: pour all water from A into B");}
        if ((b.nowA+b.nowB)<MaxA){
            actions.add("action: pour all water from B into A");}
        return actions;
    }
    @Override
    public Object getNextState(Object s,Object action){
        TwoCansState n=((TwoCansState)s);
        int tempB= n.nowB;
        int tempA= n.nowA;
        if (action.equals("action: empty A")){
            return new TwoCansState(0,tempB);}
        if (action.equals("action: empty B")){
            return new TwoCansState(tempA,0);}
        if (action.equals("action: filled B")){
            return new TwoCansState(tempA+(-MaxB+tempB),MaxB);}
        if (action.equals("action: filled A")){
            return new TwoCansState(MaxA,tempB-MaxA+tempA);}
        if (action.equals("action: pour all water from A into B")){
            return new TwoCansState(0,tempB+tempA);}
        if (action.equals("action: pour all water from B into A")){
            return new TwoCansState(tempA+tempB,0);}
        return null;
    }
    @Override
    public double getStepCost(Object s,Object action,Object dest){
        return 1;
    }
}
