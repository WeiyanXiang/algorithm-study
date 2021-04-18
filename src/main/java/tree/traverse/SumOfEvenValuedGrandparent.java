package tree.traverse;

import tree.TreeNode;

/**
 * @author Weiyan Xiang on 2021/4/18
 */

public class SumOfEvenValuedGrandparent {
    /**
     * 1315. Sum of Nodes with Even-Valued Grandparent
     * <p>
     * https://leetcode.com/problems/sum-of-nodes-with-even-valued-grandparent/
     * <p>
     * upvoted ans: L+R+Params to add up
     */
    public int sumEvenGrandparent(TreeNode root) {
        // cur,p,gp
        return helper(root, 1, 1);
    }

    private int helper(TreeNode node, int p, int gp) {
        if (node == null) return 0;
        return helper(node.left, node.val, p) + helper(node.right, node.val, p) + (gp % 2 == 0 ? node.val : 0);
    }

    /**
     * my ac ans: L-R Pattern
     */
    int ans = 0;

    public int sumEvenGrandparentMyAns(TreeNode root) {
        // traverse to check whether value is even, find the groundsons and sum up
        dfs(root);
        return ans;
    }

    private void dfs(TreeNode root) {
        if (root == null) return;
        if (root.val % 2 == 0) addGrandsons(root);
        dfs(root.left);
        dfs(root.right);
    }

    private void addGrandsons(TreeNode node) {
        if (node.left != null) {
            if (node.left.left != null) ans += node.left.left.val;
            if (node.left.right != null) ans += node.left.right.val;
        }
        if (node.right != null) {
            if (node.right.left != null) ans += node.right.left.val;
            if (node.right.right != null) ans += node.right.right.val;
        }
    }
}
