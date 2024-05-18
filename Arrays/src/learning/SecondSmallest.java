package learning;

import java.util.Scanner;

public class SecondSmallest {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Array Size : ");
        int n = scanner.nextInt();

        int[] arr = new int[n];
        System.out.print("Enter Array Elements : ");
        for (int i=0; i<n; i++){
            arr[i] = scanner.nextInt();
        }
        
        System.out.println(getSecondLargest(arr));
    }

    private static int getSecondLargest(int[] arr) {
        int smallest = arr[0];
        int sSmallest = Integer.MAX_VALUE;
        
        for (int i=0; i<arr.length; i++) {
            if (arr[i] < smallest) {
                sSmallest = smallest;
                smallest = arr[i];
            } else if (arr[i] != smallest && arr[i] < sSmallest) {
                sSmallest = arr[i];
            }
        }

        return sSmallest;
    }
}
