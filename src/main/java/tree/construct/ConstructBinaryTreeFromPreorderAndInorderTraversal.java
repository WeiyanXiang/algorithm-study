package tree.construct;/**
 * @author Weiyan Xiang on 2021/8/8
 */

import tree.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class ConstructBinaryTreeFromPreorderAndInorderTraversal {
    private int preIndex = 0;
    private Map<Integer, Integer> inMap = new HashMap<>();

    /**
     * 105. Construct Binary Tree from Preorder and Inorder Traversal
     * <p>
     * https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
     * <p>
     * my ac answer, similar to ConstructBinaryTreeFromPreorderAndInorderTraversal
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for (int i = 0; i < inorder.length; i++) {
            inMap.put(inorder[i], i);
        }
        return dfs(preorder, inorder, 0, preorder.length - 1);
    }

    private TreeNode dfs(int[] pre, int[] in, int l, int r) {
        if (l > r || preIndex > pre.length - 1) return null;
        TreeNode root = new TreeNode(pre[preIndex]);
        int midIndex = inMap.get(pre[preIndex]);
        preIndex++;
        root.left = dfs(pre, in, l, midIndex - 1);
        if (l == r) return new TreeNode(in[l]);
        root.right = dfs(pre, in, midIndex + 1, r);
        return root;
    }
}
