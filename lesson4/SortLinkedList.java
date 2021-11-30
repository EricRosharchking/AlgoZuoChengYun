package lesson4;

import util.ListNode;

public class SortLinkedList {

    public static void main(String[] args) {

        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2, l1);
        ListNode l3 = new ListNode(3, l2);
        ListNode l4 = new ListNode(3, l3);
        ListNode l5 = new ListNode(2, l4);
        ListNode l6 = new ListNode(1, l5);

        SortLinkedList sort = new SortLinkedList();
        System.out.println(sort.adjustedSort(l6, 3));
    }

    public void sort(ListNode node) {

    }

    public ListNode adjustedSort(ListNode head, int val) {
        ListNode sHead = null; // smaller than node head
        ListNode sTail = null; // smaller than node tail
        ListNode eHead = null; // equals to node head
        ListNode eTail = null; // equals to node tail
        ListNode lHead = null; // larger than node head
        ListNode lTail = null; // larger than node tail

        while (head != null) {
            System.out.println(head);
            if (head.val < val) {
                if (sHead == null) {
                    sHead = head;
                    sTail = head;
                    head = head.next;
                    continue;
                }
                sTail.next = head;
                sTail = sTail.next;
                head = head.next;
                sTail.next = null;
            } else if (head.val == val) {
                if (eHead == null) {
                    eHead = head;
                    eTail = head;
                    head = head.next;
                    continue;
                }
                eTail.next = head;
                eTail = eTail.next;
                head = head.next;
                eTail.next = null;
            } else if (head.val > val) {
                if (lHead == null) {
                    lHead = head;
                    lTail = head;
                    head = head.next;
                    continue;
                }
                lTail.next = head;
                lTail = lTail.next;
                head = head.next;
                lTail.next = null;
            }
        }
        System.out.println(sHead);
        System.out.println(eHead);
        System.out.println(lHead);

        if (sHead != null)
            sTail.next = eHead;
        else
            sHead = eHead;

        if (eTail != null)
            eTail.next = lHead;
        else
            sHead = lHead;

        return sHead;
    }
}
