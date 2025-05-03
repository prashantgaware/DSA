package learning;

public class ReverseFirstKNodes {
    public static ListNode reverseFirstKNodes(ListNode head, int k) {
        if (head == null || k <= 0) {
            return head;
        }

        ListNode prev = null;
        ListNode current = head;

        int count = 0;
        ListNode next = null;
        while (count < k && current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
            count++;
        }

        head.next = current;

        return prev;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        int k = 3;

        // Print the reversed list
        ListNode current = reverseFirstKNodes(head, k);
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
    }
}
