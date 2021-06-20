package tree.levelorder;/**
 * @author Weiyan Xiang on 2021/6/19
 */

import tree.TreeNode;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class FindBottomLeftTreeValue {

    /**
     * 513. Find Bottom Left Tree Value
     * <p>
     * https://leetcode.com/problems/find-bottom-left-tree-value/
     * <p>
     * my ac ans: dfs with level passed in.set(
     */
    private Map<Integer, Integer> cache = new HashMap<>();

    public int findBottomLeftValue(TreeNode root) {
        dfs(root, 0);
        Integer key = cache.keySet().stream().max(Comparator.comparingInt(o -> o)).get();
        return cache.get(key);
    }

    private void dfs(TreeNode root, int level) {
        if (root == null) return;
        cache.put(level, root.val);
        dfs(root.right, level + 1);
        dfs(root.left, level + 1);
    }
}
