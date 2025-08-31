package striver;

public class ClimbStairs {
    /**
     *
     * @param n
     * @return
     * Approach:
     * 1. If there are 1 or 2 stairs, the number of ways to climb them is equal to n itself.
     * 2. For more than 2 stairs, we use a dynamic programming array
     * 'dp` where `dp[i]` represents the number of ways to reach the i-th stair.
     * 3. The recurrence relation is `dp[i] = dp[i-1] + dp[i-2]`, which means
     * the number of ways to reach the i-th stair is the sum of the ways to
     * reach the (i-1)-th stair and the (i-2)-th stair.
     * 4. We initialize `dp[1]` to 1 and `dp[2]` to 2, and then fill the dp array
     * iteratively up to `n`.
     * 5. Finally, we return `dp[n]` which contains the total number of ways to climb `n` stairs.
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     */
    public static int numberOfStairs(int n) {
        if (n <= 2) {
            return n;
        }

        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;

        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(numberOfStairs(9));
    }
}
