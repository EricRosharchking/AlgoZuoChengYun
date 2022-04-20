package lesson14;

public class AVLTree {
    
    private void rebalance(AVLNode node) {
        while (node != null) {
            AVLNode parent = node.parent;
            int leftHeight = node.left == null ? -1 : node.left.height;
            int rightHeight = node.right == null ? -1 : node.right.height;
            int nodeBalance = rightHeight - leftHeight;
            if (nodeBalance == 2) {
                // means right subtree is the unbalanced reason
                if (node.right.right != null) {
                    // RR shape
                    node = avlRotateLeft(node);
                    break;
                } else {
                    // RL shape
                    node = doubleRotateRightLeft(node);
                    break;
                }
            } else if (nodeBalance == -2) {
                //means left subtree is the unbalanced reason
                if (node.left.left != null) {
                    // LL shape
                    node = avlRotateRight(node);
                    break;
                } else {
                    // LR shape
                    node = doubleRotateLeftRight(node);
                    break;
                }
            } else {
                updateHeight(node);
            }
        }
    }

    private AVLNode avlRotateLeft(AVLNode node) {
        
    }

    static class AVLNode{
        public AVLNode left, right, parent;
        public int height;
    }
}
