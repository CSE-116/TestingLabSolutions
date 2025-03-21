package quiz2;

import java.util.ArrayList;

public class TreeToArrayList {
    public static ArrayList<Integer> traverse(BinaryTreeNode<Integer> node) {
        ArrayList<Integer> list = new ArrayList<>();
        if (node != null) {
            list = traverse(node.getLeft());
            list.add(node.getValue());
            list.addAll(traverse(node.getRight()));
            return list;
        }
            return list;
    }
}
