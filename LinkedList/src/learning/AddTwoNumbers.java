package learning;

public class AddTwoNumbers {
    public static void main(String[] args) {

        Node l1 = new Node(2);
        l1.next = new Node(4);
        l1.next.next = new Node(3);

        Node l2 = new Node(5);
        l2.next = new Node(6);
        l2.next.next = new Node(4);

        Node result = addTwoNumber(l1, l2);
        printList(result); // Output: 7 -> 0 -> 8

        Node res = addTwoNums(l1, l2);
        printList(res); // Output: 7 -> 0 -> 7
    }

    private static void printList(Node head) {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    public static Node addTwoNums(Node h1, Node h2) {
        Node dummy = new Node(-1);
        Node curr = dummy;
        int carry = 0;

        while (h1 != null || h2 != null) {
            int sum = carry;
            if (h1 != null)
                sum += h1.data;
            if (h2 != null)
                sum += h2.data;

            carry = sum / 10;
            curr.next = new Node(sum % 10);
            curr = curr.next;

            if (h1 != null)
                h1 = h1.next;
            if ((h2 != null))
                h2 = h2.next;
        }

        if (carry > 0) {
            curr.next = new Node(carry);
            curr = curr.next;
        }
        return dummy.next;
    }

    public static Node addTwoNumber(Node l1, Node l2) {
        Node dummy = new Node(-1);
        Node curr = dummy;
        int carry = 0;

        while (l1 != null || l2 != null || carry != 0) {
            int sum = carry;
            if (l1 != null) {
                sum += l1.data;
                l1 = l1.next;
            }
            if (l2 != null) {
                sum += l2.data;
                l2 = l2.next;
            }
            carry = sum / 10;
            curr.next = new Node(sum % 10);
            curr = curr.next;
        }

        return dummy.next;
    }
}
