package util;

public class BinaryTreeNode {
    public BinaryTreeNode left;
    public BinaryTreeNode right;
    public int val;

    public BinaryTreeNode(int val, BinaryTreeNode left, BinaryTreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public BinaryTreeNode(int val) {
        this.val = val;
    }
}
