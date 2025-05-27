package learning;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SortingEvenOdd {
    public static ListNode sortingEvenOdd(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode evenHead = new ListNode(0);
        ListNode oddHead = new ListNode(0);
        ListNode evenTail = evenHead;
        ListNode oddTail = oddHead;

        int index = 0;
        while (head != null) {
            if (index % 2 == 0) {
                evenTail.next = head;
                evenTail = evenTail.next;
            } else {
                oddTail.next = head;
                oddTail = oddTail.next;
            }
            head = head.next;
            index++;
        }

        evenTail.next = oddHead.next;
        oddTail.next = null;

        return evenHead.next;
    }

    public static ListNode oddEvenReorderUsing(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        List<ListNode> evenNodes = new ArrayList<>();
        List<ListNode> oddNodes = new ArrayList<>();

        while (head != null) {
            if (head.val % 2 == 0) {
                evenNodes.add(head);
            } else {
                oddNodes.add(head);
            }
            head = head.next;
        }

        List<ListNode> mergedList = new ArrayList<>();
        mergedList.addAll(evenNodes);
        mergedList.addAll(oddNodes);

        for (int i = 0; i < mergedList.size() - 1; i++) {
            mergedList.get(i).next = mergedList.get(i + 1);
        }
        mergedList.get(mergedList.size() - 1).next = null;

        return mergedList.get(0);
    }

    public static ListNode oddEvenReorderUsingHashMap(ListNode head) {
        if (head == null || head.next == null)
            return head;

        Map<String, List<ListNode>> nodes = new HashMap<>();
        nodes.put("even", new ArrayList<>());
        nodes.put("odd", new ArrayList<>());

        ListNode current = head;
        while (current != null) {
            if (current.val % 2 == 0)
                nodes.get("even").add(current);
            else
                nodes.get("odd").add(current);
            current = current.next;
        }

        List<ListNode> mergedNodes = new ArrayList<>();
        mergedNodes.addAll(nodes.get("even"));
        mergedNodes.addAll(nodes.get("odd"));

        for (int i = 0; i < mergedNodes.size() - 1; i++) {
            mergedNodes.get(i).next = mergedNodes.get(i+1);
        }

        mergedNodes.get(mergedNodes.size() - 1).next = null;

        return mergedNodes.get(0);
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);

        // Test sortingEvenOdd
        ListNode sortedList = sortingEvenOdd(head);
        printList(sortedList);

        // Test oddEvenReorderUsing
        ListNode head2 = new ListNode(1);
        head2.next = new ListNode(2);
        head2.next.next = new ListNode(3);
        head2.next.next.next = new ListNode(4);
        ListNode reorderedListUsingList = oddEvenReorderUsing(head2);
        printList(reorderedListUsingList);

        // Test oddEvenReorderUsingHashMap
        ListNode head3 = new ListNode(7);
        head3.next = new ListNode(8);
        head3.next.next = new ListNode(9);
        head3.next.next.next = new ListNode(10);
        head3.next.next.next.next = new ListNode(11);
        head3.next.next.next.next.next = new ListNode(12);
        ListNode reorderedListUsingMap = oddEvenReorderUsingHashMap(head3);
        printList(reorderedListUsingMap);
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
