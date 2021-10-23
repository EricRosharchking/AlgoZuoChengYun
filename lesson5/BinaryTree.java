package lesson5;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import util.BinaryTreeNode;

public class BinaryTree {

    public static int maxWidth(BinaryTreeNode head) {
        Queue<BinaryTreeNode> queue = new LinkedList<>();
        HashMap<BinaryTreeNode, Integer> map = new HashMap<>();
        int currLevel = 1;
        int currLevelNodes = 0;
        int max = 0;
        map.put(head, currLevel);
        currLevelNodes++;
        queue.add(head);
        while (!queue.isEmpty()) {
            BinaryTreeNode node = queue.poll();
            map.remove(node);
            if (node.left != null) {
                queue.add(node.left);
                map.put(node.left, currLevel + 1);
            }
            if (node.right != null) {
                queue.add(node.right);
                map.put(node.right, currLevel + 1);
            }
            // System.out.println(node.val + ":" + currLevel + ",");
            if (!map.containsValue(currLevel)) {
                currLevel++;
                max = Math.max(currLevelNodes, max);
                currLevelNodes = 0;
            }
            currLevelNodes++;
        }
        return max;
    }

    public static int maxWidthAdjusted(BinaryTreeNode head) {
        /**
         * based on BFS for a tree, if the last node of the current level 
         * has been dequeued, then all the nodes from the next level will
         * be in the queue.
         * Hence, if the the dequeued node's right node is the last node
         * of the next level, the the dequeued node will be the last node
         * if its own level (current level) -> going to the next level
         * Two pointers: currNode and nextEndNode, if currNode == nextEndNode
         * then nextEndNode assigned to the last Node of the queue, count
        */
        int max = 0;
        int currLevelNodes = 0;
        Queue<BinaryTreeNode> queue = new LinkedList<>();
        BinaryTreeNode currNode = head;
        BinaryTreeNode nextEndNode = head;
        queue.add(head);
        while (!queue.isEmpty()) {
            currNode = queue.poll();
            if (currNode.left != null)
                queue.add(currNode.left);
            if (currNode.right != null) 
                queue.add(currNode.right);
            
            currLevelNodes++;
            if (currNode == nextEndNode) {
                max = Math.max(max, currLevelNodes);
                currLevelNodes = 0;
                if (queue.isEmpty()) {
                    nextEndNode = null;
                } else {
                    nextEndNode = ((LinkedList<BinaryTreeNode>)queue).getLast();
                }
            }
        }
        return max;
    }

    public static void nonReccursivePreOrder(BinaryTreeNode head) {
        Stack<BinaryTreeNode> stack = new Stack<>();
        if (head == null) {
            return;
        }
        stack.add(head);
        while (!stack.isEmpty()) {
            BinaryTreeNode node = stack.pop();
            System.out.print(node.val + ",");
            if (node.right != null)
                stack.add(node.right);
            if (node.left != null)
                stack.add(node.left);
        }
        System.out.println();
    }

    public static void nonReccursivePostOrder(BinaryTreeNode head) {
        if (head == null) {
            return;
        }
        Stack<BinaryTreeNode> stack = new Stack<>();
        Stack<BinaryTreeNode> help = new Stack<>();
        stack.add(head);
        while (!stack.isEmpty()) {
            BinaryTreeNode node = stack.pop();
            help.add(node);
            if (node.left != null)
                stack.add(node.left);
            if (node.right != null)
                stack.add(node.right);
        }
        while (!help.isEmpty())
            System.out.print(help.pop().val + ",");
        System.out.println();
    }

    public static void nonReccursiveInOrder(BinaryTreeNode head) {
        if (head == null) {
            return;
        }
        Stack<BinaryTreeNode> stack = new Stack<>();
        addLeftTree(stack, head);
        while (!stack.isEmpty()) {
            BinaryTreeNode node = stack.pop();
            if (node.right != null) {
                addLeftTree(stack, node.right);
            }
            System.out.print(node.val + ";");
        }

        // while (!stack.isEmpty() || head != null) {
        // if (head != null) {
        // stack.add(head);
        // head = head.left;
        // } else {
        // head = stack.pop();
        // System.out.print(head.val + ",");
        // head = head.right;
        // }
        // }
        System.out.println();
    }

    public static void bfs(BinaryTreeNode head) {
        if (head == null) {
            return;
        }
        Queue<BinaryTreeNode> queue = new LinkedList<BinaryTreeNode>();
        queue.add(head);
        while (!queue.isEmpty()) {
            head = queue.poll();
            System.out.print(head.val + ",");
            if (head.left != null)
                queue.add(head.left);
            if (head.right != null)
                queue.add(head.right);
        }
        System.out.println();
    }

    public static void addLeftTree(Stack<BinaryTreeNode> stack, BinaryTreeNode head) {
        BinaryTreeNode left = head;
        while (left != null) {
            stack.add(left);
            left = left.left;
        }
    }

    public static void reccursiveTraverse(BinaryTreeNode head) {
        if (head == null) {
            return;
        }
        // first time reaching this node
        // print or do something
        reccursiveTraverse(head.left);
        // second time after traversing left child
        // print or do something
        reccursiveTraverse(head.right);
        // third time after traversing right child
        // print or do something
    }

    public static void reccursivePreOrder(BinaryTreeNode head) {
        if (head == null) {
            return;
        }
        System.out.println(head.val);
        reccursivePreOrder(head.left);
        reccursivePreOrder(head.right);
    }

    public static void reccursiveInOrder(BinaryTreeNode head) {
        if (head == null) {
            return;
        }
        reccursivePreOrder(head.left);
        System.out.println(head.val);
        reccursivePreOrder(head.right);
    }

    public static void reccursivePostOrder(BinaryTreeNode head) {
        if (head == null) {
            return;
        }
        reccursivePreOrder(head.left);
        reccursivePreOrder(head.right);
        System.out.println(head.val);
    }
}
