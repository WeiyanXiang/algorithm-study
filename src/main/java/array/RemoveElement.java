/**
 * 
 */
package array;

import java.util.Arrays;

/**
 * @author weiyan.xiang
 * @date 19 Feb 2018
 */
public class RemoveElement {

    public static int removeElement(int[] nums, int val) {
        int j = nums.length - 1;
        for (int i = 0; i < nums.length; i++) {
            while (j >= 0 && nums[j] == val) {
                j--;
            }
            if (nums[i] == val && j >= 0 && i < j) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                j--;
            }
        }
        return j + 1;
    }

    public static void main(String[] args) {
        int[] input = new int[] { 3, 3, 4, 3, 5, 6, 3 };
        System.out.println("4 == " + removeElement(input, 3));
        Arrays.stream(input).forEach(System.out::println);
    }

}
