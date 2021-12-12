/**
 *
 */
package twopointers;

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
     *
     * idea: start from backwards
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i1 = m - 1, i2 = n - 1, i = m + n - 1;
        while (i1 >= 0 && i2 >= 0) {
            if (nums1[i1] > nums2[i2]) {
                nums1[i--] = nums1[i1--];
            } else {
                nums1[i--] = nums2[i2--];
            }
        }
        // when there is additional smaller values in nums2
        while (i2 >= 0) {
            nums1[i--] = nums2[i2--];
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
        new MergeSortedArray().merge(nums1, m, nums2, n);
        PrintUtils.printArray(nums1);
    }
}
