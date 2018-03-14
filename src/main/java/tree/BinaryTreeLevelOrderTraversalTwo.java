/**
 * 
 */
package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author weiyan.xiang
 * @date 13 Mar 2018
 */
public class BinaryTreeLevelOrderTraversalTwo {

    //@formatter:off
    /*
     * Given a binary tree, return the bottom-up level order traversal of its nodes' values. (ie, from left to right, level by level from leaf to root).

        For example:
        Given binary tree [3,9,20,null,null,15,7],
            3
           / \
          9  20
            /  \
           15   7
        return its bottom-up level order traversal as:
        [
          [15,7],
          [9,20],
          [3]
        ]
     */
    //@formatter:on
    /*
     * BFS
     */
    public static List<List<Integer>> levelOrderBottomBFS(TreeNode root) {
        if (root == null)
            return new ArrayList<>();
        List<List<Integer>> answer = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> row = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode top = queue.poll();
                row.add(top.val);
                if (top.left != null) {
                    queue.add(top.left);
                }
                if (top.right != null) {
                    queue.add(top.right);
                }
            }
            answer.add(0, row);
        }
        return answer;
    }

    public static List<List<Integer>> levelOrderBottomDFS(TreeNode root) {
        if (root == null)
            return new ArrayList<>();
        List<List<Integer>> answer = new ArrayList<>();
        doDFSPopulating(answer, root, 0);
        return answer;
    }

    private static void doDFSPopulating(List<List<Integer>> answer, TreeNode root, int lvl) {
        while (lvl > answer.size()) {
            answer.add(new ArrayList<>());
        }
        if (root != null) {
            doDFSPopulating(answer, root.left, lvl + 1);
            doDFSPopulating(answer, root.right, lvl + 1);
            answer.get(answer.size() - lvl - 1).add(root.val);
        }
    }

    public static void main(String[] args) {
      //@formatter:off
        /*
                1
               / \
              2   3
             / \ /  \
            4  5 nil 7`
        */
        //@formatter:on
        TreeNode root = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(7);
        root.left = node2;
        root.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = null;
        node3.right = node7;

        System.out.println("BFS: ");
        TreeNode.printListOfList(levelOrderBottomBFS(root));
        System.out.println("DFS: ");
        TreeNode.printListOfList(levelOrderBottomDFS(root));
        // doDFSPopulating(null, root, 0);

    }
}
