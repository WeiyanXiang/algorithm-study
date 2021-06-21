package tree.levelorder;/**
 * @author Weiyan Xiang on 2021/6/21
 */

import tree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class CheckCompletenessOfBinaryTree {

    /**
     * 958. Check Completeness of a Binary Tree
     * <p>
     * https://leetcode.com/problems/check-completeness-of-a-binary-tree/
     * <p>
     * upvoted ans: have to use BFS, the tricky part is when the queue peek is a null then loop through it if its next
     * is null, poll, until empty or a non-null value found which will be an incomplete tree
     */
    public boolean isCompleteTree(TreeNode root) {
        if (root == null) return true;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (queue.peek() != null) {
            TreeNode top = queue.poll();
            queue.add(top.left);
            queue.add(top.right);
        }
        // For a complete binary tree,
        // there should not be any node after we met an empty one.
        while (!queue.isEmpty() && queue.peek() == null) {
            queue.poll();
        }
        return queue.isEmpty();
    }
}
