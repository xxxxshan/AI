package fr.emse.ai.csp.Queens;

import fr.emse.ai.csp.core.CSP;
import fr.emse.ai.csp.core.ConstraintQueens;
import fr.emse.ai.csp.core.Domain;
import fr.emse.ai.csp.core.Variable;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Nqueens extends CSP {

    public Nqueens(){
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        for (int i=1;i<=n;i++){
            String name = "Q"+i;
           Variable Q = new Variable(name);
            collectVariables(Q);
        }
        List<Object> list = new ArrayList<>();
        for (int i=1;i<=n;i++){list.add(i);}
        Domain pos = new Domain(list);
        for (Variable var : getVariables())
            setDomain(var,pos);

        for (Variable i : getVariables()){
            for (Variable j: getVariables()){
                if (!i.equals(j)){
                    addConstraint(new ConstraintQueens(i,j));
                }
            }
        }
    }
    private void collectVariables(Variable Q){
        addVariable(Q);
        }
    }

