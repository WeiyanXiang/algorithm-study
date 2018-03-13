/**
 * 
 */
package tree;

/**
 * @author weiyan.xiang
 * @date 11 Mar 2018
 */
public class SymmetricTree {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

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

    public static boolean isSymmetric(TreeNode root) {
        return root == null || isSubTreeSymmetric(root.left, root.right);
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
        TreeNode root = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(3);
        TreeNode node5 = new TreeNode(3);
        TreeNode node6 = null;
        TreeNode node7 = new TreeNode(2);
        root.left = node2;
        root.right = node3;
        node2.left = node4;
        node2.right = null;
        node3.left = node7;
        node3.right = null;

        System.out.println(isSymmetric(root));
    }

}
