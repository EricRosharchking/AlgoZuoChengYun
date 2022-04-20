package lesson14;

public class RBTNode {

    public RBTNode left, right, parent;
    public int value;
    public Color color;

    public enum Color {
        RED, BLACK
    }

    public RBTNode() {
        color = Color.RED;
    }

    public RBTNode(int value) {
        this();
        this.value = value;
        this.color = Color.BLACK;
    }

    public RBTNode(RBTNode parent, int value) {
        this();
        this.parent = parent;
        this.value = value;
    }

    public RBTNode insert(int newValue) {
        if (newValue < value) {
            if (left != null) {
                left = left.insert(newValue);
            } else {
                left = new RBTNode(this, newValue);
                this.adjust(left);
            }
        } else if (newValue > value) {
            if (right != null) {
                right = right.insert(newValue);
            } else {
                right = new RBTNode(this, newValue);
                this.adjust(right);
            }
        }
        return this;
    }


    // return the root
    public RBTNode adjust(RBTNode node) {
        if (node.parent != null) {
            if (this.color == Color.BLACK) {
                return this;
            } else {
                if (this.left == node) {
                    right.color = Color.BLACK;
                } else {
                    left.color = Color.BLACK;
                }
                color = Color.BLACK;
                if (parent != null) {
                    parent.color = Color.RED;
                }

            }

            return node.parent;
        }
        return node;
    }

    @Override
    public String toString() {
        return "{" +
                " left='" + left + "'" +
                ", right='" + right + "'" +
                ", parent='" + parent + "'" +
                ", value='" + value + "'" +
                ", color='" + color + "'" +
                "}";
    }

}
