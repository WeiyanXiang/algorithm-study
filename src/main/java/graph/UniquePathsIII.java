package graph;/**
 * @author Weiyan Xiang on 2021/11/2
 */

import java.util.ArrayList;
import java.util.List;

public class UniquePathsIII {

    private int x1, y1;
    private List<int[]> blockers = new ArrayList<>();
    private int count = 0;

    /**
     * 980. Unique Paths III
     * <p>
     * https://leetcode.com/problems/unique-paths-iii/
     * <p>
     * my ac ans: mark visited as 10 and backtrack, count++ when there is a valid route found
     */
    public int uniquePathsIII(int[][] grid) {
        // find start,end and obstacles
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    x1 = i;
                    y1 = j;
                }
                if (grid[i][j] == -1) {
                    blockers.add(new int[]{i, j});
                }
            }
        }
        int total = grid.length * grid[0].length;
        // mark the route and backtracking and if found valid count the ans
        dfsMark(grid, 1 + blockers.size(), total, x1, y1);
        return count;
    }

    private void dfsMark(int[][] grid, int curMark, int target, int x1, int y1) {
        if (x1 < 0 || x1 >= grid.length || y1 < 0 || y1 >= grid[0].length) {
            return;
        }
        if (curMark == target && grid[x1][y1] == 2) {
            count++;
            return;
        }
        if (grid[x1][y1] == 10 || grid[x1][y1] == -1) {
            return;
        }
        int temp = grid[x1][y1];
        grid[x1][y1] = 10;
        dfsMark(grid, curMark + 1, target, x1 + 1, y1);
        dfsMark(grid, curMark + 1, target, x1 - 1, y1);
        dfsMark(grid, curMark + 1, target, x1, y1 + 1);
        dfsMark(grid, curMark + 1, target, x1, y1 - 1);
        grid[x1][y1] = temp;
    }
}
