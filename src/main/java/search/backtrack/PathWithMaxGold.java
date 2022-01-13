package search.backtrack;

import java.util.Arrays;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author Weiyan Xiang on 2021/1/15
 */

public class PathWithMaxGold {
    /**
     * 1219. Path with Maximum Gold
     * <p>
     * https://leetcode.com/problems/path-with-maximum-gold/
     * <p>
     * my own ac ans
     */
    public int getMaximumGold(int[][] grid) {
        Stream.of(grid).filter(Objects::nonNull).collect(Collectors.toList());
        int xLen = grid.length;
        int yLen = grid[0].length;
        int max = 0;
        boolean[][] visited = new boolean[xLen][yLen];
        // select every point as starting point
        for (int r = 0; r < xLen; r++) {
            for (int c = 0; c < yLen; c++) {
                max = Math.max(max, dfs(grid, visited, r, c, 0));
            }
        }
        return max;
    }

    private int dfs(int[][] grid, boolean[][] visited, int r, int c, int curSum) {
        if (r < 0 || r >= grid.length || c < 0 || c >= grid[0].length || visited[r][c]) return curSum;
        if (grid[r][c] == 0) return curSum;
        visited[r][c] = true;
        curSum += grid[r][c];
        int left = dfs(grid, visited, r, c - 1, curSum);
        int right = dfs(grid, visited, r, c + 1, curSum);
        int up = dfs(grid, visited, r - 1, c, curSum);
        int down = dfs(grid, visited, r + 1, c, curSum);
        // no needs, never used.
        // curSum -= grid[r][c];
        visited[r][c] = false;
        return Math.max(Math.max(left, right), Math.max(up, down));
    }
}
