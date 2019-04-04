package fr.emse.ai.search.solver;

import fr.emse.ai.search.core.AbstractGraphSearch;
import fr.emse.ai.search.core.Node;
import fr.emse.ai.search.core.Problem;

import java.util.Collection;
import java.util.LinkedList;

public class BreathFirstGraphSearch extends AbstractGraphSearch {

    public Collection<Node> initFrontier(){

        return new LinkedList<Node>();//linkedlist 一个队列 Node 为队列
    }
    public Node chooseLeafNode(Collection<Node> frontier, Problem problem){
        return((LinkedList<Node>) frontier).poll();//poll 删除并返回队列第一个元素
    }
}
