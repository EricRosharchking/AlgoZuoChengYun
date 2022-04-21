package lesson14;

import lesson14.RBTNode.Color;

public class RedBlackTree {

    private RBTNode root;
    private int height, blackHeight, nodes;

    public RedBlackTree() {

    }

    public RedBlackTree(int value) {
        this.root = new RBTNode();
        root.color = Color.BLACK;
        root.value = value;
    }

    public RBTNode insertNewNode(int val) {
        RBTNode node = insert(val);
        fixup(node);
        return root;
    }

    private RBTNode insert(int val) {
        if (root != null) {
            return root.insert(val);
        }
        root = new RBTNode(val);
        return root;
    }

    private RBTNode fixup(RBTNode N) {
        // case 1: N is the root of the RBT
        if (N.parent == null) {
            N.color = Color.BLACK;
            return N;
        } else {
            // case 2 : P is black
            if (N.parent.color == Color.BLACK) {
                return N.parent;
            } else {
                RBTNode P = N.parent;
                RBTNode U = P.left == N ? P.right : P.left;
                RBTNode G = P.parent;
                // case 3 : P is red, U is red, G is black
                if (U != null && U.color == Color.RED) {
                    U.flipColor();
                    P.flipColor();
                    G.flipColor();
                    return fixup(G);
                } else 
                // P is red, U is black or null
                if (U == null || U.color == Color.BLACK) {
                    // case 4: LR shape or RL shape
                    if (N == P.right && P == G.left) {
                        P = rotateLeft(P);
                        N = P.left;
                    } else if (N == P.left && P == G.right) {
                        P = rotateRight(P);
                        N = P.right;
                    }

                    // case 5: LL shape or RR shape
                    if (N == P.left && P == G.left) {
                        swapColor(P, G);
                        P = rotateRight(G);
                    } else if (N == P.right && P == G.right) {
                        swapColor(P, G);
                        P = rotateLeft(G);
                    }
                }
                return P;
            }
        }
    }

    private void swapColor(RBTNode P, RBTNode G) {
        Color c = P.color;
        P.color = G.color;
        G.color = c;
    }

    private RBTNode rotateLeft(RBTNode node) {
        RBTNode parent = node.parent;
        RBTNode right = node.right;
        RBTNode newRight = right.left;
        node.right = newRight;
        newRight.parent = node;
        right.left = node;
        node.parent = right;
        right.parent = parent;
        if (parent != null) {
            // parent.left = right;
            // parent.right = right;
        }
        return right;
    }

    private RBTNode rotateRight(RBTNode node) {
        return null;
    }
}
