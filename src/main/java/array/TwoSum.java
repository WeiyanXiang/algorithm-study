/**
 * 
 */
package array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author weiyan.xiang
 * @date 12 Feb 2018
 */
public class TwoSum {

    public static void main(String[] args) {
        int[] input = { 2, 7, 11, 15 };
        int[] answer = getTwoSum(input, 9);
        Arrays.stream(answer).forEach(System.out::println);
    }

    private static int[] getTwoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        int[] answer = new int[2];
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                answer[0] = i;
                answer[1] = map.get(target - nums[i]);
                return answer;
            }
            map.put(nums[i], i);
        }
        return null;
    }
}
