package twopointers;

import java.util.Arrays;

/**
 * @author Weiyan Xiang on 2020/11/19
 */
public class ThreeSumClosest {
    /**
     * 16. 3Sum Closest
     * <p>
     * https://leetcode.com/problems/3sum-closest/
     */
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int close = nums[0] + nums[1] + nums[2];
        for (int i = 0; i < nums.length - 2; i++) {
            int l = i + 1, r = nums.length - 1;
            while (l < r) {
                int threeSum = nums[i] + nums[l] + nums[r];
                if (Math.abs(target - threeSum) < Math.abs(target - close)) {
                    close = threeSum;
                }
                if (threeSum < target) l++;
                else if (threeSum > target) r--;
                else return target;
            }
        }
        return close;
    }
}
