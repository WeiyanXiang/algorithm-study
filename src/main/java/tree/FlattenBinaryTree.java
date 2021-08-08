package tree;/**
 * @author Weiyan Xiang on 2021/5/24
 */

import tree.TreeNode;

public class FlattenBinaryTree {

    /**
     * 114. Flatten Binary Tree to Linked List
     * <p>
     * https://leetcode.com/problems/flatten-binary-tree-to-linked-list/
     * <p>
     * adapted form upvoted ac ans
     */
    public void flatten(TreeNode root) {
        dfs(root);
    }

    // left subtree put to right and iterative traverse to append the right tree
    private void dfs(TreeNode root) {
        if (root == null) return;
        /**
         * tricky point is no matter what traverse: preorder,postorder or inorder, they should all work, validated.
         */
        dfs(root.left);
        dfs(root.right);
        TreeNode l = root.left;
        TreeNode r = root.right;
        root.left = null;

        TreeNode cur = root;
        cur.right = l;
        while (cur.right != null) cur = cur.right;
        cur.right = r;

    }
}
