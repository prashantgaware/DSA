package com.cf.stack;

import java.util.Stack;

public class StackExample {
    public static void main(String[] args) {
        Stack<Integer> st = new Stack<>();
        // st.add(10); // add() method is not available in Stack class
        st.add(5);
        st.push(10);
        st.push(20);
        st.push(30);
        st.push(40);
        st.push(50);
        System.out.println("Stack: " + st);
        System.out.println("Pop: " + st.pop());
        System.out.println("Stack: " + st);
    }
}
