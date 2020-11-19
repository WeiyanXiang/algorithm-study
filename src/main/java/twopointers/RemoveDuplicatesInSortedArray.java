package twopointers;

public class RemoveDuplicatesInSortedArray {
    /**
     * 26. Remove Duplicates from Sorted Array
     * <p>
     * https://leetcode.com/problems/remove-duplicates-from-sorted-array/
     * <p>
     * my own AC answer
     */
    public int removeDuplicates(int[] nums) {
        if (nums.length < 2) return nums.length;
        int l = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1]) nums[l++] = nums[i];
        }
        return l--;
    }

}
