package com.cf.linkedlist;

public class CustomLLExample {

    private Node head;

    /**
     *
     */
    static class Node {
        Object data;
        Node next;

        public Node(Object data) {
            this.data = data;
        }
    }

    /**
     *
     * @param data
     */
    public void insert(Object data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }

    /**
     *
     * @param data
     */
    public void insertAtFirst(Object data) {
        Node firstNode = new Node(data);
        if (head == null) {
            head = firstNode;
        } else {
            firstNode.next = head;
            head = firstNode;
        }
    }

    /**
     *
     * @param data
     * @param index
     */
    public void insertAtSpecifiedPosition(Object data, int index) {
        Node newNode = new Node(data);
        if (index == 0) {
            newNode.next = head;
            head = newNode;
            return;
        }

        Node current = head;
        int currentIndex = 0;
        while (current != null && currentIndex < index-1) {
            current = current.next;
            currentIndex++;
        }

        assert current != null;
        newNode.next = current.next;
        current.next = newNode;
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
            Node current = head;
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
     * @param data
     */
    public void remove(Object data) {
        if (head == null) {
            return;
        }

        if (head.data.equals(data)){
            head = head.next;
            return;
        }

        Node current = head;
        Node previous = null;
        while (current != null && !current.data.equals(data)) {
            previous = current;
            current = current.next;
        }

        assert previous != null;
        assert current != null;
        previous.next = current.next;
    }

    /**
     *
     */
    public Object get(int index) {
        Node current = head;
        int currentIndex = 0;
        while (current != null && currentIndex < index) {
            current = current.next;
            currentIndex++;
        }

        assert current != null;
        return current.data;
    }
}
