/**
 * 
 */
package sort.utils;

import java.util.Arrays;

/**
 * @author weiyan.xiang
 * @date 9 Mar 2018
 */
public class SortUtils {

    /**
     * using stream to print
     * 
     * @param nums
     */
    public static void printArray(int[] nums) {
        Arrays.stream(nums).forEach(System.out::println);
    }

}
