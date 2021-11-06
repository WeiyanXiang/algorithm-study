package math;

/**
 * @author Weiyan Xiang on 2021/11/6
 */

public class SingleNumberIII {

    /**
     * 260. Single Number III
     * <p>
     * https://leetcode.com/problems/single-number-iii/
     * <p>
     * upvoted ans
     */
    public int[] singleNumber(int[] nums) {
        int axorb = 0;
        for (int n : nums) {
            axorb ^= n;
        }
        int rightMost = axorb & -axorb;
        int a = 0;
        for (int n : nums) {
            if ((n & rightMost) != 0) {
                a ^= n;
            }
        }
        return new int[]{a, axorb ^ a};
    }

}
