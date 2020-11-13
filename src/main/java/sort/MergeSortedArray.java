/**
 *
 */
package sort;

import utils.PrintUtils;

/**
 * @author weiyan.xiang
 * @date 9 Mar 2018
 */
public class MergeSortedArray {

    /**
     * 88. Merge Sorted Array
     * <p>
     * https://leetcode.com/problems/merge-sorted-array/
     * <p>
     * Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.
     * <p>
     * Note: You may assume that nums1 has enough space (size that is greater or equal to m + n) to hold additional
     * elements from nums2. The number of elements initialized in nums1 and nums2 are m and n respectively.
     */
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int t1 = m - 1, t2 = n - 1, f = m + n - 1;
        while (t1 >= 0 && t2 >= 0) {
            nums1[f--] = nums1[t1] > nums2[t2] ? nums1[t1--] : nums2[t2--];
        }
        while (t2 >= 0 && f >= 0) {
            nums1[f--] = nums2[t2--];
        }
    }

    public static void main(String[] args) {
        int[] nums1 = new int[11];
        nums1[0] = 1;
        nums1[1] = 3;
        nums1[2] = 5;
        nums1[3] = 7;
        nums1[4] = 9;

        int[] nums2 = {2, 3, 4, 5, 6, 7};
        int m = 5, n = 6;
        merge(nums1, m, nums2, n);
        PrintUtils.printArray(nums1);
    }
}
