package learning;

public class InsertionSortInLinkedList {
    public static ListNode insertionSort(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode sorted = null;
        while (head != null) {
            ListNode curr = head;
            head = head.next;
            sorted = sortedInsertion(sorted, curr);
        }

        return sorted;
    }

    private static ListNode sortedInsertion(ListNode sorted, ListNode newNode) {
        if (sorted == null || newNode.val < sorted.val) {
            newNode.next = sorted;
            return newNode;
        }

        ListNode curr = sorted;
        while (curr.next != null && curr.next.val < newNode.val) {
            curr = curr.next;
        }

        newNode.next = curr.next;
        curr.next = newNode;

        return sorted;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(4);
        head.next = new ListNode(2);
        head.next.next = new ListNode(1);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(0);

        // Print sorted linked list
        ListNode current = insertionSort(head);
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
    }
}
