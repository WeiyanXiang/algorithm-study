package queue.stack;/**
 * @author Weiyan Xiang on 2021/11/13
 */

import java.util.Stack;

public class DailyTemperatures {
    /**
     * 739. Daily Temperatures
     * <p>
     * https://leetcode.com/problems/daily-temperatures/
     * <p>
     * upvoted ans: mono stack, every time larger temp found, update on the index of peek
     */
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> stack = new Stack<>();
        int[] ans = new int[temperatures.length];
        for (int i = 0; i < temperatures.length; i++) {
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                int top = stack.pop();
                ans[top] = i - top;
            }
            stack.push(i);
        }
        return ans;
    }
}
