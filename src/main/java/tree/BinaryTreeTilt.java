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
     * my ac ans
     */
    int sum = 0;

    public int findTilt(TreeNode root) {
        dfs(root);
        return sum;
    }

    /**
     * bottom up
     */
    private int dfs(TreeNode root) {
        if (root == null) return 0;
        int left = dfs(root.left);
        int right = dfs(root.right);
        sum += Math.abs(left - right);
        return root.val + left + right;
    }

}
