package learning;

import java.util.ArrayList;
import java.util.List;

public class RotateListByKPlaces {
    /**
     * reorder a linked list by rotating it to the right by k places.
     * @param head the head of the linked list
     * @param k the number of places to rotate the list
     * @return the head of the rotated linked list
     * Approach:
     * 1. Find the length of the linked list.
     * 2. Calculate the effective rotation by taking k modulo length.
     * 3. If k is 0, return the original head.
     * 4. Traverse the list to find the new head after rotation.
     * 5. Update the next pointers to rotate the list.
     * 6. Return the new head of the rotated linked list.
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    public static ListNode rotateList(ListNode head, int k) {
        if (head == null || head.next == null || k <= 0) {
            return head;
        }

        int length = 1;
        ListNode tail = head;
        while (tail.next != null) {
            tail = tail.next;
            length++;
        }

        k = k % length;
        if (k == 0)
            return head;

        for (int i = 0; i < k; i++) {
            ListNode curr = head;
            while (curr.next.next != null)
                curr = curr.next;

            ListNode newHead = curr.next;
            curr.next = null;
            newHead.next = head;
            head = newHead;
        }

        return head;
    }

    /**
     * Rotate a linked list using an ArrayList to store nodes.
     * @param head the head of the linked list
     * @param k the number of places to rotate the list
     * @return the head of the rotated linked list
     * Approach:
     * 1. Traverse the linked list and store each node in an ArrayList.
     * 2. Calculate the effective rotation by taking k modulo length.
     * 3. If k is 0, return the original head.
     * 4. Update the next pointers to rotate the list.
     * 5. Return the new head of the rotated linked list.
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     */
    public static ListNode rotateListUsingArrayList(ListNode head, int k) {
        if (head == null || head.next == null || k <= 0) {
            return head;
        }

        List<ListNode> nodes = new ArrayList<>();
        ListNode current = head;
        while (current != null) {
            nodes.add(current);
            current = current.next;
        }

        int length = nodes.size();
        k = k % length;
        if (k == 0) {
            return head;
        }

        ListNode newHead = nodes.get(length - k);
        ListNode newTail = nodes.get(length - k - 1);
        newTail.next = null;
        nodes.get(length - 1).next = head;
        return newHead;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        int k = 2;
        ListNode current = rotateList(head, k);
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }

        System.out.println();
        ListNode head2 = new ListNode(1);
        head2.next = new ListNode(2);
        head2.next.next = new ListNode(3);
        head2.next.next.next = new ListNode(4);
        head2.next.next.next.next = new ListNode(5);
        current = rotateListUsingArrayList(head2, k);
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
    }
}
