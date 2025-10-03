package leetcode;

public class LC_96_UniqueBSTs {
    /**
     * Gives the number of unique BSTs that can be formed with n nodes
     * @param n - number of nodes
     * @return - number of unique BSTs
     * Approach:
     * 1. If n <= 1, return 1
     * 2. Initialize ans = 0
     * 3. Loop from i = 1 to n
     *   4. ans += numTrees(i-1) * numTrees(n-i)
     *   5. Return ans
     * Time Complexity: O(2^n) - Exponential time complexity due to the recursive calls
     * Space Complexity: O(n) - Space complexity due to the recursion stack
     */
    public static int numTrees(int n) {
        if (n <= 1) {
            return 1;
        }

        int ans = 0;
        for (int i = 1; i <= n; i++) {
            ans += numTrees(i-1) * numTrees(n-1);
        }
        return ans;
    }

    /**
     * Gives the number of unique BSTs that can be formed with n nodes using Dynamic Programming
     * @param n - number of nodes
     * @return - number of unique BSTs
     * Approach:
     * 1. Create an array dp of size n+1
     * 2. Initialize dp[0] = 1 and dp[1] = 1
     * 3. Loop from i = 2 to n
     *   4. Loop from j = 1 to i
     *     5. dp[i] += dp[j-1] * dp[i-j]
     * 6. Return dp[n]
     * Time Complexity: O(n^2) - Two nested loops
     * Space Complexity: O(n) - Space complexity due to the dp array
     */
    public static int numTreesDP(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                dp[i] += dp[j - 1] * dp[i - j];
            }
        }

        return dp[n];
    }

    public static void main(String[] args) {
        int n = 3;
        System.out.println("Number of unique BSTs with " + n + " nodes (Recursive): " + numTrees(n));
        System.out.println("Number of unique BSTs with " + n + " nodes (DP): " + numTreesDP(n));
    }
}
