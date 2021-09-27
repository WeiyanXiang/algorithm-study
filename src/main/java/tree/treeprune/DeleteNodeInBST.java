package tree.treeprune;/**
 * @author Weiyan Xiang on 2021/9/24
 */

import tree.TreeNode;

public class DeleteNodeInBST {
    /**
     * 450. Delete Node in a BST
     * <p>
     * https://leetcode.com/problems/delete-node-in-a-bst/
     * <p>
     * upvoted ans: key part is on find the min of right subtree
     */
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) return null;
        if (root.val < key) {
            root.right = deleteNode(root.right, key);
        } else if (root.val > key) {
            root.left = deleteNode(root.left, key);
        } else {
            if (root.left == null) return root.right;
            if (root.right == null) return root.left;
            // node with two children, replace with the inOrder successor(minVal) in the right subtree
            root.val = findMin(root.right);
            root.right = deleteNode(root.right, root.val);

            /**
             * node with two children, can also replace with the inOrder successor(minVal) in the left subtree
             root.val=findMin(root.left);
             root.left=deleteNode(root.left,root.val);
             */
        }
        return root;

    }

    private int findMin(TreeNode root) {
        while (root.left != null) root = root.left;
        return root.val;
    }
}
