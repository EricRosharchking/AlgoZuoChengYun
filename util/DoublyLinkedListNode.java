package util;

public class DoublyLinkedListNode extends ListNode {

    public DoublyLinkedListNode previous;

    public DoublyLinkedListNode() {
        super();
    }

    public DoublyLinkedListNode(int val) {
        super(val);
        //TODO Auto-generated constructor stub
    }
    
    public DoublyLinkedListNode(int val, DoublyLinkedListNode next, DoublyLinkedListNode previous) {
        this.next = next;
        this.val = val;
        this.previous = previous;
    }

    public String toString() {
        return super.toString();
    }
}
