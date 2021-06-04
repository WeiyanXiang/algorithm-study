package tree.traverse.topdown;

import tree.TreeNode;

/**
 * @author Weiyan Xiang on 2021/6/2
 */

public class ConstructBinaryTreefromInorderandPostorderTraversal {

    /**
     * 106. Construct Binary Tree from Inorder and Postorder Traversal
     * <p>
     * https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/
     * <p>
     * upvoted ans
     */
    private int postIndex = 0;

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        postIndex = postorder.length - 1;
        return dfsInorder(0, postorder.length - 1, inorder, postorder);
    }

    private TreeNode dfsInorder(int l, int r, int[] inorder, int[] postorder) {
        if (l > r || postIndex < 0) return null;
        int rootValue = postorder[postIndex--];
        int rootIndex = findIndexFromValue(rootValue, inorder);
        TreeNode root = new TreeNode(rootValue);
        root.right = dfsInorder(rootIndex + 1, r, inorder, postorder);
        root.left = dfsInorder(l, rootIndex - 1, inorder, postorder);
        return root;
    }

    private int findIndexFromValue(int value, int[] inorder) {
        for (int i = 0; i < inorder.length; i++) {
            if (value == inorder[i]) return i;
        }
        return -1;
    }
}
