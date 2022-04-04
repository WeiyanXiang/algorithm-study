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
        if (check(board, true)) return false;
        if (check(board, false)) return false;
        if (checkBlocks(board)) return false;
        return true;
    }

    private boolean checkBlocks(char[][] board) {
        for (int a = 0; a < 9; a += 3) {
            for (int b = 0; b < 9; b += 3) {
                Set<Character> block = new HashSet<>();
                for (int c = 0; c < 3; c++) {
                    for (int d = 0; d < 3; d++) {
                        char bb = board[a + c][b + d];
                        if (block.contains(bb)) return true;
                        if (bb != '.') block.add(bb);
                    }
                }
            }
        }
        return false;
    }

    private boolean check(char[][] board, boolean isCol) {
        for (int i = 0; i < 9; i++) {
            Set<Character> col = new HashSet<>();
            for (int j = 0; j < 9; j++) {
                char c = isCol ? board[i][j] : board[j][i];
                if (col.contains(c)) return true;
                if (c != '.') col.add(c);
            }
        }
        return false;
    }

}
