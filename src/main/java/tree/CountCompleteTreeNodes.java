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
     * my ac ans: not fastest as it's O(n)
     */
    public int countNodes(TreeNode root) {
        if (root == null) return 0;
        int left = countNodes(root.left);
        int right = countNodes(root.right);
        return right + left + 1;
    }

    /**
     * O(logn * logn)
     */
    public int countNodesOptimal(TreeNode root) {
        if (root == null) return 0;
        int leftD = dfsD(root, true);
        int rightD = dfsD(root, false);
        if (leftD == rightD) {
            return (1 << leftD) - 1;
        } else {
            return 1 + countNodes(root.left) + countNodes(root.right);
        }
    }

    private int dfsD(TreeNode root, boolean isLeft) {
        int c = 0;
        if (isLeft) {
            while (root != null) {
                root = root.left;
                c++;
            }
        } else {
            while (root != null) {
                root = root.right;
                c++;
            }
        }
        return c;
    }
}
