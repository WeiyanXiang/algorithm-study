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

    public TreeNode(int x) {
        val = x;
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
