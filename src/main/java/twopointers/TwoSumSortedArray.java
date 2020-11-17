/**
 *
 */
package twopointers;

import java.util.Arrays;

/**
 * @author weiyan.xiang
 * @date 12 Feb 2018
 */
public class TwoSumSortedArray {

    /**
     * https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/
     * <p>
     * my answer
     */
    public int[] twoSum(int[] nums, int t) {
        int l = 0, r = nums.length - 1;
        int[] res = new int[2];
        while (l < r) {
            if (nums[l] + nums[r] > t) r--;
            else if (nums[l] + nums[r] < t) l++;
            else {
                res[0] = l + 1;
                res[1] = r + 1;
                return res;
            }
        }
        return res;
    }

    /**
     * previous answer
     */
    private static int[] getTwoSumSorted(int[] numbers, int target) {
        int[] answer = new int[2];
        int l = 0, r = numbers.length - 1;
        while (l < r) {
            int sum = numbers[l] + numbers[r];
            if (sum == target) {
                answer[0] = l + 1;
                answer[1] = r + 1;
                return answer;
            } else if (sum > target) {
                r--;
            } else {
                l++;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        int[] input = {2, 7, 11, 15};
        int[] answer = getTwoSumSorted(input, 9);
        Arrays.stream(answer).forEach(System.out::println);
    }


}
