package tree;/**
 * @author Weiyan Xiang on 2021/8/15
 */

import java.util.HashMap;
import java.util.Map;

public class CountCompleteTreeNodes {
    private int count = 0;
    private Map<TreeNode, Integer> map = new HashMap<>();

    /**
     * 222. Count Complete Tree Nodes
     * <p>
     * https://leetcode.com/problems/count-complete-tree-nodes/
     * <p>
     * my ac ans: the question requires O(n) time
     */
    public int countNodes(TreeNode root) {
        if (root == null) return count;
        if (map.containsKey(root)) return count;
        count++;
        map.put(root, 1);
        countNodes(root.left);
        countNodes(root.right);
        return count;
    }
}
