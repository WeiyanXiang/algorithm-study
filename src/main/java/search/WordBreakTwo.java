package search;/**
 * @author Weiyan Xiang on 2021/1/19
 */

import java.util.*;

public class WordBreakTwo {

    /**
     * 140. Word Break II
     * <p>
     * https://leetcode.com/problems/word-break-ii/
     * <p>
     */
    private Set<String> dict = new HashSet<>();
    private Map<String, List<String>> map = new HashMap<>();

    public List<String> wordBreak(String s, List<String> wordDict) {
        dict.addAll(wordDict);
        return check(s);
    }

    private List<String> check(String s) {
        if (map.containsKey(s)) return map.get(s);

        List<String> res = new LinkedList<>();
        if (s.length() == 0) {
            return res;
        }
        if (dict.contains(s)) {
            res.add(s);
        }
        for (int i = 1; i <= s.length(); i++) {
            String p1 = s.substring(0, i);
            String p2 = s.substring(i);
            if (dict.contains(p1)) {
                List<String> temp = check(p2);
                for (String t : temp) {
                    res.add(p1 + " " + t);
                }
            }

        }
        map.put(s, res);
        return res;
    }

    /**
     * my ans: dfs but TLE
     */
    public List<String> wordBreakRecur(String s, List<String> wordDict) {
        dict.addAll(wordDict);
        List<String> ans = new ArrayList<>();
        checkRecur(s, ans, "");
        return ans;
    }

    private void checkRecur(String s, List<String> ans, String cur) {
        if (dict.contains(s)) {
            ans.add(cur.isEmpty() ? (cur + s) : (cur + " " + s));
            return;
        }
        for (int i = 1; i <= s.length(); i++) {
            String p1 = s.substring(0, i);
            String p2 = s.substring(i);
            if (dict.contains(p1)) {
                checkRecur(p2, ans, cur.isEmpty() ? (cur + p1) : (cur + " " + p1));
            } else {
                continue;
            }
        }
    }
}
