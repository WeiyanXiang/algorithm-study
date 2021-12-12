package dp;

/**
 * @author Weiyan Xiang on 2020/6/24
 */
public class MinimumPathSum {
    public int minPathSum(int[][] grid) {
        int x = grid.length;
        int y = grid[0].length;
        // dp array, stored minimum cost on each location
        // dp[i][j] = grid[i][j] + min(dp[i-1][j], dp[i][j-1])
        int[][] dp = new int[x][y];
        dp[0][0] = grid[0][0];
        for (int i = 1; i < x; i++) dp[i][0] = grid[i][0] + dp[i - 1][0];
        for (int j = 1; j < y; j++) dp[0][j] = grid[0][j] + dp[0][j - 1];
        for (int i = 1; i < x; i++) {
            for (int j = 1; j < y; j++) {
                dp[i][j] = grid[i][j] + Math.min(dp[i - 1][j], dp[i][j - 1]);
            }
        }
        return dp[x - 1][y - 1];
    }

    //@formatter:off
    /**
     * Given a 2d grid with each cell having some value, find the largest value we can accumulate starting from the
     * bottom left and ending at the top right. We can only move up or right.
     *
     * {1, 3, 1},
     * {1, 5, 1},
     * {4, 2, 1}
     *
     * start from [2,0], end at [0,2], max should be 4+2+5+3+1=15
     */
    //@formatter:on
    public int maxPathSum(int[][] grid) {
        // dp[i][j]=grid[i][j]+max(dp[i-1][j],dp[i][j-1]);
        // prepare initial dp array from left bot
        int x = grid.length, y = grid[0].length;
        int[][] dp = new int[x][y];
        dp[x - 1][0] = grid[x - 1][0];
        // [x-1,0] -> [0,0] | [x-1,0] -> [x-1,y-1]
        for (int i = x - 2; i >= 0; i--) dp[i][0] = grid[i][0] + dp[i + 1][0];
        for (int j = 1; j < y; j++) dp[x - 1][j] = grid[x - 1][j] + dp[x - 1][j - 1];

        for (int i = x - 2; i >= 0; i--) {
            for (int j = 1; j < y; j++) {
                dp[i][j] = grid[i][j] + Math.max(dp[i + 1][j], dp[i][j - 1]);
            }
        }
        return dp[0][y - 1];
    }


    public static void main(String[] args) {
        int[][] intervals = {
                {1, 3, 1},
                {1, 5, 1},
                {4, 2, 1}
        };
        MinimumPathSum pathSum = new MinimumPathSum();
        System.out.println("7 == " + pathSum.minPathSum(intervals));
        System.out.println("15 == " + pathSum.maxPathSum(intervals));
    }
}
