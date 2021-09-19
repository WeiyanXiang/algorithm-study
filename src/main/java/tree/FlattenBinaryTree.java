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
        /**
         * why?
         *
         * i.e.
         *         1
         *       /   \
         *      2    3
         *      /\  /\
         *     4 5 6 7
         *
         *     when do at node 1, the tree will be like:
         *
         *           1
         *         /  \
         *        2   3
         *        \    \
         *        4     6
         *         \     \
         *          5     7
         *
         *  hence we need while loop to go to bottom right to connect 5 to 4
         */
        while (cur.right != null) cur = cur.right;
        cur.right = r;

    }
}
