package search.backtrack;/**
 * @author Weiyan Xiang on 2021/2/13
 */

import java.util.ArrayList;
import java.util.List;

public class SequentialDigits {
    /**
     * https://leetcode.com/problems/sequential-digits/
     * <p>
     * bruce force TLE my ans
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
