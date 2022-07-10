package dp;

/**
 * @author Weiyan Xiang on 2022/7/10
 */

public class MinCostClimbingStairs {

    /**
     * dp with array version
     */
    public int minCostClimbingStairs(int[] cost) {
        int len = cost.length;
        int[] dp = new int[len];
        for (int i = 0; i < len; i++) {
            if (i < 2) dp[i] = cost[i];
            else dp[i] = cost[i] + Math.min(dp[i - 1], dp[i - 2]);
        }
        return Math.min(dp[len - 1], dp[len - 2]);
    }

    /**
     * my recursive verison, TLE
     */
    public int minCostClimbingStairsRecursive(int[] cost) {
        return Math.min(minCost(cost, 0, 0), minCost(cost, 1, 0));
    }

    private int minCost(int[] cost, int start, int sum) {
        if (start >= cost.length) return sum;
        return Math.min(minCost(cost, start + 1, sum + cost[start]),
                minCost(cost, start + 2, sum + cost[start]));
    }


}
