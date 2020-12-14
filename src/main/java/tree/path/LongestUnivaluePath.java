package tree.path;/**
 * @author Weiyan Xiang on 2020/12/14
 */

import tree.TreeNode;

public class LongestUnivaluePath {
    private int ans = 0;

    /**
     * 687. Longest Univalue Path
     * <p>
     * https://leetcode.com/problems/longest-univalue-path/
     * <p>
     * my own ac answer
     */
    public int longestUnivaluePath(TreeNode root) {
        if (root == null) return 0;
        maxUniDepth(root, root.val);
        return ans;
    }

    private int maxUniDepth(TreeNode root, int val) {
        if (root == null) return 0;
        int l = maxUniDepth(root.left, root.val);
        int r = maxUniDepth(root.right, root.val);
        int cur = l + r;
        ans = Math.max(ans, cur);
        if (val == root.val) return Math.max(l, r) + 1;
        return 0;

    }
}
