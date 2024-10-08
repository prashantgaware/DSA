package leetcode;

/*
    268. Missing Number

    Easy
    Topics
    Companies
    Given an array nums containing n distinct numbers in the range [0, n], return the only number in the range that is missing from the array.
    Example 1:

    Input: nums = [3,0,1]
    Output: 2
    Explanation: n = 3 since there are 3 numbers, so all numbers are in the range [0,3]. 2 is the missing number in the range since it does not appear in nums.
    Example 2:

    Input: nums = [0,1]
    Output: 2
    Explanation: n = 2 since there are 2 numbers, so all numbers are in the range [0,2]. 2 is the missing number in the range since it does not appear in nums.
    Example 3:

    Input: nums = [9,6,4,2,3,5,7,0,1]
    Output: 8
    Explanation: n = 9 since there are 9 numbers, so all numbers are in the range [0,9]. 8 is the missing number in the range since it does not appear in nums.
    Constraints:
    n == nums.length
    1 <= n <= 104
    0 <= nums[i] <= n
    All the numbers of nums are unique.
    Follow up: Could you implement a solution using only O(1) extra space complexity and O(n) runtime complexity?
 */

public class LC_268_MissingNumber {
    private static int findMissingNumber (int[] nums) {
        int n = nums.length;
        int sum = n * (n+1) / 2;
        for (int num : nums) {
            sum -= num;
        }

        return sum;
    }

    private static int findMissingNum(int[] arr) {
        for (int i=0; i< arr.length; i++) {
            boolean flag = false;
            for (int j=0; j<arr.length; j++) {
                if (arr[j] == i) {
                    flag = true;
                    break;
                }
            }

            if (!flag)
                return i;
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {3,0,1};
        System.out.println(findMissingNumber(nums));

        int[] nums1 = {0,1,2,3,4,5,6,9};
        System.out.println(findMissingNum(nums1));
    }
}
