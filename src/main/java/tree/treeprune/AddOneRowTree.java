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
        if (root == null) return null;
        if (curD == depth) {
            TreeNode newNode = new TreeNode(val);
            // if it is left, add to left subtree only and vice versa
            if (isLeft) newNode.left = root;
            else newNode.right = root;
            return newNode;
        }
        root.left = dfs(root.left, val, curD + 1, depth, true);
        root.right = dfs(root.right, val, curD + 1, depth, false);
        return root;
    }

    /**
     * my another ac ans: check at depth-1 and assign in 1 go instead of passing left flag, this is easier to approach
     */
    public TreeNode addOneRowBetter(TreeNode root, int val, int depth) {
        if (depth == 1) {
            TreeNode node = new TreeNode(val);
            node.left = root;
            return node;
        }
        return dfs(root, val, 1, depth);
    }

    private TreeNode dfs(TreeNode root, int val, int curD, int depth) {
        if (root == null) return null;
        if (curD == depth - 1) {
            TreeNode l = new TreeNode(val);
            TreeNode r = new TreeNode(val);
            l.left = root.left;
            r.right = root.right;
            root.left = l;
            root.right = r;
            return root;
        }
        root.left = dfs(root.left, val, curD + 1, depth);
        root.right = dfs(root.right, val, curD + 1, depth);
        return root;
    }
}
