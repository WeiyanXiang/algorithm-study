package graph;/**
 * @author Weiyan Xiang on 2021/2/22
 */

public class MakingALargeIsland {
    /**
     *
     * 827. Making A Large Island
     *
     * https://leetcode.com/problems/making-a-large-island/
     */
    /**
     * dfs my TLE answer
     */
    private int x, y;

    public int largestIsland(int[][] grid) {
        int max = -1;
        // for loop each point and dfs find island
        x = grid.length;
        y = grid[0].length;
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                // starting point, if it's 0, flip to 1.
                if (grid[i][j] == 0) {
                    grid[i][j] = 1;
                    max = Math.max(max, dfs(grid, i, j, new boolean[x][y]));
                    if (max == x * y) return max;
                    grid[i][j] = 0;
                }
            }
        }
        return max == -1 ? x * y : max;
    }

    private int dfs(int[][] grid, int r, int c, boolean[][] visited) {
        if (r < 0 || r >= x || c < 0 || c >= y) return 0;
        if (visited[r][c]) return 0;
        if (grid[r][c] == 1) {
            visited[r][c] = true;
            return 1 + dfs(grid, r + 1, c, visited)
                    + dfs(grid, r - 1, c, visited)
                    + dfs(grid, r, c + 1, visited)
                    + dfs(grid, r, c - 1, visited);
        }
        return 0;
    }
}
