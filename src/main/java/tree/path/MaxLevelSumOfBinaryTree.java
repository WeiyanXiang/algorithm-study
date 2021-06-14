package tree.path;/**
 * @author Weiyan Xiang on 2021/6/14
 */

import tree.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class MaxLevelSumOfBinaryTree {
    /**
     * 1161. Maximum Level Sum of a Binary Tree
     * <p>
     * https://leetcode.com/problems/maximum-level-sum-of-a-binary-tree/
     * <p>
     * my ac ans: a map to track level sums
     */
    private Map<Integer, Integer> cache = new HashMap<>();

    public int maxLevelSum(TreeNode root) {
        dfs(root, 1);
        int ans = Integer.MIN_VALUE;
        int ansLevel = 1;
        for (Map.Entry<Integer, Integer> e : cache.entrySet()) {
            if (e.getValue() > ans) {
                ans = e.getValue();
                ansLevel = e.getKey();
            }
        }
        return ansLevel;
    }

    private void dfs(TreeNode root, int level) {
        if (root == null) return;
        if (cache.containsKey(level)) cache.put(level, cache.get(level) + root.val);
        else cache.put(level, root.val);
        dfs(root.left, level + 1);
        dfs(root.right, level + 1);
    }
}
