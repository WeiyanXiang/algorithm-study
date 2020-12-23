package search.backtrack;/**
 * @author Weiyan Xiang on 2020/12/23
 */

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {

    /**
     * 22. Generate Parentheses
     * <p>
     * https://leetcode.com/problems/generate-parentheses/
     *
     * upvoted ac answer
     */
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        dfs(ans, "", 0, 0, n);
        return ans;
    }

    private void dfs(List<String> ans, String temp, int open, int close, int n) {
        if (temp.length() == 2 * n) {
            ans.add(temp);
            return;
        }
        /**
         * Let’s add in constraints now. We need to interpret the meanings of constraints. First, the first character
         * should be “(“. Second, at each step, you can either print “(“ or “)”, but print “)” only when there are
         * more “(“s than “)”s. Stop printing out “(“ when the number of “(“ s hit n. The first actually merges
         * into the second condition.
         */
        if (open < n) {
            dfs(ans, temp + "(", open + 1, close, n);
        }
        if (close < open) {
            dfs(ans, temp + ")", open, close + 1, n);
        }
    }
}
