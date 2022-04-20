package lesson14;

import lesson14.RBTNode.Color;

public class RedBlackTree {
    
    private RBTNode root;

    public RedBlackTree() {

    }

    public RedBlackTree(int value) {
        this.root = new RBTNode();
        root.color = Color.BLACK;
        root.value = value;
    }

    public RBTNode insert(int value) {
        
        return root;
    }
}
