package string;

import java.util.Stack;

/**
 * @author Weiyan Xiang on 2020/6/14
 */
public class ValidParenthesisString {
    public boolean checkValidString(String s) {
        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') s1.push(i);
            else if (c == '*') s2.push(i);
            else {
                if (s1.isEmpty() && s2.isEmpty()) return false;
                if (!s1.isEmpty()) s1.pop();
                else s2.pop();
            }

        }
        while (!s1.isEmpty() && !s2.isEmpty()) {
            if (s1.pop() > s2.pop()) return false;
        }
        return s1.isEmpty();
    }
}
