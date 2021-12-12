package array;/**
 * @author Weiyan Xiang on 2021/12/11
 */

import java.util.*;

public class FindMininRotatedSortedArray {

    /**
     * 153. Find Minimum in Rotated Sorted Array
     * <p>
     * https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/
     * <p>
     * upvoted ac ans
     */
    public int findMin(int[] nums) {
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int m = (l + r) / 2;
            // when l<m>r or l>m>r
            if (nums[m] >= nums[r]) l = m + 1;
                // when l>m<r or l<m<r, the min value can be the mid, so r=m
            else r = m;
        }
        return nums[l];
    }

    /**
     * my ac ans
     */
    public int findMinMyAc(int[] nums) {
        // l, r, mid =(l+r)/2
        // if nums[l]<nums[mid], this part is in order, the min on right side
        // else nums[l]>nums[mid], this part is rotated, so the min will be on right side
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int mid = l + (r - l) / 2;
            int mi = nums[mid], le = nums[l], ri = nums[r];
            // [4,5,6,7,0,1,2]
            if (le <= mi && mi > ri) l = mid + 1;
                // [0,1,2,4,5,6,7]
            else if (le <= mi && mi < ri) return nums[l];
                // [5,6,0,1,2,3,4]
            else if (le > mi && mi < ri) r = mid;
                // [2,1]
            else return nums[r];
        }
        return nums[l];
    }
}
