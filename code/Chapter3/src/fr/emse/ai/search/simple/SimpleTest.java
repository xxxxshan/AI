package fr.emse.ai.search.simple;

import fr.emse.ai.search.solver.DepthFirstGraphSearch;

public class SimpleTest {

    public static void main(String[] args) {
        //TwoCansGraph p1 = new TwoCansGraph();
        FarmerGraph p1 = new FarmerGraph();
         //SimpleNotOrientedGraphProblem p1 = new SimpleNotOrientedGraphProblem();
        //M_C_NotOrient p1 =new M_C_NotOrient();
        //SimpleOrientedGraphProblem p1 = new SimpleOrientedGraphProblem();
        System.out.println("Solution to problem using breath first : ");
       System.out.println(new DepthFirstGraphSearch().solve(p1).pathToString());
       //System.out.println(new BreathFirstGraphSearch().solve(p1).pathToString());
    }
}