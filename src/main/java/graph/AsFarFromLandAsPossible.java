package graph;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Weiyan Xiang on 2021/2/26
 */

public class AsFarFromLandAsPossible {
    /**
     * 1162. As Far from Land as Possible
     * <p>
     * https://leetcode.com/problems/as-far-from-land-as-possible/
     */
    int x, y;

    public int maxDistance(int[][] grid) {
        x = grid.length;
        y = grid[0].length;
        int max = 0;
        // loop through each water cell, find its distance to the nearest land
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                if (grid[i][j] == 0) {
                    max = Math.max(max, bfsNearestLand(grid, i, j, new boolean[x][y]));
                }
            }
        }
        return max;
    }

    private int bfsNearestLand(int[][] grid, int r, int c, boolean[][] visited) {
        LinkedList<List<Integer>> queue = new LinkedList<>();
        queue.add(Arrays.asList(r, c));
        int count = 0;
        while (!queue.isEmpty()) {
            List<Integer> latest = queue.poll();
            count++;
            int row = latest.get(0);
            int col = latest.get(1);
            if (grid[row][col] == 1) return count;
            if (row < 0 || row >= x || col < 0 || col >= y) continue;
            checkAndAdd(grid, visited, queue, row + 1, col);
            checkAndAdd(grid, visited, queue, row - 1, col);
            checkAndAdd(grid, visited, queue, row, col + 1);
            checkAndAdd(grid, visited, queue, row, col - 1);
        }
        return count;
    }

    private void checkAndAdd(int[][] grid, boolean[][] visited, LinkedList<List<Integer>> queue, int row, int i) {
        if (isValid(row, i, grid, visited)) {
            queue.add(Arrays.asList(row, i));
            visited[row][i] = true;
        }
    }

    private boolean isValid(int row, int col, int[][] grid, boolean[][] visited) {
        return !(row < 0 || row >= x || col < 0 || col >= y) && grid[row][col] == 0 && !visited[row][col];
    }
}
