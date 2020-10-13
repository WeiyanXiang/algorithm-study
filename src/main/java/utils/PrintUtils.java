/**
 *
 */
package utils;

/**
 * @author weiyan.xiang
 * @date 9 Mar 2018
 */
public class PrintUtils {

    /**
     * using stream to print
     *
     * @param nums
     */
    public static void printArray(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (i < nums.length - 1) {
                System.out.print(nums[i] + ", ");
            } else {
                System.out.print(nums[i]);
            }
        }
        System.out.println();
    }

}
