package search;/**
 * @author Weiyan Xiang on 2021/1/11
 */

import java.util.ArrayList;
import java.util.List;

public class ExpressionAddOperators {

    /**
     * 282. Expression Add Operators
     * <p>
     * https://leetcode.com/problems/expression-add-operators/
     * <p>
     * upvoted ans
     */
    public List<String> addOperators(String num, int target) {
        List<String> ans = new ArrayList<>();
        dfs(num, target, "", 0, 0, 0, ans);
        return ans;
    }

    private void dfs(String num, int target,
                     String path, long curr, long prev, int pos,
                     List<String> ans) {
        if (pos == num.length() && target == curr) {
            ans.add(path);
            return;
        }
        for (int i = pos; i < num.length(); i++) {
            // leading 0
            if (i != pos && num.charAt(pos) == '0') break;
            // to achieve combine numbers in a loop
            Long curNum = Long.valueOf(num.substring(pos, i + 1));
            if (pos == 0) {
                // there is no oeprators yet, combining numbers first only.
                dfs(num, target, path + curNum, curNum, curNum, i + 1, ans);
            } else {
                //+
                dfs(num, target, path + '+' + curNum, curr + curNum, curNum, i + 1, ans);
                //-
                dfs(num, target, path + '-' + curNum, curr - curNum, -curNum, i + 1, ans);
                //*
                dfs(num, target, path + '*' + curNum, curr - prev + curNum * prev, prev * curNum, i + 1, ans);
            }
        }
    }


    /**
     * below is my version of supporting + - only. need to expand to support * and combine numbers
     */
    public List<String> addOperatorsAddMinusOnly(String num, int target) {
        List<String> ans = new ArrayList<>();
        searchAddMinus(num, target, ans, "", 0, 0);
        return ans;
    }

    private void searchAddMinus(String num, int target, List<String> ans, String curString, int curSum, int start) {
        if (start > num.length()) return;
        if (curSum == target && start == num.length()) ans.add(curString);
        for (int i = start; i < num.length(); i++) {
            char c = num.charAt(i);
            int ic = c - '0';
            // +
            searchAddMinus(num, target, ans, curString.isEmpty() ? "" + c : curString + "+" + c, curSum + ic, start + 1);
            // -
            searchAddMinus(num, target, ans, curString.isEmpty() ? "" + c : curString + "-" + c, curSum - ic, start + 1);
        }
    }
}
