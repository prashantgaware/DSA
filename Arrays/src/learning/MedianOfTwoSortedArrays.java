package learning;
/*
    Median of two sorted arrays of same size
    Last Updated : 14 Aug, 2024
    Given 2 sorted arrays arr1[] and arr2[], each of size n,
    the task is to find the median of the array obtained after merging arr1[] and arr2[].

    Note: Since the size of the merged array will always be even,
    the median will be the average of the middle two numbers.

    Input: arr1[] = {1, 12, 15, 26, 38}, arr2[] = {2, 13, 17, 30, 45}
    Output: 16
    Explanation: The merged sorted array is {1, 2, 12, 13, 15, 17, 26, 30, 38, 45}.
    The middle two elements are 15 and 17, so median = (15 + 17)/2 = 16

    Input: arr1[] = {10}, arr2[] = {21}
    Output : 15.5
    Explanation : The merged sorted array is {10, 21}. The middle two elements are 10 and 21, so median = (10 + 21)/2 = 15.5
*/

import java.util.Arrays;

public class MedianOfTwoSortedArrays {

    // Using Sorting – O(n * logn) Time and O(n) Space
    private static double getMedianBrute(int[] arr1, int[] arr2) {
        int x = arr1.length + arr2.length;
        int[] arr3 = new int[x];

        System.arraycopy(arr1, 0, arr3, 0, arr1.length);
        System.arraycopy(arr2, 0, arr3, arr1.length, arr2.length);

        Arrays.sort(arr3);

        int n = arr3.length;
        int mid1 = n / 2;
        int mid2 = mid1 - 1;

        return (arr3[mid1] + arr3[mid2]) / 2.0;
    }

    // Using Merge of Merge Sort – O(n) Time and O(1) Space
    private static double getMedianEfficient(int[] arr1, int[] arr2) {
        int n = arr1.length;
        int i = 0, j = 0;
        int count;

        // m1 to store element at index n of merged array
        // m2 to store element at index (n - 1) of merged array
        int m1 = -1, m2 = -1;

        // Loop till n
        for (count = 0; count <= n; count++) {
            m2 = m1;

            // If both the arrays have remaining elements
            if (i < n && j < n) {
                if (arr1[i] > arr2[j])
                    m1 = arr2[j++];
                else
                    m1 = arr1[i++];
            }

            // If only arr1 has remaining elements
            else if (i < n)
                m1 = arr1[i++];

                // If only arr2 has remaining elements
            else
                m1 = arr2[j++];
        }

        return (m1 + m2) / 2.0;
    }

    public static void main(String[] args) {
        int[] arr1 = {1, 12, 15, 26, 38};
        int[] arr2 = {2, 13, 17, 30, 45};

        System.out.println(getMedianBrute(arr1, arr2));
        System.out.println(getMedianEfficient(arr1, arr2));
    }
}
