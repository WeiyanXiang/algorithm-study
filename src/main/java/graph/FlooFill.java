package graph;

/**
 * @author Weiyan Xiang on 2021/2/20
 */

public class FlooFill {
    /**
     * 733. Flood Fill
     * <p>
     * https://leetcode.com/problems/flood-fill/
     * <p>
     * my ac answer
     */
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        // mark all prospected points, update color
        dfs(image, sr, sc, newColor, image[sr][sc]);
        return image;
    }

    private void dfs(int[][] image, int r, int c, int newColor, int color) {
        if (r < 0 || r >= image.length || c < 0 || c >= image[0].length) return;
        if (image[r][c] == newColor) return;
        if (color == image[r][c]) {M
            image[r][c] = newColor;
            dfs(image, r + 1, c, newColor, color);
            dfs(image, r - 1, c, newColor, color);
            dfs(image, r, c + 1, newColor, color);
            dfs(image, r, c - 1, newColor, color);
        }
    }
}
