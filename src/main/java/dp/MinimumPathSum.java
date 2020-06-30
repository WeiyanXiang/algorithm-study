package dp;

/**
 * @author Weiyan Xiang on 2020/6/24
 */
public class MinimumPathSum {
    public int minPathSum(int[][] grid) {
        int r = grid.length;
        int c = grid[0].length;
        if (r == 0 || c == 0) return -1;
        // dp array, stored minimum cost on each location
        // dp[i][j] = min(dp[i-1][j], dp[i][j-1]);
        int[][] dp = new int[r][c];
        dp[0][0] = grid[0][0];
        for (int i = 1; i < r; i++) {
            dp[i][0] = grid[i][0] + dp[i - 1][0];
        }
        for (int j = 1; j < c; j++) {
            dp[0][j] = grid[0][j] + dp[0][j - 1];
        }
        for (int i = 1; i < r; i++) {
            for (int j = 1; j < c; j++) {
                dp[i][j] = grid[i][j] + Math.min(dp[i - 1][j], dp[i][j - 1]);
            }
        }
        return dp[r - 1][c - 1];
    }

    public static void main(String[] args) {
        int[][] intervals = {
                {1, 3, 1},
                {1, 5, 1},
                {4, 2, 1}
        };
        System.out.println(new MinimumPathSum().minPathSum(intervals));
    }
}
