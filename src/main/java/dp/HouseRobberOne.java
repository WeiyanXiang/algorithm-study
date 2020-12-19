package dp;

import java.util.Arrays;

/**
 * @author Weiyan Xiang on 2020/12/19
 */

public class HouseRobberOne {
    /**
     * 198. House Robber
     * <p>
     * https://leetcode.com/problems/house-robber/
     * <p>
     * my own ac answer after reading ideas in upvoted answer
     */
    public int rob(int[] nums) {
        int[] cache = new int[nums.length];
        Arrays.fill(cache, -1);
        return robSub(nums, nums.length - 1, cache);
    }

    public int robSub(int[] nums, int l, int[] cache) {
        if (nums == null || nums.length == 0 || l < 0) return 0;
        // either inc nums[l] or not.
        if (cache[l] != -1) return cache[l];
        int res = Math.max(nums[l] + robSub(nums, l - 2, cache), robSub(nums, l - 1, cache));
        cache[l] = res;
        return res;
    }

    // iterative with array, my own ac answer
    public int robIterativeWithArray(int[] nums) {
        int[] cache = new int[nums.length];
        if (nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        if (nums.length == 2) return Math.max(nums[0], nums[1]);
        Arrays.fill(cache, -1);
        cache[0] = nums[0];
        cache[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < nums.length; i++) {
            cache[i] = Math.max(cache[i - 2] + nums[i], cache[i - 1]);
        }
        return cache[cache.length - 1];
    }

    // iterative with 2 vars, my own ac answer
    public int robIterativeWithTwoVars(int[] nums) {
        if (nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        if (nums.length == 2) return Math.max(nums[0], nums[1]);
        int prevPrev, prev;
        prevPrev = nums[0];
        prev = Math.max(nums[0], nums[1]);
        for (int i = 2; i < nums.length; i++) {
            int temp = Math.max(prevPrev + nums[i], prev);
            prevPrev = prev;
            prev = temp;
        }
        return prev;
    }
}
