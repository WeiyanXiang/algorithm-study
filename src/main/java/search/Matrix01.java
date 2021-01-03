package search;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Weiyan Xiang on 2021/1/3
 */

public class Matrix01 {

    /**
     * 542. 01 Matrix
     * <p>
     * https://leetcode.com/problems/01-matrix/
     * <p>
     * bfs upvoted version, idea:
     * At beginning, set cell value to Integer.MAX_VALUE if it is not 0.
     * If newly calculated distance >= current distance, then we don't need to explore that cell again.
     */
    public int[][] updateMatrix(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) q.offer(new int[]{i, j});
                else matrix[i][j] = Integer.MAX_VALUE;
            }
        }

        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        while (!q.isEmpty()) {
            int[] p = q.poll();
            for (int[] d : dirs) {
                int r = p[0] + d[0];
                int c = p[1] + d[1];
                // if the l/r/u/d shifted location already having smaller distance, skip
                if (r < 0 || r >= m || c < 0 || c >= n || matrix[r][c] <= matrix[p[0]][p[1]] + 1) continue;
                q.offer(new int[]{r, c});
                // because l/r/u/d is 1 steps away, so update it
                matrix[r][c] = matrix[p[0]][p[1]] + 1;
            }
        }
        return matrix;
    }

}
