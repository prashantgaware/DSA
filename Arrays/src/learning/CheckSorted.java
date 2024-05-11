package learning;

import java.util.Scanner;

public class CheckSorted {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Array Size : ");
        int n = scanner.nextInt();

        int[] arr = new int[n];
        System.out.print("Enter Array Elements :");
        for (int i=0; i<n; i++){
            arr[i] = scanner.nextInt();
        }

        System.out.println(isSortedNaive(arr));
        System.out.println(isSortedEfficient(arr));

    }

    private static boolean isSortedEfficient(int[] arr) {
        for (int i=1; i<arr.length; i++) {
            if (arr[i] > arr[i-1])
                return false;
        }

        return true;
    }

    private static boolean isSortedNaive(int[] arr) {
        for (int i=0; i<arr.length-1; i++) {
            for (int j=i+1; j< arr.length; j++) {
                if (arr[i] > arr[j])
                    return false;
            }
        }

        return true;
    }
}
