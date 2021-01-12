package search;/**
 * @author Weiyan Xiang on 2021/1/12
 */

import java.util.ArrayList;
import java.util.List;

public class SplitArrayIntoFibonacciSequence {
    /**
     * 842. Split Array into Fibonacci Sequence
     * <p>
     * https://leetcode.com/problems/split-array-into-fibonacci-sequence/
     */
    public List<Integer> splitIntoFibonacci(String s) {
        List<Integer> list = new ArrayList<>();
        dfs(s, list, 0);
        return list;
    }

    // backtrack
    private boolean dfs(String s, List<Integer> ans, int pos) {
        if (pos > s.length()) return false;
        if (pos == s.length() && ans.size() >= 3) return true;
        for (int i = pos; i < s.length(); i++) {
            // no leading 0 sequences
            if (i > pos && s.charAt(pos) == '0') break;
            long curNum = Long.valueOf(s.substring(pos, i + 1));
            // pruning, since bound is 2^31 in requirement
            if (curNum > Integer.MAX_VALUE) break;
            int ls = ans.size();
            // pruning, early termination
            if (ls >= 2 && curNum > ans.get(ls - 1) + ans.get(ls - 2)) break;
            if (ls < 2 || curNum == ans.get(ls - 1) + ans.get(ls - 2)) {
                ans.add((int) curNum);
                if (dfs(s, ans, i + 1)) {
                    return true;
                }
                ans.remove(ans.size() - 1);
            }
        }
        return false;
    }
}
