/**
 *
 */
package tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author weiyan.xiang
 * @date 13 Mar 2018
 */
public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode() {
    }

    public TreeNode(int x) {
        val = x;
    }

    //@formatter:off
    /**
     * [2,1,3,null,4,null,7]
     *
     *    2
     *   / \
     *  1   3
     *   \   \
     *    4   7
     * @param input: array in level order
     * @return constructed tree node head
     */
    //@formatter:on
    public static TreeNode buildTreeFromArray(Integer[] input) {
        if (input == null || input.length == 0) return null;
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode head = new TreeNode(input[0]);
        queue.add(head);
        int i = 1;
        while (!queue.isEmpty()) {
            TreeNode top = queue.poll();
            if (i < input.length) {
                top.left = input[i] == null ? null : new TreeNode(input[i]);
                i++;
                queue.add(top.left);
            }
            if (i < input.length) {
                top.right = input[i] == null ? null : new TreeNode(input[i]);
                i++;
                queue.add(top.right);
            }
        }
        return head;
    }

    public static TreeNode buildTreeFromInts(Integer... input) {
        if (input == null || input.length == 0) return null;
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode head = new TreeNode(input[0]);
        queue.add(head);
        int i = 1;
        while (!queue.isEmpty()) {
            TreeNode top = queue.poll();
            if (i < input.length) {
                top.left = input[i] == null ? null : new TreeNode(input[i]);
                i++;
                queue.add(top.left);
            }
            if (i < input.length) {
                top.right = input[i] == null ? null : new TreeNode(input[i]);
                i++;
                queue.add(top.right);
            }
        }
        return head;
    }

    public static void printListOfList(List<List<Integer>> levelOrder) {
        for (List<Integer> elementList : levelOrder) {
            System.out.print("[");
            for (Integer element : elementList) {
                System.out.print(element + " ");
            }
            System.out.print("]");
            System.out.println();
        }
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

}
