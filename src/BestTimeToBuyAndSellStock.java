public class BestTimeToBuyAndSellStock {
    public int maxProfit(int[] prices) {
        int profit = 0;
        int curMin = 0;
        for (int i = 1; i < prices.length; i++) {
            profit = Math.max(profit, prices[i] - curMin);
            curMin = Math.min(curMin, prices[i]);
        }
        return profit;
    }

    public int maxProfitII(int[] prices) {
        int sum = 0;
        for (int i = 1; i < prices.length; i++) {
            int diff = prices[i] - prices[i - 1];
            if (diff > 0) {
                sum += diff;
            }
        }
        return sum;
    }
}
