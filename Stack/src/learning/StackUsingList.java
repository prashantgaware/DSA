package learning;

import java.util.ArrayList;

public class StackUsingList {
    ArrayList<Integer> list;
    int height;

    public StackUsingList(ArrayList<Integer> list) {
        this.list = list;
        height = 0;
    }

    public void push(int data) {
        list.add(data);
        height++;
    }

    public int pop() {
        if (list.isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }
        height--;
        return list.remove(list.size() - 1);
    }

    public int peek() {
        if (list.isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }
        return list.get(list.size() - 1);
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }

    public int size() {
        return height;
    }

    public static void main(String[] args) {
        StackUsingList stack = new StackUsingList(new ArrayList<>());

        stack.push(10);
        stack.push(20);
        stack.push(30);
        System.out.println("Top element: " + stack.peek()); // Output: 30
        System.out.println("Stack size: " + stack.size()); // Output: 3
        System.out.println("Popped element: " + stack.pop()); // Output: 30
        System.out.println("Stack size after pop: " + stack.size()); // Output: 2
        System.out.println("Is stack empty? " + stack.isEmpty()); // Output: false
        stack.pop();
        stack.pop();
        try {
            stack.pop(); // This will throw an exception
        } catch (RuntimeException e) {
            System.out.println(e.getMessage()); // Output: Stack is empty
        }
        System.out.println("Is stack empty after popping all elements? " + stack.isEmpty()); // Output: true
    }
}


