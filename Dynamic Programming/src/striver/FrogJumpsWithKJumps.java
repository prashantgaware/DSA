package striver;

/*
    Frog Jumps 2

    Problem Statement:
    A frog is at the start of a series of stones, each with a certain height.
    The frog can jump to the next stone or skip one stone and jump to the stone after that.
    The energy cost of a jump is the absolute difference in heights between the starting stone and the
    destination stone. The goal is to find the minimum energy cost for the frog to reach the last stone.

    Example:
    Input: heights = [30, 10, 60, 10, 60
    Output: 40
    Explanation:
    The frog can jump from stone 0 to stone 1 (cost = |30 - 10| = 20),
    then from stone 1 to stone 3 (cost = |10 - 10| = 0),
    and finally from stone 3 to stone 4 (cost = |10 - 60| = 50).
    The total cost is 20 + 0 + 50 = 70.
    However, a better path is to jump from stone 0 to stone 2 (cost = |30 - 60| = 30),
    then from stone 2 to stone 4 (cost = |60 - 60| = 0).
    The total cost is 30 + 0 = 30.
    Thus, the minimum energy cost is 30.
*/

import java.util.Arrays;

public class FrogJumpsWithKJumps {
    /**
     * Recursion
     * @param n index of last stone
     * @param heights heights array
     * @return minimum energy to reach stone n
     * Approach: Top Down
     * 1. If n is 0, return 0 (base case)
     * 2. Calculate the energy for the left jump (to n-1)
     * 3. Calculate the energy for the right jump (to n-2) if n > 1
     * 4. Return the minimum of the two energies
     * Time Complexity: O(2^n) exponential time due to overlapping subproblems
     * Space Complexity: O(n) for recursion stack
     */
    public static int minEnergyRecursive(int n, int[] heights, int k) {
        if (n == 0)
            return 0;

        int minSteps = Integer.MAX_VALUE;
        for (int j = 1; j <= k; j++) {
            if (n - j >= 0) {
                int jumps = minEnergyRecursive(n - j, heights, k) + Math.abs(heights[n] - heights[n - j]);
                minSteps = Math.min(minSteps, jumps);
            }
        }

        return minSteps;
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
    public static int minEnergyMemoization(int n, int[] heights, int[] dp, int k) {
        if (n == 0)
            return 0;

        if (dp[n] != -1)
            return dp[n];

        int minSteps = Integer.MAX_VALUE;
        dp[0] = 0;
        for (int j = 1; j <= k; j++) {
            if (n - j >= 0) {
                int jumps = minEnergyMemoization(n - j, heights, dp, k) + Math.abs(heights[n] - heights[n - j]);
                minSteps = Math.min(minSteps, jumps);
            }
        }
        dp[n] = minSteps;

        return dp[n];
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
    public static int minEnergyTabulation(int n, int[] heights, int k) {
        int[] dp = new int[n];
        dp[0] = 0;
        for (int j = 1; j <= k; j++) {
            int jumps = dp[n - j] + Math.abs(heights[n - 1] - heights[n - 1 - j]);
            dp[j] = Math.min(dp[j], jumps);
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
        int[] heights = {30, 10, 60, 10, 60, 50, 80, 30, 20};
        int n = heights.length;
        System.out.println(minEnergyRecursive(n - 1, heights, 4));
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        System.out.println(minEnergyMemoization(n - 1, heights, dp, 4));
        System.out.println(minEnergyTabulation(n, heights, 4));
        System.out.println(minEnergySpaceOptimized(n, heights));
    }
}
