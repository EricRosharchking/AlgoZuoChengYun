package lesson17;

public class MaxSumInTree {
    
    public static class Node{
        Node left;
        Node right;
        int val;

        public Node(int val) {
            this.val = val;
        }
    }

    public static int maxSum = Integer.MIN_VALUE;

    public static int maxPath(Node head) {
        iteration(head, 0);
        return maxSum;
    }

    public static void iteration(Node node, int sum) {
        if (node.left == null && node.right == null) {
            maxSum = Math.max(maxSum, sum + node.val);
        }
        if (node.left != null) {
            iteration(node.left, sum + node.val);
        }
        if (node.right != null) {
            iteration(node.right, sum + node.val);
        }
    }

    public static int maxDis(Node head) {
        if(head == null) {
            return 0;
        }
        return process(head);
    }

    // x为头的树上，最大路径和是多少，返回
    // 路径要求一定从x出发，到叶节点，算做一个路径
    public static int process(Node x) {
        if (x.left == null && x.right == null) {
            return x.val;
        }
        int next = Integer.MIN_VALUE;
        if (x.left != null) {
            next = process(x.left);
        }
        if (x.right != null) {
            next = Math.max(next, process(x.right));
        }
        return x.val + next;
    }
}
