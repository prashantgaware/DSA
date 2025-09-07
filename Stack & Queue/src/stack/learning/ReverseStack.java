package stack.learning;

import java.util.Stack;

public class ReverseStack {
    private static void stackReversal(Stack<Integer> stack) {
        int size = stack.size();
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = stack.pop();
        }

        for (int i  = 0; i < size; i++)
            stack.push(array[i]);
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();

        // Push some elements into the stack
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);

        System.out.println("Original Stack: " + stack);
        stackReversal(stack);
        System.out.println("Reversed Stack: " + stack);
    }
}
