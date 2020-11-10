package dp;

/**
 * @author Weiyan Xiang on 2020/6/24
 */
public class UniquePaths {

    /**
     * 62. Unique Paths
     * <p>
     * https://leetcode.com/problems/unique-paths/
     * <p>
     * my first attempt
     * <p>
     */
    public int uniquePathsNaiveRecursive(int m, int n) {
        if (m == 1 || n == 1) return 1;
        return uniquePathsNaiveRecursive(m - 1, n) + uniquePathsNaiveRecursive(m, n - 1);
    }


    public int uniquePathsDPWith2D(int m, int n) {
        if (m == 0 || n == 0) return 0;
        if (m == 1 || n == 1) return 1;

        int[][] dp = new int[m][n];

        for (int i = 0; i < n; i++) {
            dp[0][i] = 1;
        }
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }

        }

        return dp[m - 1][n - 1];
    }

    /**
     * dp[i][j] = dp[i - 1][j] + dp[i][j - 1]; each time we just need to update previous row index j and current row
     * index j-1 then 2 1D array will work:
     */
    public int uniquePathsTwo1D(int m, int n) {
        if (m == 0 || n == 0) return 0;
        if (m == 1 || n == 1) return 1;

        int[] pre = new int[n];
        int[] cur = new int[n];
        for (int i = 0; i < n; i++) {
            pre[i] = 1;
            cur[i] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                cur[j] = pre[j] + cur[j - 1];
            }
            pre = cur;
        }
        return cur[n - 1];
    }

    /**
     * look the above pre is just cur before update. so we can reduce to be single array
     * <p>
     * more analysis: https://leetcode.com/problems/unique-paths/discuss/22954/C%2B%2B-DP
     * <p>
     * Now, you may wonder whether we can further reduce the memory usage to just O(1) space since the above code seems
     * to use only two variables (cur[j] and cur[j - 1]). However, since the whole row cur needs to be updated for m - 1
     * times (the outer loop) based on old values, all of its values need to be saved and thus O(1)-space is impossible.
     * However, if you are having a DP problem without the outer loop and just the inner one, then it will be possible.
     */
    public static int uniquePathsOptimal(int m, int n) {
        if (m <= 0 || n <= 0) {
            return 0;
        }
        int[] dp = new int[n]; //
        for (int i = 0; i < n; i++) {
            dp[i] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[j] = dp[j - 1] + dp[j];
            }
        }
        return dp[n - 1];
    }

}
