package stack.learning;

import java.util.LinkedList;
import java.util.Queue;

public class StackUsingQueue {
    private Queue<Integer> queue1;
    private Queue<Integer> queue2;

    public StackUsingQueue() {
        queue1 = new LinkedList<>();
        queue2 = new LinkedList<>();
    }

    public void push(int data) {
        queue1.offer(data);
    }

    public int pop() {
        if (queue1.isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }
        while (queue1.size() > 1) {
            queue2.offer(queue1.poll());
        }
        int poppedValue = queue1.poll();
        Queue<Integer> temp = queue1;
        queue1 = queue2;
        queue2 = temp;
        return poppedValue;
    }

    public int peek() {
        if (queue1.isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }
        while (queue1.size() > 1) {
            queue2.offer(queue1.poll());
        }
        int topValue = queue1.peek();
        queue2.offer(queue1.poll());
        Queue<Integer> temp = queue1;
        queue1 = queue2;
        queue2 = temp;
        return topValue;
    }

    public boolean isEmpty() {
        return queue1.isEmpty();
    }

    public int size() {
        return queue1.size();
    }

    public static void main(String[] args) {
        StackUsingQueue stack = new StackUsingQueue();

        stack.push(10);
        stack.push(20);
        stack.push(30);

        System.out.println("Top element: " + stack.peek()); // Output: 30
        System.out.println("Stack size: " + stack.size()); // Output: 3
        System.out.println("Popped element: " + stack.pop()); // Output: 30
        System.out.println("Stack size after pop: " + stack.size()); // Output: 2
    }
    
}
