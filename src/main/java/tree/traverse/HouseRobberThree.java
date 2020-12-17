package tree.traverse;/**
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
}
