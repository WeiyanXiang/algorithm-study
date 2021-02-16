package search.backtrack;

/**
 * @author Weiyan Xiang on 2021/2/16
 */

public class ConstructLexiLargestValidSequence {

    /**
     * 1718. Construct the Lexicographically Largest Valid Sequence
     * <p>
     * https://leetcode.com/problems/construct-the-lexicographically-largest-valid-sequence/
     * <p>
     * mostly upvoted ac ans
     */
    public int[] constructDistancedSequence(int n) {
        int[] ans = new int[2 * n - 1];
        // used boolean array to track the number assignment
        boolean[] used = new boolean[n + 1];
        dfs(n, used, ans, 0);
        return ans;
    }

    private boolean dfs(int n, boolean[] used, int[] ans, int start) {
        if (start == ans.length) return true;
        if (ans[start] != 0) return dfs(n, used, ans, start + 1);
        for (int i = n; i >= 1; i--) {
            if (used[i]) continue;
            used[i] = true;
            ans[start] = i;
            if (i == 1) {
                if (dfs(n, used, ans, start + 1)) return true;
            } else if (start + i < ans.length && ans[start + i] == 0) {
                // second filling which should following the distance rule
                ans[start + i] = i;
                if (dfs(n, used, ans, start + 1)) return true;
                ans[start + i] = 0;
            }
            ans[start] = 0;
            used[i] = false;
        }
        return false;
    }
}
