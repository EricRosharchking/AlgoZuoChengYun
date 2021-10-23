package lesson4;

import util.RandLinkedListNode;

public class CopyRandLinkedList {
    

    public static void main(String[] args) {
        CopyRandLinkedList cp = new CopyRandLinkedList();

        RandLinkedListNode l1 = new RandLinkedListNode(1);
        RandLinkedListNode l2 = new RandLinkedListNode(2, l1);
        RandLinkedListNode l3 = new RandLinkedListNode(3, l2);
        RandLinkedListNode l4 = new RandLinkedListNode(4, l3);
        RandLinkedListNode l5 = new RandLinkedListNode(5, l4);

        l2.rand = l5;
        l3.rand = l1;
        l5.rand = l4;

        RandLinkedListNode node = cp.copy(l5);
        System.out.println(node);

        System.out.println(cp.extract(node));
        System.out.println(l5);
    }


    public RandLinkedListNode copy(RandLinkedListNode head) {
        RandLinkedListNode newHead = head;

        while(head != null) {
            RandLinkedListNode node = head.next;
            head.next = new RandLinkedListNode(-head.val, node);
            head = node;
        }
        head = newHead;
        while(head != null) {
            if (head.rand != null)
                head.next.rand = head.rand.next;
            head = head.next.next;
        }
        return newHead;
    }

    public RandLinkedListNode extract(RandLinkedListNode newHead) {
        RandLinkedListNode copy = newHead.next;
        while(newHead != null && newHead.next.next != null) {
            RandLinkedListNode newNext = newHead.next.next;
            newHead.next.next = newNext.next;
            newHead.next = newNext;
            newHead = newNext;
        }
        newHead.next.next = null;
        newHead.next = null;
        return copy;
    }
}
