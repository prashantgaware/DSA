package learning;

/*
    82. Remove Duplicates from Sorted List II
    Given the head of a sorted linked list,
    delete all nodes that have duplicate numbers,
    leaving only distinct numbers from the original list.
    Return the linked list sorted as well.
* */

public class RemoveDuplicates2 {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(4);
        head.next.next.next.next.next = new ListNode(4);
        head.next.next.next.next.next.next = new ListNode(5);

        ListNode result = removeDuplicates(head);
        printList(result);
    }

    private static void printList(ListNode result) {
        while (result != null) {
            System.out.print(result.val + " -> ");
            result = result.next;
        }
    }

    /**
     *
     * @param head
     * @return
     * Approach:
     * 1. Create a dummy node to handle edge cases where the head might be removed
     * 2. Use two pointers, prev and curr, to traverse the list
     * 3. If curr and curr.next have the same value, it means we have found duplicates
     * 4. Move curr forward until we find a different value, marking that duplicates were found
     * 5. If duplicates were found, link prev.next to curr.next to remove duplicates
     * 6. If no duplicates were found, move prev to prev.next
     * 7. Continue until the end of the list
     * 8. Return dummy.next as the new head of the modified list
     * Time Complexity: O(n) where n is the number of nodes in the list
     * Space Complexity: O(1) as we are using only a constant amount of extra space
     */
    public static ListNode removeDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode curr = head;
        ListNode dummy = new ListNode(0);
        ListNode prev = dummy;
        dummy.next = head;
        boolean isDuplicate = false;
        while (curr.next != null) {
            if (curr.val == curr.next.val) {
                isDuplicate = true;
            } else {
                if (isDuplicate) {
                    prev.next = curr.next;
                    isDuplicate = false;
                } else {
                    prev = prev.next;
                }
            }
            curr = curr.next;
        }
        return dummy.next;
    }

    /**
     *
     * @param head
     * @return
     * Approach:
     * 1. Create a dummy node to handle edge cases where the head might be removed
     * 2. Use three pointers: preSlow, slow, and fast to traverse the list
     * 3. If slow and fast have the same value, it means we have found duplicates
     * 4. Move fast forward until we find a different value, marking that duplicates were found
     * 5. If duplicates were found, link preSlow.next to fast to remove duplicates
     * 6. If no duplicates were found, move preSlow to slow
     * 7. Continue until the end of the list
     * 8. Return dummy.next as the new head of the modified list
     * Time Complexity: O(n) where n is the number of nodes in the list
     * Space Complexity: O(1) as we are using only a constant amount of extra space
     */
    public static ListNode removeDuplicatesOptimal(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode preSlow = dummy;
        ListNode slow = head;
        ListNode fast = head.next;
        while (slow != null) {
            boolean isDuplicate = false;
            while (fast != null && fast.val == slow.val) {
                isDuplicate = true;
                fast = fast.next;
            }
            if (isDuplicate) {
                preSlow.next = fast;
            } else {
                preSlow = slow;
            }

            slow = fast;
            fast = (fast != null) ? fast.next : null;
        }
        return dummy.next;
    }
}
