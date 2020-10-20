package dfs;

/**
 * @author Weiyan Xiang on 2020/3/11
 * <p>
 * https://leetcode.com/problems/number-of-islands/
 */
public class NumberOfIslands {

    public static void main(String[] args) {
        /**
         * 11110
         * 11010
         * 11000
         * 00000
         */
        char[][] grid = {
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '1'},
                {'0', '0', '1', '1', '0'}};

        System.out.println(new NumberOfIslands().numIslands(grid));

    }

    int y;          // The height of the given grid
    int x;          // The width of the given grid
    char[][] g;     // The given grid, stored to reduce recursion memory usage

    /**
     * Given a 2d grid map of '1's (land) and '0's (water), count the number of islands.
     * <p>
     * This method approaches the problem as one of depth-first connected components search
     *
     * @param grid, the given grid.
     * @return the number of islands.
     */
    public int numIslands(char[][] grid) {
        y = grid.length;
        if (y == 0) return 0;
        x = grid[0].length;
        g = grid;
        int count = 0;
        for (int i = 0; i < y; i++) {
            for (int j = 0; j < x; j++) {
                if (g[i][j] == '1') {
                    dfs(i, j);
                    count++;
                }
            }
        }
        return count;
    }

    /**
     * Marks the given site as visited, then checks adjacent sites.
     * <p>
     * Or, Marks the given site as water, if land, then checks adjacent sites.
     * <p>
     * Or, Given one coordinate (i,j) of an island, obliterates the island from the given grid, so that it is not
     * counted again.
     *
     * @param i, the row index of the given grid
     * @param j, the column index of the given grid
     */
    private void dfs(int i, int j) {
        if (i < 0 || j < 0 || i >= y || j >= x || g[i][j] != '1') return;
        g[i][j] = 'X';
        /**
         * the reason why we need i-1 and j-1 is because for example below shape,
         * it will return 2 without check left and up:
         * 1 1 1
         * 0 1 0
         * 1 1 1
         *
         */
        dfs(i + 1, j);
        dfs(i - 1, j);
        dfs(i, j + 1);
        dfs(i, j - 1);
    }
}
