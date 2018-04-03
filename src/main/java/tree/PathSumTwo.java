/**
 * 
 */
package tree;

import java.util.List;

/**
 * @author weiyan.xiang
 * @date 3 Apr 2018
 */
public class PathSumTwo {

    public static List<List<Integer>> pathSum(TreeNode root, int sum) {
        return null;
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

        System.out.println(pathSum(root, 27));
    }

}
