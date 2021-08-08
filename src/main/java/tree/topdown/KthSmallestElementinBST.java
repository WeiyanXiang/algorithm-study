package tree.topdown;

import tree.TreeNode;

/**
 * @author Weiyan Xiang on 2021/5/26
 */

public class KthSmallestElementinBST {
    /**
     * 230. Kth Smallest Element in a BST
     * <p>
     * https://leetcode.com/problems/kth-smallest-element-in-a-bst/
     * <p>
     * my ac answer: inorder traverse
     */
    private int count = 0;
    private int res = 0;

    public int kthSmallest(TreeNode root, int k) {
        if (root == null) return res;
        kthSmallest(root.left, k);
        count++;
        if (count == k) res = root.val;
        kthSmallest(root.right, k);
        return res;
    }
}
