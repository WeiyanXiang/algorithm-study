package tree.path.possibletrees;

/**
 * @author Weiyan Xiang on 2021/6/26
 */

public class UniqueBST {

    /**
     * 96. Unique Binary Search Trees
     * <p>
     * https://leetcode.com/problems/unique-binary-search-trees/
     * <p>
     * my ac ans: DP idea: dp[i] = sum(  j = {1..i}, dp[j-1]*dp[n-j] )
     */
    public int numTrees(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        // dp[i] = sum(  j = {1..i}, dp[j-1]*dp[n-j] )
        for (int i = 2; i <= n; i++) {
            int sum = 0;
            for (int j = 1; j <= i; j++) {
                sum += dp[j - 1] * dp[i - j];
            }
            dp[i] = sum;
        }
        return dp[n];
    }
}
