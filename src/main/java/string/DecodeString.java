package string;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @author Weiyan Xiang on 2020/6/14
 */
public class DecodeString {

    /**
     * 394. Decode String
     * <p>
     * https://leetcode.com/problems/decode-string/submissions/
     * <p>
     * use a queue for recursion
     */
    public String decodeString(String s) {
        Queue<Character> q = new LinkedList<>();
        for (char c : s.toCharArray()) q.offer(c);
        return dfs(q);
    }

    private String dfs(Queue<Character> q) {
        StringBuilder ans = new StringBuilder();
        int num = 0;
        while (!q.isEmpty()) {
            char c = q.poll();
            if (Character.isDigit(c)) {
                num = num * 10 + (c - '0');
            } else if (c == '[') {
                String cur = dfs(q);
                for (int i = 0; i < num; i++) ans.append(cur);
                num = 0;
            } else if (c == ']') {
                break;
            } else {
                ans.append(c);
            }
        }
        return ans.toString();
    }

    public static void main(String[] args) {
        DecodeString testObj = new DecodeString();
        System.out.println(testObj.decodeString("3[a]2[bc]") + " == aaabcbc");
    }

}
