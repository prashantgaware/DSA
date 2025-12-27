package most_asked_200.buy_stocks;

public class Q3_BestTimeToBuyAndSellStocks3 {
    public static int maxProfit(int[] prices) {
        return getMaxProfit(0, 1, 2, prices);
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

    public static void main(String[] args) {
        int[] prices = new int[] {3,6,2,7,0,4,6};
        System.out.println(maxProfit(prices));
    }
}
