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
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {
                    for (char d = '1'; d <= '9'; d++) {
                        if (isValid(board, d, i, j)) {
                            board[i][j] = d;
                            if (dfs(board)) return true;
                            else board[i][j] = '.';
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


    private boolean isValid(char[][] board, char d, int i, int j) {
        int subR = (i / 3) * 3;
        int subC = (j / 3) * 3;
        for (int t = 0; t < 9; t++) {
            if (board[i][t] == d) return false;
            if (board[t][j] == d) return false;
        }
        for (int a = 0; a < 3; a++) {
            for (int b = 0; b < 3; b++) {
                if (board[a + subR][b + subC] == d) return false;
            }
        }
        return true;
    }
}
