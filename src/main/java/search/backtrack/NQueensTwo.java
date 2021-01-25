package search.backtrack;

/**
 * @author Weiyan Xiang on 2021/1/24
 */

public class NQueensTwo {
    private int res = 0;

    /**
     * 52. N-Queens II
     * <p>
     * https://leetcode.com/problems/n-queens-ii/
     * <p>
     * upvoted AC answer
     **/
    public int totalNQueens(int n) {
        boolean[] v = new boolean[n];
        // 2n-1 条对角线
        boolean[] l = new boolean[2 * n - 1];
        boolean[] r = new boolean[2 * n - 1];
        dfs(n, v, l, r, 0);
        return res;
    }

    private void dfs(int n, boolean[] v, boolean[] l, boolean[] ri, int c) {
        if (c == n) {
            res++;
            return;
        }
        for (int r = 0; r < n; r++) {
            if (v[r] || l[r - c + n - 1] || ri[r + c]) continue;
            v[r] = true;
            l[r - c + n - 1] = true;
            ri[r + c] = true;
            dfs(n, v, l, ri, c + 1);
            // backtrack
            v[r] = false;
            l[r - c + n - 1] = false;
            ri[r + c] = false;
        }
    }

    /**
     * my AC answer, mostly adapted from NQueens ac ans.
     */
    private int ans = 0;

    public int totalNQueensMyAns(int n) {
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }
        dfs(board, 0);
        return ans;
    }

    private void dfs(char[][] board, int col) {
        if (col == board.length) {
            ans++;
            return;
        }
        // loop through each row
        for (int i = 0; i < board.length; i++) {
            if (isValid(board, i, col)) {
                board[i][col] = 'Q';
                dfs(board, col + 1);
                // backtrack
                board[i][col] = '.';
            }
        }
    }

    private boolean isValid(char[][] board, int r, int c) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < c; j++) {
                if (board[i][j] == 'Q' && (i == r || Math.abs(r - i) == Math.abs(c - j))) {
                    return false;
                }
            }
        }
        return true;
    }
}
