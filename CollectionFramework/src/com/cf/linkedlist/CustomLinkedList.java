package com.cf.linkedlist;

import java.util.Currency;

public class CustomLinkedList {

    CustomNode head;
    int index = 0;

    private static class CustomNode {
        Object data;
        CustomNode next;
        int customNodeIndex;

        CustomNode(Object data, CustomNode next, int customNodeIndex) {
            this.data = data;
            this.next = next;
            this.customNodeIndex = customNodeIndex;
        }
    }

    /**
     * Custom method to add data in linked list
     * @param obj data to be inserted in linked list
     */
    public void insert(Object obj) {
        CustomNode newNode = new CustomNode(obj, null, index);
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
        index++;
    }

    /**
     * Function to add data as head
     * @param obj
     */
    public void insertAtFirst(Object obj) {
        CustomNode newNode = new CustomNode(obj, null, index);
        if (head == null) {
            head = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
        index++;
    }

    /**
     *
     * @param data
     * @param afterNode
     */
    public void insertAtSpecifiedIndex(Object data, Object afterNode) {
        CustomNode newNode = new CustomNode(data, null, index);
        if (head != null) {
            CustomNode current = head;
            while (current != null) {
                if (current.data.equals(afterNode)) {
                    CustomNode afterNewNode = current.next;
                    current.next = newNode;
                    newNode.next = afterNewNode;
                    break;
                } else {
                    current = current.next;
                }
            }
            if (current.next.equals(afterNode))
                current.next = newNode;
        }
    }

    /**
     *
     */
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

    /**
     *
     * @return
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        if (head == null) {
            sb.toString().concat("]");
        } else {
            CustomNode current = head;
            while (current.next != null) {
                sb.append(current.data).append(" -> ");
                current = current.next;
            }
            sb.append(current.data);
        }

        return sb.toString().concat("]");
    }

    /**
     *
     * @param indexPassed
     * @return
     */
    public Object get(int indexPassed) {
        // Check if the index is valid
        if (indexPassed < 0 || indexPassed >= index) {
            throw new IllegalArgumentException("Illegal index.");
        }

        // If the list is empty, throw an exception
        if (head == null) {
            throw new IllegalArgumentException("LinkedList is empty");
        }

        CustomNode current = head;
        // Traverse the list to find the node at the given index
        while (current != null) {
            if (current.customNodeIndex == indexPassed) {
                return current.data;
            }
            current = current.next;
        }

        // Return null if not found (should never happen with valid index)
        return null;
    }
}
