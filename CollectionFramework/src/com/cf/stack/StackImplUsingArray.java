package com.cf.stack;

import java.util.Arrays;

/**
 * This class implements stack using array.
 */
public class StackImplUsingArray {

    // Array to store the stack elements
    Object[] stackArray = null;

    // Index to keep track of the top element of the stack
    int index = 0;

    // Default constructor
    public StackImplUsingArray() {
        stackArray = new Object[10];
    }

    // Parameterized constructor
    public StackImplUsingArray(int size) {
        stackArray = new Object[size];
    }

    /**
     * This method pops the top element from the stack.
     * @return top element of the stack
     */
    public Object pop() {
        if (index == 0) {
            throw new IllegalArgumentException("Stack is empty");
        }

        Object obj = stackArray[index - 1];
        stackArray[index - 1] = null;
        index--;

        return obj;
    }

    /**
     * This method pushes the object into the stack.
     * @param obj - object to be pushed
     */
    public void push(Object obj) {
        if (index >= stackArray.length) {
            int newSize = stackArray.length * 2;
            stackArray = Arrays.copyOf(stackArray, newSize);
        }

        stackArray[index] = obj;
        index++;
    }

    /**
     * This method returns the top element of the stack.
     * @return top element of the stack
     */
    public Object peek() {
        if (index == 0) {
            throw new IllegalArgumentException("Stack is empty");
        }

        return stackArray[index - 1];
    }

    /**
     * This method returns the stack in string format.
     * @return stack in string format
     */
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < index; i++) {
            if (i == (index - 1)) {
                sb.append(stackArray[i]);
            } else {
                sb.append(stackArray[i]).append(", ");
            }
        }
        sb.append("]");

        return sb.toString();
    }
}
