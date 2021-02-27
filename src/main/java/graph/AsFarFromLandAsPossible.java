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
     *
     * my ac BFS ans, not fast
     */
    int x, y;

    public int maxDistance(int[][] grid) {
        x = grid.length;
        y = grid[0].length;
        int max = 0;
        int zeroCount = 0;
        // loop through each water cell, find its distance to the nearest land
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                if (grid[i][j] == 0) {
                    zeroCount++;
                    max = Math.max(max, bfsNearestLand(grid, i, j, new boolean[x][y]));
                }
            }
        }
        return zeroCount == 0 || zeroCount == x * y ? -1 : max;
    }

    private int bfsNearestLand(int[][] grid, int r, int c, boolean[][] visited) {
        LinkedList<List<Integer>> queue = new LinkedList<>();
        queue.add(Arrays.asList(r, c));
        visited[r][c] = true;
        int count = 0;
        while (!queue.isEmpty()) {
            int qSize = queue.size();
            for (int i = 0; i < qSize; i++) {
                List<Integer> latest = queue.poll();
                int row = latest.get(0);
                int col = latest.get(1);
                if (grid[row][col] == 1) return count;
                checkAndAdd(grid, visited, queue, row + 1, col);
                checkAndAdd(grid, visited, queue, row - 1, col);
                checkAndAdd(grid, visited, queue, row, col + 1);
                checkAndAdd(grid, visited, queue, row, col - 1);
            }
            count++;
        }
        return count;
    }

    private void checkAndAdd(int[][] grid, boolean[][] visited, LinkedList<List<Integer>> queue, int r, int c) {
        if (!(r < 0 || r >= x || c < 0 || c >= y) && !visited[r][c]) {
            queue.add(Arrays.asList(r, c));
            visited[r][c] = true;
        }
    }
}
