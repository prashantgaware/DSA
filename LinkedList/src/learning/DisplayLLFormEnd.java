package learning;

import java.util.Stack;

public class DisplayLLFormEnd {

    public static void printFromEndUsingRecursion(Node head) {
        if (head == null)
            return;

        printFromEndUsingRecursion(head.next);
        System.out.print(head.data + " -> ");
    }

    public static void printFromEndUsingStack(Node head) {
        if (head == null)
            return;

        Stack<Node> nodes = new Stack<>();
        Node temp = head;
        while (temp != null) {
            nodes.push(temp);
            temp = temp.next;
        }

        while (!nodes.isEmpty()) {
            System.out.print(nodes.pop().data + " -> ");
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        Node head = new Node(arr[0]);
        Node mover = head;
        for (int i = 1; i < arr.length; i++) {
            Node temp = new Node(arr[i]);
            mover.next = temp;
            mover = temp;
        }

        System.out.println("Printing from end using recursion:");
        printFromEndUsingRecursion(head);
        System.out.println();

        System.out.println("Printing from end using stack:");
        printFromEndUsingStack(head);
    }

}
