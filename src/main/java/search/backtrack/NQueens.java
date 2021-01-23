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
     */
    List<List<String>> ans = new ArrayList<>();

    public List<List<String>> solveNQueens(int n) {
        List<String> board = new ArrayList<>();
        getDefaultBoard(n, board);
        dfs(n, board, 0);
        return ans;
    }

    private void getDefaultBoard(int n, List<String> board) {
        for (int i = 0; i < n; i++) {
            String row = "";
            for (int j = 0; j < n; j++) {
                row += ".";
            }
            board.add(row);
        }
    }

    private boolean dfs(int n, List<String> board, int count) {
        if (count > n) return false;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                char ch = board.get(i).charAt(j);
                if (ch == '.') {
                    if (isValid(board, i, j, n)) {
                        String curRow = board.get(i);
                        String newRow = curRow.substring(0, j) + "Q" + curRow.substring(j + 1);
                        board.set(i, newRow);
                        if (dfs(n, board, count + 1)) {
                            ans.add(board);
                            return true;
                        } else {
                            String revertedRow = curRow.substring(0, j) + "." + curRow.substring(j + 1);
                            board.set(i, revertedRow);
                        }
                    }
                }
            }
        }
        return true;
    }

    private boolean isValid(List<String> board, int i, int j, int n) {
        // same row
        for (int c = 0; c < n; c++) {
            if (board.get(i).charAt(c) == 'Q') return false;
        }
        // same col
        for (int r = 0; r < n; r++) {
            if (board.get(r).charAt(j) == 'Q') return false;
        }
        // /
        int a = i + 1, b = j - 1;
        while (a >= 0 && b >= 0 && a < n && b < n) {
            if (board.get(a).charAt(b) == 'Q') return false;
            a++;
            b--;
        }
        a = i - 1;
        b = j + 1;
        while (a >= 0 && b >= 0 && a < n && b < n) {
            if (board.get(a).charAt(b) == 'Q') return false;
            a--;
            b++;
        }
        // \
        a = i - 1;
        b = j - 1;
        while (a >= 0 && b >= 0 && a < n && b < n) {
            if (board.get(a).charAt(b) == 'Q') return false;
            a--;
            b--;
        }
        a = i + 1;
        b = j + 1;
        while (a >= 0 && b >= 0 && a < n && b < n) {
            if (board.get(a).charAt(b) == 'Q') return false;
            a++;
            b++;
        }
        return true;
    }
}
