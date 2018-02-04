/**
 * 
 */
package string;

import java.util.Stack;

/**
 * @author weiyan.xiang
 * @date 4 Feb 2018
 */
public class ValidParentheses {

    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        int i = 0;
        while (i < s.length() && s.charAt(i) != 0) {
            char c = s.charAt(i);
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else if (!stack.isEmpty()) {
                if (c == ']' && stack.peek() == '[' || c == ')' && stack.peek() == '('
                        || c == '}' && stack.peek() == '{') {
                    stack.pop();
                } else {
                    return false;
                }
            } else {
                return false;
            }
            i++;
        }
        return stack.isEmpty() ? true : false;
    }

    public static void main(String[] args) {
        System.out.println("isValid(\"([]){[]}[[]]\") should be true => " + isValid("([]){[]}[[]]"));
        System.out.println("isValid(\"]]]][[[[\") should be false => " + isValid("]]]][[[["));
        System.out.println("isValid(\"[](){\") should be false => " + isValid("[](){"));
    }
}
