package learning;

import learning.dll.DLLNode;

public class DisplayDLLFormEnd {

    public static void displayDLLFromEnd(DLLNode head) {
        if (head == null) {
            System.out.println("The list is empty.");
            return;
        }

        DLLNode tail = head;
        while (tail.next != null) {
            tail = tail.next;
        }

        while (tail != null) {
            System.out.print(tail.data + " ");
            tail = tail.prev;
        }
    }

    public static void main(String[] args) {
        // Create a sample doubly linked list
        DLLNode node1 = new DLLNode(1);
        DLLNode node2 = new DLLNode(2);
        DLLNode node3 = new DLLNode(3);
        DLLNode node4 = new DLLNode(4);

        node1.next = node2;
        node2.prev = node1;
        node2.next = node3;
        node3.prev = node2;
        node3.next = node4;
        node4.prev = node3;

        // Display the list from the end
        displayDLLFromEnd(node1);
    }

}
