package learning;

import java.util.Scanner;

public class LargestElement {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Array Size : ");
        int n = scanner.nextInt();

        int[] arr = new int[n];
        System.out.print("Enter Array Elements :");
        for (int i=0; i<n; i++){
            arr[i] = scanner.nextInt();
        }

        System.out.println(getLargestNaive(arr));
        System.out.println(getLargestEff(arr));
    }

    private static int getLargestEff(int[] arr) {
        int res = 0;
        for(int i=0; i<arr.length; i++) {
            if (arr[i] > arr[res])
                res = i;
        }

        return res;
    }

    private static int getLargestNaive(int[] arr) {
        int n = arr.length;

        for (int i=0; i<n; i++) {
            boolean flag = true;
            for (int j=0; j<n; j++) {
                if (arr[j] > arr[i]){
                    flag = false;
                    break;
                }
            }

            if (flag)
                return i;
        }
        return -1;
    }
}
