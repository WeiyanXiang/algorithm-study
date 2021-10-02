package tree;

/**
 * @author Weiyan Xiang on 2021/10/2
 */

public class MinAbsoluteDifinBST {
    int min = Integer.MAX_VALUE;

    /**
     * 530. Minimum Absolute Difference in BST
     * <p>
     * https://leetcode.com/problems/minimum-absolute-difference-in-bst/
     * <p>
     * find the deepest value for both left and right to do abs dif and compare
     */
    public int getMinimumDifference(TreeNode root) {
        dfs(root);
        return min;
    }

    private void dfs(TreeNode root) {
        if (root == null) return;
        int l = root.left != null ? Math.abs(root.val - getMost(root.left, true).val) : Integer.MAX_VALUE;
        int r = root.right != null ? Math.abs(root.val - getMost(root.right, false).val) : Integer.MAX_VALUE;
        int cur = Math.min(l, r);
        min = Math.min(cur, min);
        dfs(root.left);
        dfs(root.right);
    }

    private TreeNode getMost(TreeNode root, boolean isLeft) {
        while (root.right != null && isLeft == true) root = root.right;
        while (root.left != null && isLeft == false) root = root.left;
        return root;
    }
}
