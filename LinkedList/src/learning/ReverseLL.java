package learning;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ReverseLL {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        ListNode reversedHead = reverse(head);
        printList(reversedHead);

        ListNode head2 = new ListNode(1);
        head2.next = new ListNode(2);
        head2.next.next = new ListNode(3);
        head2.next.next.next = new ListNode(4);
        head2.next.next.next.next = new ListNode(5);
        ListNode reversedHead2 = reverseListBrute(head2);
        printList(reversedHead2);
    }
    public static void printList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
        System.out.println();
    }
    public static ListNode reverse(ListNode head) {
        //
        if (head == null)
            return null;

        // If the list is empty or has only one node, return it as is
        ListNode prev = null;
        ListNode curr = head;

        // Iterate through the list and reverse the links
        while (curr != null) {
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }

        return prev;
    }

    public static ListNode reverseListBrute(ListNode head) {
        if (head == null || head.next == null)
            return head;

        List<Integer> list = new ArrayList<>();
        ListNode current = head;
        while (current != null) {
            list.add(current.val);
            current = current.next;
        }

        Collections.reverse(list);
        ListNode dummy = new ListNode(0);
        ListNode dummyHead = dummy;
        for (int i : list) {
            dummyHead.next = new ListNode(i);
            dummyHead = dummyHead.next;
        }

        return dummy.next;
    }
}
