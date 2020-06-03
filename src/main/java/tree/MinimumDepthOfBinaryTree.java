/**
 *
 */
package tree;

/**
 * @author weiyan.xiang
 * @date 25 Mar 2018
 */
public class MinimumDepthOfBinaryTree {
    /**
     * Given a binary tree, find its minimum depth.
     * <p>
     * The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf
     * node.
     *
     * @param root
     * @return
     */
    public static int minDepthOptimal(TreeNode root) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) return 1;
        int l = Integer.MAX_VALUE, r = Integer.MAX_VALUE;
        if (root.left != null) l = minDepthOptimal(root.left);
        if (root.right != null) r = minDepthOptimal(root.right);
        return 1 + Math.min(l, r);
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
