package util;

public class RandLinkedListNode {
    public int val;
    public RandLinkedListNode next;
    public RandLinkedListNode rand;

    public RandLinkedListNode() {

    }

    public RandLinkedListNode(int val) {
        this.val = val;
    }

    public RandLinkedListNode(int val, RandLinkedListNode next) {
        this.val = val;
        this.next = next;
    }

    public RandLinkedListNode(int val, RandLinkedListNode next, RandLinkedListNode rand) {
        this.val = val;
        this.rand = rand;
        this.next = next;
    }

    public String toString() {
        String randVal = "null";
        if (this.rand != null)
            randVal = String.valueOf(this.rand.val);
        if (this.next == null) {
            return String.valueOf(this.val) + ":" + randVal;
        }

        return String.valueOf(this.val) + ":" + randVal + ", " + this.next.toString();
    }


    public int getVal() {
        return this.val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public RandLinkedListNode getNext() {
        return this.next;
    }

    public void setNext(RandLinkedListNode next) {
        this.next = next;
    }

    public RandLinkedListNode getRand() {
        return this.rand;
    }

    public void setRand(RandLinkedListNode rand) {
        this.rand = rand;
    }
    
}
