package leetcode;

import learning.ListNode;

import java.util.ArrayList;
import java.util.List;

public class LC_24_SwapNodesInPairs {
    /**
     * Swaps every two adjacent nodes in a linked list.
     * This implementation uses an ArrayList to store the nodes and then swaps them.
     * @param head The head of the linked list.
     * @return The new head of the linked list after swapping pairs.
     * Approach:
     * 1. Traverse the linked list and store each node in an ArrayList.
     * 2. Iterate through the ArrayList in pairs and swap the nodes.
     * 3. Reconstruct the linked list from the modified ArrayList.
     * * Time Complexity: O(n), where n is the number of nodes in the linked list.
     * * Space Complexity: O(n), due to the use of an ArrayList to store the nodes.
     */
    public static ListNode swapPairsUsingArrayList(ListNode head) {
        if (head == null || head.next == null)
            return head;

        List<ListNode> nodes = new ArrayList<>();
        ListNode curr = head;
        while (curr != null) {
            nodes.add(curr);
            curr = curr.next;
        }

        for (int i = 0; i < nodes.size() - 1; i += 2) {
            ListNode temp = nodes.get(i);
            nodes.set(i, nodes.get(i+1));
            nodes.set(i+1, temp);
        }

        ListNode dummy = new ListNode(-1);
        curr = dummy;
        for (ListNode node : nodes) {
            curr.next = node;
            curr = curr.next;
        }
        curr.next = null;

        return dummy.next;
    }

    /**
     * Swaps every two adjacent nodes in a linked list in place.
     * @param head The head of the linked list.
     * @return The new head of the linked list after swapping pairs.
     * Approach:
     * 1. Use a dummy node to simplify the swapping process.
     * 2. Initialize a pointer to the dummy node.
     * 3. Iterate through the linked list in pairs.
     * 4. For each pair, swap the nodes by adjusting the pointers.
     * * Time Complexity: O(n), where n is the number of nodes in the linked list.
     * * Space Complexity: O(1), as we are swapping nodes in place without using extra space.
     */
    public static ListNode swapPairsInPlace(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode prev = dummy;
        // Iterate through the list in pairs till we reach the end
        while (prev.next != null && prev.next.next != null) {
            ListNode first = prev.next;
            ListNode second = prev.next.next;

            first.next = second.next;
            second.next = first;
            prev.next = second;

            // move the prev ptr to fisrt ptr
            prev = first;
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        // Example usage
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        ListNode swappedHead = swapPairsUsingArrayList(head);
        while (swappedHead != null) {
            System.out.print(swappedHead.val + " -> ");
            swappedHead = swappedHead.next;
        }
        System.out.println("null");

        ListNode head2 = new ListNode(1);
        head2.next = new ListNode(2);
        head2.next.next = new ListNode(3);
        head2.next.next.next = new ListNode(4);
        head2.next.next.next.next = new ListNode(5);
        ListNode swappedHead2 = swapPairsInPlace(head2);
        while (swappedHead2 != null) {
            System.out.print(swappedHead2.val + " -> ");
            swappedHead2 = swappedHead2.next;
        }
        System.out.println("null");
    }
}
