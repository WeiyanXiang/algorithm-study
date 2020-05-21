/**
 *
 */
package string;

/**
 * @author weiyan.xiang
 * @date 4 Feb 2018
 */
public class ValidParentheses {

    static class Stack {
        private char[] m;
        private int top;

        public Stack(int size) {
            this.m = new char[size];
            top = 0;
        }

        public char pop() {
            return m[top--];
        }

        public char peek() {
            return m[top];
        }

        public void push(char c) {
            m[++top] = c;
        }

        public boolean isEmpty() {
            return top == 0;
        }

    }

    /**
     * use own Stack
     *
     * @param s
     * @return
     */
    public static boolean isItValid(String s) {
        Stack stack = new Stack(100);
        int i = 0;
        while (i < s.length()) {
            char c = s.charAt(i);
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else if (!stack.isEmpty()) {
                if (c == ']' && stack.peek() == '[' ||
                        c == ')' && stack.peek() == '(' ||
                        c == '}' && stack.peek() == '{') {
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

    public static boolean isValid(String s) {
        java.util.Stack<Character> stack = new java.util.Stack<>();
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

    public static boolean isValidShort(String s) {
        Stack stack = new Stack(s.length() + 1);
        for (char c : s.toCharArray()) {
            if (c == '(') {
                stack.push(')');
            } else if (c == '[') {
                stack.push(']');
            } else if (c == '{') {
                stack.push('}');
            } else if (!stack.isEmpty() && stack.pop() != c) {
                return false;
            }
        }
        return stack.isEmpty();
    }


    public static void main(String[] args) {
        System.out.println("isValid(\"([]){[]}[[]]\") should be true => " + isValid("([]){[]}[[]]"));
        System.out.println("isValid(\"]]]][[[[\") should be false => " + isValid("]]]][[[["));
        System.out.println("isValid(\"[](){\") should be false => " + isValid("[](){"));

        System.out.println("isValid(\"([]){[]}[[]]\") should be true => " + isItValid("([]){[]}[[]]"));
        System.out.println("isValid(\"]]]][[[[\") should be false => " + isItValid("]]]][[[["));
        System.out.println("isValid(\"[](){\") should be false => " + isItValid("[](){"));

        System.out.println("isValid(\"([]){[]}[[]]\") should be true => " + isValidShort("([]){[]}[[]]"));
        System.out.println("isValid(\"]]]][[[[\") should be false => " + isValidShort("]]]][[[["));
        System.out.println("isValid(\"[](){\") should be false => " + isValidShort("[](){"));
    }
}
