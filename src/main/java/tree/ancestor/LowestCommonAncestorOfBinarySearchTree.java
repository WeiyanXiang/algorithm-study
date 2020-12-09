package tree.ancestor;

import tree.TreeNode;

/**
 * @author Weiyan Xiang on 2020/12/9
 */
public class LowestCommonAncestorOfBinarySearchTree {

    /**
     * 235. Lowest Common Ancestor of a Binary Search Tree
     * <p>
     * https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/
     * <p>
     * my own ac answer: very similar to 236 LowestCommonAncestorOfBinaryTree
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;
        if (root == q || root == p) return root;
        if (p.val < root.val && q.val < root.val) return lowestCommonAncestor(root.left, p, q);
        if (p.val > root.val && q.val > root.val) return lowestCommonAncestor(root.right, p, q);
        else return root;
    }
}
