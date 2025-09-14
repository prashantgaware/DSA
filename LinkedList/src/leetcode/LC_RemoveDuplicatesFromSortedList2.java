package leetcode;

/*
    82. Remove Duplicates from Sorted List II
    Solved
    Medium
    Topics
    premium lock icon
    Companies
    Given the head of a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list. Return the linked list sorted as well.

    Example 1:
    Input: head = [1,2,3,3,4,4,5]
    Output: [1,2,5]

    Example 2:
    Input: head = [1,1,1,2,3]
    Output: [2,3]

    Constraints:

    The number of nodes in the list is in the range [0, 300].
    -100 <= Node.val <= 100
    The list is guaranteed to be sorted in ascending order.
*/

import learning.ListNode;

public class LC_RemoveDuplicatesFromSortedList2 {
    public static ListNode removeDuplicates(ListNode head) {
        if (head==null || head.next==null) return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;
        ListNode slow = head;
        ListNode fast = head.next;
        while (slow != null && fast != null) {
            boolean isDuplicate = false;
            while (fast != null && slow.val == fast.val) {
                isDuplicate = true;
                fast = fast.next;
            }
            if (isDuplicate) {
                prev.next = fast;
            } else {
                prev = slow;
            }
            slow = fast;
            if (fast != null) fast = fast.next;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(4);
        head.next.next.next.next.next = new ListNode(4);
        head.next.next.next.next.next.next = new ListNode(5);

        ListNode result = removeDuplicates(head);
        while (result != null) {
            System.out.print(result.val + " ");
            result = result.next;
        }
    }
}
