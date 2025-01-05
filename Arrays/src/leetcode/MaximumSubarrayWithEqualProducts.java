package leetcode;

// Maximum Subarray With Equal Products
/*
* You are given an array of positive integers nums.

An array arr is called product equivalent if prod(arr) == lcm(arr) * gcd(arr), where:

prod(arr) is the product of all elements of arr.
gcd(arr) is the GCD of all elements of arr.
lcm(arr) is the LCM of all elements of arr.
Return the length of the longest product equivalent subarray of nums.

A subarray is a contiguous non-empty sequence of elements within an array.

The term gcd(a, b) denotes the greatest common divisor of a and b.

The term lcm(a, b) denotes the least common multiple of a and b.

 

Example 1:

Input: nums = [1,2,1,2,1,1,1]

Output: 5

Explanation: 

The longest product equivalent subarray is [1, 2, 1, 1, 1], where prod([1, 2, 1, 1, 1]) = 2, gcd([1, 2, 1, 1, 1]) = 1, and lcm([1, 2, 1, 1, 1]) = 2.

Example 2:

Input: nums = [2,3,4,5,6]

Output: 3

Explanation: 

The longest product equivalent subarray is [3, 4, 5].

Example 3:

Input: nums = [1,2,3,1,4,5,1]

Output: 5

 

Constraints:

2 <= nums.length <= 100
1 <= nums[i] <= 10
* */

public class MaximumSubarrayWithEqualProducts {
    public static int maxLength(int[] nums) {
        int n = nums.length;
        int[] prefixProd = new int[n];
        int[] prefixGcd = new int[n];
        int[] prefixLcm = new int[n];
        int[] suffixProd = new int[n];
        int[] suffixGcd = new int[n];
        int[] suffixLcm = new int[n];

        prefixProd[0] = nums[0];
        prefixGcd[0] = nums[0];
        prefixLcm[0] = nums[0];
        for (int i = 1; i < n; i++) {
            prefixProd[i] = prefixProd[i - 1] * nums[i];
            prefixGcd[i] = gcd(prefixGcd[i - 1], nums[i]);
            prefixLcm[i] = lcm(prefixLcm[i - 1], nums[i]);
        }

        suffixProd[n - 1] = nums[n - 1];
        suffixGcd[n - 1] = nums[n - 1];
        suffixLcm[n - 1] = nums[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            suffixProd[i] = suffixProd[i + 1] * nums[i];
            suffixGcd[i] = gcd(suffixGcd[i + 1], nums[i]);
            suffixLcm[i] = lcm(suffixLcm[i + 1], nums[i]);
        }

        int result = 1;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int prod = prefixProd[j] / (i == 0 ? 1 : prefixProd[i - 1]);
                int gcd = i == 0 ? prefixGcd[j] : gcd(prefixGcd[j], prefixGcd[i - 1]);
                int lcm = i == 0 ? prefixLcm[j] : lcm(prefixLcm[j], prefixLcm[i - 1]);

                if (prod == gcd * lcm) {
                    result = Math.max(result, j - i + 1);
                }
            }
        }

        return result;
    }

    private static int lcm(int i, int i1) {
        return i * i1 / gcd(i, i1);
    }

    private static int gcd(int i, int num) {
        return i == 0 ? num : gcd(num % i, i);
    }

    public static void main(String[] args) {
        int[] nums = {1,2,1,2,1,1,1};
        System.out.println(maxLength(nums));
        int[] nums1 = {6,7,2,1};
        System.out.println(maxLength(nums1));
    }
}
