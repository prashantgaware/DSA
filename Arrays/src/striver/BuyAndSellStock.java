package striver;

public class BuyAndSellStock {
    public static int maxProfitBrute(int[] prices) {
        int max = 0;
        for (int i = 0; i < prices.length; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                int profit = prices[j] - prices[i];
                max = Math.max(max, profit);
            }
        }
        return max;
    }

    /**
     * Get the maximum profit by buying and selling the stock only once.
     * Time Complexity: O(n)
     * @param prices - array of stock prices
     * @return maximum profit
     * Approach:
     * 1. Initialize min to the first element of the array and maxProfit to 0.
     * 2. Loop through the array from the second element to the end.
     * 3. Calculate the cost by subtracting min from the current element.
     * 4. Update maxProfit to the maximum of maxProfit and cost.
     * 5. Update min to the minimum of min and the current element.
     * 6. Return maxProfit.
     */
    public static int maxProfitOptimal(int[] prices) {
        int min = prices[0];
        int maxProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            int cost = prices[i] - min;
            maxProfit = Math.max(maxProfit, cost);
            min = Math.min(min, prices[i]);
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        int[] prices = {2,4,2,1,6,9,3};
        System.out.println("Max Profit:" + maxProfitBrute(prices));
        System.out.println("Max Profit:" + maxProfitOptimal(prices));
    }
}
