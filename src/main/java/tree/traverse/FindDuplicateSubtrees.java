package tree.traverse;/**
 * @author Weiyan Xiang on 2021/7/2
 */

import tree.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindDuplicateSubtrees {

    /**
     * 652. Find Duplicate Subtrees
     * <p>
     * https://leetcode.com/problems/find-duplicate-subtrees/
     */
    Map<String, Integer> map = new HashMap<>();
    List<TreeNode> ans = new ArrayList<>();

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        dfs(root);
        return ans;
    }

    private String dfs(TreeNode root) {
        if (root == null) return "";
        String cur = root.val + "," + dfs(root.left) + "," + dfs(root.right);
        map.put(cur, map.getOrDefault(cur, 0) + 1);
        // count is 2 add once guarantees only add duplicate once, if there are 3 nodes, add only once, instead of twice
        if (map.get(cur) == 2) ans.add(root);
        return cur;
    }

}
