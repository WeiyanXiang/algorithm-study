package graph;

/**
 * @author Weiyan Xiang on 2021/11/2
 */

public class UniquePathsIII {

    /**
     * 980. Unique Paths III
     * <p>
     * https://leetcode.com/problems/unique-paths-iii/
     * <p>
     * my ac ans: mark visited as 10 and backtrack, count++ when there is a valid route found
     */
    private int x1, y1;
    private int blockers;
    private int count = 0;

    public int uniquePathsIII(int[][] grid) {
        // find start point and count blockers
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    x1 = i;
                    y1 = j;
                }
                if (grid[i][j] == -1) {
                    blockers++;
                }
            }
        }
        // mark visited and backtrack, count++ when there is a valid route found
        dfsMark(grid, 1 + blockers, grid.length * grid[0].length, x1, y1);
        return count;
    }

    private void dfsMark(int[][] grid, int curMark, int target, int x1, int y1) {
        if (x1 < 0 || x1 >= grid.length || y1 < 0 || y1 >= grid[0].length) return;
        if (curMark == target && grid[x1][y1] == 2) {
            count++;
            return;
        }
        if (grid[x1][y1] == 10 || grid[x1][y1] == -1) return;
        int temp = grid[x1][y1];
        // mark visited as 10, as long as something dif to any existing value
        grid[x1][y1] = 10;
        dfsMark(grid, curMark + 1, target, x1 + 1, y1);
        dfsMark(grid, curMark + 1, target, x1 - 1, y1);
        dfsMark(grid, curMark + 1, target, x1, y1 + 1);
        dfsMark(grid, curMark + 1, target, x1, y1 - 1);
        // backtrack
        grid[x1][y1] = temp;
    }
}
