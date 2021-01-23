package search.backtrack;/**
 * @author Weiyan Xiang on 2021/1/23
 */

import java.util.ArrayList;
import java.util.List;

public class NQueens {
    /**
     * 51. N-Queens
     * <p>
     * https://leetcode.com/problems/n-queens/
     *
     * upvoted ans, dfs + backtrack
     */
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList<>();
        char[][] board = getDefaultBoard(n);
        dfs(board, 0, ans);
        return ans;
    }

    private char[][] getDefaultBoard(int n) {
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }
        return board;
    }

    private void dfs(char[][] board, int colIndex, List<List<String>> res) {
        if (colIndex == board.length) {
            res.add(build(board));
            return;
        }
        for (int i = 0; i < board.length; i++) {
            if (isValid(board, i, colIndex)) {
                board[i][colIndex] = 'Q';
                dfs(board, colIndex + 1, res);
                board[i][colIndex] = '.';
            }
        }

    }

    private boolean isValid(char[][] board, int x, int y) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < y; j++) {
                /**
                 * The reason it checks (x + j == y + i || x + y == i + j || x == i):
                 *
                 * Every time we find a existing 'Q', 3 conditions need to be met before we can place a new 'Q' in the new column:
                 *
                 * no confict in columns : self explanatory as we put 'Q' col by col.
                 * no confict in rows : x == i
                 * no conflict in diagonals : Math.abs(x-i) == Math.abs(y-j)
                 * For Math.abs(x-i) == Math.abs(y-j),
                 * if x > i, y > j , x - i = y - j => x + j = y + i
                 * if x < i, y < j, i - x = j - y => x + j = y + i
                 * if x > i, y < j, x - i = j - y => x + y = i + j
                 * if x < i, y > j, i - x = y - j => x + y = i + j
                 *
                 */
                // if (board[i][j] == 'Q' && (Math.abs(x-i) == Math.abs(y-j) || x == i)) {
                if (board[i][j] == 'Q' && (x + j == y + i || x + y == i + j || x == i)) {
                    return false;
                }
            }
        }
        return true;
    }

    private List<String> build(char[][] board) {
        List<String> ans = new ArrayList<>();
        for (int i = 0; i < board.length; i++) {
            String row = "";
            for (int j = 0; j < board[0].length; j++) {
                row += board[i][j];
            }
            ans.add(row);
        }
        return ans;
    }
}
