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

    /**
     * why return boolean? use the returned value to terminate the dfs searching, whenever found the ans, return it.
     * Which can guarantee the largest array
     */
    private boolean dfs(int n, boolean[] used, int[] ans, int index) {
        if (index == ans.length) return true;
        if (ans[index] != 0) return dfs(n, used, ans, index + 1);
        for (int i = n; i >= 1; i--) {
            if (used[i]) continue;
            used[i] = true;
            ans[index] = i;
            if (i == 1) {
                if (dfs(n, used, ans, index + 1)) return true;
            } else if (index + i < ans.length && ans[index + i] == 0) {
                // second filling which should following the distance rule
                ans[index + i] = i;
                if (dfs(n, used, ans, index + 1)) return true;
                ans[index + i] = 0;
            }
            ans[index] = 0;
            used[i] = false;
        }
        return false;
    }
}
