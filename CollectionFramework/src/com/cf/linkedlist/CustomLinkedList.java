package com.cf.linkedlist;

public class CustomLinkedList {

    CustomNode head;

    private static class CustomNode {
        Object data;
        CustomNode next;

        CustomNode(Object data, CustomNode next) {
            this.data = data;
            this.next = next;
        }
    }

    /**
     * Custom method to add data in linked list
     * @param obj data to be inserted in linked list
     */
    public void insert(Object obj) {
        CustomNode newNode = new CustomNode(obj, null);
        // If the list is empty, set the new node as the head
        if (head == null) {
            head = newNode;
        } else {
            CustomNode current = head;
            // Traverse to the end of the list
            while (current.next != null) {
                current = current.next;
            }
            // Set the next reference of the last node to the new node
            current.next = newNode;
        }
    }

    public void display() {
        if (head == null) {
            System.out.println("Linked List is empty.");
        }

        CustomNode current = head;
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }

        System.out.println("null");
    }
}
