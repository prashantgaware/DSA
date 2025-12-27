package most_asked_200.buy_stocks;

import java.util.Arrays;

public class Q4_BestTimeToBuyAndSellStocks4 {
    public static int maxProfit(int[] prices, int k) {
        return getMaxProfit(0, 1, k, prices);
    }

    private static int getMaxProfit(int index, int buy, int cap, int[] prices) {
        if (cap == 0) {
            return 0;
        }
        if (index == prices.length) {
            return 0;
        }

        int maxProfit;
        if (buy == 1) {
            maxProfit = Math.max(-prices[index] + getMaxProfit(index + 1, 0, cap, prices),
                    getMaxProfit(index + 1, 1, cap, prices));
        } else {
            maxProfit = Math.max(prices[index] + getMaxProfit(index + 1, 1, cap - 1, prices),
                    getMaxProfit(index + 1, 0, cap, prices));
        }

        return maxProfit;
    }

    public static int maxProfitUsingMemoization(int[] prices, int k) {
        int[][][] dp = new int[prices.length][2][k + 1];
        for (int[][] row : dp) {
            for (int[] col : row) {
                Arrays.fill(col, -1);
            }
        }
        return getMaxProfitUsingMemoization(0, 1, 2, prices, dp);
    }

    private static int getMaxProfitUsingMemoization(int index, int buy, int cap, int[] prices, int[][][] dp) {
        if (index == prices.length || cap == 0) {
            return 0;
        }

        if  (dp[index][buy][cap] != -1) {
            return dp[index][buy][cap];
        }

        int maxProfit;
        if (buy == 1) {
            maxProfit = Math.max(-prices[index] + getMaxProfitUsingMemoization(index + 1, 0, cap, prices, dp),
                    getMaxProfitUsingMemoization(index + 1, 1, cap, prices, dp));
        } else {
            maxProfit = Math.max(prices[index] + getMaxProfitUsingMemoization(index + 1, 1, cap - 1, prices, dp),
                    getMaxProfitUsingMemoization(index + 1, 0, cap, prices, dp));
        }

        return dp[index][buy][cap] = maxProfit;
    }

    public static void main(String[] args) {
        int[] prices = new int[] {3,6,2,7,0,4,6};
        System.out.println(maxProfit(prices, 3));
        System.out.println(maxProfitUsingMemoization(prices, 3));
    }
}
