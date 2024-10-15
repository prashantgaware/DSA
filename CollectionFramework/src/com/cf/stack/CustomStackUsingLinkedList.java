package com.cf.stack;

class CustomNode {
    Object data;
    CustomNode next;

    public CustomNode(Object data) {
        this.data = data;
    }
}

public class CustomStackUsingLinkedList {
    CustomNode head;
    CustomNode tail;

    public CustomStackUsingLinkedList() {
        this.head = null;
        this.tail = null;
    }

    /**
     * This method pushes the data into the stack.
     * @param data - data to be pushed
     * @return pushed data
     */
    public Object push(Object data) {
        CustomNode newNode = new CustomNode(data);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            CustomNode current = head;
            /*while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;*/

            tail.next = newNode;
            tail = newNode;
        }

        return data;
    }

    /**
     * This method pops the top element from the stack.
     * @return top element of the stack
     */
    public Object pop() {
        if (head == null) {
            throw new IllegalArgumentException("Stack is empty");
        }

        CustomNode current = head;
        CustomNode prev = null;
        while (current.next != null) {
            prev = current;
            current = current.next;
        }

        Object data = current.data;
        if (prev == null) {
            head = null;
            tail = null;
        } else {
            prev.next = null;
            tail = prev;
        }

        return data;
    }

    /**
     * method to return the top element of the stack
     * @return top element of the stack
     */
    public Object peek() {
        return tail.data;

        /*if (head == null)
            throw new IllegalArgumentException("Stack is empty.");
        else {
            CustomNode current = head;
            while (current.next != null) {
                current = current.next;
            }

            return current;
        }*/
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        CustomNode temp = head;
        while (temp != null) {
            sb.append(temp.data);
            if (temp.next != null)
                sb.append(" -> ");
            temp = temp.next;
        }
        sb.append("}");

        return sb.toString();
    }
}
