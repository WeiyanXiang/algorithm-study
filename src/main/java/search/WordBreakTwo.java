package search;/**
 * @author Weiyan Xiang on 2021/1/19
 */

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordBreakTwo {
    private Set<String> dict = new HashSet<>();

    /**
     * 140. Word Break II
     * <p>
     * https://leetcode.com/problems/word-break-ii/
     * <p>
     * my ans: dfs but TLE
     */
    public List<String> wordBreak(String s, List<String> wordDict) {
        dict.addAll(wordDict);
        List<String> ans = new ArrayList<>();
        check(s, ans, "");
        return ans;
    }

    private void check(String s, List<String> ans, String cur) {
        if (dict.contains(s)) {
            ans.add(cur.isEmpty() ? (cur + s) : (cur + " " + s));
            return;
        }
        for (int i = 1; i <= s.length(); i++) {
            String p1 = s.substring(0, i);
            String p2 = s.substring(i);
            if (dict.contains(p1)) {
                check(p2, ans, cur.isEmpty() ? (cur + p1) : (cur + " " + p1));
            } else {
                continue;
            }
        }
    }
}
