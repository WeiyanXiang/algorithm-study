package search.backtrack;/**
 * @author Weiyan Xiang on 2021/1/31
 */

import java.util.Arrays;

public class LetterTilePossibilities {
    /**
     * 1079. Letter Tile Possibilities
     * <p>
     * https://leetcode.com/problems/letter-tile-possibilities/
     * <p>
     * my own ac answer and then learnt the pruning using this line :
     * <p>
     * if(i - 1 >= 0 && tiles[i] == tiles[i-1] && !visited[i - 1]) continue;
     *
     * this version I passed cur String in, which takes big space, second impl below passing an int length in, which faster than 99%
     */
    private int count = 0;

    public int numTilePossibilities(String tiles) {
        char[] chs = tiles.toCharArray();
        Arrays.sort(chs);
        // combination
        dfs(chs, "", new boolean[chs.length]);
        return count;
    }

    private void dfs(char[] tiles, String cur, boolean[] visited) {
        if (cur.length() >= tiles.length) {
            return;
        }
        for (int i = 0; i < tiles.length; i++) {
            // not use repeat i-th letter
            if (visited[i]) continue;
            // prune duplicate branches
            if (i - 1 >= 0 && tiles[i] == tiles[i - 1] && !visited[i - 1]) continue;
            count++;
            visited[i] = true;
            dfs(tiles, cur + tiles[i], visited);
            visited[i] = false;
        }
    }

    /**
     * Runtime: 1 ms, faster than 99.63% of Java online submissions for Letter Tile Possibilities.
     * Memory Usage: 37.1 MB, less than 79.46% of Java online submissions for Letter Tile Possibilities.
     */
    private int ct = 0;

    public int numTilePossibilitiesOptimized(String tiles) {
        char[] chs = tiles.toCharArray();
        Arrays.sort(chs);
        // combination
        dfs(chs, 0, new boolean[chs.length]);
        return ct;
    }

    private void dfs(char[] tiles, int len, boolean[] visited) {
        if (len == tiles.length) {
            return;
        }
        for (int i = 0; i < tiles.length; i++) {
            // not use repeat i-th letter
            if (visited[i]) continue;
            // prune duplicate branches
            if (i - 1 >= 0 && tiles[i] == tiles[i - 1] && !visited[i - 1]) continue;
            ct++;
            visited[i] = true;
            dfs(tiles, len + 1, visited);
            visited[i] = false;
        }
    }
}
