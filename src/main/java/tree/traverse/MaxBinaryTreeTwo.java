package tree.traverse;/**
 * @author Weiyan Xiang on 2021/4/28
 */

import tree.TreeNode;

public class MaxBinaryTreeTwo {
    public TreeNode insertIntoMaxTree(TreeNode root, int val) {
        if (root == null) return new TreeNode(val);
        if (root.val < val) {
            TreeNode newNode = new TreeNode(val);
            newNode.left = root;
            return newNode;
        }
        root.right = insertIntoMaxTree(root.right, val);
        return root;
    }
}
