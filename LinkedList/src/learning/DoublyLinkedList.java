package learning;

class DLLNode {
    int data;
    DLLNode prev;
    DLLNode next;

    public DLLNode(int data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }

    public DLLNode(DLLNode prev, int data, DLLNode next) {
        this.prev = prev;
        this.data = data;
        this.next = next;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public DLLNode getPrev() {
        return prev;
    }

    public void setPrev(DLLNode prev) {
        this.prev = prev;
    }

    public DLLNode getNext() {
        return next;
    }

    public void setNext(DLLNode next) {
        this.next = next;
    }
}

public class DoublyLinkedList {
    private static DLLNode convertArray2DLL(int[] arr) {
        DLLNode head = new DLLNode(arr[0]);
        DLLNode prev = head;
        for (int i = 1; i < arr.length; i++) {
            DLLNode temp = new DLLNode(prev, arr[i], null);
            prev.next = temp;
            prev = temp;
        }

        return head;
    }

    private static void print(DLLNode head) {
        while (head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr = {3,5,2,4,1};
        DLLNode head = convertArray2DLL(arr);
        print(head);
    }
}
