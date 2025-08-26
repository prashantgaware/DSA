package striver;

import java.util.Arrays;

public class FrogJumps {
    public static int minEnergyRecursive(int n, int[] heights) {
        if (n == 0) return 0;

        int left = minEnergyRecursive(n - 1, heights) + Math.abs(heights[n] - heights[n - 1]);
        int right = Integer.MAX_VALUE;
        if (n > 1)
            right = minEnergyRecursive(n - 2, heights) + Math.abs(heights[n] - heights[n - 2]);

        return Math.min(left, right);
    }

    /**
     * Memoization
     * @param n index of last stone
     * @param heights heights array
     * @param dp memoization array
     * @return minimum energy to reach stone n
     * Approach: Top Down
     * 1. Create a dp array of size n+1 and initialize it with -1
     * 2. If n is 0, return 0 (base case)
     * 3. If dp[n] is not -1, return dp[n] (already computed)
     * 4. Calculate the energy for the left jump (to n-1)
     * 5. Calculate the energy for the right jump (to n-2) if n > 1
     * 6. Store the minimum of the two energies in dp[n] and return it
     * Time Complexity: O(n)
     * Space Complexity: O(n) for dp array + O(n) for recursion stack
     */
    public static int minEnergyMemoization(int n, int[] heights, int[] dp) {
        if (n == 0)
            return 0;
        if (dp[n] != -1)
            return dp[n];

        int left = minEnergyMemoization(n -1, heights, dp) + Math.abs(heights[n] - heights[n - 1]);
        int right = Integer.MAX_VALUE;
        if (n > 1)
            right = minEnergyMemoization(n - 2, heights, dp) + Math.abs(heights[n] - heights[n - 2]);
        return dp[n] = Math.min(left, right);
    }

    /**
     * Tabulation
     * @param n number of stones
     * @param heights heights array
     * @return minimum energy to reach stone n-1
     * Approach: Bottom Up
     * 1. Create a dp array of size n
     * 2. Initialize dp[0] to 0 (base case)
     * 3. Iterate from 1 to n-1
     * 4. For each i, calculate the energy for the left jump (to i-1)
     * 5. Calculate the energy for the right jump (to i-2) if i > 1
     * 6. Store the minimum of the two energies in dp[i]
     * 7. Return dp[n-1]
     * Time Complexity: O(n)
     * Space Complexity: O(n) for dp array
     */
    public static int minEnergyTabulation(int n, int[] heights) {
        int[] dp = new int[n];
        dp[0] = 0;

        for (int i = 1; i < n; i++) {
            int left = dp[i - 1] + Math.abs(heights[i] - heights[i - 1]);
            int right = Integer.MAX_VALUE;
            if (i > 1)
                right = dp[i - 2] + Math.abs(heights[i] - heights[i - 2]);
            dp[i] = Math.min(left, right);
        }
        return dp[n - 1];
    }

    /**
     * Space Optimized
     * @param n number of stones
     * @param heights heights array
     * @return minimum energy to reach stone n-1
     * Approach: Bottom Up with space optimization
     * 1. Use two variables to store the last two computed values instead of a dp array
     * 2. Initialize prev to 0 (dp[0]) and prev2 to 0 (dp[-1] which is not used)
     * 3. Iterate from 1 to n-1
     * 4. For each i, calculate the energy for the left jump (to i-1) using prev
     * 5. Calculate the energy for the right jump (to i-2) using prev2 if i > 1
     * 6. Update prev2 to prev and prev to the current minimum energy
     * 7. Return prev which holds the minimum energy to reach stone n-1
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    public static int minEnergySpaceOptimized(int n, int[] heights) {
        int prev = 0;
        int prev2 = 0;

        for (int i = 1; i < n; i++) {
            int left = prev + Math.abs(heights[i] - heights[i - 1]);
            int right = Integer.MAX_VALUE;
            if (i > 1)
                right = prev2 + Math.abs(heights[i] - heights[i - 2]);
            int curr = Math.min(left, right);
            prev2 = prev;
            prev = curr;
        }
        return prev;
    }

    public static void main(String[] args) {
        int[] heights = {30, 10, 60, 10, 60, 50};
        int n = heights.length;
        System.out.println(minEnergyRecursive(n - 1, heights));
        System.out.println();
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        System.out.println(minEnergyMemoization(n - 1, heights, dp));
        System.out.println();
        System.out.println(minEnergyTabulation(n, heights));
        System.out.println();
        System.out.println(minEnergySpaceOptimized(n, heights));
    }
}
