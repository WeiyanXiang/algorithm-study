package search.backtrack;/**
 * @author Weiyan Xiang on 2020/12/22
 */

public class ShortestSuperstring {
    /**
     * 943. Find the Shortest Superstring
     * <p>
     * https://leetcode.com/problems/find-the-shortest-superstring/
     * <p>
     * too hard, cannot understand during reading tutorial:
     * https://zxi.mytechroad.com/blog/searching/leetcode-943-find-the-shortest-superstring/
     *
     * below answer is dfs/backtracking.
     * backtracking is not optimal, optimal method is the dp version in the tutorial
     */
    private int n;
    private int[][] g;
    private String[] a;
    private int best_len;
    private int[] path;
    private int[] best_path;

    private void dfs(int d, int used, int cur_len) {
        if (cur_len >= best_len) return;
        if (d == n) {
            best_len = cur_len;
            best_path = path.clone();
            return;
        }

        for (int i = 0; i < n; ++i) {
            // checks whether the i-th is 1
            if ((used & (1 << i)) != 0) continue;
            path[d] = i;
            dfs(d + 1,
                    used | (1 << i),
                    d == 0 ? a[i].length() : cur_len + g[path[d - 1]][i]);
        }
    }

    public String shortestSuperstring(String[] A) {
        n = A.length;
        g = new int[n][n];
        a = A;
        for (int i = 0; i < n; ++i)
            for (int j = 0; j < n; ++j) {
                g[i][j] = A[j].length();
                for (int k = 1; k <= Math.min(A[i].length(), A[j].length()); ++k)
                    if (A[i].substring(A[i].length() - k).equals(A[j].substring(0, k)))
                        g[i][j] = A[j].length() - k;
            }

        path = new int[n];
        best_len = Integer.MAX_VALUE;

        dfs(0, 0, 0);

        String ans = A[best_path[0]];
        for (int k = 1; k < n; ++k) {
            int i = best_path[k - 1];
            int j = best_path[k];
            ans += A[j].substring(A[j].length() - g[i][j]);
        }
        return ans;
    }

}
