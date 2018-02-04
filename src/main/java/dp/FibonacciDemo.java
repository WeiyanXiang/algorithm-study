/**
 * 
 */
package dp;

import java.util.Stack;

/**
 * @author weiyan.xiang
 * @date 4 Feb 2018
 */
public class FibonacciDemo {

    public static int fibRecursice(int n) {
        return n <= 1 ? n : fibRecursice(n - 1) + fibRecursice(n - 2);
    }

    // public static int fibBottomUpD(int n) {
    //
    // }

    public static void main(String[] args) {
        System.out.println("fibRecursice(18) => " + fibRecursice(18));
        Stack<Character> stack = new Stack<>();
        stack.push('c');
    }
}
