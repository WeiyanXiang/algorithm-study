package tree.traverse;/**
 * @author Weiyan Xiang on 2021/5/3
 */

import tree.TreeNode;

public class NumberOfGoodLeaf {
    /**
     * 1530. Number of Good Leaf Nodes Pairs
     * <p>
     * https://leetcode.com/problems/number-of-good-leaf-nodes-pairs/
     * <p>
     * ac ans, idea is to track current leaf's depth
     */
    int res = 0;

    public int countPairs(TreeNode root, int distance) {
        dfs(root, distance);
        return res;
    }

    public int[] dfs(TreeNode root, int distance) {
        if (root == null) return new int[0];
        if (root.left == null && root.right == null) return new int[]{1};
        int[] left = dfs(root.left, distance), right = dfs(root.right, distance);
        for (int l : left)
            for (int r : right)
                if (l + r <= distance) res++;
        int idx = 0;
        int[] cur = new int[left.length + right.length];
        // array/list to track current depth of leafs
        for (int l : left) cur[idx++] = l + 1;
        for (int r : right) cur[idx++] = r + 1;
        return cur;
    }
}
