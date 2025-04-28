package learning.dll;

public class DeleteDLL {

    public static void printList(DLLNode head) {
        DLLNode current = head;
        while (current != null) {
            System.out.print(current.getData() + " ");
            current = current.getNext();
        }
        System.out.println();
    }

    public static DLLNode deleteHead(DLLNode head) {
        if (head == null || head.getNext() == null) {
            return null;
        }

        DLLNode prev = head;
        head = head.next;
        head.prev = null;
        prev.next = null;

        return head;
    }

    public static DLLNode deleteTail(DLLNode head) {
        if (head == null || head.next == null) {
            return null;
        }

        DLLNode current = head;
        while (current.next != null)
            current = current.next;

        current.prev.next = null;
        current.prev = null;

        return head;
    }

    public static DLLNode deleteAtPosition(DLLNode head, int position) {
        if (head == null || position <= 0) {
            return null;
        }

        if (position == 1) {
            return deleteHead(head);
        }

        DLLNode current = head;
        for (int i = 1; current != null && i < position; i++)
            current = current.next;

        assert current != null;
        current.next.prev = current.prev;
        current.prev.next = current.next;

        return head;
    }

    public static void main(String[] args) {
        DLLNode head = new DLLNode(1);
        DLLNode second = new DLLNode(2);
        DLLNode third = new DLLNode(3);
        DLLNode fourth = new DLLNode(4);
        DLLNode fifth = new DLLNode(5);
        DLLNode sixth = new DLLNode(6);

        head.next = second;
        second.prev = head;
        second.next = third;
        third.prev = second;
        third.next = fourth;
        fourth.prev = third;
        fourth.next = fifth;
        fifth.prev = fourth;
        fifth.next = sixth;
        sixth.prev = fifth;
        sixth.next = null;

        System.out.println("Before deletion:");
        printList(head);

        head = deleteHead(head);
        System.out.println("After deleting head:");
        printList(head);

        head = deleteTail(head);
        System.out.println("After deleting tail:");
        printList(head);

        head = deleteAtPosition(head, 3);
        System.out.println("After deleting node at 3rd position: ");
        printList(head);
    }
}
