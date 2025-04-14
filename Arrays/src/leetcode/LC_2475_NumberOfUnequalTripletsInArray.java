package leetcode;

public class LC_2475_NumberOfUnequalTripletsInArray {
    public static void main(String[] args) {
        System.out.println(unequalTriplets(new int[]{4, 4, 2, 4, 3}));
        System.out.println(unequalTriplets(new int[]{1, 1, 1}));
        System.out.println(unequalTriplets(new int[]{1, 2, 3}));

        System.out.println(unequalTripletsUsingFrequencyCount(new int[]{4, 4, 2, 4, 3}));
        System.out.println(unequalTripletsUsingFrequencyCount(new int[]{1, 1, 1}));
        System.out.println(unequalTripletsUsingFrequencyCount(new int[]{1, 2, 3}));

        System.out.println(unequalTripletsUsingHashMap(new int[]{4, 4, 2, 4, 3}));
        System.out.println(unequalTripletsUsingHashMap(new int[]{1, 1, 1}));
        System.out.println(unequalTripletsUsingHashMap(new int[]{1, 2, 3}));
    }

    static int unequalTriplets(int[] nums) {
        int n = nums.length;
        int ans = 0;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    if (nums[i] != nums[j] && nums[j] != nums[k] && nums[i] != nums[k]) {
                        ans++;
                    }
                }
            }
        }

        return ans;
    }

    // Optimized approach using frequency count
    static int unequalTripletsUsingFrequencyCount(int[] nums) {
        int n = nums.length;
        int ans = 0;

        // Count the frequency of each number
        int[] freq = new int[101];
        for (int num : nums) {
            freq[num]++;
        }

        // Calculate the total number of triplets
        int totalTriplets = n * (n - 1) * (n - 2) / 6;

        // Calculate the number of triplets with equal elements
        for (int count : freq) {
            if (count >= 3) {
                ans += count * (count - 1) * (count - 2) / 6;
            }
        }

        return totalTriplets - ans;
    }

    // Optimized approach using HashMap
    static int unequalTripletsUsingHashMap(int[] nums) {
        int n = nums.length;
        int ans = 0;

        // Count the frequency of each number
        int[] freq = new int[101];
        for (int num : nums) {
            freq[num]++;
        }

        // Calculate the total number of triplets
        int totalTriplets = n * (n - 1) * (n - 2) / 6;

        // Calculate the number of triplets with equal elements
        for (int count : freq) {
            if (count >= 3) {
                ans += count * (count - 1) * (count - 2) / 6;
            }
        }

        return totalTriplets - ans;
    }
}
