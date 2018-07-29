/**
 *
 */
package array;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

/**
 * @author weiyan.xiang
 * @date 12 Feb 2018
 */
public class KDiffPairs {
    /*
     * Given an array of integers and an integer k, you need to find the number
     * of unique k-diff pairs in the array
     */
    public static int findPairs(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int count = 0;
        /**
         * we have to use first loop to store frequency for situation of
         * filtering duplicate elements
         */
        for (int element : nums) {
            map.put(element, map.getOrDefault(element, 0) + 1);
        }

        for (Entry<Integer, Integer> entry : map.entrySet()) {
            if (k == 0) {
                if (entry.getValue() > 1) {
                    count++;
                }
            } else {
                /**
                 * entry.getKey() + k or entry.getKey() - k
                 */
                if (map.containsKey(entry.getKey() + k)) {
                    count++;
                }
            }
        }
        return count;
    }
    /*
     * if ((map.containsKey(nums[i] + k) || map.containsKey(nums[i] - k))) {
     * count++; }
     */

    public static void main(String[] args) {
        int[] input1 = {3, 1, 4, 1, 5};
        int k1 = 2;
        int[] input2 = {1, 2, 3, 4, 5};
        int k2 = 1;
        int[] input3 = {1, 3, 1, 5, 4};
        int k3 = 0;
        int[] input4 = {1, 2, 3, 4, 5};
        int k4 = 3;

        System.out.println("2 == " + findPairs(input1, k1));
        System.out.println("4 == " + findPairs(input2, k2));
        System.out.println("1 == " + findPairs(input3, k3));
        System.out.println("2 == " + findPairs(input4, k4));
    }
}
