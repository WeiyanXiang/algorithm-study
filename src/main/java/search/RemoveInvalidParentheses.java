package search;/**
 * @author Weiyan Xiang on 2020/12/24
 */

import java.util.ArrayList;
import java.util.List;

public class RemoveInvalidParentheses {
    /**
     * 301. Remove Invalid Parentheses
     * <p>
     * https://leetcode.com/problems/remove-invalid-parentheses/
     * <p>
     * learnt the iead from huahua: https://zxi.mytechroad.com/blog/searching/leetcode-301-remove-invalid-parentheses/
     */
    public List<String> removeInvalidParentheses(String s) {
        int l = 0, r = 0;
        List<String> ans = new ArrayList<>();
        for (char ss : s.toCharArray()) {
            if (ss == '(') l++;
            if (l == 0 && ss == ')') r++;
            else if (ss == ')') l--;
        }
        dfs(0, l, r, s, ans);
        return ans;
    }

    private void dfs(int start, int l, int r, String s, List<String> ans) {
        if (l == 0 && r == 0 && isValid(s)) {
            ans.add(s);
            return;
        }
        for (int i = start; i < s.length(); i++) {
            char ci = s.charAt(i);
            if (i != start && ci == s.charAt(i - 1)) continue;
            if (ci == '(' || ci == ')') {
                StringBuilder curr = new StringBuilder(s);
                curr = curr.deleteCharAt(i);
                if (r > 0 && ci == ')') dfs(i, l, r - 1, curr.toString(), ans);
                else if (l > 0 && ci == '(') dfs(i, l - 1, r, curr.toString(), ans);
            }

        }
    }

    public boolean isValid(String s) {
        int count = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') count++;
            if (c == ')') count--;
            if (count < 0) return false;
        }
        return count == 0;
    }
}