package sorting.merge;

import java.util.Arrays;

public class MergeTwoSortedArrays {
    public static void main(String[] args) {
        int[] arr1 = {10,30, 60};
        int[] arr2 = {20,30,40};
        mergeTwoSortedArraysNaive(arr1, arr2, arr1.length, arr2.length);
        System.out.println();
        mergeTwoSortedArraysEfficient(arr1, arr2, arr1.length, arr2.length);
    }

    private static void mergeTwoSortedArraysNaive(int[] a, int[] b, int m, int n) {
        int[] c = new int[m+n];

        for (int i = 0; i<n; i++) {
            c[i] = a[i];
        }
        for (int i=0; i<n; i++)
            c[m+i] = b[i];

        Arrays.sort(c);

        for (int val: c)
            System.out.print(val + " ");
    }

    private static void mergeTwoSortedArraysEfficient(int[] a, int[] b, int m, int n) {
        int[] c = new int[m+n];
        int i = 0, j = 0, k = 0;

        while (i<m && j<n) {
            if (a[i] <= b[j]) {
                c[k] = a[i];
                k++; i++;
            } else {
                c[k] = b[j];
                k++; j++;
            }
        }

        while (i<m) {
            c[k] = a[i];
            k++; i++;
        }
        while (j<n) {
            c[k] = b[j];
            k++; j++;
        }

        for(int val : c)
            System.out.print(val + " ");
    }
}
