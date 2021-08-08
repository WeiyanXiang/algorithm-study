package tree.topdown;/**
 * @author Weiyan Xiang on 2021/5/25
 */

import tree.TreeNode;

public class BinarySearchTreeToGreaterSumTree {

    /**
     * 1038. Binary Search Tree to Greater Sum Tree
     * <p>
     * https://leetcode.com/problems/binary-search-tree-to-greater-sum-tree/
     * <p>
     * reverse order traverse, make sure all right hand trees value added to the global var and then set on the fly
     */
    public TreeNode bstToGst(TreeNode root) {
        sumUpRightSubTree(root);
        return root;
    }

    private int sum = 0;

    private void sumUpRightSubTree(TreeNode root) {
        if (root == null) return;
        sumUpRightSubTree(root.right);
        sum += root.val;
        root.val = sum;
        sumUpRightSubTree(root.left);
    }
}
