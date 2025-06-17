package leetcode;

import learning.ListNode;

import static learning.ReorderList.reverseList;

public class LC_234_PalindromeLinkedList {
    public static boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null)
            return true;

        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        ListNode firstHalf = head;
        ListNode secondHalf = reverseList(slow);

        while (secondHalf != null) {
            if (firstHalf.val != secondHalf.val) {
                return false;
            }

            firstHalf = firstHalf.next;
            secondHalf = secondHalf.next;
        }

        return true;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(1);

        System.out.println("Is the linked list a palindrome? " + isPalindrome(head));

        ListNode head2 = new ListNode(1);
        head2.next = new ListNode(2);
        System.out.println("Is the linked list a palindrome? " + isPalindrome(head2));
    }
}
