package tree.path;

import tree.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Weiyan Xiang on 2020/12/7
 */
public class PathSumThree {
    int count = 0;

    // prefix sum: key is sum of current path until cur node, value is how many ways of this sum until cur node.
    public int pathSum(TreeNode root, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        doPathSum(root, target, 0, map);
        return count;
    }

    private void doPathSum(TreeNode root, int target, int cur, Map<Integer, Integer> map) {
        if (root == null) return;
        cur += root.val;
        count += map.getOrDefault(cur - target, 0);
        map.put(cur, map.getOrDefault(cur, 0) + 1);

        doPathSum(root.left, target, cur, map);
        doPathSum(root.right, target, cur, map);
        map.put(cur, map.get(cur) - 1);
    }
}
