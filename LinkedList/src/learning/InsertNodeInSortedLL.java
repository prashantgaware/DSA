package learning;

public class InsertNodeInSortedLL {
    public static Node insertNode(Node head, Node newNode) {
        // If the list is empty (head is null), simply return newNode as the new head of the list.
        if (head == null) {
            return newNode;
        }

        // If newNode has a value smaller than the current head, it should become the new head.
        // You link the newNode.next to the old head, then return newNode as the new head.
        if (newNode.data < head.data) {
            newNode.next = head;
            return newNode;
        }

        // Start from the head and iterate through the list until you find a node where:
        //      current.next.data >= newNode.data, or
        //      You've reached the end of the list.
        //This ensures you find the correct sorted position for insertion.
        Node current = head;
        while (current.next != null && current.next.data < newNode.data) {
            current = current.next;
        }

        // insert the newNode between current and current.next.
        newNode.next = current.next;
        current.next = newNode;

        return head;
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(3);
        head.next.next = new Node(5);

        Node newNode = new Node(4);

        head = insertNode(head, newNode);

        // Print the updated linked list
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
    }
}
