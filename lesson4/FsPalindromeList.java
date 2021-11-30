package lesson4;

import util.ListNode;

public class FsPalindromeList {
    // F(ast Pointer) moves 2 nodes every time
    // S(low Pointer) moves 1 nodes every time

    public static void main(String[] args) {

        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2, l1);
        ListNode l3 = new ListNode(3, l2);
        ListNode l4 = new ListNode(3, l3);
        ListNode l5 = new ListNode(2, l4);
        ListNode l6 = new ListNode(1, l5);

        FsPalindromeList fs = new FsPalindromeList();
        System.out.println(l6);
        ListNode tail = fs.transformList(l6);
        System.out.println(tail);
        System.out.println(fs.isPalindrome(l6, tail));
        try {
            ListNode node = fs.restoreList(l6, tail);
            System.out.println(node);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ListNode transformList(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode node = new ListNode();
        if (fast.next != null) {
            fast = fast.next;
            node = new ReverseLinkedList().reverse(slow.next);
        } else {
            node = new ReverseLinkedList().reverse(slow);
        }
        slow.next = null;
        return node;
    }

    public ListNode restoreList(ListNode head, ListNode tail) {
        ListNode node = head;
        while (node.next != null) {
            node = node.next;
        }
        ListNode mid = new ReverseLinkedList().reverse(tail);
        if (node != mid)
            node.next = mid;
        else
            node = mid;
        return head;
    }

    public boolean isPalindrome(ListNode head, ListNode tail) {
        while (head.next != null && tail.next != null) {
            if (head.val != tail.val) {
                return false;
            }
            head = head.next;
            tail = tail.next;
        }
        if (head.val != tail.val) {
            return false;
        }
        return true;
    }
}
