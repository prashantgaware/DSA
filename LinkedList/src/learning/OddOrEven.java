package learning;

public class OddOrEven {
    public static boolean isOdd(Node head) {
        if (head == null)
            return true;

        int count = 0;
        Node temp = head;
        while (temp != null) {
            count++;
            temp = temp.next;
        }

        return count % 2 != 0;
    }

    public static boolean isOddUsingPointer(Node head) {
        if (head == null)
            return false;

        Node temp = head;
        while (temp != null && temp.next  != null)
            temp = temp.next.next;

        return temp != null;
    }
}
