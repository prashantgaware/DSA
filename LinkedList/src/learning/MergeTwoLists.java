package learning;

public class MergeTwoLists {
    public static Node mergeTwoLists(Node h1, Node h2) {
        Node dummy = new Node(0);
        Node current = dummy;

        while (h1 != null && h2 != null) {
            if (h1.data <= h2.data) {
                current.next = h1;
                h1 = h1.next;
            } else {
                current.next = h2;
                h2 = h2.next;
            }
            current = current.next;
        }

        if (h1 != null) {
            current.next = h1;
        } else
            current.next = h2;

        return dummy.next;
    }

    public static void main(String[] args) {
        // Create list1: 1 -> 3 -> 5
        Node l1 = new Node(1);
        l1.next = new Node(3);
        l1.next.next = new Node(5);

        // Create list2: 2 -> 4 -> 6
        Node l2 = new Node(2);
        l2.next = new Node(4);
        l2.next.next = new Node(6);

        Node mergedList = mergeTwoLists(l1, l2);
        Node current = mergedList;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
    }
}
