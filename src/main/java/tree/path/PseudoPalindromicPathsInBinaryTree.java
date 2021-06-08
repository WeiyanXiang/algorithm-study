package tree.path;/**
 * @author Weiyan Xiang on 2021/6/9
 */

import tree.TreeNode;

public class PseudoPalindromicPathsInBinaryTree {
    private int count = 0;

    /**
     * 1457. Pseudo-Palindromic Paths in a Binary Tree
     * <p>
     * https://leetcode.com/problems/pseudo-palindromic-paths-in-a-binary-tree/
     * <p>
     * use array to track the occurrences of the values to bypass timelimit requirement
     */
    public int pseudoPalindromicPaths(TreeNode root) {
        dfs(root, new int[10]);
        return count;
    }

    private void dfs(TreeNode root, int[] path) {
        if (root == null) {
            return;
        }
        path[root.val]++;
        if (root.left == null && root.right == null) {
            if (isPalindromic(path)) count++;
        }
        dfs(root.left, path);
        dfs(root.right, path);
        //backtrack
        path[root.val]--;
    }

    private boolean isPalindromic(int[] cache) {
        int count = 0;
        for (int c : cache) {
            if (c != 0 && c % 2 != 0) count++;
        }
        return count <= 1;
    }

}
