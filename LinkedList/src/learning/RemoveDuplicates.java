package learning;

import java.util.HashSet;
import java.util.Set;

public class RemoveDuplicates {
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

        Set<ListNode> seen = new HashSet<>();
        ListNode current = head;
        ListNode previous = null;
        while (current != null) {
            if (seen.contains(current)) {
                previous.next = current.next;
            } else {
                seen.add(current);
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
