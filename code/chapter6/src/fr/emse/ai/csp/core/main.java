package fr.emse.ai.csp.core;

import fr.emse.ai.csp.Queens.Fourqueens;
import fr.emse.ai.csp.Queens.Nqueens;
import fr.emse.ai.csp.australia.MapCSP;

import java.util.Scanner;

public class main {
        public static void main(String[] args) {
                MapCSP map = new MapCSP();
                Fourqueens queens = new Fourqueens();
              //  System.out.println("n queens: ");
               // Nqueens nqueens = new Nqueens();
               BacktrackingStrategy bts = new BacktrackingStrategy();
                //MinConflictsStrategy bts = new MinConflictsStrategy(14);
               //new AC3Strategy().reduceDomains(map);
               bts.addCSPStateListener(new CSPStateListener() {
                        @Override
                        public void stateChanged(Assignment assignment, CSP csp) {
                                System.out.println("Assignment evolved : " + assignment);
                        }

                        @Override
                        public void stateChanged(CSP csp) {
                                System.out.println("CSP evolved : " + csp);
                        }
                });
                double start = System.currentTimeMillis();
                Assignment sol = bts.solve(map);
               // Assignment sol = bts.solve(nqueens);
                //Assignment sol = new BacktrackingStrategy().solve(map);
                double end = System.currentTimeMillis();
                System.out.println(sol);
                System.out.println("Time to solve = " + (end - start));
        }
}