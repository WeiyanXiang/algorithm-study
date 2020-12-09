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
     * my first super slow ac answer
     */
    TreeNode ans;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // dfs: return the deepest node that can find both p and q
        if (root == null) return null;
        if (hasPath(root, p) && hasPath(root, q)) ans = root;
        lowestCommonAncestor(root.left, p, q);
        lowestCommonAncestor(root.right, p, q);
        return ans;
    }

    private boolean hasPath(TreeNode root, TreeNode n) {
        if (root == null) return false;
        if (root.val == n.val) return true;
        return hasPath(root.left, n) || hasPath(root.right, n);
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
