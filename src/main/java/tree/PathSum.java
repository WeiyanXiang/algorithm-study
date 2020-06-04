/**
 *
 */
package tree;

/**
 * @author weiyan.xiang
 * @date 3 Apr 2018
 */
public class PathSum {

    //@formatter:off
    /**
     *  Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that adding up all the values along the path equals the given sum.

        For example:
        Given the below binary tree and sum = 22,
        
                      5
                     / \
                    4   8
                   /   / \
                  11  13  4
                 /  \      \
                7    2      1
        return true, as there exist a root-to-leaf path 5->4->11->2 which sum is 22.
     * @param root
     * @param sum
     * @return
     */
    //@formatter:on
    public static boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) return false;
        return doCheck(root, sum, 0);
    }

    private static boolean doCheck(TreeNode root, int sum, int cs) {
        if (root == null) return false;
        cs += root.val;
        if (root.left == null && root.right == null && cs == sum) return true;
        return doCheck(root.left, sum, cs) || doCheck(root.right, sum, cs);
    }

    public static boolean hasPathSumOptimised(TreeNode node, int sum) {
        if (node == null)
            return false;
        if (node.val == sum && node.left == null && node.right == null) {
            return true;
        } else if (node.left != null || node.right != null) {
            return hasPathSumOptimised(node.left, sum - node.val) || hasPathSumOptimised(node.right, sum - node.val);
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        //@formatter:off
        /*
                5
               /  \
              4    18
             / \  / \
            11 12 4  23
        */
        //@formatter:on
        TreeNode root = new TreeNode(5);
        TreeNode node2 = new TreeNode(4);
        TreeNode node3 = new TreeNode(18);
        TreeNode node4 = new TreeNode(11);
        TreeNode node5 = new TreeNode(12);
        TreeNode node6 = new TreeNode(4);
        TreeNode node7 = new TreeNode(23);
        root.left = node2;
        root.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        node3.right = node7;

        System.out.println("true == " + hasPathSumOptimised(root, 27));
        System.out.println("true == " + hasPathSum(root, 27));
    }

}
