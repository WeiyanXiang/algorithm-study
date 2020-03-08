package array;

import java.util.Arrays;

/**
 * @author Weiyan Xiang on 2020/3/8
 */
public class MoveZeroes {

    public void moveZeroes(int[] nums) {
        int writeIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                doSwap(i, writeIndex++, nums);
            }
        }
    }

    private void doSwap(int a, int b, int[] nums) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 0, 0, 3, 0, 12, 0, 7};
        new MoveZeroes().moveZeroes(nums);
        Arrays.stream(nums).forEach(n -> System.out.print(n + ", "));

    }


}
