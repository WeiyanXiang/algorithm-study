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
     *
     * If the entire left part is monotonically increasing, which means the pivot point is on the right part
     * If left <= target < mid ------> drop the right half
     * Else ------> drop the left half
     * If the entire right part is monotonically increasing, which means the pivot point is on the left part
     * If mid < target <= right ------> drop the left half
     * Else ------> drop the right half
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
        while (l <= r) {
            int mid = (l + r) / 2;
            if (nums[mid] == target) return mid;
            if (nums[l] <= nums[mid]) {
                if (nums[l] <= target && target < nums[mid]) r = mid - 1;
                else l = mid + 1;
            } else {
                if (nums[mid] < target && target <= nums[r]) l = mid + 1;
                else r = mid - 1;
            }
        }
        return -1;
    }


}
