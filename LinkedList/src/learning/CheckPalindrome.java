package learning;

import org.w3c.dom.ls.LSInput;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class CheckPalindrome {
    public static boolean isPalindrome(String str) {
        int i = 0;
        int j = str.length() - 1;
        while (i < j) {
            if (str.charAt(i) != str.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    public static boolean isPalindromeUsingList(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }

        List<Integer> nodeValues = new ArrayList<>();
        ListNode current = head;
        while (current != null) {
            nodeValues.add(current.val);
            current = current.next;
        }

        int left = 0;
        int right = nodeValues.size() - 1;
        while (left < right) {
            if (!nodeValues.get(left).equals(nodeValues.get(right))) {
                return false;
            }
            left++;
            right--;
        }

        return true;
    }

    public static boolean isPalindromeUsingStack(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }

        Stack<Integer> stack = new Stack<>();
        ListNode current = head;

        while (current != null) {
            stack.push(current.val);
            current = current.next;
        }

        current = head;
        while (current != null) {
            if (!stack.pop().equals(current.val)) {
                return false;
            }
            current = current.next;
        }

        return true;
    }

    /**
     * This method checks if a linked list is a palindrome using the two-pointer technique.
     * @param head the head of the linked list
     * @return true if the linked list is a palindrome, false otherwise
     * Time complexity: O(n)
     * Space complexity: O(1)
     * Approach:
     * 1. Use the slow and fast pointer technique to find the middle of the linked list.
     * 2. Reverse the second half of the linked list.
     * 3. Compare the first half and the reversed second half of the linked list.
     * 4. Restore the original linked list by reversing the second half again.
     * 5. Return true if all values match, otherwise return false.
     */
    public static boolean isPalindromeUsingTwoPointers(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }

        ListNode firstHalfEnd = getMiddle(head);
        ListNode startOfSecond = reverseSecondHalfOfList(firstHalfEnd.next);
        firstHalfEnd.next = null;

        ListNode firstHalfStart = head;
        ListNode secondHalfStart = startOfSecond;
        boolean isPalindrome = true;
        while (firstHalfStart != null && secondHalfStart != null) {
            if (firstHalfStart.val != secondHalfStart.val) {
                isPalindrome = false;
                break;
            }
            firstHalfStart = firstHalfStart.next;
            secondHalfStart = secondHalfStart.next;
        }

        firstHalfEnd.next = reverseSecondHalfOfList(startOfSecond);

        return isPalindrome;
    }

    private static ListNode reverseSecondHalfOfList(ListNode listNode) {
        ListNode prev = null;
        ListNode curr = listNode;
        while (curr != null) {
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }

        return prev;
    }

    private static ListNode getMiddle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }
}
