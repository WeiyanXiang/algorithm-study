package tree.traverse.topdown;/**
 * @author Weiyan Xiang on 2021/5/30
 */

import tree.TreeNode;

public class FlipEquivalentBinaryTrees {

    /**
     * 951. Flip Equivalent Binary Trees
     * <p>
     * https://leetcode.com/problems/flip-equivalent-binary-trees/
     * <p>
     * my own ac ans
     */
    public boolean flipEquiv(TreeNode root1, TreeNode root2) {
        return dfs(root1, root2);
    }

    private boolean dfs(TreeNode n1, TreeNode n2) {
        if (n1 == null && n2 == null) return true;
        if (n1 == null || n2 == null) return false;
        if (n1.val != n2.val) return false;
        if (n1.left != null && n2.left == null) return dfs(n1.right, n2.left) && dfs(n1.left, n2.right);
        if (n1.left == null && n2.left != null) return dfs(n1.right, n2.left) && dfs(n1.left, n2.right);
        if (n1.left != null && n2.left != null && n1.left.val != n2.left.val)
            return dfs(n1.right, n2.left) && dfs(n1.left, n2.right);
        return dfs(n1.left, n2.left) && dfs(n1.right, n2.right);

    }
}
