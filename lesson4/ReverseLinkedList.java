package lesson4;

import util.ListNode;

public class ReverseLinkedList {
    
    public static void main(String[] args) {
        ReverseLinkedList re = new ReverseLinkedList();

        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2, l1);
        ListNode l3 = new ListNode(3, l2);
        ListNode l4 = new ListNode(4, l3);
        ListNode l5 = new ListNode(5, l4);
        ListNode l6 = new ListNode(6, l5);
        System.out.println(l6);
        System.out.println(re.reverse(l6));
    }

    public ListNode reverse(ListNode head) {    // entry point: starting with just a head node
        if (head.next == null) {
            return head;
        }
        ListNode node = head.next;
        head.next = null;
        head = reverse(head, node);
        return head;
    }

    public ListNode reverse(ListNode head, ListNode node) { // base case: one new head node, and one old head node
        if (node.next == null) {    // end point: old head has reached its end 
            node.next = head;
            return node;
        }
        ListNode newNode = node.next;
        node.next = head;
        node = reverse(node, newNode);
        return node;
    }

}
