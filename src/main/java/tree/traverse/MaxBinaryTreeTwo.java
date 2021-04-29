package tree.traverse;/**
 * @author Weiyan Xiang on 2021/4/28
 */

import tree.TreeNode;

public class MaxBinaryTreeTwo {
    /**
     * 998. Maximum Binary Tree II
     * <p>
     * https://leetcode.com/problems/maximum-binary-tree-ii/
     * <p>
     * my ans: BOTTOM UP: return nomal node OR return inserted node. only update root.right as node is append to right.
     */
    public TreeNode insertIntoMaxTree(TreeNode root, int val) {
        if (root == null) return new TreeNode(val);
        if (root.val < val) {
            TreeNode newNode = new TreeNode(val);
            newNode.left = root;
            return newNode;
        }
        root.right = insertIntoMaxTree(root.right, val);
        return root;
    }
}
