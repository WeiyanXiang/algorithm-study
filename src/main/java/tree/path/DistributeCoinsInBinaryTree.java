package tree.path;/**
 * @author Weiyan Xiang on 2020/12/20
 */

import tree.TreeNode;

public class DistributeCoinsInBinaryTree {
    int count = 0;

    /**
     * 979. Distribute Coins in Binary Tree
     * <p>
     * https://leetcode.com/problems/distribute-coins-in-binary-tree/
     * <p>
     * upvoted ac ans, learnt from:
     * <p>
     * https://leetcode.com/problems/distribute-coins-in-binary-tree/discuss/221939/C%2B%2B-with-picture-post-order-traversal
     */
    public int distributeCoins(TreeNode root) {
        dfs(root);
        return count;
    }

    private int dfs(TreeNode root) {
        if (root == null) return 0;
        int l = dfs(root.left);
        int r = dfs(root.right);
        count += Math.abs(l) + Math.abs(r);
        return root.val + l + r - 1;
    }
}
