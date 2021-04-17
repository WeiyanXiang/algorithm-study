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
    Map<TreeNode, Integer> map = new HashMap<>();

    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        List<Integer> answer = new ArrayList<>();
        prep(root, target);
        dfs(root, K, 0, answer);
        return answer;
    }

    private void dfs(TreeNode node, int k, int c, List<Integer> ans) {
        if (node == null) return;
        int d = map.containsKey(node) ? map.get(node) : c;
        if (d == k) ans.add(node.val);
        dfs(node.left, k, d + 1, ans);
        dfs(node.right, k, d + 1, ans);
    }

    private int prep(TreeNode node, TreeNode target) {
        if (node == null) return -1;
        if (target == node) {
            map.put(node, 0);
            return 0;
        }
        int l = prep(node.left, target);
        int r = prep(node.right, target);
        // if it is a leaf, then -1
        if (l == -1 && r == -1) return -1;
        int distance = Math.max(l, r) + 1;
        // if there is a node which is in the path from root to target, then add its distance into map
        if (l >= 0 || r >= 0) map.put(node, distance);
        return distance;

    }
}
