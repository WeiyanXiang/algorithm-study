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
     * <p>
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


    /**
     * my backtrack version, easier to understand, so we construct temp and then prune the branch after backtrack
     */
    public List<String> generateParenthesisBacktrack(int n) {
        List<String> ans = new ArrayList<>();
        backtrack(ans, "", 0, 0, n);
        return ans;
    }

    private void backtrack(List<String> ans, String temp, int open, int close, int n) {
        if (temp.length() == 2 * n) {
            ans.add(temp);
            return;
        }
        if (open < n) {
            temp += "(";
            backtrack(ans, temp, open + 1, close, n);
            temp = temp.substring(0, temp.length() - 1);
        }
        if (close < open) {
            temp += ")";
            backtrack(ans, temp, open, close + 1, n);
            temp = temp.substring(0, temp.length() - 1);
        }
    }
}
