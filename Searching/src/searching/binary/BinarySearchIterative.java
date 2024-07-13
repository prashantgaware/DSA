package searching.binary;

import java.util.Scanner;

public class BinarySearchIterative {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Array Size : ");
        int n = scanner.nextInt();

        int[] arr = new int[n];
        System.out.print("Enter Array Elements :");
        for (int i=0; i<n; i++){
            arr[i] = scanner.nextInt();
        }

        System.out.print("Enter target : ");
        int target = scanner.nextInt();

        System.out.println(bSearchIterative(arr, n, target));
    }

    private static int bSearchIterative(int[] arr, int n, int target) {
        int low = 0, high = n-1;
        while (low <= high) {
            int mid = (low + high) / 2;

            if (arr[mid] == target)
                return mid;
            else if (target > arr[mid]) {
                low = mid+1;
            } else {
                high = mid-1;
            }
        }

        return -1;
    }
}
