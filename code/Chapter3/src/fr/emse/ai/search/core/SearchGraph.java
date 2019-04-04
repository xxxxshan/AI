package fr.emse.ai.search.core;

import java.util.Collection;
import java.util.LinkedList;

public interface SearchGraph {
    public Node solve(Problem problem);
    public Collection<Node> expand(Node node, Problem problem, LinkedList<Node> explored);
}
