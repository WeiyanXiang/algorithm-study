package array;

/**
 * @author Weiyan Xiang on 2020/11/7
 */
public class JumpGame {

    /**
     * https://leetcode.com/problems/jump-game/
     */
    public boolean canJump(int[] nums) {
        return jump(nums, nums.length);
    }

    /**
     * backward thinking
     */
    private boolean jump(int[] nums, int n) {
        // second to last element
        int last = n - 1;
        for (int i = n - 2; i >= 0; i--) {
            if (nums[i] + i >= last) last = i;
        }
        return last == 0;
    }

    public boolean canJumpForward(int[] nums) {
        return jumpForward(nums, nums.length);
    }

    /**
     * backward thinking
     */
    private boolean jumpForward(int[] nums, int n) {
        int reach = 0, i = 0;
        for (; i < n && i <= reach; i++) {
            reach = Math.max(nums[i] + i, reach);
        }
        return i == n;
    }
}
