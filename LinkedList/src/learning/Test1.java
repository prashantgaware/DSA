package learning;

public class Test1 {
    public static void main(String[] args) {
        int[] arr={ 1,2,3,4,5 };
        Node a = new Node(arr[2]);
        System.out.println(a.data);
        System.out.println(a.next);
        Node b= new Node(arr[3],a);
        System.out.println(b.data);
        System.out.println(b.next.data); // This will print the data of the node 'a' which is the next node of 'b'
        a.next = b; // Now 'a' points to 'b'
        System.out.println(a.next.data); // This will now print the data of the node 'b'


    }
}
