package lesson5;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import util.BinaryTreeNode;

public class IsTree {

    public static boolean isCTBReccursive(BinaryTreeNode head) { // is complete binary tree
        
        return true;
    }
    public static boolean isCBTNonReccursive(BinaryTreeNode head) { // is complete binary tree
        if (head == null) {
            return true;
        }
        boolean leaf = false;
        Queue<BinaryTreeNode> queue = new LinkedList<>();
        queue.add(head);
        while(!queue.isEmpty()) {
            head = queue.poll();
            if (head.left == null && head.right != null) {
                return false;
            }
            if (head.left != null)
                queue.add(head.left);
            if (head.right != null)
                queue.add(head.right);
            if (head.left != null && head.right == null) {
                leaf = true;
            }
            if (head.left == null && head.right == null && leaf)
                return false;
        }
        return true;
    }

    //In-Order Traversed value is always increasing
    public static boolean isBSTNonReccursive(BinaryTreeNode head) { // is binary search tree
        if (head == null) {
            return true;
        }
        Stack<BinaryTreeNode> stack = new Stack<>();
        while (!stack.isEmpty() || head != null) {
            if (head != null) {
                stack.add(head);
                head = head.left;
            } else {
                BinaryTreeNode node = stack.pop();
                
                System.out.print(node.val + ",");
                head = node.right;
                if (head != null && head.val < node.val) {
                    return false;
                }
            }
        }
        return true;
    }

    public static BSTReturnType isBSTReccursive(BinaryTreeNode head) { // is binary search tree
        if (head == null)
            return null;

        BSTReturnType left = isBSTReccursive(head.left);
        BSTReturnType right = isBSTReccursive(head.right);

        if (left == null)
            left = new BSTReturnType(head.val, head.val, true);
        if (right == null)
            right = new BSTReturnType(head.val, head.val, true);
        return new BSTReturnType(left.minVal, right.maxVal,
                left.isBST && right.isBST && (left.maxVal <= head.val) && (right.minVal >= head.val));
    }

    public static class BSTReturnType {
        public int minVal;
        public int maxVal;
        public boolean isBST;

        public BSTReturnType() {
        }

        public BSTReturnType(int minVal, int maxVal, boolean isBST) {
            this.maxVal = maxVal;
            this.minVal = minVal;
            this.isBST = isBST;
        }
    }
}
