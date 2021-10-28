/**
 *
 */
package array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map.Entry;

/**
 * @author weiyan.xiang
 * @date 12 Feb 2018
 */
public class TwoSumCount {

    public static void main(String[] args) {
        int[] input1 = {2, 2, 3, 3, 3, 5, 5};
        System.out.println("6 == " + getTwoSum(input1, 5));
        int[] input2 = {1, 1, 1, 1};
        System.out.println("6 == " + getTwoSum(input2, 2));
        int[] input3 = {1, 5, 7, -1, 5};
        System.out.println("3 == " + getTwoSum(input3, 6));
        int[] input4 = {1, 5, 7, -1};
        System.out.println("2 == " + getTwoSum(input4, 6));
    }

    /**
     * Given an array of integers, and a number �sum�, find the number of pairs of integers in the array whose sum is
     * equal to �sum�.
     * <p>
     * Time: O(n) * 2
     *
     * @param input
     * @param i
     * @return
     */
    private static int getTwoSum(int[] arr, int sum) {
        HashMap<Integer, Integer> map = Arrays.stream(arr).collect(HashMap<Integer, Integer>::new,
                (m, e) -> m.put(e, m.getOrDefault(e, 0) + 1), null);

        int count = 0;
        for (Entry<Integer, Integer> entry : map.entrySet()) {
            int dif = sum - entry.getKey();
            if (dif != entry.getKey() && map.containsKey(dif)) {
                count += entry.getValue() * map.get(dif);
            } else if (dif == entry.getKey() && map.containsKey(dif)) {
                count += entry.getValue() * (entry.getValue() - 1);
            }
        }
        return count / 2;
    }

}