package array;/**
 * @author Weiyan Xiang on 2022/4/2
 */

import java.util.HashSet;
import java.util.Set;

public class ValidSudoku {
    /**
     * 36. Valid Sudoku
     * <p>
     * https://leetcode.com/problems/valid-sudoku/
     * <p>
     * my ac ans, basic loop
     */
    public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (!isValid(board, i, j)) return false;
            }
        }
        return true;
    }

    private boolean isValid(char[][] board, int i, int j) {
        Set<Character> col = new HashSet<>();
        for (int a = 0; a < 9; a++) {
            if (board[i][a] != '.' && col.contains(board[i][a])) return false;
            col.add(board[i][a]);
        }

        Set<Character> row = new HashSet<>();
        for (int b = 0; b < 9; b++) {
            if (board[b][j] != '.' && row.contains(board[b][j])) return false;
            row.add(board[b][j]);
        }
        Set<Character> loc = new HashSet<>();
        for (int c = 0; c < 3; c++) {
            for (int d = 0; d < 3; d++) {
                char bb = board[i - i % 3 + c][j - j % 3 + d];
                if (bb != '.' && loc.contains(bb)) return false;
                loc.add(bb);
            }
        }
        return true;
    }
}
