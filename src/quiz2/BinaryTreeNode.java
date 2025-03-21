package quiz2;

public class BinaryTreeNode<A> {
    private A value;
    private BinaryTreeNode<A> left;
    private BinaryTreeNode<A> right;

    public BinaryTreeNode(A value, BinaryTreeNode<A> left, BinaryTreeNode<A> right) {
        this.value = value;
        this.right = right;
        this.left = left;
    }

    public A getValue() {
        return value;
    }

    public void setValue(A value) {
        this.value = value;
    }

    public BinaryTreeNode<A> getLeft() {
        return left;
    }

    public void setLeft(BinaryTreeNode<A> left) {
        this.left = left;
    }

    public BinaryTreeNode<A> getRight() {
        return right;
    }

    public void setRight(BinaryTreeNode<A> right) {
        this.right = right;
    }

    public String preOrderTraversal(BinaryTreeNode<A> node) {
        if (node != null) {
            String out = "";
            out += node.value.toString() + " ";
            out += preOrderTraversal(node.left);
            out += preOrderTraversal(node.right);
            return out;
        } else {
            return "";
        }
    }

    public String postOrderTraversal(BinaryTreeNode<A> node) {
        if (node != null) {
            String out = "";
            out += postOrderTraversal(node.left);
            out += postOrderTraversal(node.right);
            out += node.value.toString() + " ";
            return out;
        } else {
            return "";
        }
    }

    public String inOrderTraversal(BinaryTreeNode<A> node) {
        if (node != null) {
            String out = "";
            out += inOrderTraversal(node.left);
            out += node.value.toString() + " ";
            out += inOrderTraversal(node.right);
            return out;
        } else {
            return "";
        }
    }

}
