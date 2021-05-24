/**
 *
 */
package tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author weiyan.xiang
 * @date 12 Feb 2018
 */
public class TreeTraverse {

    /**
     * left root right
     *
     * @param treeNode
     */
    public void printInorder(TreeNode treeNode) {
        if (treeNode == null) return;
        printInorder(treeNode.left);
        System.out.print(treeNode.val + " ");
        printInorder(treeNode.right);
    }

    /**
     * root left right
     *
     * @param treeNode
     */
    public void printPreorder(TreeNode treeNode) {
        if (treeNode == null) return;
        System.out.print(treeNode.val + " ");
        printPreorder(treeNode.left);
        printPreorder(treeNode.right);
    }

    /**
     * left right root
     *
     * @param treeNode
     */
    public void printPostorder(TreeNode treeNode) {
        if (treeNode == null)
            return;
        printPostorder(treeNode.left);
        printPostorder(treeNode.right);
        System.out.print(treeNode.val + " ");
    }

    /**
     * BFS
     *
     * @param root
     */
    public void printTreeInLevelOrder(tree.TreeNode root) {
        if (root == null)
            return;
        Queue<tree.TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            tree.TreeNode top = queue.poll();
            System.out.print(top.val + " ");
            if (top.left != null) {
                queue.add(top.left);
            }
            if (top.right != null) {
                queue.add(top.right);
            }

        }

    }

}
