/**
 * 
 */
package tree;

import java.util.Stack;

/**
 * @author weiyan.xiang
 * @date 11 Mar 2018
 */
public class SymmetricTree {

    //@formatter:off
    /*
     * Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).
        For example, this binary tree [1,2,2,3,4,4,3] is symmetric:
            1
           / \
          2   2
         / \ / \
        3  4 4  3
        But the following [1,2,2,null,3,null,3] is not:
            1
           / \
          2   2
           \   \
           3    3
        Note:
        Bonus points if you could solve it both recursively and iteratively.
     */
    //@formatter:on 
    /*
     * Recursive approach is more effective
     */
    public static boolean isSymmetricRecur(TreeNode root) {
        return root == null || isSubTreeSymmetric(root.left, root.right);
    }

    public static boolean isSymmetricIterative(TreeNode root) {
        if (root == null)
            return true;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root.left);
        stack.push(root.right);
        while (!stack.empty()) {
            TreeNode first = stack.pop();
            TreeNode second = stack.pop();
            if (first == null && second == null) {
                continue;
            } else if (first == null || second == null || first.val != second.val) {
                return false;
            } else {
                stack.push(first.left);
                stack.push(second.right);
                stack.push(first.right);
                stack.push(second.left);
            }
        }
        return true;
    }

    private static boolean isSubTreeSymmetric(TreeNode left, TreeNode right) {
        if (left == null || right == null) {
            return left == right;
        } else if (left.val != right.val) {
            return false;
        } else {
            return isSubTreeSymmetric(left.left, right.right) && isSubTreeSymmetric(left.right, right.left);
        }
    }

    public static void main(String[] args) {
        //@formatter:off
        /*
                1
               / \
              2   2
             / \ / \
            3  4 4  3
        */
        //@formatter:on
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

        System.out.println("true == " + isSymmetricRecur(root));
        System.out.println("true == " + isSymmetricIterative(root));
    }

}
