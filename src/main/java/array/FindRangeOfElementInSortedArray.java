package array;

/**
 * @author Weiyan Xiang on 2020/11/4
 */
public class FindRangeOfElementInSortedArray {

    /**
     * https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/
     * <p>
     * my own answer: not fully efficient as there is some linear search on left most and right most
     */
    public int[] searchRange(int[] nums, int target) {
        int lo = 0, hi = nums.length - 1;
        int[] res = new int[]{-1, -1};
        while (lo <= hi) {
            int mid = (lo + hi) / 2;
            // find lowest bound
            if (nums[mid] == target) {
                int lm = mid, hm = mid;
                while (lm > 0 && nums[lm] == nums[lm - 1]) lm--;
                res[0] = lm;
                while (hm < nums.length - 1 && nums[hm] == nums[hm + 1]) hm++;
                res[1] = hm;
                return res;
            } else if (nums[mid] < target) lo = mid + 1;
            else hi = mid - 1;
        }
        return res;
    }

    /**
     * LC formal solution: 2 binary search for leftMost and rightMost
     */
    public int[] searchRangeOptimal(int[] nums, int target) {
        int[] res = {-1, -1};
        int leftIndex = extremeInsertionIndex(nums, target, true);
        if (leftIndex == nums.length || nums[leftIndex] != target) {
            return res;
        }
        res[0] = leftIndex;
        res[1] = extremeInsertionIndex(nums, target, false) - 1;
        return res;
    }

    private int extremeInsertionIndex(int[] nums, int target, boolean left) {
        int lo = 0, hi = nums.length;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (nums[mid] > target || (left && nums[mid] == target)) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }
        return lo;
    }
}
