package learning;

public class LinkedListCycle {

    static boolean isCycle(Node head) {
        Node current = head;
        while (current != null) {
            if (current.next == head) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    static boolean isCycleBetter(Node head) {
        if (head == null || head.next == null) {
            return false;
        }

        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;

        System.out.print("Linked List: ");
        node1.printList();

        System.out.println("Does the linked list have a cycle? " + isCycle(node1));
        System.out.println("Does the linked list have a cycle? " + isCycleBetter(node1));

        node4.next = node2;

        System.out.println("Does the linked list have a cycle after introducing one? " + isCycle(node1));
        System.out.println("Does the linked list have a cycle after introducing one? " + isCycleBetter(node1));
    }
}
