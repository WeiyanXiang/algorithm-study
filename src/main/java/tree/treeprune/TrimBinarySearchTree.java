package tree.treeprune;

import tree.TreeNode;

/**
 * @author Weiyan Xiang on 2020/12/6
 */
public class TrimBinarySearchTree {

    /**
     * 669. Trim a Binary Search Tree
     * <p>
     * https://leetcode.com/problems/trim-a-binary-search-tree/
     * <p>
     * my own ac answer
     */
    public TreeNode trimBST(TreeNode root, int low, int high) {
        if (root == null) return null;
        if (root.val < low) return trimBST(root.right, low, high);
        if (root.val > high) return trimBST(root.left, low, high);
        if (root.val >= low && root.val <= high) {
            root.left = trimBST(root.left, low, high);
            root.right = trimBST(root.right, low, high);
        }
        return root;
    }

}
