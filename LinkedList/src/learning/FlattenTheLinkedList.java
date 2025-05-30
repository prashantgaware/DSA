package learning;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FlattenTheLinkedList {

    private static class FlattenNode {
        int val;
        FlattenNode next;
        FlattenNode child;

        FlattenNode(int data) {
            this.val = data;
            this.next = null;
            this.child = null;
        }
    }

    private static FlattenNode flatten(FlattenNode head) {
        if (head == null || head.next == null)
            return head;

        head.next = flatten(head.next);

        head = mergeNodes(head, head.next);

        return head;
    }

    private static FlattenNode mergeNodes(FlattenNode a, FlattenNode b) {
        if (a == null)
            return b;
        if (b == null)
            return a;

        FlattenNode res;
        if (a.val < b.val) {
            res = a;
            res.next = mergeNodes(a.next, b);
        } else {
            res = b;
            res.next = mergeNodes(a, b.next);
        }

        return res;
    }

    private static FlattenNode flattenListUsingArrayList(FlattenNode head) {
        if (head == null) {
            return null;
        }

        List<Integer> nodes = new ArrayList<>();
        FlattenNode current = head;
        while (current != null) {
            FlattenNode temp = current;
            while (temp != null) {
                nodes.add(temp.val);
                temp = temp.next;
            }
            current = current.next;
        }

        Collections.sort(nodes);

        FlattenNode dummy = new FlattenNode(-1);
        FlattenNode res = dummy;
        for (int i : nodes) {
            res.child = new FlattenNode(i);
            res = res.child;
        }

        return dummy.next;
    }
}
