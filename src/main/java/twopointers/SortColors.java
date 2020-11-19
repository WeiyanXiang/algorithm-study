package twopointers;

/**
 * @author Weiyan Xiang on 2020/11/10
 */
public class SortColors {
    /**
     * https://leetcode.com/problems/sort-colors/
     * <p>
     * 4 different solutions: https://leetcode.com/problems/sort-colors/discuss/26500/Four-different-solutions
     */
    public void sortColors(int[] nums) {
        int zero = 0, two = nums.length - 1, i = 0;
        while (i <= two) {
            if (nums[i] == 0 && i > zero) {
                int temp = nums[i];
                nums[i++] = nums[zero];
                nums[zero++] = temp;
            } else if (nums[i] == 2 && i < two) {
                int temp = nums[i];
                /**
                 * the reason why here is not i++ is because after swap, we still not sure whether it is
                 * another 2 from nums[b], if yes then need to swap again.
                 */
                nums[i] = nums[two];
                nums[two--] = temp;
            } else {
                i++;
            }
        }
    }

    /**
     * my own version, easier to understand
     */
    public void sortColorsTwo(int[] nums) {
        int zero = 0, two = nums.length - 1;
        for (int i = 0; i <= two; ++i) {
            if (nums[i] == 0) {
                int temp = nums[i];
                nums[i] = nums[zero];
                nums[zero] = temp;
                zero++;

            } else if (nums[i] == 2) {
                int temp = nums[i];
                nums[i] = nums[two];
                nums[two] = temp;
                two--;
                /**
                 * reason is nums[two] might be another 2 which may not be sorted.
                 * why when nums[i]==0 no need to i--?
                 * because after swap, from left of array, it must have been sorted already
                 */
                i--;
            }
        }
    }
}
