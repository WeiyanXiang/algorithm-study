package tree.construct;

import tree.TreeNode;

import java.util.HashMap;
import java.util.Map;

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
    int postIndex = 0;
    Map<Integer, Integer> map = new HashMap<>();

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        for (int i = 0; i < inorder.length; i++) map.put(inorder[i], i);
        postIndex = postorder.length - 1;
        // inorder: left - root - right
        // postorder: left - right - root
        return dfs(postorder, 0, postorder.length - 1);
    }

    private TreeNode dfs(int[] postorder, int l, int r) {
        if (l > r || postIndex < 0) return null;
        TreeNode root = new TreeNode(postorder[postIndex]);
        int mid = map.get(postorder[postIndex]);
        postIndex--;
        /**
         * why right -> left here? because postorder is R->L->Root, it keeps popping the right's parent first
         */
        root.right = dfs(postorder, mid + 1, r);
        root.left = dfs(postorder, l, mid - 1);
        return root;
    }
}
