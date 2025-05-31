package learning;

import java.util.HashSet;
import java.util.Set;

public class RemoveDuplicates {
    public static ListNode removeDuplicatesX(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode current = head;
        while (current != null && current.next != null) {
            ListNode runner = current;
            while (runner.next != null) {
                if (runner.next.val == current.val) {
                    runner.next = runner.next.next;
                } else {
                    runner = runner.next;
                }
            }

            current = current.next;
        }
        return head;
    }

    public static void removeDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return; // No duplicates in an empty or single-node list
        }

        ListNode current1 = head;
        ListNode current2;
        ListNode previous;

        while (current1 != null) {
            previous = current1;
            current2 = current1.next;
            while (current2 != null) {
                if (current1.val == current2.val)
                    previous.next = current2.next;
                else
                    previous = current2;
                current2 = current2.next;
            }
            current1 = current1.next;
        }
    }

    /**
     * Removes duplicates from a linked list using a HashSet.
     * @param head the head of the linked list
     *             Approach:
     *             1. Traverse the linked list while maintaining a HashSet to keep track of seen nodes.
     *             2. If a node is already in the HashSet, remove it by adjusting the previous node's next pointer.
     *             3. If a node is not in the HashSet, add it to the HashSet and move the previous pointer to the current node.
     *             Time Complexity: O(n)
     *             Space Complexity: O(n)
     */
    public static void removeDuplicatesUsingHashing(ListNode head) {
        if (head == null || head.next == null) {
            return; // No duplicates in an empty or single-node list
        }

        Set<Integer> seen = new HashSet<>();
        ListNode current = head;
        ListNode previous = null;
        while (current != null) {
            if (seen.contains(current.val)) {
                previous.next = current.next;
            } else {
                seen.add(current.val);
                previous = current;
            }
            current = current.next;
        }
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(2);
        ListNode node4 = new ListNode(3);
        ListNode node5 = new ListNode(3);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        System.out.println("Before removing duplicates:");
        printList(node1);

        removeDuplicates(node1);

        System.out.println("After removing duplicates:");
        printList(node1);

        // Reset the list for testing removeDuplicatesUsingHashing
        node1 = new ListNode(1);
        node2 = new ListNode(2);
        node3 = new ListNode(2);
        node4 = new ListNode(3);
        node5 = new ListNode(3);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        System.out.println("Before removing duplicates using hashing:");
        printList(node1);
        removeDuplicatesUsingHashing(node1);
        System.out.println("After removing duplicates using hashing:");
        printList(node1);

        // Reset the list for testing removeDuplicatesX
        node1 = new ListNode(1);
        node2 = new ListNode(2);
        node3 = new ListNode(2);
        node4 = new ListNode(3);
        node5 = new ListNode(3);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        System.out.println("Before removing duplicates using removeDuplicatesX:");
        printList(node1);
        ListNode listNode = removeDuplicatesX(node1);
        System.out.println("After removing duplicates using removeDuplicatesX:");
        printList(listNode);
    }

    public static void printList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
        System.out.println();
    }
}
