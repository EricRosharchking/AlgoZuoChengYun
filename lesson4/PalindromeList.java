package lesson4;

import java.util.Stack;

import util.ListNode;

public class PalindromeList {

    public static void main(String[] args) {

        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2, l1);
        ListNode l3 = new ListNode(3, l2);
        ListNode l4 = new ListNode(3, l3);
        ListNode l5 = new ListNode(2, l4);
        ListNode l6 = new ListNode(1, l5);

        System.out.println(l6);
        System.out.println(new PalindromeList().isPalindrome(l6));
    }

    public boolean isPalindrome(ListNode head) {
        Stack<ListNode> stack = new Stack<>();
        ListNode node = head;
        while (node != null) {
            stack.push(node);
            node = node.next;
        }
        node = head;
        while (!stack.isEmpty()) {
            if (stack.pop().val != node.val) {
                return false;
            }
            node = node.next;
        }
        return true;
    }
}
