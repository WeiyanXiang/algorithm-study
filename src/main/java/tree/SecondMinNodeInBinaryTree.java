package tree;/**
 * @author Weiyan Xiang on 2022/1/6
 */

import java.util.*;

public class SecondMinNodeInBinaryTree {
    int ans = Integer.MAX_VALUE;
    boolean reAssigned = false;

    /**
     * 671. Second Minimum Node In a Binary Tree
     * <p>
     * https://leetcode.com/problems/second-minimum-node-in-a-binary-tree/
     * <p>
     * my ac ans: dfs
     */
    public int findSecondMinimumValue(TreeNode root) {
        if (root == null) return -1;
        dfs(root, root.val);
        return reAssigned ? ans : -1;
    }

    private void dfs(TreeNode root, int mini) {
        if (root == null) return;
        if (root.val - mini > 0) {
            reAssigned = true;
            ans = Math.min(root.val, ans);
        }
        dfs(root.left, mini);
        dfs(root.right, mini);
    }
}
