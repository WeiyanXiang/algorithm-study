package tree.traverse;/**
 * @author Weiyan Xiang on 2020/12/11
 */

import tree.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MostFrequentSubtreeSum {
    Map<Integer, Integer> map = new HashMap<>();
    int maxCount = 0;

    /**
     * 508. Most Frequent Subtree Sum
     * <p>
     * https://leetcode.com/problems/most-frequent-subtree-sum/
     * <p>
     * mostly upvoted ac answer
     */
    public int[] findFrequentTreeSum(TreeNode root) {
        // map <sum,frequency>
        dfs(root);
        List<Integer> ans = new ArrayList<>();
        for (int k : map.keySet()) {
            if (map.get(k) == maxCount) ans.add(k);
        }
        return ans.stream().mapToInt(i -> i).toArray();
    }

    private int dfs(TreeNode root) {
        if (root == null) return 0;
        int sum = dfs(root.left) + dfs(root.right) + root.val;
        maxCount = Math.max(maxCount, map.get(sum));
        map.put(sum, map.getOrDefault(sum, 0) + 1);
        return sum;
    }
}
