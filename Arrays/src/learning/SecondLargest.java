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
        System.out.println(getSecondLargestEff(arr));
    }

    private static int getSecondLargestEfficient(int[] arr) {
        int n = arr.length;
        if (n < 2) return -1;

        int sec = -1;
        int lar = 0;

        for (int i = 1; i < n; i++) {
            if (arr[i] > arr[lar]) {
                sec = lar;
                lar = i;
            } else if (arr[i] != arr[lar]) {
                if (sec == -1 || arr[i] > arr[sec])
                    sec = i;
            }
        }

        return (sec == -1) ? -1 : arr[sec];
    }


    private static int getSecondLargestEff(int[] arr) {
        if (arr.length < 2) {
            return -1;
        }

        int largest = Integer.MIN_VALUE;
        int sLargest = Integer.MIN_VALUE;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > largest) {
                sLargest = largest;
                largest = arr[i];
            } else if (arr[i] > sLargest && arr[i] != largest) {
                sLargest = arr[i];
            }
        }

        return (sLargest == Integer.MIN_VALUE) ? -1 : sLargest;
    }


    private static int getLargest(int[] arr) {
        int largest = 0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > arr[largest])
                largest = i;
        }
        return largest;
    }


    private static int getSecondLargestNaive(int[] arr) {
        int largest = getLargest(arr);

        int res = -1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != arr[largest]) {
                if (res == -1 || arr[i] > arr[res])
                    res = i;
            }
        }

        return (res == -1) ? -1 : arr[res];
    }

}
