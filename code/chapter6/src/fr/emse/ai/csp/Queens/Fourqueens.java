package fr.emse.ai.csp.Queens;

import fr.emse.ai.csp.core.CSP;
import fr.emse.ai.csp.core.Domain;
import fr.emse.ai.csp.core.ConstraintQueens;
import fr.emse.ai.csp.core.Variable;

import java.util.ArrayList;
import java.util.List;

public class Fourqueens extends CSP{

    public static final Variable Q1 = new Variable("Q1");
    public static final Variable Q2 = new Variable("Q2");
    public static final Variable Q3 = new Variable("Q3");
    public static final Variable Q4 = new Variable("Q4");

    public Fourqueens(){

        for (int i=1;i<=4;i++){
            String name = "Q"+i;
            Variable Q = new Variable(name);
            collectVariables(Q);
        }

        //collectVariables();
        Domain pos = new Domain(new Object[]{1,2,3,4});
        /*List<Object> list = new ArrayList<>();
        for (int i=1;i<=4;i++){list.add(i);}
        Domain pos = new Domain(list);
        */
        for (Variable var : getVariables())
            setDomain(var, pos);

        addConstraint(new ConstraintQueens(Q1,Q2));
        addConstraint(new ConstraintQueens(Q1,Q3));
        addConstraint(new ConstraintQueens(Q1,Q4));
        addConstraint(new ConstraintQueens(Q2,Q3));
        addConstraint(new ConstraintQueens(Q2,Q4));
        addConstraint(new ConstraintQueens(Q3,Q4));
    }

    private void collectVariables(Variable Q){
        addVariable(Q);
        /*addVariable(Q2);
        addVariable(Q3);
        addVariable(Q4);
        */
    }

}
