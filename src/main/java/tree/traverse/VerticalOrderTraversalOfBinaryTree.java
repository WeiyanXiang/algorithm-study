package tree.traverse;

import tree.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.TreeMap;

/**
 * @author Weiyan Xiang on 2020/11/28
 */
public class VerticalOrderTraversalOfBinaryTree {
    /**
     * https://leetcode.com/problems/vertical-order-traversal-of-a-binary-tree/
     * <p>
     * 987. Vertical Order Traversal of a Binary Tree
     */
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map = new TreeMap<>();
        dfs(root, 0, 0, map);
        List<List<Integer>> ans = new ArrayList<>();
        for (TreeMap<Integer, PriorityQueue<Integer>> ys : map.values()) {
            ans.add(new ArrayList<>());
            for (PriorityQueue<Integer> q : ys.values()) {
                while (!q.isEmpty()) {
                    ans.get(ans.size() - 1).add(q.poll());
                }
            }
        }
        return ans;
    }

    private void dfs(TreeNode root, int x, int y, TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map) {
        if (root == null) return;
        if (!map.containsKey(x)) {
            map.put(x, new TreeMap<>());
        }
        if (!map.get(x).containsKey(y)) {
            map.get(x).put(y, new PriorityQueue<>());
        }
        map.get(x).get(y).offer(root.val);
        dfs(root.left, x - 1, y + 1, map);
        dfs(root.right, x + 1, y + 1, map);
    }
}
