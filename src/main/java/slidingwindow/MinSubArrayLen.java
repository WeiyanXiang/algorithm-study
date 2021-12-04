package slidingwindow;

/**
 * @author Weiyan Xiang on 2020/11/14
 */
public class MinSubArrayLen {
    /**
     * https://leetcode.com/problems/minimum-size-subarray-sum/submissions/
     * <p>
     * Sliding window
     */
    public int minSubArrayLen(int target, int[] nums) {
        int l = 0, r = 0, sum = 0, ans = Integer.MAX_VALUE;
        while (r < nums.length) {
            // right
            sum += nums[r++];
            // left
            while (sum >= target) {
                sum -= nums[l++];
                ans = Math.min(ans, r - l + 1);
            }
        }
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }
}
