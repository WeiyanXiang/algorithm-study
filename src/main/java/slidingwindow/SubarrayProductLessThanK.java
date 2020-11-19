package slidingwindow;

/**
 * @author Weiyan Xiang on 2020/11/19
 */
public class SubarrayProductLessThanK {

    /**
     * 713. Subarray Product Less Than K
     * <p>
     * https://leetcode.com/problems/subarray-product-less-than-k/
     */
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if (k <= 1) return 0;
        int count = 0;
        int l = 0, r = 0;
        int product = 1;
        while (r < nums.length) {
            product *= nums[r];
            while (product >= k) {
                product /= nums[l];
                l++;
            }
            count += r - l + 1;
            r++;
        }
        return count;
    }
}
