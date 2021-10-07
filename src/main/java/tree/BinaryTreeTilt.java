package tree;

/**
 * @author Weiyan Xiang on 2021/10/7
 */

public class BinaryTreeTilt {
    /**
     * 563. Binary Tree Tilt
     * <p>
     * https://leetcode.com/problems/binary-tree-tilt/
     * <p>
     * my ac ans: can be refined
     */
    int sum = 0;

    public int findTilt(TreeNode root) {
        dfs(root);
        return sum;
    }

    private void dfs(TreeNode root) {
        if (root == null) return;
        sum += Math.abs(dfsSum(root.left) - dfsSum(root.right));
        dfs(root.left);
        dfs(root.right);
    }

    private int dfsSum(TreeNode root) {
        if (root == null) return 0;
        return root.val + dfsSum(root.left) + dfsSum(root.right);
    }
}
