package learning;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class NthNodeFromEnd {
    public static int findNthNodeFromEnd(Node head, int n) {
        int length = 0;
        Node temp = head;

        while (temp != null) {
            length++;
            temp = temp.next;
        }

        if (n > length) {
            throw new IllegalArgumentException("Invalid argument");
        }

        int target = length - n;
        temp = head;

        for (int i = 0; i < target; i++) {
            temp = temp.next;
        }

        return temp.data;
    }

    public static int findNthFromEndEff(Node head, int n) {
        Node fast = head;
        Node slow = head;

        for (int i = 0; i < n; i++) {
            if (fast == null) {
                throw new IllegalArgumentException("Invalid");
            }

            fast = fast.next;
        }

        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }

        return slow.data;
    }

    public static int findNthUsingArrayList(Node head, int n) {
        List<Node> list = new ArrayList<>();
        Node temp = head;

        while (temp != null) {
            list.add(temp);
            temp = temp.next;
        }

        int target = list.size() - n;
        if (target < 0 || target >= list.size()) {
            throw new IllegalArgumentException("Invalid.");
        }

        return list.get(target).data;
    }

    public static int findNthUsingHashMap(Node head, int n) throws Exception {
        HashMap<Integer, Node> hm = new HashMap<>();
        Node temp = head;
        int index = 0;

        while (temp != null) {
            hm.put(index, temp);
            index++;
            temp = temp.next;
        }

        int target = index - n;
        if (target < 0 || target >= index) {
            throw new Exception("Fewer number of nodes in the list.");
        }

        return hm.get(target).data;
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        System.out.println(findNthNodeFromEnd(head, 3));
        System.out.println(findNthFromEndEff(head, 2));
        System.out.println(findNthUsingArrayList(head, 1));
    }
}
