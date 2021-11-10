package dfs;

/**
 * @author Weiyan Xiang on 2020/11/13
 */
public class BestTimeToBuyAndSellStockII {
    /**
     * 122. Best Time to Buy and Sell Stock II
     * <p>
     * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/
     * <p>
     * my ac ans: track the trend
     */
    public int maxProfit(int[] prices) {
        if (prices.length <= 1) return 0;
        int sum = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i - 1] < prices[i]) {
                sum += prices[i] - prices[i - 1];
            }
        }
        return sum;
    }
}
