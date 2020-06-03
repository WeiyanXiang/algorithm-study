package tree;

/**
 * @author Weiyan Xiang on 2020/6/1
 */
public class MaxDepth {
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        return Math.max(1 + maxDepth(root.left), 1 + maxDepth(root.right));
    }

    public static void main(String[] args) {
        //@formatter:off
        /*
                5
               /  \
              4    18
             / \  / \
            11 12 4  23
            /
           14
        */
        //@formatter:on
        TreeNode root = new TreeNode(5);
        TreeNode node2 = new TreeNode(4);
        TreeNode node3 = new TreeNode(18);
        TreeNode node4 = new TreeNode(11);
        TreeNode node5 = new TreeNode(12);
        TreeNode node6 = new TreeNode(4);
        TreeNode node7 = new TreeNode(23);
        TreeNode node8 = new TreeNode(14);

        root.left = node2;
        root.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        node3.right = node7;
        node4.left = node8;

        MaxDepth testObj = new MaxDepth();

        System.out.println("4 == " + testObj.maxDepth(root));
    }

}
