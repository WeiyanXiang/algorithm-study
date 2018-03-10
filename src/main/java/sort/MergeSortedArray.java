/**
 * 
 */
package sort;

import sort.utils.SortUtils;

/**
 * @author weiyan.xiang
 * @date 9 Mar 2018
 */
public class MergeSortedArray {

    /**
     * Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1
     * as one sorted array.
     * 
     * Note: You may assume that nums1 has enough space (size that is greater or
     * equal to m + n) to hold additional elements from nums2. The number of
     * elements initialized in nums1 and nums2 are m and n respectively.
     * 
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1, j = n - 1, k = m + n - 1;
        // proceed merging in reverse order
        while (i >= 0 && j >= 0) {
            if (nums1[i] <= nums2[j]) {
                nums1[k--] = nums2[j--];
            } else {
                nums1[k--] = nums1[i--];
            }
        }
        while (i >= 0) {
            nums1[k--] = nums1[i--];
        }
    }

    public static void main(String[] args) {
        int[] nums1 = new int[11];
        nums1[0] = 1;
        nums1[1] = 3;
        nums1[2] = 5;
        nums1[3] = 7;
        nums1[4] = 9;

        int[] nums2 = { 2, 3, 4, 5, 6, 7 };
        int m = 5, n = 6;
        merge(nums1, m, nums2, n);
        SortUtils.printArray(nums1);
    }
}
