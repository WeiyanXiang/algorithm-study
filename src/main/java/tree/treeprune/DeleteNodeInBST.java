package tree.treeprune;/**
 * @author Weiyan Xiang on 2021/9/24
 */

import tree.TreeNode;

public class DeleteNodeInBST {
    /**
     * 450. Delete Node in a BST
     * <p>
     * https://leetcode.com/problems/delete-node-in-a-bst/
     */
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) return null;
        if (root.val < key) root.right = deleteNode(root.right, key);
        else if (root.val > key) root.left = deleteNode(root.left, key);
        else {
            // dfsBuildRight(root.right);
            TreeNode temp = root.left;
            root = root.right;
            if (temp != null) root.left = temp;
        }
        return root;
    }
}
