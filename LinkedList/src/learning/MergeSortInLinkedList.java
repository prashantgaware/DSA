package learning;

public class MergeSortInLinkedList {
    public static ListNode mergeSort(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode middle = getMiddleOfLinkedList(head);
        ListNode nextOfMiddle = middle.next;
        middle.next = null;

        ListNode left = mergeSort(head);
        ListNode right = mergeSort(nextOfMiddle);

        return sortedMerge(left, right);
    }

    private static ListNode sortedMerge(ListNode left, ListNode right) {
        if (left == null)
            return right;
        if (right == null)
            return left;

        ListNode result;
        if (left.val < right.val) {
            result = left;
            result.next = sortedMerge(left.next, right);
        } else {
            result = right;
            result.next = sortedMerge(left, right.next);
        }

        return result;
    }

    private static ListNode getMiddleOfLinkedList(ListNode head) {
        if (head == null)
            return null;

        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        return slow;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(4);
        head.next = new ListNode(2);
        head.next.next = new ListNode(1);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(0);

        // Print sorted linked list
        ListNode current = mergeSort(head);
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
    }
}
