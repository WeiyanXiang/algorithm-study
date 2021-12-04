package array;

import java.util.Arrays;

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
        int l = 0, r = nums.length - 1;
        int[] res = new int[]{-1, -1};
        while (l <= r) {
            int mid = (l + r) / 2;
            if (target == nums[mid]) {
                int ll = mid, rr = mid;
                while (ll >= 1 && nums[ll] == nums[ll - 1]) ll--;
                while (rr < nums.length - 1 && nums[rr] == nums[rr + 1]) rr++;
                res[0] = ll;
                res[1] = rr;
                return res;
            } else if (target > nums[mid]) l = mid + 1;
            else r = mid - 1;
        }
        return res;
    }

    /**
     * There must be two indices in the array. Which means, we can just simply apply to binary search twice to find each
     * index of the target element.
     */
    public int[] searchRangeReadiable(int[] nums, int target) {
        int[] res = new int[2];
        res[0] = findLeft(nums, target);
        res[1] = findRight(nums, target);
        return res;
    }

    private int findLeft(int[] nums, int target) {
        int l = 0, r = nums.length - 1, idx = -1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (target <= nums[mid]) r = mid - 1;
            else l = mid + 1;

            if (target == nums[mid]) idx = mid;

        }
        return idx;
    }

    private int findRight(int[] nums, int target) {
        int l = 0, r = nums.length - 1, idx = -1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (target >= nums[mid]) l = mid + 1;
            else r = mid - 1;

            if (target == nums[mid]) idx = mid;

        }
        return idx;
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
