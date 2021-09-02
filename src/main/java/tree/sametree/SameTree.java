package tree.sametree;

import tree.TreeNode;

/**
 * @author Weiyan Xiang on 2020/11/29
 */
public class SameTree {
    /**
     * 100. Same Tree
     * <p>
     * https://leetcode.com/problems/same-tree/
     * <p>
     * my own ac answer
     */
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        return p != null && q != null && p.val == q.val && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

    /**
     * simpler to write
     */
    public boolean isSameTreeAnother(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (p == null || q == null) return false;
        if (p.val != q.val) return false;
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}
