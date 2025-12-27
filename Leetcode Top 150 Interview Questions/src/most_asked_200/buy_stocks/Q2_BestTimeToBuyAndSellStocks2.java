package most_asked_200.buy_stocks;

import java.util.Arrays;

public class Q2_BestTimeToBuyAndSellStocks2 {
    public static int maxProfit(int[] prices) {
        return getMaxProfit(0, 1, prices);
    }

    private static int getMaxProfit(int index, int buy, int[] prices) {
        if (index == prices.length) {
            return 0;
        }

        int maxProfit;
        if (buy == 1) {
            maxProfit = Math.max(-prices[index] + getMaxProfit(index + 1, 0, prices),
                    getMaxProfit(index + 1, 1, prices));
        } else {
            maxProfit = Math.max(prices[index] + getMaxProfit(index + 1, 1, prices),
                    getMaxProfit(index + 1, 0, prices));
        }

        return maxProfit;
    }

    public static int maxProfitUsingMemoization(int[] prices) {
        int[][] dp = new int[prices.length][2];
        for (int[]  row : dp) {
            Arrays.fill(row, -1);
        }
        return getMaxProfitUsingMemoization(0, 1, prices, dp);
    }

    private static int getMaxProfitUsingMemoization(int index, int buy, int[] prices, int[][] dp) {
        if (index == prices.length) {
            return 0;
        }

        if (dp[index][buy] != 0) return dp[index][buy];

        int maxProfit;
        if (buy == 1) {
            maxProfit = Math.max(-prices[index] + getMaxProfitUsingMemoization(index + 1, 0, prices, dp),
                    getMaxProfitUsingMemoization(index + 1, 1, prices, dp));
        } else {
            maxProfit = Math.max(prices[index] + getMaxProfitUsingMemoization(index + 1, 1, prices, dp),
                    getMaxProfitUsingMemoization(index + 1, 0, prices, dp));
        }

        return dp[index][buy] = maxProfit;
    }

    public static void main(String[] args) {
        int[] prices = new int[] {3,6,2,7,0,4,6};
        System.out.println(maxProfit(prices));
        System.out.println(maxProfitUsingMemoization(prices));
    }
}
