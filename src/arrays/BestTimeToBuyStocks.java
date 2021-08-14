package arrays;

public class BestTimeToBuyStocks {

    public static void main(String[] args) {

    }

    static int maxProfit(int[] prices) {
        int trend = 0;
        int profit = 0;
        int buy = -1;

        for(int i = 0; i < prices.length - 1; i++) {
            if(prices[i] > prices[i+1]) {
                if(trend > 0) {
                    // SELL
                    profit += prices[i] - prices[buy];
                    buy = -1;
                }
                trend = -1;
            } else if(prices[i] <= prices[i+1]) {
                if(trend < 0 || i == 0) {
                    // BUY
                    buy = i;
                }
                trend = 1;
            }

        }

        if(trend > 0 && buy != -1) {
            profit += prices[prices.length - 1] - prices[buy];
        }

        return profit;
    }
}
