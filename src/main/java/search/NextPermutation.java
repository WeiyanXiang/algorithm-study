package search;

/**
 * @author Weiyan Xiang on 2021/11/15
 */

public class NextPermutation {

    /**
     * 31. Next Permutation
     * <p>
     * https://leetcode.com/problems/next-permutation/
     * <p>
     * upvoted ans with analysis: https://leetcode.com/problems/next-permutation/discuss/13994/Readable-code-without-confusing-ij-and-with-explanation
     */
    public void nextPermutation(int[] nums) {
        // find longest non-increase suffix
        int pivot = lastIndexOfIncreaseSeq(nums) - 1;
        // find rightmost number which is greater than pivot
        if (pivot != -1) {
            int rightmost = lastIndexOfGreaterThanPivot(nums, nums[pivot]);
            swap(nums, pivot, rightmost);
        }
        reverse(nums, pivot + 1, nums.length - 1);
    }

    private int lastIndexOfIncreaseSeq(int[] nums) {
        for (int i = nums.length - 1; i > 0; i--) {
            if (nums[i - 1] < nums[i]) return i;
        }
        return 0;
    }

    private int lastIndexOfGreaterThanPivot(int[] nums, int pivot) {
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] > pivot) return i;
        }
        return 0;
    }

    private void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }

    private void reverse(int[] nums, int l, int r) {
        while (l < r) {
            swap(nums, l++, r--);
        }
    }
}
