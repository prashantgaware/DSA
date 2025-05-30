package learning;

public class AddOneToLinkedList {
    public static ListNode addOne(ListNode head) {
        if (head == null) {
            return new ListNode(1);
        }

        ListNode reversedHead = reverseList(head);
        ListNode current = reversedHead;
        ListNode prev = null;
        int carry = 1; // Start with carry of 1 to add one
        while (current != null) {
            int sum = current.val + carry;
            carry = sum / 10;
            current.val = sum % 10;

            prev = current;
            current = current.next;
        }
        if (carry > 0) {
            prev.next = new ListNode(carry);
        }

        return reverseList(reversedHead);
    }

    private static ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }
        return prev;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(9);
        head.next = new ListNode(9);
        head.next.next = new ListNode(9);

        // Print original linked list
        System.out.print("Original Linked List: ");
        printList(head);

        // Add one to the linked list
        ListNode result = addOne(head);

        // Print updated linked list
        System.out.print("Updated Linked List after adding one: ");
        printList(result);
    }

    private static void printList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
        System.out.println();
    }
}
