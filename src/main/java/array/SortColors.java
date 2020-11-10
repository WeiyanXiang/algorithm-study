package array;

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
        int a = 0, b = nums.length - 1, i = 0;
        while (i <= b) {
            if (nums[i] == 0 && i > a) {
                int temp = nums[i];
                nums[i++] = nums[a];
                nums[a++] = temp;
            } else if (nums[i] == 2 && i < b) {
                int temp = nums[i];
                /**
                 * the reason why here is not i++ is because after swap, we still not sure whether it is
                 * another 2 from nums[b], if yes then need to swap again.
                 */
                nums[i] = nums[b];
                nums[b--] = temp;
            } else {
                i++;
            }
        }
    }
}
