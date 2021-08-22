package tree;/**
 * @author Weiyan Xiang on 2021/8/22
 */

public class SumOfLeftLeaves {
    int sum = 0;

    /**
     * 404. Sum of Left Leaves
     * <p>
     * https://leetcode.com/problems/sum-of-left-leaves/
     * <p>
     * my ac ans
     */
    public int sumOfLeftLeaves(TreeNode root) {
        dfs(root, false);
        return sum;
    }

    private void dfs(TreeNode root, boolean isLeft) {
        if (root == null) return;
        if (isLeft && root.left == null && root.right == null) sum += root.val;
        dfs(root.left, true);
        dfs(root.right, false);
    }
}
