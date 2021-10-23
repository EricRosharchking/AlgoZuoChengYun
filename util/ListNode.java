package util;

public class ListNode {
    
    public int val;
    public ListNode next;

    public ListNode() {}

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public ListNode(int val) {
        this.val = val;
    }

    public String toString() {
        if (next == null) {
            return String.valueOf(this.val);
        }
        return this.val + ", " + this.next.toString();
    }
}
