package search;/**
 * @author Weiyan Xiang on 2021/1/16
 */

import java.util.LinkedList;
import java.util.Queue;

public class ShortestBridge {
    /**
     * 934. Shortest Bridge
     * <p>
     * https://leetcode.com/problems/shortest-bridge/
     * <p>
     * huahua ans: dfs+bfs
     */
    public int shortestBridge(int[][] A) {
        // dfs mark one island to 2.
        Queue<int[]> q = new LinkedList<>();
        boolean found = false;
        for (int r = 0; r < A.length; r++) {
            for (int c = 0; c < A[0].length; c++) {
                if (!found && A[r][c] == 1) {
                    dfs(A, r, c, q);
                    found = true;
                }
            }
        }
        // bfs to find distance between 1s and 2s.
        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        int steps = 0;
        while (!q.isEmpty()) {
            for (int qq = q.size(); qq > 0; qq--) {
                int[] p = q.poll();

                for (int[] d : dirs) {
                    int rr = p[0] + d[0];
                    int cc = p[1] + d[1];
                    // if out of bound
                    if (rr < 0 || rr >= A.length || cc < 0 || cc >= A[0].length || A[rr][cc] == 2) continue;
                    // if it is 1 then found the other island, return steps
                    if (A[rr][cc] == 1) return steps;
                    A[rr][cc] = 2;
                    q.offer(new int[]{rr, cc});
                }
            }
            steps++;
        }
        return -1;
    }

    private void dfs(int[][] a, int r, int c, Queue<int[]> q) {
        if (r < 0 || r >= a.length || c < 0 || c >= a[0].length || a[r][c] != 1) return;
        a[r][c] = 2;
        q.offer(new int[]{r, c});
        dfs(a, r, c - 1, q);
        dfs(a, r, c + 1, q);
        dfs(a, r - 1, c, q);
        dfs(a, r + 1, c, q);
    }
}
