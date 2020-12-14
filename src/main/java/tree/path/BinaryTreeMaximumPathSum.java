package tree.path;/**
 * @author Weiyan Xiang on 2020/12/14
 */

import tree.TreeNode;

public class BinaryTreeMaximumPathSum {
    int ans = Integer.MIN_VALUE;

    /**
     * 124. Binary Tree Maximum Path Sum
     * <p>
     * https://leetcode.com/problems/binary-tree-maximum-path-sum/
     * <p>
     * learnt from huahua answer
     */
    public int maxPathSum(TreeNode root) {
        doMs(root);
        return ans;
    }

    private int doMs(TreeNode root) {
        if (root == null) return Integer.MIN_VALUE;
        int l = Math.max(doMs(root.left), 0);
        int r = Math.max(doMs(root.right), 0);
        int sum = root.val + l + r;
        ans = Math.max(ans, sum);
        return Math.max(l, r) + root.val;
    }
}
