package learning;

import java.util.HashMap;
import java.util.Map;

public class MiddleOfLinkedList {
    public static Node getMiddleBrute(Node head) {
        if (head == null)
            return null;

        Node temp = head;
        int count = 0;
        while (temp != null) {
            count++;
            temp = temp.next;
        }

        temp = head;
        for (int i = 0; i < count / 2; i++) {
            temp = temp.next;
        }

        return temp;
    }

    public static Node getMiddleUsingHashMap(Node head) {
        Map<Integer, Node> nodes = new HashMap<>();
        int count = 0;
        Node temp = head;
        while (temp != null) {
            nodes.put(count, temp);
            count++;
            temp = temp.next;
        }

        return nodes.get(count / 2);
    }

    public static Node getMiddleUsingTwoPointers(Node head) {
        if (head == null)
            return null;

        Node fast = head, slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        return slow;
    }
}
