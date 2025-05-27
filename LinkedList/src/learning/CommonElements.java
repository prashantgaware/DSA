package learning;

import java.util.HashSet;
import java.util.Set;

public class CommonElements {
    public static ListNode commonElementsUsingHashSet(ListNode head1, ListNode head2) {
        if (head1 == null || head2 == null) {
            return null;
        }

        Set<Integer> set = new HashSet<>();
        ListNode current = head1;

        while (current != null) {
            set.add(current.val);
            current = current.next;
        }

        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;

        current = head2;
        while (current != null) {
            if (set.contains(current.val)) {
                tail.next = new ListNode(current.val);
                tail = tail.next;
            }
            current = current.next;
        }

        return dummy.next;
    }

    public static ListNode commonElementsUsingTwoPointers(ListNode head1, ListNode head2) {
        if (head1 == null || head2 == null) {
            return null;
        }

        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;

        ListNode current1 = head1;
        ListNode current2 = head2;

        while (current1 != null && current2 != null) {
            if (current1.val < current2.val) {
                current1 = current1.next;
            } else if (current1.val > current2.val) {
                current2 = current2.next;
            } else {
                tail.next = new ListNode(current1.val);
                tail = tail.next;
                current1 = current1.next;
                current2 = current2.next;
            }
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        // Test Common Elements in Two Linked Lists
        ListNode head1 = new ListNode(1);
        head1.next = new ListNode(2);
        head1.next.next = new ListNode(3);
        head1.next.next.next = new ListNode(4);
        head1.next.next.next.next = new ListNode(5);
        ListNode head2 = new ListNode(3);
        head2.next = new ListNode(4);
        head2.next.next = new ListNode(5);
        head2.next.next.next = new ListNode(6);
        ListNode commonUsingHashSet = commonElementsUsingHashSet(head1, head2);
        printList(commonUsingHashSet);

        ListNode commonUsingTwoPointers = commonElementsUsingTwoPointers(head1, head2);
        printList(commonUsingTwoPointers);
    }

    public static void printList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
        System.out.println();
    }
}
