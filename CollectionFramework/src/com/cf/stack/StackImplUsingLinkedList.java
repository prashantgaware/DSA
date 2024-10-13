package com.cf.stack;

class Node {
    Object data;
    Node next;

    Node(Object data) {
        this.data = data;
        this.next = null;
    }
}

public class StackImplUsingLinkedList {
    private Node top;

    public StackImplUsingLinkedList() {
        this.top = null;
    }

    /**
     * This method pushes the data into the stack.
     * @param data - data to be pushed
     */
    public void push(Object data) {
        Node newNode = new Node(data);
        if (top == null)
            top = newNode;
        else {
            newNode.next = top;
            top = newNode;
        }
    }

    /**
     * This method returns the top element of the stack.
     * @return top element of the stack
     */
    public Object pop() {
        if (top == null)
            throw new IllegalArgumentException("Stack is empty");
        Object data = top.data;
        top = top.next;

        return data;
    }

    /**
     * This method returns the top element of the stack.
     * @return top element of the stack
     */
    public Object peek() {
        if (top == null)
            throw new IllegalArgumentException("Stack is empty");
        return top.data;
    }

    /**
     * This method returns the stack in string format.
     * @return stack in string format
     */
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        Node temp = top;
        while (temp != null) {
            sb.append(temp.data);
            if (temp.next != null)
                sb.append(" -> ");
            temp = temp.next;
        }
        sb.append("]");

        return sb.toString();
    }
}
