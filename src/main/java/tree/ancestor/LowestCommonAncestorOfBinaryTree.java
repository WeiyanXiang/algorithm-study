package tree.ancestor;

import tree.TreeNode;

/**
 * @author Weiyan Xiang on 2020/12/9
 */
public class LowestCommonAncestorOfBinaryTree {

    /**
     * 236. Lowest Common Ancestor of a Binary Tree
     * <p>
     * https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/
     * <p>
     * my ac answer
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;
        TreeNode le = lowestCommonAncestor(root.left, p, q);
        TreeNode ri = lowestCommonAncestor(root.right, p, q);
        // dfs canFind after bottom up
        if (canFind(le, p) && canFind(le, q)) return le;
        if (canFind(ri, p) && canFind(ri, q)) return ri;
        return root;
    }

    // dfs to return whether can find target node
    private boolean canFind(TreeNode root, TreeNode t) {
        if (root == null) return false;
        if (root == t) return true;
        return canFind(root.left, t) || canFind(root.right, t);
    }

    /**
     * upvoted answer
     */
    public TreeNode lowestCommonAncestorOptimal(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;
        if (root == q || root == p) return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left == null) return right; // p and q in right sub tree
        if (right == null) return left; // p and q in left sub tree
        return root; // p and q across left and right sub tree
    }
}
