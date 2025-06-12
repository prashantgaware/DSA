package leetcode;

import learning.ListNode;

public class LC_328_OddEvenLinkedList {
    public static ListNode oddEvenList(ListNode head){
        if (head == null)
            return null;

        ListNode oddHead = new ListNode(0);
        ListNode evenHead = new ListNode(0);
        ListNode odd = oddHead;
        ListNode even = evenHead;

        int index = 0;
        while (head != null) {
            if (index % 2 == 0) {
                odd.next = head;
                odd = odd.next;
            } else {
                even.next = head;
                even = even.next;
            }
            head = head.next;
            index++;
        }
        odd.next = evenHead.next;
        even.next = null;
        return oddHead.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        ListNode result = oddEvenList(head);
        while (result != null) {
            System.out.print(result.val + " ");
            result = result.next;
        }
    }
}
