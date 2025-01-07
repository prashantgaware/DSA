package leetcode;

import java.util.HashMap;
import java.util.Map;

public class LC_560_SubarraySumEqualsK {
    public static int subarraySum(int[] nums, int k) {
        int n = nums.length;
        int count = 0;

        for (int i = 0; i < n; i++) {
            int sum = nums[i];
            if (sum == k) {
                count++;
            }

            for (int j = i + 1; j < n; j++) {
                sum += nums[j];
                if (sum == k) {
                    count++;
                }
            }
        }

        return count;
    }

    public static int subarraySumBetter(int[] nums, int k) {
        int n = nums.length;
        int count = 0;
        int[] prefixSum = new int[n + 1];
        prefixSum[0] = 0;

        for (int i = 1; i <= n; i++) {
            prefixSum[i] = prefixSum[i - 1] + nums[i - 1];
        }

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j <= n; j++) {
                if (prefixSum[j] - prefixSum[i] == k) {
                    count++;
                }
            }
        }

        return count;
    }

    public static int subarraySumOptimal(int[] nums, int k) {
        int n = nums.length;
        int count = 0;
        int sum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);

        for (int i = 0; i < n; i++) {
            sum += nums[i];
            if (map.containsKey(sum - k)) {
                count += map.get(sum - k);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }

        return count;
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 3, 1, 1, 1, 1, 1, 1};
        int k = 9;
        System.out.println(subarraySum(nums, k));
        System.out.println(subarraySumBetter(nums, k));
        System.out.println(subarraySumOptimal(nums, k));
    }
}
