package leetcode;

/*
    1. Two Sum

    Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.

    You may assume that each input would have exactly one solution, and you may not use the same element twice.

    You can return the answer in any order.



    Example 1:

    Input: nums = [2,7,11,15], target = 9
    Output: [0,1]
    Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
    Example 2:

    Input: nums = [3,2,4], target = 6
    Output: [1,2]
    Example 3:

    Input: nums = [3,3], target = 6
    Output: [0,1]


    Constraints:

    2 <= nums.length <= 104
    -109 <= nums[i] <= 109
    -109 <= target <= 109
    Only one valid answer exists.
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TwoSum {
    public static void main(String[] args) {
        int[] nums1 = {2, 7, 11, 15};
        int target1 = 9;
        int[] result1 = twoSumWithUsingHM(nums1, target1);
        System.out.println("Indices: [" + result1[0] + ", " + result1[1] + "]");

        int[] nums2 = {3, 2, 4};
        int target2 = 6;
        int[] result2 = twoSumWithUsingHM(nums2, target2);
        System.out.println("Indices: [" + result2[0] + ", " + result2[1] + "]");

        int[] nums3 = {3, 3};
        int target3 = 6;
        int[] result3 = twoSumWithUsingHM(nums3, target3);
        System.out.println("Indices: [" + result3[0] + ", " + result3[1] + "]");

        System.out.println("======================================================");

        int[] nums4 = {2, 7, 11, 15, 2, 7};
        int target4 = 9;
        List<int[]> result4 = twoSumAllPairs(nums4, target4);
        for (int[] pair : result4) {
            System.out.println("Indices: [" + pair[0] + ", " + pair[1] + "]");
        }

        int[] nums5 = {3, 2, 4, 3};
        int target5 = 6;
        List<int[]> result5 = twoSumAllPairs(nums5, target5);
        for (int[] pair : result5) {
            System.out.println("Indices: [" + pair[0] + ", " + pair[1] + "]");
        }

        int[] nums6 = {3, 3, 3};
        int target6 = 6;
        List<int[]> result6 = twoSumAllPairs(nums6, target6);
        for (int[] pair : result6) {
            System.out.println("Indices: [" + pair[0] + ", " + pair[1] + "]");
        }

    }

    // For single pair
    private static int[] twoSumWithUsingHM(int[] arr, int target) {
        Map<Integer, Integer> hm = new HashMap<>();

        for (int i=0; i<arr.length; i++) {
            int complement = target - arr[i];

            if (hm.containsKey(complement)) {
                return new int[] { hm.get(complement), i};
            }

            hm.put(arr[i], i);
        }

        throw new IllegalArgumentException("Not found.");
    }

    //for multiple pairs
    private static List<int[]> twoSumAllPairs(int[] nums, int target) {
        List<int[]> result = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];

            if (map.containsKey(complement)) {
                result.add(new int[] { map.get(complement), i });
            }

            map.put(nums[i], i);
        }

        return result;
    }
}
