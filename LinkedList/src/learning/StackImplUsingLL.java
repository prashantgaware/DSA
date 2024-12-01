package learning;

public class StackImplUsingLL {
    private Node top;

    public StackImplUsingLL() {
        this.top = null;
    }

    public boolean isEmpty() {
        return top == null;
    }

    public void push(int data) {
        if (isEmpty())
            System.out.println("LL is empty");

        Node newTop = new Node(data);
        newTop.next = top;
        top = newTop;
    }

    public int pop() {
        if (isEmpty())
            System.out.println("LL is empty");

        int val = top.data;
        top = top.next;
        return val;
    }

    public int peek() {
        if (isEmpty())
            System.out.println("LL is empty");

        return top.data;
    }

    public void display() {
        if (isEmpty())
            System.out.println("LL is empty");

        Node current = top;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        StackImplUsingLL stack = new StackImplUsingLL();
        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.display();

        System.out.println("Top element: " + stack.peek());

        System.out.println("Popped element: " + stack.pop());
        stack.display();

        System.out.println("Popped element: " + stack.pop());
        System.out.println("Is Empty : " + stack.isEmpty());
        System.out.println("Popped element: " + stack.pop());
        stack.display();
    }
}
