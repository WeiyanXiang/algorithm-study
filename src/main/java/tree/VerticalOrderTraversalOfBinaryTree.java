package tree;

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
        // store x y to each node through dfs
        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map = new TreeMap<>();
        dfs(map, root, 0, 0);
        List<List<Integer>> ans = new ArrayList<>();
        for (TreeMap<Integer, PriorityQueue<Integer>> ys : map.values()) {
            List<Integer> x = new ArrayList<>();
            for (PriorityQueue<Integer> list : ys.values()) {
                while (!list.isEmpty()) x.add(list.poll());
            }
            ans.add(x);
        }
        return ans;
    }

    private void dfs(TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map, TreeNode root, int x, int y) {
        if (root == null) return;
        if (!map.containsKey(x)) map.put(x, new TreeMap<>());
        if (!map.get(x).containsKey(y)) map.get(x).put(y, new PriorityQueue<Integer>());
        map.get(x).get(y).offer(root.val);
        dfs(map, root.left, x - 1, y + 1);
        dfs(map, root.right, x + 1, y + 1);
    }

}
