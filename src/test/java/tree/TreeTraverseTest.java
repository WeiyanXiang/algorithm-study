package tree;

import org.junit.Test;

/**
 * @author Weiyan Xiang on 2020/10/25
 */
public class TreeTraverseTest {

    @Test
    public void should_printTreeInLevelOrder() {
        TreeTraverse tree = new TreeTraverse();

        Integer[] input = {1, 2, 3, 4, 5};
        TreeNode head = TreeNode.buildTreeFromArray(input);

        System.out.println("Preorder traversal of binary tree is ");
        tree.printPreorder(head);

        System.out.println("\nInorder traversal of binary tree is ");
        tree.printInorder(head);

        System.out.println("\nPostorder traversal of binary tree is ");
        tree.printPostorder(head);

        System.out.println("\nLevel order traversal of binary tree is ");
        tree.printTreeInLevelOrder(head);
    }
}