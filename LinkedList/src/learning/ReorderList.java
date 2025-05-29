package learning;

/*
    * Reorder a linked list such that the nodes are arranged in the following order:
    * 1 -> n -> 2 -> n-1 -> 3 -> n-2 -> ...
    * * Approach:
    * 1. Find the middle of the linked list using the slow and fast pointer technique.
    * 2. Reverse the second half of the linked list.
    * 3. Merge the two halves of the linked list by alternating nodes from each half.
    * Time Complexity: O(n)
    * Space Complexity: O(1)
 */

public class ReorderList {
    public static ListNode reverseList(ListNode head) {
        if (head == null)
            return null;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode curr = dummy.next;
        ListNode prev = null;

        while (curr != null) {
            ListNode nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }
        return prev;
    }

    public static ListNode getMiddle(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    /**
     * Reorders the linked list such that the nodes are arranged in the following order:
     * @param head the head of the linked list
     * @return the head of the reordered linked list
     * Approach:
     * 1. Find the middle of the linked list using the slow and fast pointer technique.
     * 2. Reverse the second half of the linked list.
     * 3. Merge the two halves of the linked list by alternating nodes from each half.
     * * Time Complexity: O(n)
     * * Space Complexity: O(1)
     */
    public static ListNode reorderList(ListNode head) {
        if (head == null)
            return null;

        ListNode middle = getMiddle(head);
        ListNode secondHalf = reverseList(middle.next);
        middle.next = null;

        ListNode firstHalf = head;
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        boolean isFirstHalf = true;
        while (firstHalf != null || secondHalf != null) {
            if (isFirstHalf && firstHalf != null) {
                current.next = firstHalf;
                firstHalf = firstHalf.next;
            } else if (!isFirstHalf && secondHalf != null) {
                current.next = secondHalf;
                secondHalf = secondHalf.next;
            }
            current = current.next;
            isFirstHalf = !isFirstHalf;
        }

        current.next = null;
        return dummy.next;
    }
}
