/**
 * 
 */
package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

/**
 * @author weiyan.xiang
 * @date 11 Mar 2018
 */
public class SymmetricTree {

    public static class TreeNode {
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
    public static boolean isSymmetric(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<Integer> levelOrderTraverse = new ArrayList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            /*
             * poll() removes the present head. For more information on poll()
             * visit http://www.tutorialspoint.com/java/util/linkedlist_poll.htm
             */
            TreeNode tempNode = queue.poll();
            levelOrderTraverse.add(tempNode.val);

            /* Enqueue left child */
            if (tempNode.left != null) {
                queue.add(tempNode.left);
            }

            /* Enqueue right child */
            if (tempNode.right != null) {
                queue.add(tempNode.right);
            }
        }
        return isListSymmetric(levelOrderTraverse);
    }

    private static boolean isListSymmetric(List<Integer> levelOrderTraverse) {
        if (levelOrderTraverse.size() <= 1)
            return true;
        Stack<Integer> stack = new Stack<>();
        for (int i = 1; i < levelOrderTraverse.size(); i++) {
            Integer element = levelOrderTraverse.get(i);
            if (stack.isEmpty()) {
                stack.push(element);
            } else if (stack.peek() == element) {
                stack.pop();
            } else {
                stack.push(element);
            }

        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(2);
        TreeNode node4 = new TreeNode(3);
        TreeNode node5 = new TreeNode(3);
        TreeNode node6 = new TreeNode(4);
        TreeNode node7 = new TreeNode(4);
        root.left = node2;
        root.right = node3;
        node2.left = node4;
        node2.right = node6;
        node3.left = node7;
        node3.right = node5;

        System.out.println(isSymmetric(root));

    }

}
