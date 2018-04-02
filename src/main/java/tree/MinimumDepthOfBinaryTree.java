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
     * 
     * The minimum depth is the number of nodes along the shortest path from the
     * root node down to the nearest leaf node.
     * 
     * @param root
     * @return
     */
    public static int minDepth(TreeNode root) {
        if (root == null)
            return 0;
        if (root.left == null)
            return 1 + getDfsMinLength(root.right);
        if (root.right == null)
            return 1 + getDfsMinLength(root.left);
        return 1 + Math.min(getDfsMinLength(root.left), getDfsMinLength(root.right));
    }

    private static int getDfsMinLength(TreeNode node) {
        if (node == null) {
            return 0;
        } else {
            if (node.left == null && node.right == null) {
                return 1 + getDfsMinLength(node.right);
            } else {
                return 1 + Math.max(getDfsMinLength(node.left), getDfsMinLength(node.right));
            }
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

        System.out.println(minDepth(root));
    }
}
