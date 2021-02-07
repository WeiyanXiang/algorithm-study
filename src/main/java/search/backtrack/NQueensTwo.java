package search.backtrack;

import java.util.HashSet;
import java.util.Set;

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
     * my AC answer
     **/
    Set<Integer> row = new HashSet<>();
    Set<Integer> dio1 = new HashSet<>();
    Set<Integer> dio2 = new HashSet<>();
    private int count = 0;

    public int totalNQueens(int n) {
        dfs(n, 0);
        return count;
    }

    private void dfs(int n, int c) {
        if (c == n) {
            count++;
            return;
        }
        for (int r = 0; r < n; r++) {
            // for \, r-c all same, for /, r+c all same
            int leftD = r + c;
            int rightD = r - c;
            if (row.contains(r) || dio1.contains(leftD) || dio2.contains(rightD)) continue;

            row.add(r);
            dio1.add(leftD);
            dio2.add(rightD);

            dfs(n, c + 1);

            row.remove(r);
            dio1.remove(leftD);
            dio2.remove(rightD);

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
                // for \, i-j all same, for /, i+j all same
                if (board[i][j] == 'Q' && (i == r || Math.abs(r - i) == Math.abs(c - j))) {
                    return false;
                }
            }
        }
        return true;
    }
}
