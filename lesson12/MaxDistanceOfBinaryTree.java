package lesson12;

import util.BinaryTreeNode;

public class MaxDistanceOfBinaryTree {

    public static int getMaxDistance(BinaryTreeNode head) {
        return processBinaryTreeNode(head).maxDistance;
    }
    
    public static class Info {
        public int maxDistance;
        public int h;

        public Info(int maxDistance, int h) {
            this.maxDistance = maxDistance;
            this.h = h;
        }
    }

    public static Info processBinaryTreeNode(BinaryTreeNode head) {
        //base case
        if (head == null) {
            return new Info(0, 0);
        }
        // Info from both sub trees
        Info leftInfo = processBinaryTreeNode(head.left);
        Info rightInfo = processBinaryTreeNode(head.right);
        // return max Distance of this tree
        int maxDis = Math.max(leftInfo.h + rightInfo.h + 1, Math.max(leftInfo.maxDistance, rightInfo.maxDistance));
        int h = Math.max(leftInfo.h, rightInfo.h) + 1;
        return new Info(maxDis, h);
    }
}
