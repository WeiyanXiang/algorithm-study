package dfs;

import static java.lang.Math.max;

/**
 * @author Weiyan Xiang on 2020/4/4
 */
public class BestTimeToBuyAndSellStock {
    //@formatter:off
    /**
     * https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
     *
     * A more clear explanation on why sum of subarray works.:
     *
     * Suppose we have original array:
     * [a0, a1, a2, a3, a4, a5, a6]
     *
     * what we are given here(or we calculate ourselves) is:
     * [b0, b1, b2, b3, b4, b5, b6]
     *
     * where,
     * b[i] = 0, when i == 0
     * b[i] = a[i] - a[i - 1], when i != 0
     *
     * suppose if a2 and a6 are the points that give us the max difference (a2 < a6)
     * then in our given array, we need to find the sum of sub array from b3 to b6.
     *
     * b3 = a3 - a2
     * b4 = a4 - a3
     * b5 = a5 - a4
     * b6 = a6 - a5
     *
     * adding all these, all the middle terms will cancel out except two
     * i.e.
     *
     * b3 + b4 + b5 + b6 = a6 - a2
     *
     * a6 - a2 is the required solution.
     *
     * so we need to find the largest sub array sum to get the most profit
     *
     */
    //@formatter:on
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
        BestTimeToBuyAndSellStock buyTime = new BestTimeToBuyAndSellStock();

        int[] stock = {7, 1, 5, 3, 6, 4};
        System.out.print(buyTime.maxProfit(stock));
        System.out.print(buyTime.maxProfitHelpForUnderstanding(stock));

    }
}
