package string;

import java.util.Stack;

/**
 * @author Weiyan Xiang on 2020/6/14
 */
public class DecodeString {

    /**
     * i didnt finish, below is not correct answer, will revisit
     *
     * @param s
     * @return
     */
    public String decodeString(String s) {
        String answer = "";
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == '[') st.push(i);
                // nested
            else if (c == ']' && !st.isEmpty()) {
                int start = st.pop();
                int num = Integer.parseInt(String.valueOf(s.charAt(start - 1)));
                String rep = s.substring(start + 1, i);
                for (int r = 0; r < num; r++) {
                    answer += rep;
                }
            }

        }
        return answer;
    }

    public static void main(String[] args) {
        DecodeString testObj = new DecodeString();
        System.out.println(testObj.decodeString("3[a]2[bc]"));
    }

}
