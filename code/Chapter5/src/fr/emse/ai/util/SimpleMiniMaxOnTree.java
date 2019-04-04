package fr.emse.ai.util;

public class SimpleMiniMaxOnTree {
    public static int minimax(SimpleTwoPlyGameTree<Integer> tree) {
        if (tree.isLeaf())//子节点为空 则查询结点值
            return tree.getValue();
        else {
            int minmax = tree.getValue();
            if (tree.isMax()) {
                for (SimpleTwoPlyGameTree<Integer> child : tree.getChildren()) {
                    minmax = Math.max(minimax(child), minmax);//包含child节点则 继续调用 minimax(该节点) recursive call
                }
                tree.setValue((Integer) minmax);
                return minmax;
            } else {
                for (SimpleTwoPlyGameTree<Integer> child : tree.getChildren()) {
                    minmax = Math.min(minimax(child), minmax);
                }
                tree.setValue((Integer)minmax);
                return minmax;


            }
        }


    }
}




