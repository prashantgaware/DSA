package learning;

import java.util.Scanner;

public class SecondLargest {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Array Size : ");
        int n = scanner.nextInt();

        int[] arr = new int[n];
        System.out.print("Enter Array Elements :");
        for (int i=0; i<n; i++){
            arr[i] = scanner.nextInt();
        }

        System.out.println(getSecondLargestNaive(arr));
        System.out.println(getSecondLargestEfficient(arr));
    }

    private static int getSecondLargestEfficient(int[] arr) {
        int n = arr.length;
        int sec = -1;
        int lar = 0;

        for (int i=1; i<n; i++) {
            if (arr[i] > arr[lar]) {
                sec = lar;
                lar = i;
            } else if (arr[i] != arr[lar]) {
                if (sec == -1 || arr[i] > arr[lar])
                    sec = i;
            }
        }

        return sec;
    }

    private static int getLargest(int[] arr) {
        int largest = 0;
        for (int i=0; i<arr.length; i++) {
            if (arr[i] > arr[0])
                largest = i;
        }
        return largest;
    }

    private static int getSecondLargestNaive(int[] arr) {
        int largest = getLargest(arr);

        int res = -1;
        for (int i=0; i<arr.length; i++) {
            if (arr[i] != arr[largest]) {
                if (res == -1)
                    res = i;
                else if (arr[i] > arr[largest])
                    res = i;
            }
        }

        return res;
    }
}
