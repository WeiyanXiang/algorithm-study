package tree.treeprune;

import tree.TreeNode;

/**
 * @author Weiyan Xiang on 2020/12/6
 */
public class BinaryTreePruning {

    /**
     * 814. Binary Tree Pruning
     * <p>
     * https://leetcode.com/problems/binary-tree-pruning/
     * <p>
     * my own ac answer
     */
    public TreeNode pruneTree(TreeNode root) {
        TreeNode cur = root;
        return prune(cur);
    }

    public TreeNode prune(TreeNode root) {
        if (root == null) return null;
        root.left = pruneTree(root.left);
        root.right = pruneTree(root.right);
        if (root.val == 0 && root.left == null && root.right == null) return null;
        return root;
    }
}
