package search.backtrack;/**
 * @author Weiyan Xiang on 2021/2/13
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SequentialDigits {
    /**
     * https://leetcode.com/problems/sequential-digits/
     * <p>
     * my dfs ac ans
     */
    public List<Integer> sequentialDigits(int low, int high) {
        List<Integer> ans = new ArrayList<>();
        for (int i = 1; i <= 9; i++) {
            dfs(low, high, ans, i);
        }
        Collections.sort(ans);
        return ans;
    }

    private void dfs(int low, int high, List<Integer> ans, int cur) {
        if (cur > high) return;
        if (low <= cur && cur <= high) {
            ans.add(cur);
        }
        int i = cur % 10 + 1;
        if (i > 9) return;
        dfs(low, high, ans, cur * 10 + i);
    }

    /**
     * my bruce force TLE ans
     */
    public List<Integer> sequentialDigitsBF(int low, int high) {
        List<Integer> ans = new ArrayList<>();
        int cur = low;
        while (cur <= high) {
            if (isSeq(cur)) ans.add(cur);
            cur++;
        }
        return ans;
    }

    private boolean isSeq(int cur) {
        int temp = cur;
        int digit = temp % 10;
        temp /= 10;
        while (temp > 0) {
            int newDigit = temp % 10;
            if (digit - newDigit != 1) return false;
            digit = newDigit;
            temp /= 10;
        }
        return true;
    }
}
