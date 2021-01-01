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

    public boolean canJumpRec(int[] nums) {
        return jumpRec(nums, nums.length - 2, nums.length - 1);
    }

    private boolean jumpRec(int[] nums, int i, int last) {
        if (i == 0) return true;
        if (nums[i] + i < last) return false;
        return jumpRec(nums, i - 1, i);
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
     * Forward thinking
     */
    private boolean jumpForward(int[] nums, int n) {
        int reach = 0, i = 0;
        for (i = 0; i < n && i <= reach; i++) {
            reach = Math.max(nums[i] + i, reach);
        }
        return i == n;
    }
}
