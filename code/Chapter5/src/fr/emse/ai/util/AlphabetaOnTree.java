package fr.emse.ai.util;

public class AlphabetaOnTree {
    int a = -10000;
    int b = 10000;
    public static int alphab(SimpleTwoPlyGameTree<Integer>tree){
        if (tree.isLeaf())
            return tree.getValue();

        else {

            int minmax = tree.getValue();
            if (tree.isMax()) {
                for (SimpleTwoPlyGameTree<Integer> child : tree.getChildren()) {
                    minmax = Math.max(alphab(child), minmax);//包含child节点则 继续调用 minimax(该节点) recursive call
                }
                tree.setValue((Integer) minmax);
                return minmax;
            } else {
                for (SimpleTwoPlyGameTree<Integer> child : tree.getChildren()) {
                    minmax = Math.min(alphab(child), minmax);
                }
                tree.setValue((Integer)minmax);
                return minmax;


            }
        }


    }
}



