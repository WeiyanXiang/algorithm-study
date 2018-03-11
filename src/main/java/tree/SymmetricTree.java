/**
 * 
 */
package tree;

/**
 * @author weiyan.xiang
 * @date 11 Mar 2018
 */
public class SymmetricTree {
    public class TreeNode {
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
    public boolean isSymmetric(TreeNode root) {
        return false;
    }

    public static void main(String[] args) {

    }

}
