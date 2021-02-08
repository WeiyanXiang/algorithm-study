package search.backtrack;

/**
 * @author Weiyan Xiang on 2021/1/21
 */

public class SudokuSolver {

    /**
     * 37. Sudoku Solver
     * <p>
     * https://leetcode.com/problems/sudoku-solver/submissions/
     * <p>
     * mostly upvoted ans
     */
    public void solveSudoku(char[][] board) {
        // if visited mark as v otherwise put number in
        dfs(board);
    }

    private boolean dfs(char[][] board) {
        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {
                if (board[r][c] == '.') {
                    for (char cur = '1'; cur <= '9'; cur++) {
                        if (isValid(board, cur, r, c)) {
                            board[r][c] = cur;
                            if (dfs(board)) return true;
                                // backtrack
                            else board[r][c] = '.';
                        }
                    }
                    // my thoughts: below return false means above 1->9 all tried but not working meaning the previous value might be wrong
                    // and this is the only place where returns false.
                    return false;
                }
            }
        }
        return true;
    }


    private boolean isValid(char[][] board, char cur, int r, int c) {
        int subR = (r / 3) * 3;
        int subC = (c / 3) * 3;
        for (int t = 0; t < 9; t++) {
            if (board[r][t] == cur) return false;
            if (board[t][c] == cur) return false;
        }
        for (int a = 0; a < 3; a++) {
            for (int b = 0; b < 3; b++) {
                if (board[a + subR][b + subC] == cur) return false;
            }
        }
        return true;
    }
}
