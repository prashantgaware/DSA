package leetcode;
/*
    160. Intersection of Two Linked Lists
    Solved
    Easy
    Topics
    Companies
    Given the heads of two singly linked-lists headA and headB, return the node at which the two lists intersect. If the two linked lists have no intersection at all, return null.

    For example, the following two linked lists begin to intersect at node c1:


    The test cases are generated such that there are no cycles anywhere in the entire linked structure.

    Note that the linked lists must retain their original structure after the function returns.

    Custom Judge:

    The inputs to the judge are given as follows (your program is not given these inputs):

    intersectVal - The value of the node where the intersection occurs. This is 0 if there is no intersected node.
    listA - The first linked list.
    listB - The second linked list.
    skipA - The number of nodes to skip ahead in listA (starting from the head) to get to the intersected node.
    skipB - The number of nodes to skip ahead in listB (starting from the head) to get to the intersected node.
    The judge will then create the linked structure based on these inputs and pass the two heads, headA and headB to your program. If you correctly return the intersected node, then your solution will be accepted.



    Example 1:


    Input: intersectVal = 8, listA = [4,1,8,4,5], listB = [5,6,1,8,4,5], skipA = 2, skipB = 3
    Output: Intersected at '8'
    Explanation: The intersected node's value is 8 (note that this must not be 0 if the two lists intersect).
    From the head of A, it reads as [4,1,8,4,5]. From the head of B, it reads as [5,6,1,8,4,5]. There are 2 nodes before the intersected node in A; There are 3 nodes before the intersected node in B.
    - Note that the intersected node's value is not 1 because the nodes with value 1 in A and B (2nd node in A and 3rd node in B) are different node references. In other words, they point to two different locations in memory, while the nodes with value 8 in A and B (3rd node in A and 4th node in B) point to the same location in memory.
    Example 2:


    Input: intersectVal = 2, listA = [1,9,1,2,4], listB = [3,2,4], skipA = 3, skipB = 1
    Output: Intersected at '2'
    Explanation: The intersected node's value is 2 (note that this must not be 0 if the two lists intersect).
    From the head of A, it reads as [1,9,1,2,4]. From the head of B, it reads as [3,2,4]. There are 3 nodes before the intersected node in A; There are 1 node before the intersected node in B.
    Example 3:


    Input: intersectVal = 0, listA = [2,6,4], listB = [1,5], skipA = 3, skipB = 2
    Output: No intersection
    Explanation: From the head of A, it reads as [2,6,4]. From the head of B, it reads as [1,5]. Since the two lists do not intersect, intersectVal must be 0, while skipA and skipB can be arbitrary values.
    Explanation: The two lists do not intersect, so return null.


    Constraints:

    The number of nodes of listA is in the m.
    The number of nodes of listB is in the n.
    1 <= m, n <= 3 * 104
    1 <= Node.val <= 105
    0 <= skipA < m
    0 <= skipB < n
    intersectVal is 0 if listA and listB do not intersect.
    intersectVal == listA[skipA] == listB[skipB] if listA and listB intersect.
*/

public class LC_160_IntersectionOfTwoLinkedLists {
    public static void main(String[] args) {

        // Test case 1
        Node headA1 = new Node(4);
        headA1.next = new Node(1);
        headA1.next.next = new Node(8);
        headA1.next.next.next = new Node(4);
        headA1.next.next.next.next = new Node(5);

        Node headB1 = new Node(5);
        headB1.next = new Node(6);
        headB1.next.next = new Node(1);
        headB1.next.next.next = headA1.next.next;

        Node result1 = getIntersection(headA1, headB1);
        System.out.println(result1.val);

        // Test case 2
        Node headA2 = new Node(1);
        headA2.next = new Node(9);
        headA2.next.next = new Node(1);
        headA2.next.next.next = new Node(2);
        headA2.next.next.next.next = new Node(4);

        Node headB2 = new Node(3);
        headB2.next = headA2.next.next.next;

        Node result2 = getIntersection(headA2, headB2);
        System.out.println(result2.val);

        // Test case 3
        Node headA3 = new Node(2);
        headA3.next = new Node(6);
        headA3.next.next = new Node(4);

        Node headB3 = new Node(1);
        headB3.next = new Node(5);

        Node result3 = getIntersection(headA3, headB3);
        System.out.println(result3);
    }

    //Approach:
    //1. Find the length of both linked lists.
    //2. Move the pointer of the longer linked list to the same length as the shorter linked list.
    //3. Now, move both pointers until they meet.
    //4. Return the intersection node.
    /**
     * This method returns the intersection node of two linked lists.
     * @param headA - head of the first linked list
     * @param headB - head of the second linked list
     * @return intersection node of two linked lists
     */
    private static Node getIntersection(Node headA, Node headB) {
        Node a = headA;
        Node b = headB;
        int lenA = 0;
        int lenB = 0;

        while (a != null) {
            lenA++;
            a = a.next;
        }
        while (b != null) {
            lenB++;
            b = b.next;
        }

        a = headA;
        b = headB;
        if (lenA > lenB) {
            for (int i = 0; i < lenA - lenB; i++) {
                a = a.next;
            }
        } else {
            for (int i = 0; i < lenB - lenA; i++) {
                b = b.next;
            }
        }

        while (a != b) {
            a = a.next;
            b = b.next;
        }

        return a;
    }
}
