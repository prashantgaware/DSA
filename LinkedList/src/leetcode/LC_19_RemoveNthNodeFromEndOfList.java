package leetcode;
/**
 * 19. Remove Nth Node From End of List
 * <p>
 * Given the head of a linked list, remove the nth node from the end of the list and return its head.
 * <p>
 * Follow up: Could you do this in one pass?
 * <p>
 * Test
 * Input: head = [1,2,3,4,5], n = 2
 * Output: [1,2,3,5]
 */

public class LC_19_RemoveNthNodeFromEndOfList {
    /**
     * This method removes the nth node from the end of the linked list.
     * @param head - head of the linked list
     * @param n - nth node from the end
     * @return head of the linked list after removing the nth node from the end
     * <p>
     * Approach:
     * 1. We can't delete the node directly as we don't have access to the previous node.
     * 2. So, we will copy the value of the next node to the current node and delete the next node.
     * 3. This way, we are able to delete the current node.
     * 4. Time complexity is O(1).
     * 5. Space complexity is O(1).
     */
    private static Node removeNthFromEnd(Node head, int n) {
        Node dummy = new Node(0);
        dummy.next = head;
        Node first = dummy;
        Node last = dummy;

        for (int i = 0; i <= n; i++) {
            first = first.next;
        }

        while (first != null) {
            first = first.next;
            last = last.next;
        }

        last.next = last.next.next;

        return dummy.next;
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);

        int n = 2;
        Node result = removeNthFromEnd(head, n);
        printLinkedList(result);
    }

    private static void printLinkedList(Node result) {
        Node current = result;
        while (current != null) {
            if (current.next != null) {
                System.out.print(current.val + " -> ");
            } else {
                System.out.print(current.val);
            }
            current = current.next;
        }
    }
}
