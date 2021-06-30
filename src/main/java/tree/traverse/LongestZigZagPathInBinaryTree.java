package tree.traverse;/**
 * @author Weiyan Xiang on 2021/6/30
 */

import tree.TreeNode;

public class LongestZigZagPathInBinaryTree {

    private int max = 0;

    /**
     * https://leetcode.com/problems/longest-zigzag-path-in-a-binary-tree/
     * <p>
     * my ac ans after reading upvoted ans, dfs with some variation
     */
    public int longestZigZag(TreeNode root) {
        // left -> 0, right -> 1
        dfs(root, 0, 0);
        dfs(root, 1, 0);
        return max;
    }


    private void dfs(TreeNode root, int direction, int d) {
        if (root == null) return;
        max = Math.max(max, d);
        if (direction == 0) {
            dfs(root.right, 1, d + 1);
            dfs(root.left, 0, 1); // try again from start
        } else {
            dfs(root.left, 0, d + 1);
            dfs(root.right, 1, 1);// try again from start
        }
    }

}
