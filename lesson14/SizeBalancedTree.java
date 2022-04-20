package lesson14;

public class SizeBalancedTree<K, V> {

    private SBTNode<K, V> node;

    private SBTNode<K, V> m(SBTNode<K, V> curr) {
        if (curr == null) {
            return null;
        }
        if (curr.l != null && curr.l.l != null && curr.r != null && curr.l.l.size > curr.r.size) {
            // LL
            curr = rotateRight(curr);
            curr.r = m(curr.r);
            curr = m(curr);
        } else if (curr.l != null && curr.l.r != null && curr.r != null && curr.l.r.size > curr.r.size) {
            // LR
            curr.l = rotateLeft(curr.l);
            curr = rotateRight(curr);
            curr.l = m(curr.l);
            curr.r = m(curr.r);
            curr = m(curr);
        } else if (curr.r != null && curr.r.r != null && curr.l != null && curr.r.r.size > curr.l.size) {
            // RR
            curr = rotateLeft(curr);
            curr.l = m(curr.l);
            curr = m(curr);
        } else if (curr.r != null && curr.r.l != null && curr.l != null && curr.r.l.size > curr.l.size) {
            // RL
            curr.r = rotateLeft(curr.r);
            curr = rotateRight(curr);
            curr.l = m(curr.l);
            curr.r = m(curr.r);
            curr = m(curr);
        }
        return curr;
    }

    public SBTNode<K,V> rotateLeft(SBTNode<K,V> node) {

        return node;
    }
    public SBTNode<K,V> rotateRight(SBTNode<K,V> node) {

        return node;
    }

    public static class SBTNode<K, V> {
        K k;
        V v;
        SBTNode<K, V> l, r;
        int size;
    }
}
