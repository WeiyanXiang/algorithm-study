package tree.traverse.topdown;

import tree.TreeNode;

/**
 * @author Weiyan Xiang on 2021/6/2
 */

public class ConstructBinaryTreefromInorderandPostorderTraversal {

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return dfsInorder(0, postorder.length - 1, inorder, postorder);
    }

    private TreeNode dfsInorder(int l, int r, int[] inorder, int[] postorder) {
        if (l > r) return null;
        int rootValue = postorder[r];
        int rootIndex = findIndexFromValue(rootValue, inorder);
        TreeNode root = new TreeNode(rootValue);
        root.left = dfsInorder(l, rootIndex - 1, inorder, postorder);
        root.right = dfsInorder(rootIndex + 1, r, inorder, postorder);
        return root;
    }

    private int findIndexFromValue(int value, int[] inorder) {
        for (int i = 0; i < inorder.length; i++) {
            if (value == inorder[i]) return i;
        }
        return -1;
    }
}
