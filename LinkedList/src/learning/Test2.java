package learning;

public class Test2 {
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
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6};
        Node head = convertArrToLL(arr);
        System.out.println(head.data);
        System.out.println(head.next.data);
    }
}
