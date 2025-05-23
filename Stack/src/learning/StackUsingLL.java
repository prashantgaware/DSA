package learning;

class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class StackUsingLL {
    private Node top;
    private int height;

    public StackUsingLL() {
        this.top = null;
        this.height = 0;
    }

    public boolean isEmpty() {
        return top == null;
    }

    public void push(int data) {
        Node newNode = new Node(data);
        newNode.next = top;
        top = newNode;
        height++;
    }

    public int pop() throws Exception {
        if (isEmpty())
            throw new IllegalArgumentException("Stack is empty.");

        int value = top.data;
        top = top.next;
        height--;
        return value;
    }

    public int peek() throws Exception {
        if (isEmpty())
            throw new IllegalArgumentException("Stack is empty.");

        return top.data;
    }

    public void display() {
        if (isEmpty()) {
            System.out.println("Stack is empty.");
            return;
        }

        Node curr = top;
        while (curr != null) {
            System.out.print(curr.data + "  ");
            curr = curr.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        StackUsingLL stack = new StackUsingLL();
//        System.out.println(sll.isEmpty());
        try {
            stack.push(10);
            stack.push(20);
            stack.push(30);
            stack.display();

            System.out.println("Top element: " + stack.peek());

            System.out.println("Popped element: " + stack.pop());
            stack.display();

            System.out.println("Popped element: " + stack.pop());
            System.out.println("Popped element: " + stack.pop());
            stack.display();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
