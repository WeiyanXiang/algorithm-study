package array;/**
 * @author Weiyan Xiang on 2021/11/11
 */

public class MinValueToGetPositiveStepByStepSum {

    /**
     * 1413. Minimum Value to Get Positive Step by Step Sum
     * <p>
     * https://leetcode.com/problems/minimum-value-to-get-positive-step-by-step-sum/
     * <p>
     * my ac ans: calculation step by step sum array and work out ans
     */
    public int minStartValue(int[] nums) {
        int min = nums[0];
        for (int i = 1; i < nums.length; i++) {
            nums[i] = nums[i removeElements- 1] + nums[i];
            if (nums[i] < min) min = nums[i];
        }
        return min > 0 ? 1 : 1 - min;
    }
}
