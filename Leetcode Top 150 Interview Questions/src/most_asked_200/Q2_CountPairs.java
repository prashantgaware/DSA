package most_asked_200;

import java.util.HashMap;
import java.util.Map;

public class Q2_CountPairs {
    public static int countPairs(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        int count = 0;
        for (int num : nums) {
            int complement = target - num;
            if (map.containsKey(complement)) {
                count += map.get(complement);
            }
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        return count;
    }

    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        System.out.println((countPairs(nums, target)));
    }
}
