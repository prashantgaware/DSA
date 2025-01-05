package leetcode;

import java.util.*;

/**
 * Maximum Coins From K Consecutive Bags
 * Given N bags, each bag contains Ai coins. In one move, we can select any K bags, remove the coins from it, and add the
 * floor of the total number of coins in the selected bags to all the remaining bags. We need to maximize the number of coins
 * in any one bag after performing M moves.
 * <p>
 * Example:
 * Input: N = 3, K = 2, M = 2, coins = {{8, 10, 1}, {1, 3, 2}, {5, 6, 4}}
 * Output: 10
 * Explanation: We can select the first two bags and remove the coins from them. The remaining coins are {3, 5, 6}. We can
 * select the last two bags and remove the coins from them. The remaining coins are {0, 1, 2}. The maximum number of coins
 * in any one bag is 10.
 */

public class MaximumCoinsFromKConsecutiveBags {
    public static long maximumCoins(int[][] coins, int k) {
        Map<Integer, Long> parnoktils = new HashMap<>();

        // Step 1: Process the coin segments and store the increments and decrements in the map
        for (int i = 0; i < coins.length; i++) {
            int l = coins[i][0];
            int r = coins[i][1];
            int c = coins[i][2];
            parnoktils.put(l, parnoktils.getOrDefault(l, 0L) + c);
            parnoktils.put(r + 1, parnoktils.getOrDefault(r + 1, 0L) - c);
        }

        // Step 2: Use a TreeMap to process in sorted order and accumulate the sums
        TreeMap<Integer, Long> sortedMap = new TreeMap<>(parnoktils);
        long currentSum = 0;
        long maxCoins = 0;
        long start = -1;

        // Step 3: Traverse through the sorted map
        for (Map.Entry<Integer, Long> entry : sortedMap.entrySet()) {
            int position = entry.getKey();
            long change = entry.getValue();

            if (start != -1 && position - start <= k) {
                currentSum += change;
                maxCoins = Math.max(maxCoins, currentSum);
            }

            currentSum += change;
            start = position;
        }

        return maxCoins;
    }

    public static void main(String[] args) {
        int[][] coins = {{8, 10, 1}, {1, 3, 2}, {5, 6, 4}};
        int k = 4;
        System.out.println(maximumCoins(coins, k)); // Expected output: 10
    }
}
