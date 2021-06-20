package tree.levelorder;/**
 * @author Weiyan Xiang on 2021/6/20
 */

import tree.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class BinaryTreeZigzagLevelOrderTraversal {

    /**
     * 103. Binary Tree Zigzag Level Order Traversal
     * <p>
     * https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/
     * <p>
     * my ac ans: have to use BFS instead of DFS
     */
    List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null) return ans;
        LinkedList<TreeNode> queue = new LinkedList<>();
        boolean inOrder = true;
        queue.add(root);
        while (!queue.isEmpty()) {
            int qSize = queue.size();
            List<Integer> row = new ArrayList<>();
            for (int i = 0; i < qSize; i++) {
                TreeNode top = queue.poll();
                row.add(top.val);
                if (top.left != null) queue.add(top.left);
                if (top.right != null) queue.add(top.right);
            }
            if (inOrder == false) Collections.reverse(row);
            ans.add(row);
            inOrder = !inOrder;
        }
        return ans;
    }
}
