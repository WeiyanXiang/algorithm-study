package tree;/**
 * @author Weiyan Xiang on 2020/12/17
 */

import tree.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class HouseRobberThree {
    /**
     * 337. House Robber III
     * <p>
     * https://leetcode.com/problems/house-robber-iii/
     * <p>
     * recursion without memorisation
     */
    public int rob(TreeNode root) {
        if (root == null) return 0;
        int ll = root.left != null ? rob(root.left.left) : 0;
        int lr = root.left != null ? rob(root.left.right) : 0;
        int rl = root.right != null ? rob(root.right.left) : 0;
        int rr = root.right != null ? rob(root.right.right) : 0;
        return Math.max(root.val + ll + lr + rl + rr, rob(root.left) + rob(root.right));
    }

    /**
     * each run we need rob(root.left), rob(root.right), rob(root.left.left), rob(root.left.right), rob(root.right.left),
     * rob(root.right.right)
     *
     * since rob(left) will also need rob(left.left) and rob(left.right), use a map to store computed values.
     *
     * https://leetcode.com/problems/house-robber-iii/discuss/79330/Step-by-step-tackling-of-the-problem
     */
    private Map<TreeNode, Integer> map = new HashMap<>();
    public int robWithMem(TreeNode root) {
        if (root == null) return 0;
        if (map.containsKey(root)) return map.get(root);
        int ll = root.left != null ? robWithMem(root.left.left) : 0;
        int lr = root.left != null ? robWithMem(root.left.right) : 0;
        int rl = root.right != null ? robWithMem(root.right.left) : 0;
        int rr = root.right != null ? robWithMem(root.right.right) : 0;
        int cur = Math.max(root.val + ll + lr + rl + rr, robWithMem(root.left) + robWithMem(root.right));
        map.put(root, cur);
        return cur;
    }

    /**
     * need to re-think, cannot understand this step:
     * res[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
     * i can understand now: i.e. [2,1,3,null,4], the result should be 7. left and right not necessarily in sync, and
     * root vs left or right not necessarily in opposite either
     *
     * https://leetcode.com/problems/house-robber-iii/discuss/79330/Step-by-step-tackling-of-the-problem
     */
    public int robDp(TreeNode root) {
        int[] res = robSub(root);
        return Math.max(res[0], res[1]);
    }

    private int[] robSub(TreeNode root) {
        if (root == null) return new int[2];

        int[] left = robSub(root.left);
        int[] right = robSub(root.right);
        int[] res = new int[2];

        res[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        res[1] = root.val + left[0] + right[0];

        return res;
    }
}
