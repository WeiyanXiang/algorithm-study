/**
 *
 */
package tree.sametree;

import tree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * @author weiyan.xiang
 * @date 11 Mar 2018
 */
public class SymmetricTree {

    /**
     * 101. Symmetric Tree
     * <p>
     * https://leetcode.com/problems/symmetric-tree/
     */
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
    /*
     * Recursive approach is more effective and human readable
     */
    public static boolean isSymmetricRecur(TreeNode root) {
        if (root == null) return true;
        return isSubTreeSymmetric(root.left, root.right);
    }

    private static boolean isSubTreeSymmetric(TreeNode left, TreeNode right) {
        // check whether only 1 node is null
        if (left == null || right == null) return left == right;
        if (left.val != right.val) return false;
        return isSubTreeSymmetric(left.left, right.right) && isSubTreeSymmetric(left.right, right.left);
    }

    /**
     * my own AC answer BFS using queue
     */
    public boolean isSymmetricIterativeBfs(TreeNode root) {
        if (root == null) return true;
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int len = queue.size();
            List<Integer> row = new ArrayList<>();
            for (int i = 0; i < len; i++) {
                TreeNode top = queue.pop();
                if (top.left != null) {
                    queue.add(top.left);
                    row.add(top.left.val);
                } else row.add(null);
                if (top.right != null) {
                    queue.add(top.right);
                    row.add(top.right.val);
                } else row.add(null);
            }
            // check each row whether it is symmetric
            int s = 0, e = row.size() - 1;
            while (s < e) {
                if (row.get(s) != row.get(e)) return false;
                s++;
                e--;
            }
        }
        return true;
    }

    /**
     * most upvoted using queue
     */
    public boolean isSymmetric(TreeNode root) {
        LinkedList<TreeNode> q = new LinkedList<TreeNode>();
        if (root == null) return true;
        q.add(root.left);
        q.add(root.right);
        while (q.size() > 1) {
            TreeNode left = q.poll(),
                    right = q.poll();
            if (left == null && right == null) continue;
            // bitwise operator, return true if different, false if same;
            if (left == null ^ right == null) return false;
            if (left.val != right.val) return false;
            q.add(left.left);
            q.add(right.right);
            q.add(left.right);
            q.add(right.left);
        }
        return true;
    }

    /**
     * most upvoted using stack: its same with using queue, doesnt matter here.
     */
    public static boolean isSymmetricIterative(TreeNode root) {
        if (root == null)
            return true;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root.left);
        stack.push(root.right);
        while (!stack.empty()) {
            TreeNode first = stack.pop();
            TreeNode second = stack.pop();
            if (first == null && second == null) {
                continue;
            } else if (first == null || second == null || first.val != second.val) {
                return false;
            } else {
                stack.push(first.left);
                stack.push(second.right);
                stack.push(first.right);
                stack.push(second.left);
            }
        }
        return true;
    }

    public static void main(String[] args) {
        //@formatter:off
        /*
                1
               / \
              2   2
             / \ / \
            3  4 4  3
        */
        //@formatter:on
        TreeNode root = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(2);
        TreeNode node4 = new TreeNode(3);
        TreeNode node5 = new TreeNode(4);
        TreeNode node6 = new TreeNode(4);
        TreeNode node7 = new TreeNode(3);
        root.left = node2;
        root.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        node3.right = node7;

        System.out.println("true == " + isSymmetricRecur(root));
        System.out.println("true == " + isSymmetricIterative(root));
    }

}
