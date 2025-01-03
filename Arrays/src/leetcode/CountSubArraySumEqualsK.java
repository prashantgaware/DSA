package leetcode;

import java.util.HashMap;
import java.util.Map;

public class CountSubArraySumEqualsK {

    /**
     * Given an array of integers nums and an integer k, return the total number of continuous subarrays whose sum equals to k.
     * @param nums - array of integers
     * @param k - integer
     * @return total number of continuous subarrays whose sum equals to k
     * Time Complexity: O(n^3)
     */
    public static int subArraySumBrute(int[] nums, int k) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                int sum = 0;
                for (int k1 = i; k1 <= j; k1++) {
                    sum += nums[k1];
                }
                if (sum == k) {
                    count++;
                }
            }
        }

        return count;
    }

    /**
     * Given an array of integers nums and an integer k, return the total number of continuous subarrays whose sum equals to k.
     * @param arr - array of integers
     * @param k - integer
     * @return total number of continuous subarrays whose sum equals to k
     * Time Complexity: O(n^2)
     */
    public static int subArraySumBetter(int[] arr, int k) {
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            int sum = 0;
            for (int j = i; j < arr.length; j++) {
                sum += arr[j];
                if (sum == k) {
                    count++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
        int k = 2;
        System.out.println(subArraySumBrute(nums, k));
        System.out.println(subArraySumBetter(nums, k));
    }
}
