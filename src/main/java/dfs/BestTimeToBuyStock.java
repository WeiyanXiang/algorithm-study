package dfs;

import static java.lang.Math.max;

/**
 * @author Weiyan Xiang on 2020/4/4
 */
public class BestTimeToBuyStock {
    /**
     * https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
     */
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2) {
            return 0;
        }
        int maxCurr = 0, max = 0;
        for (int i = 1; i < prices.length; i++) {
            maxCurr = max(0, maxCurr += prices[i] - prices[i - 1]);
            max = max(maxCurr, max);
        }
        return max;

    }

    /**
     * easy to understand
     *
     * @param prices
     * @return
     */
    public int maxProfitHelpForUnderstanding(int[] prices) {
        if (prices == null || prices.length < 2) {
            return 0;
        }
        int max = 0, min = Integer.MAX_VALUE;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < min) {
                min = prices[i];
            } else if (prices[i] > min) {
                max = Math.max(prices[i] - min, max);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        BestTimeToBuyStock buyTime = new BestTimeToBuyStock();

        int[] stock = {7, 1, 5, 3, 6, 4};
        System.out.print(buyTime.maxProfit(stock));
        System.out.print(buyTime.maxProfitHelpForUnderstanding(stock));

    }
}
