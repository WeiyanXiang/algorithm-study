package tree.path.possibletrees;

/**
 * @author Weiyan Xiang on 2021/6/26
 */

public class UniqueBST {

    /**
     * 96. Unique Binary Search Trees
     * <p>
     * https://leetcode.com/problems/unique-binary-search-trees/
     * Taking 1~n as root respectively:
     *      1 as root: # of trees = F(0) * F(n-1)  // F(0) == 1
     *      2 as root: # of trees = F(1) * F(n-2)
     *      3 as root: # of trees = F(2) * F(n-3)
     *      ...
     *      n-1 as root: # of trees = F(n-2) * F(1)
     *      n as root:   # of trees = F(n-1) * F(0)
     *
     * So, the formulation is:
     *      F(n) = F(0) * F(n-1) + F(1) * F(n-2) + F(2) * F(n-3) + ... + F(n-2) * F(1) + F(n-1) * F(0)
     */
    public int numTrees(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                dp[i] += dp[j - 1] * dp[i - j];
            }
        }
        return dp[n];
    }
}
