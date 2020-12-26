package search.backtrack;

/**
 * @author Weiyan Xiang on 2020/12/25
 */

public class WordSearch {
    /**
     * 79. Word Search
     * <p>
     * https://leetcode.com/problems/word-search/
     * <p>
     * upvoted ans, my version
     */
    public boolean exist(char[][] board, String word) {
        boolean[][] visited = new boolean[board.length][board[0].length];
        for (int r = 0; r < board.length; r++) {
            for (int c = 0; c < board[0].length; c++) {
                if (dfs(board, word, r, c, 0, visited)) return true;
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, String word, int r, int c, int i, boolean[][] visited) {
        if (i == word.length()) return true;
        if (r < 0 || r > board.length - 1 || c < 0 || c > board[0].length - 1) return false;
        if (!visited[r][c] && word.charAt(i) == board[r][c]) {
            visited[r][c] = true;
            boolean found = dfs(board, word, r + 1, c, i + 1, visited) || dfs(board, word, r - 1, c, i + 1, visited) ||
                    dfs(board, word, r, c + 1, i + 1, visited) || dfs(board, word, r, c - 1, i + 1, visited);

            visited[r][c] = false;
            return found;
        }
        return false;
    }
}
