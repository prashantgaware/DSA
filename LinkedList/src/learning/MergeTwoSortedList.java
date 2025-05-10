package learning;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MergeTwoSortedList {
    // time complexity: O(n)
    // explaination:
    // 1. We are using a two pointer approach to merge two sorted linked lists.
    // 2. We are creating a new linked list and adding the smaller element from both lists to the new list.
    // 3. We are using a dummy node to keep track of the head of the new list.
    // 4. We are using a while loop to iterate through both lists and adding the smaller element to the new list.
    // 5. We are using a while loop to add the remaining elements of the first list to the new list.
    // 6. We are using a while loop to add the remaining elements of the second list to the new list.
    // 7. Finally, we are returning the new list.
    // Space Complexity: O(1)
    public static Node mergeTwoLists(Node l1, Node l2) {
        if (l1 == null)
            return l2;
        if (l2 == null)
            return l1;

        Node l3 = new Node(-1);
        Node current = l3;
        while (l1 != null && l2 != null) {
            if (l1.data <= l2.data) {
                current.next = new Node(l1.data);
                l1 = l1.next;
            } else {
                current.next = new Node(l2.data);
                l2 = l2.next;
            }
            current = current.next;
        }
        while (l1 != null) {
            current.next = new Node(l1.data);
            l1 = l1.next;
            current = current.next;
        }

        while (l2 != null) {
            current.next = new Node(l2.data);
            l2 = l2.next;
            current = current.next;
        }

        return l3.next;
    }

    // Time Complexity: O(n * log n)
    // Explanation:
    // 1. We are using a brute force approach to merge two sorted linked lists.
    // 2. We are storing all the elements of both lists in an array and then sorting it.
    // 3. The sorting takes O(n * log n) time.
    // 4. Finally, we are creating a new linked list from the sorted array.
    // 5. The creation of the new linked list takes O(n) time.
    // 6. So, the overall time complexity is O(n * log n).
    // Space Complexity: O(n)
    public static Node mergeTwoListBrute(Node l1, Node l2) {
        List<Integer> nodes = new ArrayList<>();
        Node curr = l1;
        while (curr != null) {
            nodes.add(curr.data);
            curr = curr.next;
        }

        curr = l2;
        while (curr != null) {
            nodes.add(curr.data);
            curr = curr.next;
        }

        Collections.sort(nodes);    // Sorting the array : O(n * log n)
        Node dummy = new Node(-1);
        Node temp = dummy;
        for (int val : nodes) {
            temp.next = new Node(val);
            temp = temp.next;
        }

        return dummy.next;
    }

    /**
     * Merge two sorted linked list using recursion
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     * Approach:
     * 1. If l1 is null, return l2
     * 2. If l2 is null, return l1
     * 3. If l1.data < l2.data, set l1.next to the result of mergeTwoListUsingRecursion(l1.next, l2)
     * 4. Else, set l2.next to the result of mergeTwoListUsingRecursion(l1, l2.next)
     * 5. Return l1 or l2 based on the comparison
     */
    private static Node mergeTwoListUsingRecursion(Node l1, Node l2) {
        if (l1 == null)
            return l2;
        if (l2 == null)
            return l1;

        if (l1.data < l2.data) {
            l1.next = mergeTwoListUsingRecursion(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoListUsingRecursion(l1, l2.next);
            return l2;
        }
    }

    public static void main(String[] args) {
        Node l1 = new Node(1);
        l1.next = new Node(3);
        l1.next.next = new Node(5);

        Node l2 = new Node(2);
        l2.next = new Node(4);
        l2.next.next = new Node(6);

        Node mergedList = mergeTwoLists(l1, l2);
        printList(mergedList);
        Node mergedList1 = mergeTwoListBrute(l1, l2);
        printList(mergedList1);
        Node mergedList2 = mergeTwoListUsingRecursion(l1, l2);
        printList(mergedList2);
    }

    public static void printList(Node head) {
        Node curr = head;
        while (curr != null) {
            System.out.print(curr.data + " ");
            curr = curr.next;
        }
        System.out.println();
    }
}
