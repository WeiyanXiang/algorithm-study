package array;/**
 * @author Weiyan Xiang on 2021/10/19
 */

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class NextGreaterElementI {
    /**
     * 496. Next Greater Element I
     * <p>
     * https://leetcode.com/problems/next-greater-element-i/
     * <p>
     * my ac ans: map to track index to narrow down searching
     */
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map2 = new HashMap<>();
        for (int j = 0; j < nums2.length; j++) map2.put(nums2[j], j);

        int index = 0;
        for (int z = 0; z < nums1.length; z++) {
            nums1[index++] = findNext(nums1[z], map2.get(nums1[z]), nums2);
        }
        return nums1;
    }

    private int findNext(int cur, int l, int[] nums2) {
        for (int i = l + 1; i < nums2.length; i++) {
            if (nums2[i] > cur) return nums2[i];
        }
        return -1;
    }

    /**
     * upvoted ans: use stack and map to keep track of next greater number
     */
    public int[] nextGreaterElementStack(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        Stack<Integer> stack = new Stack<>();
        for (int num : nums2) {
            while (!stack.isEmpty() && stack.peek() < num) {
                map.put(stack.pop(), num);
            }
            stack.push(num);
        }
        int index = 0;
        for (int n1 : nums1) {
            nums1[index++] = map.getOrDefault(n1, -1);
        }
        return nums1;
    }


}
