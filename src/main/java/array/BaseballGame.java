package array;

import java.util.Stack;

public class BaseballGame {

    /**
     * 682. Baseball Game
     * <p>
     * https://leetcode.com/problems/baseball-game/
     * <p>
     * stack to push and pop with operations
     */
    public int calPoints(String[] ops) {
        Stack<Integer> stack = new Stack<>();
        int sum = 0;
        for (String op : ops) {
            if (op.equals("C")) {
                sum -= stack.pop();
            } else if (op.equals("D")) {
                int doubledPrev = stack.peek() * 2;
                sum += doubledPrev;
                stack.push(doubledPrev);
            } else if (op.equals("+")) {
                int prev = stack.peek();
                stack.pop();
                int prePrev = stack.peek();
                stack.push(prev);
                int subsum = prev + prePrev;
                sum += subsum;
                stack.push(subsum);
            } else {
                sum += Integer.parseInt(op);
                stack.push(Integer.parseInt(op));
            }
        }
        return sum;
    }
}
