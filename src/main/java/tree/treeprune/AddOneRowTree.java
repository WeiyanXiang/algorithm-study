package tree.treeprune;/**
 * @author Weiyan Xiang on 2021/4/30
 */

import tree.TreeNode;

public class AddOneRowTree {
    /**
     * 623. Add One Row to Tree
     * <p>
     * https://leetcode.com/problems/add-one-row-to-tree/
     * <p>
     * my ans with Dan: stop condition then L-R-Root
     */
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        return dfs(root, val, 1, depth, true);
    }

    private TreeNode dfs(TreeNode root, int val, int curD, int depth, boolean isLeft) {
        if (curD == depth) {
            TreeNode newNode = new TreeNode(val);
            if (isLeft) newNode.left = root;
            else newNode.right = root;
            return newNode;
        }
        if (root == null) return null;
        root.left = dfs(root.left, val, curD + 1, depth, true);
        root.right = dfs(root.right, val, curD + 1, depth, false);
        return root;
    }
}
