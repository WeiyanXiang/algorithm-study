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

    /**
     * Write a dfs helper, return the number of coins given to the parent.
     */
    private int dfs(TreeNode root) {
        if (root == null) return 0;
        int l = dfs(root.left);
        int r = dfs(root.right);
        count += Math.abs(l) + Math.abs(r);
        return root.val + l + r - 1;
    }


    private int res = 0;
    /**
     * res += abs[num of subTree, sum of coins]
     */
    public int distributeCoinsMyVersion(TreeNode root) {
        dfsMine(root);
        return res;
    }

    private int[] dfsMine(TreeNode root) {
        if (root == null) return new int[]{0, 0};
        if (root.left == null && root.right == null) return new int[]{1, root.val};
        int[] l = dfsMine(root.left);
        int[] r = dfsMine(root.right);
        res += Math.abs(l[0] - l[1]);
        res += Math.abs(r[0] - r[1]);
        return new int[]{l[0] + r[0] + 1, l[1] + r[1] + root.val};
    }
}
