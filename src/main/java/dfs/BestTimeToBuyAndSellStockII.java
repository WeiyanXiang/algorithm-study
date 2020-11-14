package dfs;

/**
 * @author Weiyan Xiang on 2020/11/13
 */
public class BestTimeToBuyAndSellStockII {
    /**
     * https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
     */
    public int maxProfitMyAnswer(int[] p) {
        if (p == null || p.length < 2) return 0;
        int maxSoFar = 0, maxCur = 0;
        for (int i = 0; i < p.length - 1; i++) {
            maxCur = Math.max(0, maxCur += p[i + 1] - p[i]);
            maxSoFar = Math.max(maxCur, maxSoFar);
        }
        return maxSoFar;

    }
}
