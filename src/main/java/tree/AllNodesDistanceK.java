package tree;/**
 * @author Weiyan Xiang on 2021/4/7
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AllNodesDistanceK {
    /**
     * 863. All Nodes Distance K in Binary Tree
     * <p>
     * https://leetcode.com/problems/all-nodes-distance-k-in-binary-tree/
     * <p>
     * upvoted ans: prep a map to store from root to target, target having 0 depth, root having the distance
     */
    Map<Integer, Integer> map = new HashMap<>();
    List<Integer> ans = new ArrayList<>();

    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        // prep a map to store from root to target, target having 0 depth, root having the distance
        prep(root, target);
        dfs(root, target, K, 0);
        return ans;
    }

    private void dfs(TreeNode cur, TreeNode t, int k, int d) {
        if (cur == null) return;
        int curD = map.containsKey(cur.val) ? map.get(cur.val) : d;
        if (curD == k) ans.add(cur.val);
        dfs(cur.left, t, k, curD + 1);
        dfs(cur.right, t, k, curD + 1);
    }

    private int prep(TreeNode cur, TreeNode target) {
        if (cur == null) return -1;
        if (cur == target) {
            map.put(cur.val, 0);
            return 0;
        }
        int left = prep(cur.left, target);
        int right = prep(cur.right, target);
        if (left == -1 && right == -1) return -1;

        int depth = (left >= 0 ? left : right) + 1;
        map.put(cur.val, depth);
        return depth;
    }
}
