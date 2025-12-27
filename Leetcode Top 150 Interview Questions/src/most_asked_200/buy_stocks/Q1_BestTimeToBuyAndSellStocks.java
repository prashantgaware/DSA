package most_asked_200.buy_stocks;

public class Q1_BestTimeToBuyAndSellStocks {
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

    public static void main(String[] args) {
        int[] prices = new int[] {3,6,2,7,0,4,6};
        System.out.println(maxProfit(prices));
    }
}
