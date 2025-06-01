package leetcode;

/*
    4. Median of Two Sorted Arrays
    Hard
    Topics
    Companies
    Given two sorted arrays nums1 and nums2 of size m and n respectively, return the median of the two sorted arrays.

    The overall run time complexity should be O(log (m+n)).



    Example 1:

    Input: nums1 = [1,3], nums2 = [2]
    Output: 2.00000
    Explanation: merged array = [1,2,3] and median is 2.
    Example 2:

    Input: nums1 = [1,2], nums2 = [3,4]
    Output: 2.50000
    Explanation: merged array = [1,2,3,4] and median is (2 + 3) / 2 = 2.5.


    Constraints:

    nums1.length == m
    nums2.length == n
    0 <= m <= 1000
    0 <= n <= 1000
    1 <= m + n <= 2000
    -106 <= nums1[i], nums2[i] <= 106
*/

import java.util.Arrays;
import java.util.stream.IntStream;

public class LC_4_MedianOfTwoSortedArrays {
    public static void main(String[] args) {
        int[] nums1 = {1, 3};
        int[] nums2 = {2};
        System.out.println("Median is: " + findMedianSortedArrays(nums1, nums2));
        System.out.println("Median using brute approach is: " + findMedianOfTwoSortedArraysBrute(nums1, nums2));
        System.out.println("Median using merge approach is: " + findMedianOfTwoSortedArraysUsingMerge(nums1, nums2));
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }

        int x = nums1.length;
        int y = nums2.length;
        int low = 0, high = x;

        while (low <= high) {
            int partitionX = (low + high) / 2;
            int partitionY = (x + y + 1) / 2 - partitionX;

            int maxX = (partitionX == 0) ? Integer.MIN_VALUE : nums1[partitionX - 1];
            int maxY = (partitionY == 0) ? Integer.MIN_VALUE : nums2[partitionY - 1];

            int minX = (partitionX == x) ? Integer.MAX_VALUE : nums1[partitionX];
            int minY = (partitionY == y) ? Integer.MAX_VALUE : nums2[partitionY];

            if (maxX <= minY && maxY <= minX) {
                if ((x + y) % 2 == 0) {
                    return ((double)Math.max(maxX, maxY) + Math.min(minX, minY)) / 2;
                } else {
                    return (double)Math.max(maxX, maxY);
                }
            } else if (maxX > minY) {
                high = partitionX - 1;
            } else {
                low = partitionX + 1;
            }
        }

        throw new IllegalArgumentException("Input arrays are not sorted");
    }

    /*
    Combine both arrays into one new array,
    then sort it and pick the median element. Although simple to implement,
    this method uses additional space (O(m+n)) and
    takes O((m+n)+log(m+n)) time due to the sort.
    */
    public static double findMedianOfTwoSortedArraysBrute(int[] arr1, int[] arr2) {
        int m = arr1.length;
        int n = arr2.length;
        int[] merged = new int[m+n];
        IntStream.range(0, m).forEach(i -> merged[i] = arr1[i]);
        IntStream.range(0, n).forEach(i -> merged[m + i] = arr2[i]);

        // sort the merge array
        Arrays.sort(merged);

        int lengthOfMergedArray = merged.length;
        if (lengthOfMergedArray % 2 == 0) {
            return (merged[lengthOfMergedArray / 2 - 1] + merged[lengthOfMergedArray / 2]) / 2.0;
        } else {
            return merged[lengthOfMergedArray / 2];
        }
    }

    /**
     * Find the median of two sorted arrays using a merge-like approach.
     * @param arr1 first sorted array
     * @param arr2 second sorted array
     * @return the median of the two sorted arrays
     * Approach:
     * 1. Initialize two pointers p and q for arr1 and arr2 respectively.
     * 2. Iterate through the arrays, merging them until reaching the middle.
     * 3. Keep track of the last two elements added to the merged array.
     * 4. If the total length is even, return the average of the last two elements.
     * 5. If odd, return the last element added.
     * This method runs in O(m+n) time and uses O(1) space.
     */
    public static double findMedianOfTwoSortedArraysUsingMerge(int[] arr1, int[] arr2) {
        int m = arr1.length;
        int n = arr2.length;
        int totalLength = m + n;
        int p = 0, q = 0;
        int med1 = 0, med2 = 0;

        for (int i = 0; i < totalLength / 2; i++) {
            med1 = med2;
            if (p < m && (q >= n || arr1[p] < arr2[q])) {
                med2 = arr1[p];
                p++;
            } else {
                med2 = arr2[q];
                q++;
            }
        }

        if (totalLength % 2 == 0)
            return (med1 + med2) / 2.0;
        else
            return med2;
    }
}
