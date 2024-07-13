package searching.learning.binary;

import java.util.Scanner;

public class BinarySearchRecursive {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Array Size : ");
        int n = scanner.nextInt();

        int[] arr = new int[n];
        System.out.print("Enter Array Elements :");
        for (int i=0; i<n; i++){
            arr[i] = scanner.nextInt();
        }

        int low = 0, high = n-1;

        System.out.print("Enter target : ");
        int target = scanner.nextInt();

        System.out.println(bSearchRecursive(arr, low, high, target));
    }

    private static int bSearchRecursive(int[] arr, int low, int high, int target) {
        if(low > high)
            return -1;

        int mid = (low+high) / 2;

        if (arr[mid] == target)
            return mid;
        else if (target > arr[mid])
            return bSearchRecursive(arr, mid+1, high, target);
        else
            return bSearchRecursive(arr, low, mid-1, target);
    }

}
