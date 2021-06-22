package tree.traverse.topdown.construct;/**
 * @author Weiyan Xiang on 2021/6/22
 */

import tree.TreeNode;

public class InsertIntoBST {
    /**
     * 701. Insert into a Binary Search Tree
     * <p>
     * https://leetcode.com/problems/insert-into-a-binary-search-tree/
     * <p>
     * my ac ans: bottom up basic impl
     */
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) return new TreeNode(val);
        if (val > root.val) root.right = insertIntoBST(root.right, val);
        if (val < root.val) root.left = insertIntoBST(root.left, val);
        return root;
    }
}
