package search;/**
 * @author Weiyan Xiang on 2021/1/11
 */

import java.util.ArrayList;
import java.util.List;

public class ExpressionAddOperators {

    public List<String> addOperatorsAddMinusCombine(String num, int target) {
        List<String> ans = new ArrayList<>();
        searchAddMinusCombine(num, target, ans, "", 0, 0);
        return ans;
    }

    private void searchAddMinusCombine(String num, int target, List<String> ans, String curString, int curSum, int start) {
        if (start > num.length()) return;
        if (curSum == target && start == num.length()) ans.add(curString);
        for (int i = start; i < num.length(); i++) {
            char c = num.charAt(i);
            int ic = c - '0';
            int prevDigit = curString.isEmpty() ? 0 : curString.charAt(curString.length() - 1) - '0';
            // combine
            searchAddMinusCombine(num, target, ans,
                    curString.isEmpty() ? "" + c : curString + c,
                    curSum - prevDigit + prevDigit * 10 + ic,
                    start + 1);
            // +
            searchAddMinusCombine(num, target, ans,
                    curString.isEmpty() ? "" + c : curString + "+" + c,
                    curSum + ic,
                    start + 1);
            // -
            searchAddMinusCombine(num, target, ans,
                    curString.isEmpty() ? "" + c : curString + "-" + c,
                    curSum - ic,
                    start + 1);
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
