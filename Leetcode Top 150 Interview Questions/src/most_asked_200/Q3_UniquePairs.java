package most_asked_200;

import java.util.*;

public class Q3_UniquePairs {
    public static List<List<Integer>> uniquePairs(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int sum = nums[left] + nums[right];
            if (sum == target) {
                result.add(Arrays.asList(nums[left], nums[right]));
                while (left < right && nums[left] == nums[left+1]) {
                    left++;
                }

                while (left < right && nums[right] == nums[right-1]) {
                    right--;
                }

                left++;
                right--;
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        System.out.println((uniquePairs(nums, target)));
    }
}
