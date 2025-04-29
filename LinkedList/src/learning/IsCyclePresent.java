package learning;

import java.util.HashSet;

public class IsCyclePresent {
    public static void main(String[] args) {
        // Create a linked list with a cycle
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = head; // Creating a cycle

        System.out.println("Is cycle present: " + isCyclePresent(head));
        System.out.println("Is cycle present (Brute Force): " + isCyclePresentBruteForce(head));
    }

    // Floyd's Cycle Detection Algorithm (Tortoise and Hare)
    public static boolean isCyclePresent(Node head) {
        if (head == null) {
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

    // Brute force approach using hashing
    public static boolean isCyclePresentBruteForce(Node head) {
        HashSet<Node> visitedNodes = new HashSet<>();
        Node current = head;

        while (current != null) {
            if (visitedNodes.contains(current)) {
                return true;
            }
            visitedNodes.add(current);
            current = current.next;
        }

        return false;
    }
}
