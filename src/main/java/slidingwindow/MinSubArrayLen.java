package slidingwindow;

/**
 * @author Weiyan Xiang on 2020/11/14
 */
public class MinSubArrayLen {
    /**
     * https://leetcode.com/problems/minimum-size-subarray-sum/submissions/
     * <p>
     * my own answer using template idea to approach
     */
    public int minSubArrayLen(int s, int[] nums) {
        int l = 0, r = 0, sum = 0, res = nums.length + 1;
        while (r < nums.length) {
            // right
            sum += nums[r];
            r++;
            // left
            while (sum >= s) {
                sum -= nums[l];
                res = Math.min(res, r - l);
                l++;
            }
        }
        return res == nums.length + 1 ? 0 : res;
    }
}
