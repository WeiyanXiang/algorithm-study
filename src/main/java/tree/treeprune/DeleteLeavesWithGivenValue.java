package tree.treeprune;

import tree.TreeNode;

/**
 * @author Weiyan Xiang on 2020/12/6
 */
public class DeleteLeavesWithGivenValue {
    /**
     * 1325. Delete Leaves With a Given Value
     * <p>
     * https://leetcode.com/problems/delete-leaves-with-a-given-value/
     * <p>
     * my own ac answer: this is very much same to @BinaryTreePruning
     */
    public TreeNode removeLeafNodes(TreeNode root, int t) {
        if (root == null) return null;
        // first work out lef and right, because in case of recursive cases: i.e. removing the leaf, the new leaf is again the target
        root.left = removeLeafNodes(root.left, t);
        root.right = removeLeafNodes(root.right, t);
        // second check whether it is target
        if (root.val == t && root.left == null && root.right == null) return null;
        return root;
    }


    public TreeNode removeLeafNodesInitialAcVersion(TreeNode root, int target) {
        TreeNode cur = root;
        return trim(cur, target);
    }

    public TreeNode trim(TreeNode root, int t) {
        if (root == null) return null;
        root.left = trim(root.left, t);
        root.right = trim(root.right, t);
        if (root.val == t && root.left == null && root.right == null) return null;
        return root;
    }
}
