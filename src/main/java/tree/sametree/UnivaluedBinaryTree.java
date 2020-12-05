package tree.sametree;

import tree.TreeNode;

/**
 * @author Weiyan Xiang on 2020/12/5
 */
public class UnivaluedBinaryTree {
    /**
     * 965. Univalued Binary Tree
     * <p>
     * https://leetcode.com/problems/univalued-binary-tree/
     */
    public boolean isUnivalTree(TreeNode root) {
        if (root == null) return true;
        return isSameValue(root, root.val);
    }

    private boolean isSameValue(TreeNode node, int v) {
        if (node == null) return true;
        if (node.val != v) return false;
        return isSameValue(node.left, v) && isSameValue(node.right, v);
    }
}
