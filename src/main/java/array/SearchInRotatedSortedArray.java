package array;

/**
 * @author Weiyan Xiang on 2020/11/4
 */
public class SearchInRotatedSortedArray {

    /**
     * 33. Search in Rotated Sorted Array
     * <p>
     * https://leetcode.com/problems/search-in-rotated-sorted-array/
     * <p>
     * upvoted ans
     */
    public int search(int[] nums, int target) {
        int lo = 0, hi = nums.length - 1;
        // find the rotation index
        while (lo < hi) {
            int mid = (lo + hi) / 2;
            if (nums[mid] > nums[hi]) lo = mid + 1;
            else hi = mid;
        }
        int rot = lo;
        lo = 0;
        hi = nums.length;
        while (lo <= hi) {
            int m = (lo + hi) / 2;
            int rm = (m + rot) % nums.length;
            if (nums[rm] == target) return rm;
            if (nums[rm] < target) lo = m + 1;
            else hi = m - 1;
        }
        return -1;
    }

    public int searchUpvoted(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int mid = (l + r) / 2;
            if (target == nums[mid]) return mid;
            if (nums[l] <= nums[mid]) {
                if (target >= nums[l] && target < nums[mid]) r = mid - 1;
                else l = mid + 1;
            } else {
                if (target > nums[mid] && target <= nums[r]) l = mid + 1;
                else r = mid - 1;
            }
        }
        return nums[l] == target ? l : -1;

    }


}
