package leetcode;

import learning.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * LeetCode Problem 1721: Swapping Nodes in a Linked List
 *
 * Given the head of a linked list, swap the values of the kth node from the beginning
 * and the kth node from the end of the list, and return the modified list.
 * * Example:
 * * Input: head = [1,2,3,4,5], k = 2
 * * Output: [1,4,3,2,5]
 */

public class LC_1721_SwappingNodesInLinkedList {
    /**
     * This method swaps the kth node from the beginning and the kth node from the end of the linked list.
     * @param head - head of the linked list
     * @param k - position of the node to swap
     * @return head of the modified linked list
     * Approach:
     * 1. First, we traverse the linked list to find the length of the list.
     * 2. Then, we traverse the list again to find the kth node from the beginning and the kth node from the end.
     * 3. Finally, we swap the values of these two nodes.
     */
    public static ListNode swapNodesUsingArrayList(ListNode head, int k) {
        List<ListNode> nodes = new ArrayList<>();
        ListNode current = head;

        // Store all nodes in a list
        while (current != null) {
            nodes.add(current);
            current = current.next;
        }

        // Swap the kth node from the beginning and the kth node from the end
        int n = nodes.size();
        int temp = nodes.get(k - 1).val;
        nodes.get(k - 1).val = nodes.get(n - k).val;
        nodes.get(n - k).val = temp;

        return head;
    }

    public static ListNode swapNodeInTwoPass(ListNode head, int k) {
        if (head == null || head.next == null)
            return head;

        int length = 0;
        ListNode curr = head;
        while (curr != null) {
            length++;
            curr = curr.next;
        }

        ListNode first = head;
        for (int i = 0; i < k; i++) {
            first = first.next;
        }

        ListNode second = head;
        for (int i = 0; i < length-k+1; i++) {
            second = second.next;
        }

        int temp = first.val;
        first.val = second.val;
        second.val = temp;

        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        int k = 2;

        ListNode result = swapNodesUsingArrayList(head, k);
        while (result != null) {
            System.out.print(result.val + " ");
            result = result.next;
        }
    }
}
