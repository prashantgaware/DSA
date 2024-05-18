package sorting.bubble;

import java.util.Arrays;
import java.util.Scanner;

public class BubbleSort {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter number of array element : ");
        int n  = scanner.nextInt();
        int[] arr = new int[n];
        System.out.print("Enter array elements : ");
        for (int i=0; i<n; i++)
            arr[i] = scanner.nextInt();

        System.out.println("Original Array : " + Arrays.toString(arr));
        System.out.println("Sorted Array : " + Arrays.toString(bubbleSort(arr)));
    }

    private static int[] bubbleSort(int[] arr) {
        int n = arr.length;
        boolean swapped;

        for (int i=0; i<n-1; i++) {
            swapped = false;

            for (int j=0; j< n-1-i; j++) {
                if (arr[j] > arr[j+1]) {
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;

                    swapped = true;
                }
            }

            if (!swapped)
                break;
        }

        return arr;
    }
}