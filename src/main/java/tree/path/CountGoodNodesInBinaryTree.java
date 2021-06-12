package tree.path;/**
 * @author Weiyan Xiang on 2021/6/13
 */

import tree.TreeNode;

public class CountGoodNodesInBinaryTree {

    /**
     * 1448. Count Good Nodes in Binary Tree
     * <p>
     * https://leetcode.com/problems/count-good-nodes-in-binary-tree/
     * <p>
     * my ac ans: backtrack
     */
    int count = 0;

    public int goodNodes(TreeNode root) {
        if (root == null) return 0;
        dfs(root, root.val);
        return count;
    }

    private void dfs(TreeNode root, int max) {
        if (root == null) return;
        int temp = max;
        if (max <= root.val) {
            count++;
            max = root.val;
        }
        dfs(root.left, max);
        dfs(root.right, max);
        max = temp;
    }
}
