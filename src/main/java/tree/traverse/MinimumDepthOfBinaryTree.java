/**
 *
 */
package tree.traverse;

import tree.TreeNode;

/**
 * @author weiyan.xiang
 * @date 25 Mar 2018
 */
public class MinimumDepthOfBinaryTree {
    /**
     * 111. Minimum Depth of Binary Tree
     * <p>
     * https://leetcode.com/problems/minimum-depth-of-binary-tree/submissions/
     */
    public static int minDepthOptimal(TreeNode root) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) return 1;
        int l = Integer.MAX_VALUE, r = Integer.MAX_VALUE;
        if (root.left != null) l = minDepthOptimal(root.left);
        if (root.right != null) r = minDepthOptimal(root.right);
        return 1 + Math.min(l, r);
    }

    /**
     * my second ac answer:
     */
    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        int l = minDepth(root.left);
        int r = minDepth(root.right);
        return l == 0 || r == 0 ? Math.max(l, r) + 1 : Math.min(l, r) + 1;
    }

    public static void main(String[] args) {
        //@formatter:off
        /*
                1
               / \
              2   2
             / \
            3  4
        */
        //@formatter:on
        TreeNode root = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(2);
        TreeNode node4 = new TreeNode(3);
        TreeNode node5 = new TreeNode(4);
        root.left = node2;
        root.right = node3;
        node2.left = node4;
        node2.right = node5;

        System.out.println("2 == " + minDepthOptimal(root));
    }
}
