package array;

/**
 * @author Weiyan Xiang on 2020/11/4
 */
public class SearchInRotatedSortedArray {

    /**
     * https://leetcode.com/problems/search-in-rotated-sorted-array/
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


}
