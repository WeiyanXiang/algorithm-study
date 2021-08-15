package tree;/**
 * @author Weiyan Xiang on 2021/8/15
 */

public class InvertBinaryTree {
    /**
     * 226. Invert Binary Tree
     * <p>
     * https://leetcode.com/problems/invert-binary-tree/
     * <p>
     * my ac ans
     */
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;
        TreeNode curL = root.left;
        root.left = root.right;
        root.right = curL;
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }
}
