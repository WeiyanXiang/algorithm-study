package tree.levelorder;/**
 * @author Weiyan Xiang on 2021/6/16
 */

import tree.TreeNode;

import java.util.*;

public class EvenOddTree {

    /**
     * 1609. Even Odd Tree
     * <p>
     * https://leetcode.com/problems/even-odd-tree/
     * <p>
     * my ac ans: level order traverse bfs
     */
    public boolean isEvenOddTree(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int level = 0;
        while (!queue.isEmpty()) {
            List<Integer> cache = new ArrayList<>();
            int qSize = queue.size();
            for (int i = 0; i < qSize; i++) {
                TreeNode top = queue.poll();
                if (level % 2 == 0) {
                    if ((cache.size() > 0 && top.val <= cache.get(cache.size() - 1)) || top.val % 2 == 0) return false;
                } else {
                    if ((cache.size() > 0 && top.val >= cache.get(cache.size() - 1)) || top.val % 2 == 1) return false;
                }
                cache.add(top.val);
                if (top.left != null) queue.add(top.left);
                if (top.right != null) queue.add(top.right);
            }
            level++;
        }
        return true;
    }


    /**
     * my ac ans: recursive way
     */
    private Map<Integer, List<Integer>> cache = new HashMap<>();

    public boolean isEvenOddTreeRecursive(TreeNode root) {
        return dfs(root, 0);
    }

    private boolean dfs(TreeNode root, int level) {
        if (root == null) return true;
        if (cache.containsKey(level)) {
            List<Integer> cur = cache.get(level);
            int preValue = cur.get(cur.size() - 1);
            if (level % 2 == 0 && root.val <= preValue) return false;
            if (level % 2 == 1 && root.val >= preValue) return false;
            cache.get(level).add(root.val);
        } else {
            cache.put(level, new ArrayList<>(Arrays.asList(root.val)));
        }
        if (level % 2 == 0 && root.val % 2 == 0) return false;
        if (level % 2 == 1 && root.val % 2 == 1) return false;
        return dfs(root.left, level + 1) && dfs(root.right, level + 1);
    }
}
