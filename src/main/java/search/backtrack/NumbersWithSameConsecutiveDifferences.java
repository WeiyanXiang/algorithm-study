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
     * <p>
     * my own ac answer
     */
    public int[] numsSameConsecDiff(int n, int k) {
        List<Integer> ans = new ArrayList<>();
        dfs(n, k, ans, 0);
        return ans.stream().mapToInt(i -> i).toArray();
    }

    private void dfs(int n, int k, List<Integer> ans, int cur) {
        if (n == 0) {
            ans.add(cur);
            return;
        }
        for (char i = 0; i <= 9; i++) {
            if (cur == 0 && i == 0) continue;
            if (cur == 0) {
                dfs(n - 1, k, ans, i);
            } else {
                int lastDigit = cur % 10;
                if (Math.abs(lastDigit - i) == k) {
                    dfs(n - 1, k, ans, cur * 10 + i);
                }
            }
        }
    }
}
