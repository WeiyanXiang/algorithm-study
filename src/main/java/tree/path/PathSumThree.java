package tree.path;

import tree.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Weiyan Xiang on 2020/12/7
 */
public class PathSumThree {
    int count = 0;


    /**
     * 437. Path Sum III
     * <p>
     * https://leetcode.com/problems/path-sum-iii/
     * <p>
     * upvoted answer: https://leetcode.com/problems/path-sum-iii/discuss/91878/17-ms-O(n)-java-Prefix-sum-method
     */
    public int pathSum(TreeNode root, int target) {
        // The map stores <prefix sum, frequency> pairs before getting to the current node.
        Map<Integer, Integer> map = new HashMap<>();
        // to handle start from root pre sum case
        // [5,4,8,11,null,13,4,7,2,null,null,5,1] and target is 22
        // [5,8,4,5], [5,4,11,2] and [4,11,7], the paths which starting from root 5 were handled by a map with [0,1] in the beginning
        map.put(0, 1);
        doPathSum(root, target, 0, map);
        return count;
    }

    private void doPathSum(TreeNode root, int target, int cur, Map<Integer, Integer> map) {
        if (root == null) return;
        // cur now will be sum from root to current node
        cur += root.val;
        /**
         * The map stores <prefix sum, frequency> pairs before getting to the current node. We can imagine a path from
         * the root to the current node. The sum from any node in the middle of the path to the current node =
         * the difference between the sum from the root to the current node and the prefix sum of the node in the middle.
         */
        // if there is a node in the mid of the path which fulfills the target, add the frequency
        count += map.getOrDefault(cur - target, 0);
        map.put(cur, map.getOrDefault(cur, 0) + 1);

        doPathSum(root.left, target, cur, map);
        doPathSum(root.right, target, cur, map);
        // backtrack
        map.put(cur, map.get(cur) - 1);
    }

    /**
     * I cannot understand
     */
    public int pathSumRecur(TreeNode root, int target) {
        if (root == null) return 0;
        // specifically here cannot explain
        return pathSumFrom(root, target) + pathSum(root.left, target) + pathSum(root.right, target);
    }

    private int pathSumFrom(TreeNode root, int target) {
        if (root == null) return 0;
        return (root.val == target ? 1 : 0) +
                pathSumFrom(root.left, target - root.val) +
                pathSumFrom(root.right, target - root.val);
    }
}
