package leetcode;

import learning.MergeTwoLists;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LC_23_MergeKSortedLists {

    // This is a brute force approach
    // Time complexity: O(nlogn) where n is the total number of elements in all lists
    // Space complexity: O(n) for storing the elements in an array
    public static Node mergeKSortedLists(Node[] lists)  {
        ArrayList<Integer> values = new ArrayList<>();
        for (Node list : lists) {
            Node current = list;
            while (current != null) {
                values.add(current.val);
                current = current.next;
            }
        }

        Collections.sort(values);

        Node dummy = new Node(0);
        Node current = dummy;
        for (int value : values) {
            current.next = new Node(value);
            current = current.next;
        }

        return dummy.next;
     }

    public static Node mergeKListsBrute(Node[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }

        List<Integer> array = new ArrayList<>();
        for (int i = 0; i < lists.length; i++) {
            Node current = lists[i];
            while (current != null) {
                array.add(current.val);
                current = current.next;
            }
        }

        Collections.sort(array);

        return convertToLinkedList(array);
    }

    private static Node convertToLinkedList(List<Integer> array) {
        Node head = new Node(array.get(0));
        Node current = head;

        for (int i = 1; i < array.size(); i++) {
            current.next = new Node(array.get(i));
            current = current.next;
        }

        return head;
    }

    public static Node mergeKListsUsingMergeTwoLists(Node[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }

        Node result = lists[0];
        for (int i = 1; i < lists.length; i++) {
            result = mergeLists(result, lists[i]);
        }

        return result;
    }

    private static Node mergeLists(Node head1, Node head2) {
        Node dummy = new Node(0);
        Node current = dummy;

        while (head1 != null && head2 != null) {
            if (head1.val <= head2.val) {
                current.next = head1;
                head1 = head1.next;
            } else {
                current.next = head2;
                head2 = head2.next;
            }
            current = current.next;
        }
        if (head1 != null) {
            current.next = head1;
        } else {
            current.next = head2;
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        Node[] lists = new Node[3];
        lists[0] = new Node(1);
        lists[0].next = new Node(4);
        lists[0].next.next = new Node(5);

        lists[1] = new Node(1);
        lists[1].next = new Node(3);
        lists[1].next.next = new Node(4);

        lists[2] = new Node(2);
        lists[2].next = new Node(6);

        Node result = mergeKListsBrute(lists);
        while (result != null) {
            System.out.print(result.val + " -> ");
            result = result.next;
        }
        System.out.println("null");

        Node result2 = mergeKListsUsingMergeTwoLists(lists);
        while (result2 != null) {
            System.out.print(result2.val + " -> ");
            result2 = result2.next;
        }
        System.out.println("null");
    }
}
