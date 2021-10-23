package lesson4;

import util.ListNode;

public class IntersectionLinkedList {
    
    public static void main(String[] args) {
        
        ListNode l1 = new ListNode(6);
        ListNode l2 = new ListNode(5, l1);
        ListNode l3 = new ListNode(4, l2);
        ListNode l4 = new ListNode(3, l3);
        ListNode l5 = new ListNode(2, l4);
        ListNode l6 = new ListNode(1, l5);
        l1.next = l4;

        ListNode node = containsCircle(l6);
        System.out.println(node.val);
    } 

    public static ListNode hasIntersection(ListNode h1, ListNode h2) {
        ListNode c1 = containsCircle(h1);
        ListNode c2 = containsCircle(h2);
        if (c1 == null && c2 == null) { // not circle in either list
            ListNode t1 = getTail(h1);
            ListNode t2 = getTail(h2);
            if (t1 == t2) {
                int l1 = getLength(h1, c1);
                int l2 = getLength(h2, c2);
                ListNode n1 = l1 > l2 ? h1 : h2;
                ListNode n2 = l1 < l2 ? h1 : h2;
                if (l1 < l2) {
                    l1 = l1 ^ l2;
                    l2 = l1 ^ l2;
                    l1 = l1 ^ l2;
                }
                for (int i = 0; i < l1-l2; i++) {
                    n1 = n1.next;
                }
                while (n1 != n2) {
                    n1 = n1.next;
                    n2 = n2.next;
                }
                return n1;
            }
        } else if ( c1 != null && c2 != null) {
            if (c1 == c2) {
                int l1 = getLength(h1, c1);
                int l2 = getLength(h2, c2);
                ListNode n1 = l1 > l2 ? h1 : h2;
                ListNode n2 = l1 < l2 ? h1 : h2;
                if (l1 < l2) {
                    l1 = l1 ^ l2;
                    l2 = l1 ^ l2;
                    l1 = l1 ^ l2;
                }
                for (int i = 0; i < l1-l2; i++) {
                    n1 = n1.next;
                }
                while (n1 != n2) {
                    n1 = n1.next;
                    n2 = n2.next;
                }
                return n1;
            } else {
                
            }
        }
        return null;
    }

    public static ListNode containsCircle(ListNode head) {
        // if a LinkedList contains circle, then the circle must be at the end of the list

        ListNode slow = head;
        ListNode fast = head;
        while(fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                break;
            }
        }
        if (slow == fast) {
            fast = head;
            while (slow != fast) {
                slow = slow.next;
                fast = fast.next;
            }
            return fast;
        }
        return null;
    }

    public static ListNode getTail(ListNode head) {
        ListNode tail = head;
        if (tail == null) {
            return null;
        }
        while (tail.next != null) {
            tail = tail.next;
        }
        return tail;
    }

    public static int getLength(ListNode head, ListNode tail) {
        int i = 0;
        ListNode node = head;
        while (node != tail) {
            i ++;
            node = node.next;
        }
        return i;
    }
}
