package fr.emse.ai.csp.core;

import java.util.ArrayList;
import java.util.List;

public class ConstraintQueens implements Constraint {
    private Variable var1;
    private Variable var2;
    private List<Variable> scope;

    public ConstraintQueens(Variable var1, Variable var2){
        this.var1 = var1;
        this.var2 = var2;
        scope = new ArrayList<Variable>(2);
        scope.add(var1);
        scope.add(var2);
    }
    @Override
    public List<Variable> getScope(){ return scope;}

    @Override
    public  boolean isSatisfiedWith(Assignment assignment) {
        Object a = assignment.getAssignment(var1);
        Object b = assignment.getAssignment(var2);
        if (a == null|| b == null){return true;}
        else{
        int value1 = getN(assignment.getAssignment(var1).toString());
        int value2 = getN(assignment.getAssignment(var2).toString());
        int v1 = getN(var1.toString());//qn->n
        int v2 = getN(var2.toString());

        if ((value1 != value2 && v1 - value1 != v2 - value2 && v1+value1 != v2+value2)) {return true;}
        }
        return false;
    }

    public int getN(String o) {
        for (int i = 1; i < 5; i++) {
            String j = "" + i;
            if (o.contains(j)) {
                return i;
            }
        }
        return -1;
    }
}


