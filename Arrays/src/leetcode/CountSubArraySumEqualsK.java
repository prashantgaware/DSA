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

    /**
     * Given an array of integers nums and an integer k, return the total number of continuous subarrays whose sum equals to k.
     * @param nums - array of integers
     * @param k - integer
     * @return total number of continuous subarrays whose sum equals to k
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     * Approach:
     * 1. Use a HashMap to store the cumulative sum and its frequency.
     * 2. Initialize the map with (0, 1) to handle the case where the cumulative sum equals k.
     * 3. Iterate through the array, updating the cumulative sum.
     * 4. For each cumulative sum, check if (cumulative sum - k) exists in the map.
     *      If it does, it means there is a subarray that sums to k, so increment the count
     *      by the frequency of (cumulative sum - k).
     * 5. Update the map with the current cumulative sum.
     * 6. Return the count of subarrays that sum to k.
     */
    public static int subArraySumEfficient(int[] nums, int k) {
        int count = 0;
        int sum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);

        for (int num : nums) {
            sum += num;

            // Check if there is a subarray (ending at the current index) which sums to k
            if (map.containsKey(sum - k)) {
                count += map.get(sum - k);
            }

            // Update the map with the current cumulative sum
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }

        return count;
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
        int k = 2;
        System.out.println(subArraySumBrute(nums, k));
        System.out.println(subArraySumBetter(nums, k));
        System.out.println(subArraySumEfficient(nums, k));
    }
}
