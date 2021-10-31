package graph;/**
 * @author Weiyan Xiang on 2021/10/31
 */

import java.util.ArrayList;
import java.util.List;

public class RottingOranges {

    /**
     * 994. Rotting Oranges
     * <p>
     * https://leetcode.com/problems/rotting-oranges/
     * <p>
     * my an ans: small recursion
     */
    private int freshCount = 0;
    private int ans = -1;
    List<int[]> rottens = new ArrayList<>();

    public int orangesRotting(int[][] grid) {
        // find all rotten organes
        for (int x = 0; x < grid.length; x++) {
            for (int y = 0; y < grid[0].length; y++) {
                if (grid[x][y] == 2) {
                    int[] loc = new int[2];
                    loc[0] = x;
                    loc[1] = y;
                    rottens.add(loc);
                } else if (grid[x][y] == 1) freshCount++;
            }
        }
        if (rottens.isEmpty() && freshCount == 0) return 0;
        if (rottens.isEmpty()) return -1;
        // recursive explore 4 directions and convert to rotten
        // check whether all are rotten
        convert(grid, rottens);
        return freshCount == 0 ? ans : -1;

    }

    private void convert(int[][] grid, List<int[]> cur) {
        if (cur.isEmpty()) return;
        List<int[]> newCur = new ArrayList<>();
        int size = cur.size();
        for (int i = 0; i < size; i++) {
            int x = cur.get(i)[0];
            int y = cur.get(i)[1];
            if (x - 1 >= 0 && grid[x - 1][y] == 1) doRotten(newCur, grid, x - 1, y);
            if (x + 1 < grid.length && grid[x + 1][y] == 1) doRotten(newCur, grid, x + 1, y);
            if (y - 1 >= 0 && grid[x][y - 1] == 1) doRotten(newCur, grid, x, y - 1);
            if (y + 1 < grid[0].length && grid[x][y + 1] == 1) doRotten(newCur, grid, x, y + 1);
        }
        ans++;
        convert(grid, newCur);
    }

    private void doRotten(List<int[]> newCur, int[][] grid, int x, int y) {
        newCur.add(new int[]{x, y});
        grid[x][y] = 2;
        freshCount--;
    }


}
