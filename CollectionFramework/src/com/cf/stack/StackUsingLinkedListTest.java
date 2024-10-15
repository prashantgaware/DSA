package com.cf.stack;

public class StackUsingLinkedListTest {
    public static void main(String[] args) {
        CustomStackUsingLinkedList csll = new CustomStackUsingLinkedList();
        csll.push(10);
        csll.push(20);
        csll.push(30);
        csll.push(40);
        csll.push(50);
        System.out.println(csll);
        System.out.println(csll.peek());
        System.out.println(csll.pop());
        csll.push(60);
        System.out.println(csll);

        System.out.println("##########################################");
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
