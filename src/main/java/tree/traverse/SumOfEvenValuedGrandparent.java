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
     * my ac ans: bottom-up
     */
    public int sumEvenGrandparentMy(TreeNode root) {
        if (root == null) return 0;
        int l = sumEvenGrandparent(root.left);
        int r = sumEvenGrandparent(root.right);
        if (root.val % 2 == 0) {
            if (root.left != null) {
                l += root.left.left == null ? 0 : root.left.left.val;
                l += root.left.right == null ? 0 : root.left.right.val;
            }
            if (root.right != null) {
                r += root.right.left == null ? 0 : root.right.left.val;
                r += root.right.right == null ? 0 : root.right.right.val;
            }
        }
        return l + r;
    }
}
