/**
 *
 */
package tree.levelorder;

import tree.TreeNode;

import java.util.*;

/**
 * @author weiyan.xiang
 * @date 13 Mar 2018
 */
public class BinaryTreeLevelOrderTraversal {

    //@formatter:off
    /*
     * Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).
        For example:
        Given binary tree [3,9,20,null,null,15,7],
            3
           / \
          9  20
            /  \
           15   7
        return its level order traversal as:
        [
          [3],
          [9,20],
          [15,7]
        ]
     */
    //@formatter:on
    // BFS

    /**
     * 102. Binary Tree Level Order Traversal
     * <p>
     * https://leetcode.com/problems/binary-tree-level-order-traversal/
     */
    public static List<List<Integer>> levelOrder(TreeNode root) {
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
            answer.add(row);
        }
        Collections.reverse(answer);
        return answer;
    }

    /**
     * DFS approach
     */
    List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> levelOrderDfs(TreeNode root) {
        dfs(root, 0);
        return ans;
    }

    private void dfs(TreeNode root, int h) {
        if (root == null) return;
        if (h == ans.size()) {
            ans.add(new ArrayList<>());
        }
        ans.get(h).add(root.val);
        dfs(root.left, h + 1);
        dfs(root.right, h + 1);
    }

    /**
     * 107. Binary Tree Level Order Traversal II
     * <p>
     * https://leetcode.com/problems/binary-tree-level-order-traversal-ii/
     */
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) return ans;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            List<Integer> row = new ArrayList<>();
            int len = queue.size();
            for (int i = 0; i < len; i++) {
                TreeNode top = queue.poll();
                row.add(top.val);
                if (top.left != null) queue.add(top.left);
                if (top.right != null) queue.add(top.right);
            }
            ans.add(row);
        }
        Collections.reverse(ans);
        return ans;
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
        // TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(7);
        root.left = node2;
        root.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = null;
        node3.right = node7;

        TreeNode.printListOfList(levelOrder(root));

    }

}
