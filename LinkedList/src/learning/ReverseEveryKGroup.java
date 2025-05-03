package learning;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ReverseEveryKGroup {
    public static ListNode reverseEveryKGroup(ListNode head, int k) {
        if (head == null || k <= 1) {
            return head;
        }

        List<ListNode> nodes = new ArrayList<>();
        ListNode current = head;

        while (current != null) {
            nodes.add(current);
            current = current.next;
        }

        for (int i = 0; i < nodes.size(); i = i + k) {
            if (i+k <= nodes.size()) {
                Collections.reverse(nodes.subList(i, i + k));
            }
        }

        for (int i = 0; i < nodes.size() - 1; i++) {
            nodes.get(i).next = nodes.get(i + 1);
        }

        nodes.get(nodes.size() - 1).next = null;

        return nodes.get(0);
    }

    // This method reverses the linked list in place using traversal
    // and does not use any extra space for storing nodes.
    // Approach:
    // 1. Count the number of nodes in the linked list.
    // 2. Traverse the linked list and reverse every k nodes.
    // 3. Connect the reversed segments together.
    // 4. Return the new head of the linked list.
    public static ListNode reverseKGroupInPlaceTraversal(ListNode head, int k) {
        if (head == null || k <= 1) {
            return head;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy, curr = head, next = null;

        int count = 0;
        while (curr != null) {
            count++;
            curr = curr.next;
        }

        curr = dummy.next;
        while (count >= k) {
            curr = prev.next;
            next = curr.next;

            for (int i = 1; i < k; i++) {
                curr.next = next.next;
                next.next = prev.next;
                prev.next = next;
                next = curr.next;
            }
            prev = curr;
            count -= k;
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        int k = 2;

        ListNode result = reverseEveryKGroup(head, k);

        while (result != null) {
            System.out.print(result.val + " ");
            result = result.next;
        }
    }
}
