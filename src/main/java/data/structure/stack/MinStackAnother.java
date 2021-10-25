package data.structure.stack;

import java.util.Stack;

/**
 * @author Weiyan Xiang on 2020/6/23
 */
public class MinStackAnother {

    private Stack<Integer> s1;
    private Stack<Integer> s2;

    /**
     * https://leetcode.com/problems/min-stack/submissions/
     * <p>
     * https://leetcode.com/problems/min-stack/submissions/
     * <p>
     * my ac ans: 2 stacks: 1 normal; 1 keeps tracking appearing min values
     */
    public MinStackAnother() {
        this.s1 = new Stack<>();
        this.s2 = new Stack<>();
    }

    public void push(int val) {
        s1.push(val);
        if (s2.isEmpty() || s2.peek() >= val) s2.push(val);
    }

    public void pop() {
        int top = s1.pop();
        if (!s2.isEmpty() && top == s2.peek()) s2.pop();
    }

    public int top() {
        return s1.peek();
    }

    public int getMin() {
        return !s2.isEmpty() ? s2.peek() : s1.peek();
    }

}