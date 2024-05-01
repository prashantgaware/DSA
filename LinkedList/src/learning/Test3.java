package learning;

// Traversal

public class Test3 {
    private static Node convertArrToLL(int[] arr){
        Node head = new Node(arr[0]);
        Node mover = head;
        for (int i=1; i<arr.length; i++){
            Node temp = new Node(arr[i]);
            mover.next = temp;
            mover = temp;
        }
        return head;
    }

    private static void traversalOfLL(int[] arr){
        Node head = convertArrToLL(arr);
        Node temp = head;
        while(temp != null){
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    private static int lengthOfLL(Node head){
        int count = 0;
        Node temp = head;
        while(temp != null){
            temp = temp.next;
            count++;
        }
        return count;
    }

    private static int checkIfPresent(Node head, int val) {
        Node temp = head;
        while (temp != null) {
            if (temp.data == val) {
                return 1;
            }
            temp = temp.next;
        }

        return 0;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6};
        Node head = convertArrToLL(arr);
        System.out.println(head.data);
        System.out.println(head.next.data);
        traversalOfLL(arr);
        System.out.println(lengthOfLL(head));
        System.out.println(checkIfPresent(head, 3));
    }
}
