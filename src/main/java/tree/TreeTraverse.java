/**
 *
 */
package tree;

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

    private void printPostorder(Node node) {
        if (node == null)
            return;
        printPostorder(node.left);
        printPostorder(node.right);
        System.out.println(node.key + " ");
    }

    private void printPreorder(Node node) {
        if (node == null)
            return;
        System.out.println(node.key + " ");
        printPreorder(node.left);
        printPreorder(node.right);
    }

    private void printInorder(Node node) {
        if (node == null)
            return;
        printInorder(node.left);
        System.out.println(node.key + " ");
        printInorder(node.right);
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
