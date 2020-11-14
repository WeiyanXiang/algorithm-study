package twopointers;

/**
 * @author Weiyan Xiang on 2020/11/14
 */
public class MinSubArrayLen {
    /**
     * https://leetcode.com/problems/minimum-size-subarray-sum/submissions/
     */
    public int minSubArrayLen(int s, int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int window = Integer.MAX_VALUE;
        int sum = 0, p = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            while (sum >= s) {
                window = Math.min(window, i - p + 1);
                sum -= nums[p++];
            }
        }
        return window == Integer.MAX_VALUE ? 0 : window;
    }
}
