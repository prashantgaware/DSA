package com.cf.stack;

public class StackUsingLinkedListTest {
    public static void main(String[] args) {
        StackImplUsingLinkedList stack = new StackImplUsingLinkedList();
        stack.push(10);
        stack.push(20);
        stack.push(30);
        System.out.println("Stack: " + stack.toString());
        System.out.println("Popped element: " + stack.pop());
        System.out.println("Top element after pop: " + stack.peek());
        System.out.println("Current Stack: " + stack.toString());
        stack.push(40);
        stack.push(50);
        System.out.println("Updated Stack: " + stack.toString());
    }
}
