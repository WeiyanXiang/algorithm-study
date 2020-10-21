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


    /*
     *        1
     *       / \
     *      2    3
     *     / \
     *    4   5
     */
    private class Node {
        int key;
        Node left, right;

        public Node(int item) {
            key = item;
            left = right = null;
        }
    }

    Node root;


    /**
     * left root right
     *
     * @param node
     */
    private void printInorder(Node node) {
        if (node == null)
            return;
        printInorder(node.left);
        System.out.println(node.key + " ");
        printInorder(node.right);
    }

    /**
     * root left right
     *
     * @param node
     */
    private void printPreorder(Node node) {
        if (node == null)
            return;
        System.out.println(node.key + " ");
        printPreorder(node.left);
        printPreorder(node.right);
    }

    /**
     * left right root
     *
     * @param node
     */
    private void printPostorder(Node node) {
        if (node == null)
            return;
        printPostorder(node.left);
        printPostorder(node.right);
        System.out.println(node.key + " ");
    }

    /**
     * BFS
     *
     * @param root
     */
    public static void printTreeInLevelOrder(TreeNode root) {
        if (root == null)
            return;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            TreeNode top = queue.poll();
            System.out.print(top.val + " ");
            if (top.left != null) {
                queue.add(top.left);
            }
            if (top.right != null) {
                queue.add(top.right);
            }

        }

    }

    public static void main(String[] args) {

        TreeTraverse tree = new TreeTraverse();
        tree.root = tree.new Node(1);
        tree.root.left = tree.new Node(2);
        tree.root.right = tree.new Node(3);
        tree.root.left.left = tree.new Node(4);
        tree.root.left.right = tree.new Node(5);

        System.out.println("Preorder traversal of binary tree is ");
        tree.printPreorder(tree.root);

        System.out.println("\nInorder traversal of binary tree is ");
        tree.printInorder(tree.root);

        System.out.println("\nPostorder traversal of binary tree is ");
        tree.printPostorder(tree.root);
    }

}
