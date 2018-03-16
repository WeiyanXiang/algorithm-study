/**
 * 
 */
package tree;

/**
 * @author weiyan.xiang
 * @date 14 Mar 2018
 */
public class ConvertSortedArrayToBST {
    //@formatter:off
    /*
     *  Given an array where elements are sorted in ascending order, convert it to a height balanced BST.
        For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.
        
        Example:
        
        Given the sorted array: [-10,-3,0,5,9],
        
        One possible answer is: [0,-3,9,-10,null,5], which represents the following height balanced BST:
        
              0
             / \
           -3   9
           /   /
         -10  5
     */
    //@formatter:on
    public static TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null || nums.length < 1)
            return null;
        int mid = nums.length / 2;
        TreeNode root = new TreeNode(nums[mid]);
        doConvert(nums, root, 0, mid, nums.length);
        return root;
    }

    private static void doConvert(int[] nums, TreeNode root, int l, int m, int r) {
        int left = (m + l) / 2, right = (m + r) / 2;
        if (l < left && left < m) {
            root.left = new TreeNode(nums[left]);
        }
        if (m < right && right < r) {
            root.right = new TreeNode(nums[right]);
        }
        doConvert(nums, root.left, l, m, right);
    }

    public static void main(String[] args) {
        // int[] nums = { -10, -3, 0, 5, 9 };
        // printTreeInLevelOrder(sortedArrayToBST(nums));
        System.out.println("5CA7CE0F-C4E6-449D-A88B-EC651DCDF076".toLowerCase());
    }

}
