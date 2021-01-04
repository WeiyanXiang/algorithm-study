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
     * bfs upvoted version, idea: At beginning, set cell value to Integer.MAX_VALUE if it is not 0. If a newly labelled
     * cell (which is having max value) found, then we explore that cell.
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
                // if out of bound
                if (r < 0 || r >= m || c < 0 || c >= n) continue;
                // if it is labelled to check distance
                if (matrix[r][c] == Integer.MAX_VALUE) {
                    q.offer(new int[]{r, c});
                    matrix[r][c] = matrix[p[0]][p[1]] + 1;
                }
            }
        }
        return matrix;
    }

}
