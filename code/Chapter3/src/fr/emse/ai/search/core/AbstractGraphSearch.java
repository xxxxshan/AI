package fr.emse.ai.search.core;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;

/**
 * Created with IntelliJ IDEA.
 * User: picard (picard@emse.fr)
 * Date: 09/09/15
 * Time: 15:41
 */
public abstract class AbstractGraphSearch implements SearchGraph {

    Collection<Node> frontier;

    public Node solve(Problem problem) {
        // initialize fringe 初始化
        System.out.println("Solving...");

        LinkedList<Node> explored = new LinkedList<Node>();

        frontier = initFrontier();
        frontier.addAll(expand(new Node(problem.getInitialState()), problem, explored));
        System.out.println("Starting frontier is " + frontier);
        boolean done = false;
        Node solution = null;
        //开始循环
        while (!done) {
            if (frontier.isEmpty()) {
                System.out.println("No more nodes in frontier => FAILURE");//未探索为空 失败
                done = true;
            } else {//
                Node node = chooseLeafNode(frontier, problem);
                System.out.println("Inspecting node " + node);//检查节点
                if (problem.isGoal(node.getState())) {
                    System.out.println("Goal node reached => SUCCESS");
                    solution = node;
                    done = true;
                } else {
                    explored.add(node);
                   // boolean pan = problem.isValid(node.getState());
                    //如何判断？
                    frontier.addAll(expand(node, problem,explored));//继续探索


                    System.out.println("Expanding node, frontier is " + frontier);

                }
            }
        }
        return solution;
    }

    public Collection<Node> expand(Node node, Problem problem,LinkedList<Node> explored) {
        Collection<Node> nodes = new ArrayList<Node>();
        Collection<Object> actions = problem.getActions(node.getState());
        //Collection<Node> temps = new ArrayList<Node>();
        for (Object action : actions) {
            Object next = problem.getNextState(node.getState(), action);
            if ((problem.isValid(next))){

            Node t=new Node(next, node, action, problem.getStepCost(node.getState(), action, next));
                if (!(isexplored(t,explored))){
                    nodes.add(t);
                }
            }
        }
        return nodes;
    }

    public abstract Collection<Node> initFrontier();



    public abstract Node chooseLeafNode(Collection<Node> frontier, Problem problem);

    public boolean isexplored(Node node,LinkedList<Node> explored) {
        if (explored.isEmpty()) {return false;}
        for (Node n : explored) {

            if (n.getState().equals(node.getState())) {
                return true;
            }
        }
        return false;
    }
}

