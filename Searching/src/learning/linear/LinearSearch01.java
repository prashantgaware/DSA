package learning.linear;

import java.util.Scanner;

public class LinearSearch01 {
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

        System.out.println(lSearchSorted(arr, target));
        System.out.println(lSearchUnsorted(arr, target));
    }

    private static int lSearchSorted(int[] arr, int target) {
        for (int i=0; i<arr.length; i++) {
            if (target <= arr[i]) {
                break;
            }

            if (i == target || target < arr[i]) {
                System.out.println("Not found.");
            } else {
                return i;
            }
        }

        return -1;
    }

    private static int lSearchUnsorted(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (target == arr[i]) {
                return i;
            } else if (target < arr[i]) {
                System.out.println("Not found.");
                return -1;
            }
        }

        return -1;
    }
}
