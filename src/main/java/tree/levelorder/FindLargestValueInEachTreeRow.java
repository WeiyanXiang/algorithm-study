package tree.levelorder;/**
 * @author Weiyan Xiang on 2021/6/20
 */

import tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class FindLargestValueInEachTreeRow {

    /**
     * 515. Find Largest Value in Each Tree Row
     * <p>
     * https://leetcode.com/problems/find-largest-value-in-each-tree-row/
     * <p>
     * my ac ans: dfs with level template, similar to findBottomLeftTreeValue
     */
    private List<Integer> ans = new ArrayList<>();

    public List<Integer> largestValues(TreeNode root) {
        dfs(root, 0);
        return ans;
    }

    private void dfs(TreeNode root, int level) {
        if (root == null) return;
        if (level + 1 > ans.size()) ans.add(root.val);
        else ans.set(level, ans.get(level) < root.val ? root.val : ans.get(level));
        dfs(root.left, level + 1);
        dfs(root.right, level + 1);
    }
}
