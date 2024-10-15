package leetcode;
/*
    876. Middle of the Linked List
    Given the head of a singly linked list, return the middle node of the linked list.

    If there are two middle nodes, return the second middle node.

    Example 1:
    Input: head = [1,2,3,4,5]
    Output: [3,4,5]
    Explanation: The middle node of the list is node 3.

    Example 2:
    Input: head = [1,2,3,4,5,6]
    Output: [4,5,6]
    Explanation: Since the list has two middle nodes with values 3 and 4, we return the second one.

    Constraints:

    The number of nodes in the list is in the range [1, 100].
    1 <= Node.val <= 100
*/

public class LC_876_MiddleOfTheLinkedList {
    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        head.next.next.next.next.next = new Node(6);

        Node result = getMiddle(head);
        System.out.println(result.val);
    }

    // Approach:
    // 1. We will use two pointers slow and fast.
    // 2. Slow pointer will move one step at a time and fast pointer will move two steps at a time.
    // 3. When fast pointer reaches the end of the linked list, slow pointer will be at the middle of the linked list.
    // 4. Time complexity is O(n).
    // 5. Space complexity is O(1).
    /**
     * This method returns the middle node of the linked list.
     * @param head - head of the linked list
     * @return middle node of the linked list
     */
    private static Node getMiddle(Node head) {
        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }
}
