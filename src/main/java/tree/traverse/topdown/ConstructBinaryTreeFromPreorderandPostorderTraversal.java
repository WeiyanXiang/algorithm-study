package tree.traverse.topdown;/**
 * @author Weiyan Xiang on 2021/6/5
 */

import tree.TreeNode;

public class ConstructBinaryTreeFromPreorderandPostorderTraversal {

    /**
     * https://leetcode.com/problems/construct-binary-tree-from-preorder-and-postorder-traversal/
     */
    private int preIndex = 0;

    public TreeNode constructFromPrePost(int[] pre, int[] post) {
        preIndex = post.length - 1;
        return dfsBuild(pre, post, 0, post.length - 1);
    }

    private TreeNode dfsBuild(int[] pre, int[] post, int l, int r) {
        if (l > r || preIndex < 0) return null;
        int riValue = pre[preIndex--];
        int i = findIndex(post, riValue);

        TreeNode right = dfsBuild(pre, post, l + 1, i - 1);
        TreeNode left = dfsBuild(pre, post, l, i - 1);

        if (i + 1 >= post.length) return null;
        TreeNode rootNode = new TreeNode(post[i + 1]);
        rootNode.left = left;
        rootNode.right = right;

        return rootNode;
    }

    private int findIndex(int[] arr, int value) {
        for (int i = 0; i < arr.length; i++) {
            if (value == arr[i]) return i;
        }
        return -1;
    }


}
