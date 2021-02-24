package graph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author Weiyan Xiang on 2021/2/22
 */

public class MakingALargeIsland {
    /**
     * 827. Making A Large Island
     * <p>
     * https://leetcode.com/problems/making-a-large-island/
     */

    private int x, y;
    private int color;

    /**
     * huahua ans
     */
    public int largestIsland(int[][] grid) {
        // loop all to mark land cell to color and save down to a map
        // second loop to check each 0 and work out largest connected islands
        x = grid.length;
        y = grid[0].length;
        // key: color ; value: area size
        Map<Integer, Integer> map = new HashMap<>();
        color = 1;
        int max = 0;
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                // if new island found
                if (grid[i][j] == 1) {
                    color++;
                    int newArea = getArea(grid, i, j);
                    map.put(color, newArea);
                    max = Math.max(newArea, max);
                }
            }
        }

        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                if (grid[i][j] == 0) {
                    int area = 1;
                    Set<Integer> colors = new HashSet<>();
                    colors.add(getColor(grid, i - 1, j));
                    colors.add(getColor(grid, i + 1, j));
                    colors.add(getColor(grid, i, j - 1));
                    colors.add(getColor(grid, i, j + 1));
                    for (int cr : colors) {
                        area += map.getOrDefault(cr, 0);
                    }
                    max = Math.max(area, max);
                }
            }
        }
        return max;
    }

    private int getColor(int[][] grid, int r, int c) {
        if (r < 0 || r >= x || c < 0 || c >= y) return 0;
        return grid[r][c];
    }

    private int getArea(int[][] grid, int r, int c) {
        if (r < 0 || r >= x || c < 0 || c >= y || grid[r][c] != 1) return 0;
        // mark color
        grid[r][c] = color;
        return 1
                + getArea(grid, r + 1, c)
                + getArea(grid, r - 1, c)
                + getArea(grid, r, c + 1)
                + getArea(grid, r, c - 1);
    }

    /**
     * dfs my TLE answer
     */
    private int xx, yy;

    public int largestIslandDfsBasic(int[][] grid) {
        int max = -1;
        // for loop each point and dfs find island
        xx = grid.length;
        yy = grid[0].length;
        for (int i = 0; i < xx; i++) {
            for (int j = 0; j < yy; j++) {
                // starting point, if it's 0, flip to 1.
                // if it's 1, meaning should have been handled
                if (grid[i][j] == 0) {
                    grid[i][j] = 1;
                    max = Math.max(max, dfs(grid, i, j, new boolean[xx][yy]));
                    if (max == xx * yy) return max;
                    grid[i][j] = 0;
                }
            }
        }
        return max == -1 ? xx * yy : max;
    }

    private int dfs(int[][] grid, int r, int c, boolean[][] visited) {
        if (r < 0 || r >= xx || c < 0 || c >= yy) return 0;
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
