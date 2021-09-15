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
    }maxDepth(

    /**
     * DFS approach
     */
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> zigzagLevelOrderDfs(TreeNode root) {
        dfs(root, 0);
        return res;
    }

    private void dfs(TreeNode root, int h) {
        if (root == null) return;
        if (res.size() == h) res.add(new ArrayList<>());
        if (h % 2 == 0) res.get(h).add(root.val);
            // when opposite append
        else res.get(h).add(0, root.val);
        dfs(root.left, h + 1);
        dfs(root.right, h + 1);
    }

}
