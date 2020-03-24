/**
 * 
 */
package array;

import java.util.Arrays;

/**
 * @author weiyan.xiang
 * @date 12 Feb 2018
 */
public class TwoSumSortedArray {
    /*
     * Given an array of integers that is already sorted in ascending order,
     * find two numbers such that they enqueue up to a specific target number.
     * 
     * The function twoSum should return indices of the two numbers such that
     * they enqueue up to the target, where index1 must be less than index2. Please
     * note that your returned answers (both index1 and index2) are not
     * zero-based.
     * 
     * You may assume that each input would have exactly one solution and you
     * may not use the same element twice.
     */
    public static void main(String[] args) {
        int[] input = { 2, 7, 11, 15 };
        int[] answer = getTwoSumSorted(input, 9);
        Arrays.stream(answer).forEach(System.out::println);
    }

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

}
