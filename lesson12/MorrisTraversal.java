package lesson12;

import util.BinaryTreeNode;

public class MorrisTraversal {
    
    // well optimized version
    public static void morris(BinaryTreeNode head) {
        if (head == null) {
            return;
        }
        BinaryTreeNode curr = head;
        BinaryTreeNode rightMost = null;
        // traverse until curr points to null, there is no recursion
        while (curr != null) {
            // rightMost starts at curr's leftNode (head of curr's left subTree)
            rightMost = curr.left;
            // if curr has a left subTree
            if (rightMost != null) { 
                // find the right most node of the subTree, 
                // if curr has not been traversed, rightMost.right will be null
                // it curr has been traversed, rightMost.right will be curr
                while (rightMost.right != null && rightMost.right != curr) {
                    rightMost = rightMost.right;
                }
                // when rightMost.right is null, point it to curr, and curr moves left
                // when rightMost.right points to curr, then restore it back to null, and curr moves right
                if (rightMost.right == null) {
                    rightMost.right = curr;
                    curr = curr.left;
                    //continue back to start of while loop
                    continue;
                } else if (rightMost.right == curr) {
                    rightMost.right = null;
                    curr = curr.right;
                }
            }
            // if curr does not have a left subTree
            curr = curr.right;
        }
    }

    public static void morrisPre(BinaryTreeNode head) {
        if (head == null) {
            return;
        }
        BinaryTreeNode curr = head;
        BinaryTreeNode rightMost = null;
        while (curr != null) {
            rightMost = curr.left;
            if (rightMost != null) { 
                while (rightMost.right != null && rightMost.right != curr) {
                    rightMost = rightMost.right;
                }
                if (rightMost.right == null) {
                    // print the node that is traversed the first time
                    System.out.println(curr.val);
                    rightMost.right = curr;
                    curr = curr.left;
                    continue;
                } else if (rightMost.right == curr) {
                    rightMost.right = null;
                    curr = curr.right;
                }
            } else {
                // print the node that is traversed only once
                System.out.println(curr.val);
            }
            curr = curr.right;
        }
    }
    
    public static void morrisIn(BinaryTreeNode head) {
        if (head == null) {
            return;
        }
        BinaryTreeNode curr = head;
        BinaryTreeNode rightMost = null;
        while (curr != null) {
            rightMost = curr.left;
            if (rightMost != null) { 
                while (rightMost.right != null && rightMost.right != curr) {
                    rightMost = rightMost.right;
                }
                if (rightMost.right == null) {
                    rightMost.right = curr;
                    curr = curr.left;
                    continue;
                } else if (rightMost.right == curr) {
                    rightMost.right = null;
                    curr = curr.right;
                }
            }
            // print the node that is traversed the second time or the only time
            System.out.println(curr.val);
            curr = curr.right;
        }
    }
    
    public static void morrisPost(BinaryTreeNode head) {
        if (head == null) {
            return;
        }
        BinaryTreeNode curr = head;
        BinaryTreeNode rightMost = null;
        while (curr != null) {
            rightMost = curr.left;
            if (rightMost != null) { 
                while (rightMost.right != null && rightMost.right != curr) {
                    rightMost = rightMost.right;
                }
                if (rightMost.right == null) {
                    rightMost.right = curr;
                    curr = curr.left;
                    continue;
                } else if (rightMost.right == curr) {
                    rightMost.right = null;
                    curr = curr.right;
                }
            } else {
                reversePrintRightEdge(curr.left);
            }
            curr = curr.right;
        }
        reversePrintRightEdge(head);
    }

    public static void reversePrintRightEdge(BinaryTreeNode node) {
        BinaryTreeNode tail = reverseRightEdge(node);
        BinaryTreeNode curr = tail;
        while (curr != null) {
            System.out.println(curr.val + ", ");
            curr = curr.right;
        }
        reverseRightEdge(tail);
    }

    public static BinaryTreeNode reverseRightEdge(BinaryTreeNode node) {
        BinaryTreeNode prev = null;
        BinaryTreeNode next = null;
        while (node != null) {
            next = node.right;
            next.right = prev;
            prev = node;
            node = next;
        }
        return prev;
    }

    public static boolean isBSTMorris(BinaryTreeNode head) {
        if (head == null) {
            return true;
        }
        BinaryTreeNode curr = head;
        BinaryTreeNode rightMost = null;
        int prevValue = Integer.MIN_VALUE;
        while (curr != null) {
            rightMost = curr.left;
            if (rightMost != null) { 
                while (rightMost.right != null && rightMost.right != curr) {
                    rightMost = rightMost.right;
                }
                if (rightMost.right == null) {
                    rightMost.right = curr;
                    curr = curr.left;
                    continue;
                } else if (rightMost.right == curr) {
                    rightMost.right = null;
                    curr = curr.right;
                }
            }
            // In-Order Traversed Value comparison
            if (prevValue >= curr.val) {
                return false;
            }
            prevValue = curr.val;
            curr = curr.right;
        }
        return true;
    }
}
