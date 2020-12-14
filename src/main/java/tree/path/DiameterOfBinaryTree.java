package tree.path;/**
 * @author Weiyan Xiang on 2020/12/14
 */

import tree.TreeNode;

public class DiameterOfBinaryTree {

    private int ans = 0;

    /**
     * 543. Diameter of Binary Tree
     * <p>
     * https://leetcode.com/problems/diameter-of-binary-tree/
     * <p>
     * similar to 124. BinaryTreeMaximumPathSum, my own ac answer, also the upvoted one:
     */
    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) return 0;
        maxD(root);
        return ans;
    }

    // for each recusion: path must be via root, at least 1 child in path
    private int maxD(TreeNode root) {
        if (root == null) return 0;
        int l = maxD(root.left);
        int r = maxD(root.right);
        int curMaxD = l + r;
        ans = Math.max(ans, curMaxD);
        // must return either left or right path, as path is single route cannot be two directions
        return Math.max(l, r) + 1;
    }
}
