package array;

/**
 * @author Weiyan Xiang on 2021/11/20
 */

public class SingleElementInSortedArray {
    /**
     * 540. Single Element in a Sorted Array
     * <p>
     * https://leetcode.com/problems/single-element-in-a-sorted-array/
     * <p>
     * upvoted ans: binary search O(logn) performance and O(1) space
     */
    public int singleNonDuplicate(int[] nums) {
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int mid = (l + r) / 2;
            // if pattern retained, the single num should be in second half
            if (mid % 2 == 0 && nums[mid] == nums[mid + 1] || mid % 2 == 1 && nums[mid] == nums[mid - 1]) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return nums[l];
    }
}
