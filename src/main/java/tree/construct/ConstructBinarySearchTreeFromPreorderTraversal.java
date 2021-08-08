package tree.construct;

import tree.TreeNode;

/**
 * @author Weiyan Xiang on 2021/6/6
 */

public class ConstructBinarySearchTreeFromPreorderTraversal {

    /**
     * 1008. Construct Binary Search Tree from Preorder Traversal
     * <p>
     * https://leetcode.com/problems/construct-binary-search-tree-from-preorder-traversal/
     * <p>
     * my ac ans: find next larger value in preorder arrag which will be the mid index to split
     */
    public TreeNode bstFromPreorder(int[] preorder) {
        return dfsBuild(preorder, 0, preorder.length - 1);
    }

    private TreeNode dfsBuild(int[] preorder, int l, int r) {
        if (l > r || l > preorder.length - 1) return null;
        int cur = preorder[l];
        TreeNode root = new TreeNode(cur);
        if (l == r) return root;
        int rightStartIndex = findNextLargerValueIndex(preorder, l, cur);
        root.left = dfsBuild(preorder, l + 1, rightStartIndex - 1);
        root.right = dfsBuild(preorder, rightStartIndex, r);
        return root;
    }

    private int findNextLargerValueIndex(int[] preorder, int curIndex, int curValue) {
        for (int i = curIndex + 1; i < preorder.length; i++) {
            if (curValue < preorder[i]) return i;
        }
        return 100;
    }
}
