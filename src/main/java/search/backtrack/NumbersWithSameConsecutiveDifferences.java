package search.backtrack;/**
 * @author Weiyan Xiang on 2021/1/30
 */

import java.util.ArrayList;
import java.util.List;

public class NumbersWithSameConsecutiveDifferences {
    /**
     * 967. Numbers With Same Consecutive Differences
     * <p>
     * https://leetcode.com/problems/numbers-with-same-consecutive-differences/
     */
    public int[] numsSameConsecDiff(int n, int k) {
        List<String> ans = new ArrayList<>();
        dfs(n, k, ans, "");
        int[] res = new int[ans.size()];
        for (int i = 0; i < ans.size(); i++) res[i] = Integer.valueOf(ans.get(i));
        return res;
    }

    private void dfs(int n, int k, List<String> ans, String cur) {
        if (cur.length() == n) {
            ans.add(cur);
            return;
        }
        for (char i = '0'; i <= '9'; i++) {
            if (cur.length() == 0 && i == '0') continue;
            char lastDigit = cur.length() == 0 ? '0' : cur.toCharArray()[cur.length()-1];
            if (Math.abs(lastDigit - i) == k) {
                dfs(n, k, ans, cur + i);
            }
        }
    }
}
