package leetcode;

import learning.ListNode;

import static learning.RemoveDuplicates.printList;

/*
    83. Remove Duplicates from Sorted List
    Solved
    Easy
    Given the head of a sorted linked list, delete all duplicates such
    that each element appears only once. Return the linked list sorted as well.
*/
public class LC_83_RemoveDuplicatesFromSortedList {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(1);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(3);

        ListNode result = deleteDuplicates(head);
        printList(result);
    }

    private static ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode current = head;
        while (current != null && current.next != null) {
            ListNode temp = current;
            while (temp.next != null) {
                if (temp.next.val == current.val) {
                    temp.next = temp.next.next;
                } else {
                    temp = temp.next;
                }
            }
            current = current.next;
        }
        return head;
    }
}
