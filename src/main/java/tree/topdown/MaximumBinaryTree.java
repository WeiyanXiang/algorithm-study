package tree.topdown;/**
 * @author Weiyan Xiang on 2021/6/1
 */

import tree.TreeNode;

public class MaximumBinaryTree {
    /**
     * 654. Maximum Binary Tree
     * <p>
     * https://leetcode.com/problems/maximum-binary-tree/
     * <p>
     * my ac ans
     */
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return dfsBuild(nums, 0, nums.length - 1);
    }

    private TreeNode dfsBuild(int[] nums, int l, int r) {
        if (l > r) return null;
        int max = getMax(nums, l, r);
        TreeNode node = new TreeNode(nums[max]);
        node.left = dfsBuild(nums, l, max - 1);
        node.right = dfsBuild(nums, max + 1, r);
        return node;
    }

    private int getMax(int[] nums, int l, int r) {
        int maxIndex = l;
        int max = 0;
        for (int i = l; i <= r; i++) {
            if (max < nums[i]) {
                max = nums[i];
                maxIndex = i;
            }
        }
        return maxIndex;
    }
}
