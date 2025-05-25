package learning;

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
}
