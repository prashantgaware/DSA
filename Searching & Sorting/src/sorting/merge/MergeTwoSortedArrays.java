package sorting.merge;

import java.util.Arrays;

public class MergeTwoSortedArrays {
    public static void main(String[] args) {
        int[] arr1 = {10,30, 60};
        int[] arr2 = {20,30,40};
        mergeTwoSortedArraysNaive(arr1, arr2, arr1.length, arr2.length);
        System.out.println();
        mergeTwoSortedArraysEfficient(arr1, arr2, arr1.length, arr2.length);

    System.out.println();
        // Merge function for MergeSort
        int[] arr3 = {40,60,70,10,30};
        int left = 0, right = arr3.length - 1;
        int mid = (left+right) / 2;
        merge(arr3, left, mid, right);
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

    private static void merge(int[] arr, int low, int mid, int high) {
        int n1 = mid - low + 1;
        int n2 = high - mid;

        int[] left = new int[n1];
        int[] right = new int[n2];

        for (int i=0; i<n1; i++)
            left[i] = arr[low+i];

        for (int i=0; i<n2; i++)
            right[i] = arr[mid+1+i];

        int i = 0, j = 0, k = low;

        while (i<n1 && j<n2) {
            if (left[i] <= right[j]) {
                arr[k] = left[i];
                i++;
            }
            else {
                arr[k] = right[j];
                j++;
            }
            k++;
        }

        while (i<n1) {
            arr[k] = left[i];
            k++; i++;
        }

        while (j<n2) {
            arr[k] = right[j];
            k++; j++;
        }

        for (int val : arr)
            System.out.print(val + " ");
    }
}
