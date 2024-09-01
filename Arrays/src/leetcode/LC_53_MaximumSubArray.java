package leetcode;

/*
    53. Maximum Subarray
    Solved
    Medium
    Topics
    Companies
    Given an integer array nums, find the
    subarray
     with the largest sum, and return its sum.



    Example 1:

    Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
    Output: 6
    Explanation: The subarray [4,-1,2,1] has the largest sum 6.
    Example 2:

    Input: nums = [1]
    Output: 1
    Explanation: The subarray [1] has the largest sum 1.
    Example 3:

    Input: nums = [5,4,-1,7,8]
    Output: 23
    Explanation: The subarray [5,4,-1,7,8] has the largest sum 23.


    Constraints:

    1 <= nums.length <= 105
    -104 <= nums[i] <= 104


    Follow up: If you have figured out the O(n) solution, try coding another solution using the divide and conquer approach, which is more subtle.
*/

public class LC_53_MaximumSubArray {
    /*
    Approach 1: Kadane's Algorithm
    Kadane's Algorithm is an efficient way to solve this problem with a time complexity of O(n).
    The algorithm works by iterating through the array while keeping track of the maximum subarray sum ending at each position.

    Initialize two variables:

    currentSum to keep track of the current subarray sum.
    maxSum to keep track of the maximum subarray sum found so far.
    Iterate through the array:

    For each element num, update currentSum to be the maximum of num itself or currentSum + num.
    Update maxSum to be the maximum of maxSum and currentSum.
    Return maxSum after iterating through the array.
    */
    private static int maxSubArrayApproach1(int[] nums) {
        int currentSum = nums[0];
        int maxSum = nums[0];

        for (int i = 1; i < nums.length; i++) {
            currentSum = Math.max(nums[i], currentSum + nums[i]);
            maxSum = Math.max(maxSum, currentSum);
        }

        return maxSum;
    }

    /*
    Approach 2: Divide and Conquer
    The Divide and Conquer approach splits the array into two halves and recursively finds the maximum subarray sum in each half and the maximum subarray sum that crosses the middle of the array. This approach has a time complexity of O(n log n).

    Base Case: If the array has only one element, return that element.
    Divide: Split the array into two halves.
    Conquer:
    Recursively find the maximum subarray sum in the left half.
    Recursively find the maximum subarray sum in the right half.
    Find the maximum subarray sum that crosses the middle of the array.
    Combine: The result is the maximum of the three values obtained from the previous step.
    */
    private static int maxSubArrayApproach2(int[] nums) {
        return maxSubArrayHelper(nums, 0, nums.length - 1);
    }

    private static int maxSubArrayHelper(int[] nums, int left, int right) {
        if (left == right) {
            return nums[left];
        }

        int mid = left + (right - left) / 2;

        int leftMax = maxSubArrayHelper(nums, left, mid);
        int rightMax = maxSubArrayHelper(nums, mid + 1, right);
        int crossMax = findMaxCrossingSubarray(nums, left, mid, right);

        return Math.max(Math.max(leftMax, rightMax), crossMax);
    }

    private static int findMaxCrossingSubarray(int[] nums, int left, int mid, int right) {
        int leftSum = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = mid; i >= left; i--) {
            sum += nums[i];
            if (sum > leftSum) {
                leftSum = sum;
            }
        }

        int rightSum = Integer.MIN_VALUE;
        sum = 0;
        for (int i = mid + 1; i <= right; i++) {
            sum += nums[i];
            if (sum > rightSum) {
                rightSum = sum;
            }
        }

        return leftSum + rightSum;
    }
}
