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
    int count = 0;

    public int countPairs(TreeNode root, int distance) {
        dfs(root, distance);
        return count;
    }

    /**
     * idea: bottom-up, keep track of array of leafs' depths, at leaf, return depth of 1 to parent. keep track of list
     * of leafs depth on the fly and if it matches <= d, return it
     */
    public int[] dfs(TreeNode root, int d) {
        if (root == null) return new int[0];
        if (root.left == null && root.right == null) return new int[]{1};
        int[] l = dfs(root.left, d);
        int[] r = dfs(root.right, d);
        for (int le : l) {
            for (int ri : r) {
                if (le + ri <= d) count++;
            }
        }
        int[] list = new int[l.length + r.length];
        int i = 0;
        for (int le : l) list[i++] = le + 1;
        for (int ri : r) list[i++] = ri + 1;
        return list;
    }
}
