package learning;

public class LengthOfCyclicLoop {
    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        head.next.next.next.next.next = head.next;

        int length = lengthOfLoop(head);
        System.out.println("Length of the loop is: " + length);
    }

    public static int lengthOfLoop(Node head) {
        if (head == null) {
            return 0;
        }

        Node slow = head;
        Node fast = head;
        boolean isCycle = false;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                isCycle = true;
                break;
            }
        }

        if (!isCycle) {
            return 0;
        }

        // Calculate the length of the cycle
        int length = 1;
        Node current = slow;
        while (current.next != slow) {
            length++;
            current = current.next;
        }

        return length;
    }
}
