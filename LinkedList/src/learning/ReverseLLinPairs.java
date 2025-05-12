package learning;

import java.util.ArrayList;
import java.util.List;

public class ReverseLLinPairs {
    public static Node reverseInPairsUsingArrayList(Node head) {
        if (head == null || head.next == null)
            return head;

        List<Node> nodes = new ArrayList<>();
        Node curr = head;
        while (curr != null) {
            nodes.add(curr);
            curr = curr.next;
        }

        // Reverse the nodes in pairs
        for (int i = 0; i < nodes.size() - 1; i += 2) {
            Node temp = nodes.get(i);
            nodes.set(i, nodes.get(i + 1));
            nodes.set(i + 1, temp);
        }

        // Reconstruct the linked list
        for (int i = 0; i < nodes.size() - 1; i++) {
            nodes.get(i).next = nodes.get(i + 1);
        }
        nodes.get(nodes.size() - 1).next = null; // Last node should point to null

        return nodes.get(0);
    }

    public static Node reverseInPairsUsingRecursion(Node head) {
        if (head == null || head.next == null)
            return null;

        Node newNode = head.next;
        head.next = reverseInPairsUsingRecursion(newNode.next);
        newNode.next = head;

        return newNode;
    }

    public static void main(String[] args) {
        // Create a linked list: 1 -> 2 -> 3 -> 4 -> 5
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        head.next.next.next.next.next = new Node(6);

        System.out.println("Reversed in pairs using ArrayList:");
        Node reversedHead = reverseInPairsUsingArrayList(head);
        Node curr = reversedHead;
        while (curr != null) {
            System.out.print(curr.data + " ");
            curr = curr.next;
        }
        System.out.println();

        System.out.println("Reversed in pairs using recursion:");
        Node reversedHeadRecursion = reverseInPairsUsingRecursion(head);
        Node current = reversedHeadRecursion;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }
}
