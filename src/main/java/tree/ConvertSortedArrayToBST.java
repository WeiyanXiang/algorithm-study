/**
 *
 */
package tree;

/**
 * @author weiyan.xiang
 * @date 8 Aug 2021
 */
public class ConvertSortedArrayToBST {
    /**
     * 108. Convert Sorted Array to Binary Search Tree
     * <p>
     * Given an integer array nums where the elements are sorted in ascending order, convert it to a height-balanced
     * binary search tree. A height-balanced binary tree is a binary tree in which the depth of the two subtrees of
     * every node never differs by more than one.
     * <p>
     * https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/
     * <p>
     * my ac ans:
     */
    public TreeNode sortedArrayToBST(int[] nums) {
        return dfsBuild(nums, 0, nums.length - 1);
    }

    private TreeNode dfsBuild(int[] nums, int l, int r) {
        if (l > r) return null;
        int mid = (l + r) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = dfsBuild(nums, l, mid - 1);
        root.right = dfsBuild(nums, mid + 1, r);
        return root;
    }

}
