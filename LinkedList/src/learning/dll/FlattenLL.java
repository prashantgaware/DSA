package learning.dll;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class FlattenDLLNode {
    int data;
    FlattenDLLNode next;
    FlattenDLLNode child;
    FlattenDLLNode prev;

    public FlattenDLLNode(int data) {
        this.data = data;
        this.next = null;
        this.child = null;
        this.prev = null;
    }
}

public class FlattenLL {
    private static FlattenDLLNode flatten(FlattenDLLNode head) {
        if (head == null) {
            return null;
        }

        flattenDFS(head);
        return head;
    }

    private static FlattenDLLNode flattenDFS(FlattenDLLNode node) {
        FlattenDLLNode current = node;
        FlattenDLLNode tail = current;

        while (current != null) {
            if (current.child != null) {
                FlattenDLLNode childTail = flattenDFS(current.child);
                childTail.next = current.next;
                if (current.next != null) {
                    current.next.prev = childTail;
                }
                current.next = current.child;
                current.child.prev = current;
                current.child = null;
            }
            tail = current;
            current = current.next;
        }

        return tail;
    }

    private static FlattenDLLNode flattenUsingArrayList(FlattenDLLNode head) {
        if (head == null) {
            return null;
        }

        List<Integer> nodes = new ArrayList<>();
        FlattenDLLNode current = head;
        while (current != null) {
            FlattenDLLNode temp = current;
            while (temp != null) {
                nodes.add(temp.data);
                temp = temp.next;
            }
            current = current.child;
        }

        Collections.sort(nodes);
        FlattenDLLNode newHead = new FlattenDLLNode(nodes.get(0));
        FlattenDLLNode newCurrent = newHead;

        for (int i = 1; i < nodes.size(); i++) {
            FlattenDLLNode newNode = new FlattenDLLNode(nodes.get(i));
            newCurrent.next = newNode;
            newNode.prev = newCurrent;
            newCurrent = newNode;
        }

        return newHead;
    }

    public static void main(String[] args) {
        FlattenDLLNode head = new FlattenDLLNode(1);
        head.next = new FlattenDLLNode(2);
        head.next.prev = head;
        head.next.child = new FlattenDLLNode(3);
        head.next.child.next = new FlattenDLLNode(4);
        head.next.child.next.prev = head.next.child;
        head.next.child.next.child = new FlattenDLLNode(5);
        head.next.child.next.child.next = new FlattenDLLNode(6);
        head.next.child.next.child.next.prev = head.next.child.next;
        head.next.child.next.child.next.child = new FlattenDLLNode(7);
        head.next.child.next.child.next.child.next = new FlattenDLLNode(8);
        head.next.child.next.child.next.child.next.prev = head.next.child.next.child.next;
        head.next.child.next.child.next.child.next.child = new FlattenDLLNode(9);
        head.next.child.next.child.next.child.next.child.next = new FlattenDLLNode(10);

        FlattenDLLNode flattenedHead = flatten(head);
        System.out.println("Flattened List:");
        printList(flattenedHead);

        FlattenDLLNode flattenedUsingArrayList = flattenUsingArrayList(head);
        System.out.println("Flattened List using ArrayList:");
        printList(flattenedUsingArrayList);
    }

    private static void printList(FlattenDLLNode head) {
        FlattenDLLNode current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }
}
