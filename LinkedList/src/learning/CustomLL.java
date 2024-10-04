package learning;

public class CustomLL {

    CustomNode head;

    private static class CustomNode {
        Object data;
        CustomNode next;

        public CustomNode (Object data) {
            this.data = data;
        }
    }

    public void insert(Object data) {
        CustomNode newNode = new CustomNode(data);
        if (head == null) {
            head = newNode;
        } else {
            CustomNode curr = head;
            while (curr.next != null) {
                curr = curr.next;
            }
            curr.next = newNode;
        }
    }

    public void insertAtFirst(Object data) {
        CustomNode fistNode = new CustomNode(data);
        if (head == null)
            head = fistNode;
        else {
            fistNode.next = head;
            head = fistNode;
        }
    }

    public void insertAtSpecifiedPosition(Object data, int index) {
        CustomNode newNode = new CustomNode(data);
        if (head == null)
            return;

        if (index == 0) {
            head = newNode;
            return;
        }

        CustomNode curr = head;
        int customIndex = 0;
        while (curr != null && customIndex < index-1) {
            curr = curr.next;
            customIndex++;
        }

        newNode.next = curr.next;
        curr.next = newNode;
    }

    public void remove(Object data) {
        if (head == null)
            return;

        if (head.data.equals(data)) {
            head = head.next;
            return;
        }

        CustomNode curr = head;
        CustomNode prev = null;
        while (curr != null && !curr.data.equals(data)) {
            prev = curr;
            curr = curr.next;
        }

        prev.next = curr.next;
    }
}
