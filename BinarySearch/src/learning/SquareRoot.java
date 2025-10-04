package learning;

public class SquareRoot {
    /**
     * Find the square root of a number using binary search
     * @param n - the number to find the square root of
     * @return the square root of the number
     * Approach:
     * 1. Initialize low to 0 and high to n.
     * 2. While low is less than or equal to high, do the following:
     *    3. Calculate mid as the average of low and high.
     *    4. Calculate val as mid * mid.
     *    5. If val is less than or equal to n, set ans to mid and set low to mid + 1.
     *    6. If val is greater than n, set high to mid - 1.
     * 7. Return ans.
     * Time Complexity: O(log n)
     * Space Complexity: O(1)
     * Dry Run:
     * n = 25
     * low = 0, high = 25, ans = -1
     * mid = 12, val = 144 (val > n) -> high = 11
     * mid = 5, val = 25 (val <= n) -> ans = 5, low = 6
     * mid = 8, val = 64 (val > n) -> high = 7
     * mid = 6, val = 36 (val > n) -> high = 5
     * low > high, exit loop
     * return ans = 5
     */
    public static int findSquareRoot(int n) {
        int low = 0;
        int high = n;
        int ans = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int val = mid * mid;
            if (val <= n) {
                ans = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return ans;
    }

    public static int findSqRootBrute(int n) {
        int ans = -1;
        for (int i = 1; i < n; i++) {
            if (i * i <= n) {
                ans = i;
            } else {
                break;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(findSquareRoot(25));
        System.out.println(findSqRootBrute(25));
    }
}
