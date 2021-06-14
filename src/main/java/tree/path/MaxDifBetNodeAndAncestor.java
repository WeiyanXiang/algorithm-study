package tree.path;/**
 * @author Weiyan Xiang on 2021/6/14
 */

import tree.TreeNode;

public class MaxDifBetNodeAndAncestor {
    /**
     * 1026. Maximum Difference Between Node and Ancestor
     * <p>
     * https://leetcode.com/problems/maximum-difference-between-node-and-ancestor/
     * <p>
     * my ac ans: backtracking
     */
    int max = 0;
    int min = 100001;

    public int maxAncestorDiff(TreeNode root) {
        if (root == null) return Math.abs(max - min);
        int t1 = max, t2 = min;
        if (root.val > max) max = root.val;
        if (root.val < min) min = root.val;
        int l = maxAncestorDiff(root.left);
        int r = maxAncestorDiff(root.right);
        max = t1;
        min = t2;
        return Math.max(l, r);
    }
}
