package stack.learning;

import java.util.Scanner;

public class Test01 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter number of array element : ");
        int n = scanner.nextInt();
        int[] arr = new int[n];
        System.out.print("Enter array elements : ");
        for (int i=0; i<n; i++) {
            arr[i] = scanner.nextInt();
        }
    }
}
