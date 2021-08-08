/**
 *
 */
package tree;

import tree.TreeNode;

/**
 * @author weiyan.xiang
 * @date 24 Mar 2018
 */
public class BalancedBinaryTree {

    private static class ReturnNode {
        public boolean isBalanced;
        public int d;

        public ReturnNode(boolean isBalanced, int d) {
            this.isBalanced = isBalanced;
            this.d = d;
        }
    }

    /**
     * 110. Balanced Binary Tree
     * <p>
     * https://leetcode.com/problems/balanced-binary-tree/submissions/
     */
    public static boolean isBalancedTemplate(TreeNode root) {
        return doIsBalanced(root).isBalanced;
    }

    public static ReturnNode doIsBalanced(TreeNode root) {
        // break / stop
        if (root == null) return new ReturnNode(true, 0);
        // task / this
        ReturnNode l = doIsBalanced(root.left);
        ReturnNode r = doIsBalanced(root.right);
        // children
        if (!l.isBalanced || !r.isBalanced) return new ReturnNode(false, 0);
        if (Math.abs(l.d - r.d) > 1) return new ReturnNode(false, 0);
        return new ReturnNode(true, Math.max(l.d, r.d) + 1);
    }

    //@formatter:off
    /**
     * Given a binary tree, determine if it is height-balanced.

        For this problem, a height-balanced binary tree is defined as:
        
        a binary tree in which the depth of the two subtrees of every node never differ by more than 1.
        
        Example 1:
        
        Given the following tree [3,9,20,null,null,15,7]:
        
            3
           / \
          9  20
            /  \
           15   7
        Return true.
        
        Example 2:
        
        Given the following tree [1,2,2,3,3,null,null,4,4]:
        
               1
              / \
             2   2
            / \
           3   3
          / \
         4   4
        Return false.


     */
    //@formatter:on
    public static boolean isBalanced(TreeNode root) {
        if (root == null)
            return true;
        return Math.abs(getDfsLength(root.left) - getDfsLength(root.right)) <= 1 && isBalanced(root.left)
                && isBalanced(root.right);
    }

    private static int getDfsLength(TreeNode node) {
        return node == null ? 0 : 1 + Math.max(getDfsLength(node.left), getDfsLength(node.right));
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(2);
        TreeNode node4 = new TreeNode(3);
        TreeNode node5 = new TreeNode(4);
        TreeNode node6 = new TreeNode(4);
        TreeNode node7 = new TreeNode(3);
        root.left = node2;
        root.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        node3.right = node7;

        System.out.println("true == " + isBalanced(root));
        //@formatter:off
        /*
         *     1
              / 
             2   
            /
           3
         */
        //@formatter:on
        TreeNode node_1 = new TreeNode(1);
        TreeNode node_2 = new TreeNode(2);
        TreeNode node_3 = new TreeNode(3);
        node_1.left = node_2;
        node_2.left = node_3;
        TreeNode.printTreeInLevelOrder(node_1);
        System.out.println("\nfalse == " + isBalanced(node_1));
        System.out.println("\nfalse == " + isBalancedTemplate(node_1));

    }
}
