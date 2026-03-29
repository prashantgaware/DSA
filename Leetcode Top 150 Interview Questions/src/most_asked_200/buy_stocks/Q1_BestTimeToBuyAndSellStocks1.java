package most_asked_200.buy_stocks;

public class Q1_BestTimeToBuyAndSellStocks1 {
    public static int maxProfit(int[] prices) {
        int max = 0;
        int min = Integer.MAX_VALUE;

        for (int price : prices) {
            if (price < min) {
                min = price;
            } else if (max < price - min) {
                max = price - min;
            }
        }
        return max;
    }

    public static int maxProfitBrute(int[] prices) {
        int max = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                int profit = prices[j] - prices[i];
                max = Math.max(max, profit);
            }
        }
        return max;
    }

    private static int maxProfitUsingKadane(int[] prices) {
        int maxSoFar = 0;
        int currentMax = 0;
        for (int i = 1; i < prices.length; i++) {
            currentMax += prices[i] - prices[i - 1];
            currentMax = Math.max(0, currentMax);
            maxSoFar = Math.max(maxSoFar, currentMax);
        }
        return maxSoFar;
    }

    public static int maxProfitMinMax(int[] prices) {
        int min = prices[0];
        int max = 0;
        for (int i = 1; i < prices.length; i++) {
            int cost = prices[i] - min;
            max = Math.max(max, cost);
            min = Math.min(min, prices[i]);
        }
        return max;
    }

    public static void main(String[] args) {
//        int[] prices = new int[] {3,6,2,7,0,4,6};
        int[] prices = new int[] {1,2,2,3,0,4,6};
        System.out.println(maxProfit(prices));
        System.out.println(maxProfitBrute(prices));
        System.out.println(maxProfitUsingKadane(prices));
        System.out.println(maxProfitMinMax(prices));
    }
}
