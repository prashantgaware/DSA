package learning;

import java.util.Arrays;

public class MinimumInRotatedSortedArray {
    public static int findMinInRotatedSortedArrayBrute(int[] arr) {
        if (arr == null || arr.length == 0)
            return -1;
        Arrays.sort(arr);
        return arr[0];
    }

    public static int findMinLinear(int[] nums) {
        int min = 0;
        for (int i = 0; i < nums.length-1; i++) {
            if (nums[i] < min)
                min = i;
        }

        return min;
    }

    public static int findMinInRotatedSortedArray(int[] nums) {
        if (nums == null || nums.length == 0)
            return -1;

        int low = 0;
        int high = nums.length - 1;
        while (low < high) {
            int mid = (low + high) / 2;
            if (nums[mid] > nums[high])
                low = mid + 1;
            else
                high = mid;
        }
        return nums[low];
    }

    public static int findMinWithDuplicates(int[] nums) {
        int low = 0;
        int high = nums.length - 1;
        while (low < high) {
            if (nums[low] < nums[high])
                return nums[low];

            int mid = low + (high - low) / 2;
            if (nums[mid] > nums[high])
                low = mid + 1;
            else if (nums[mid] < nums[high]) {
                high = mid;
            } else {
                // When arr[mid] == arr[high], we cannot determine which side is unsorted.
                // Reduce the high pointer to narrow the search space.
                high--;
            }
        }
        return nums[low];
    }

    public static void main(String[] args) {
        int[] arr = {4, 5, 6, 7, 0, 1, 2};
        System.out.println("Minimum in rotated sorted array: " + findMinInRotatedSortedArray(arr));

        int[] arrWithDuplicates = {2, 2, 2, 0, 1};
        System.out.println("Minimum in rotated sorted array with duplicates: " + findMinWithDuplicates(arrWithDuplicates));

        int[] emptyArray = {};
        System.out.println("Minimum in empty array: " + findMinInRotatedSortedArray(emptyArray));

        int[] arr2 = {3, 4, 5, 1, 2};
        System.out.println("Minimum with linear approach : " + findMinLinear(arr2));

        int [] arr3 = {1, 2, 3, 4, 5};
        System.out.println("Minimum in sorted array using brute approach: " + findMinInRotatedSortedArrayBrute(arr3));
    }
}
