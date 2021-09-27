package tree;/**
 * @author Weiyan Xiang on 2021/9/27
 */

import java.util.*;

public class FindModeInBST {
    private Map<Integer, Integer> map = new HashMap<>();

    /**
     * 501. Find Mode in Binary Search Tree
     * <p>
     * https://leetcode.com/problems/find-mode-in-binary-search-tree/
     * <p>
     * my own ac ans
     */
    public int[] findMode(TreeNode root) {
        dfs(root);
        Set<Integer> ans = new HashSet<>();
        int max = 0;
        List<Integer> set = new ArrayList<>(map.keySet());
        for (int i = 0; i < set.size(); i++) {
            if (max < map.get(set.get(i))) {
                max = map.get(set.get(i));
                ans.clear();
                ans.add(set.get(i));
            } else if (max == map.get(set.get(i))) {
                ans.add(set.get(i));
            }
        }
        return ans.stream().mapToInt(i -> i).toArray();
    }

    private void dfs(TreeNode root) {
        if (root == null) return;
        int v = root.val;
        if (map.containsKey(v)) map.put(v, map.get(v) + 1);
        else map.put(v, 1);
        dfs(root.left);
        dfs(root.right);
    }


}
