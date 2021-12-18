package array;

import java.util.Stack;

/**
 * @author Weiyan Xiang on 2020/6/22
 */
public class CandyCrush1D {

    /**
     * https://leetcode.com/discuss/interview-question/380650/Bloomberg-or-Phone-Screen-or-Candy-Crush-1D
     * <p>
     * Write a function to crush candy in one dimensional board. In candy crushing games, groups of like items are
     * removed from the board. In this problem, any sequence of 3 or more like items should be removed and any items
     * adjacent to that sequence should now be considered adjacent to each other. This process should be repeated as
     * many time as possible. You should greedily remove characters from left to right.
     * <p>
     * Example 1:
     * <p>
     * Input: "aaabbbc" Output: "c" Explanation: 1. Remove 3 'a': "aaabbbc" => "bbbc" 2. Remove 3 'b': "bbbc" => "c"
     * Example 2:
     * <p>
     * Input: "aabbbacd" Output: "cd" Explanation: 1. Remove 3 'b': "aabbbacd" => "aaacd" 2. Remove 3 'a': "aaacd" =>
     * "cd" Example 3:
     * <p>
     * Input: "aabbccddeeedcba" Output: "" Explanation: 1. Remove 3 'e': "aabbccddeeedcba" => "aabbccdddcba" 2. Remove 3
     * 'd': "aabbccdddcba" => "aabbcccba" 3. Remove 3 'c': "aabbcccba" => "aabbba" 4. Remove 3 'b': "aabbba" => "aaa" 5.
     * Remove 3 'a': "aaa" => "" Example 4:
     * <p>
     * Input: "aaabbbacd" Output: "acd" Explanation: 1. Remove 3 'a': "aaabbbacd" => "bbbacd" 2. Remove 3 'b': "bbbacd"
     * => "acd" I solved it with recursion and also discussed the stack based approach.
     * <p>
     * Follow-up: What if you need to find the shortest string after removal?
     * <p>
     * Example:
     * <p>
     * Input: "aaabbbacd" Output: "cd"
     * <p>
     * Explanation: 1. Remove 3 'b': "aaabbbacd" => "aaaacd" 2. Remove 4 'a': "aaaacd" => "cd"
     */

    public String candyCrush(String s) {
        Stack<Character> stack = new Stack<>();
        Stack<Integer> counts = new Stack<>();
        int i = 0;
        while (i < s.length()) {
            char c = s.charAt(i);
            // if empty or different letter found
            if (stack.isEmpty() || c != stack.peek()) {
                if (!stack.isEmpty() && counts.peek() >= 3) {
                    stack.pop();
                    counts.pop();
                    // no need to i++ because we need to keep checking this incoming letter after the 3 letters crushed
                } else {
                    stack.push(c);
                    counts.push(1);
                    i++;
                }
            } else {
                // when it's same letter, update counts count
                counts.push(counts.pop() + 1);
                i++;
            }
        }

        if (counts.peek() >= 3) {
            stack.pop();
            counts.pop();
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            char c = stack.pop();
            int count = counts.pop();
            while (count > 0) {
                sb.append(c);
                count--;
            }
        }

        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        CandyCrush1D candyCrush = new CandyCrush1D();
        String actual = candyCrush.candyCrush("aabbbacd");
        System.out.println(actual + " == " + "cd");
    }


}
