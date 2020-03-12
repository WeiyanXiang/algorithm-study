/**
 *
 */
package array;

import java.util.Arrays;

/**
 * @author weiyan.xiang
 * @date 19 Feb 2018
 * <p>
 * https://leetcode.com/problems/remove-element/
 */
public class RemoveElement {

    public static int removeElement(int[] nums, int val) {
        int j = nums.length - 1;
        for (int i = 0; i < nums.length; i++) {
            while (j >= 0 && nums[j] == val) {
                j--;
            }
            if (nums[i] == val && j >= 0 && i < j) {
                nums[i] = nums[j];
                j--;
            }
        }
        return j + 1;
    }

    /**
     * better 
     * @param nums
     * @param val
     * @return
     */
    public static int doRemoveElement(int[] nums, int val) {
        int w = 0;
        for(int i=0;i<nums.length;i++){
            if(nums[i] != val) {
                nums[w++] = nums[i];
            }
        }
        return w;
    }

    public static void main(String[] args) {
        int[] input = {0, 1, 2, 2, 3, 0, 4, 2};
        System.out.println("5 == " + removeElement(input, 2));
        Arrays.stream(input).forEach(e -> System.out.print(e + ", "));
    }

}
