package tree.topdown;/**
 * @author Weiyan Xiang on 2021/5/22
 */

import tree.TreeNode;

public class FindElementsInContaminatedBinaryTree {
    /**
     * 1261. Find Elements in a Contaminated Binary Tree
     * <p>
     * https://leetcode.com/problems/find-elements-in-a-contaminated-binary-tree/
     *
     * my own ac ans
     */
    /**
     * Your FindElements object will be instantiated and called as such: FindElements obj = new FindElements(root);
     * boolean param_1 = obj.find(target);
     */
    class FindElements {
        TreeNode node;

        public FindElements(TreeNode root) {
            root.val = 0;
            dfs(root);
            this.node = root;
        }

        private void dfs(TreeNode root) {
            if (root == null) return;
            if (root.left != null) root.left.val = root.val * 2 + 1;
            if (root.right != null) root.right.val = root.val * 2 + 2;
            dfs(root.left);
            dfs(root.right);
        }

        public boolean find(int target) {
            return doFind(node, target);
        }

        private boolean doFind(TreeNode node, int t) {
            if (node == null) return false;
            if (node.val == t) return true;
            return doFind(node.left, t) || doFind(node.right, t);
        }
    }
}
