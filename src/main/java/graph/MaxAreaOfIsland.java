package graph;

/**
 * @author Weiyan Xiang on 2021/2/18
 */

public class MaxAreaOfIsland {
    private int max = 0;
    private int x;
    private int y;

    /**
     * 695. Max Area of Island
     * <p>
     * https://leetcode.com/problems/max-area-of-island/
     * <p>
     * my ac ans
     */
    public int maxAreaOfIsland(int[][] grid) {
        x = grid.length;
        y = grid[0].length;
        boolean[][] visited = new boolean[x][y];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                max = Math.max(dfs(grid, i, j, visited), max);
            }
        }
        return max;
    }

    private int dfs(int[][] grid, int r, int c, boolean[][] visited) {
        if (r < 0 || r >= x || c < 0 || c >= y) return 0;
        if (visited[r][c]) return 0;
        if (grid[r][c] == 1) {
            visited[r][c] = true;
            return 1 + dfs(grid, r + 1, c, visited) +
                    dfs(grid, r - 1, c, visited) +
                    dfs(grid, r, c + 1, visited) +
                    dfs(grid, r, c - 1, visited);
        }
        return 0;
    }
}
